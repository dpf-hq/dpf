package no.hib.mums.shared;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.framework.Bundle;

public class DPFResourceHandler {
	//TODO: Whenever an editor is opened, make sure model hierarchy has been loaded.
	private TransactionalEditingDomain ted;
	private Specification model;
	
	private static URI M1_URI = DPFResourceHandler.findFile("no.hib.mums.shared", "models/m1.xmi");
	
	public DPFResourceHandler(TransactionalEditingDomain ted) {
		this.ted = ted;
		initiateResources();
	}
	
	private void initiateResources() {

		CommandStack cs = ted.getCommandStack();

		cs.execute(new RecordingCommand(ted) {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub

				//We retrieve our resource set from the transactional domain
				ResourceSetImpl resourceSet = (ResourceSetImpl) ted.getResourceSet();

				resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

				//We add m1
				Resource m1 = resourceSet.createResource(M1_URI);
				resourceSet.getURIResourceMap().put(M1_URI, m1);
				
				EcoreUtil.resolveAll(resourceSet);
			}
		});
	}

	public void createResource(URI uri, String fileNamePostfix, final Specification spec) {
		ResourceSet rs = ted.getResourceSet();
		
		final Resource modelResource = createFileResource(createURI(uri, fileNamePostfix), rs);
		
		CommandStack cs = ted.getCommandStack();
		cs.execute(new RecordingCommand(ted) {
			
			@Override
			protected void doExecute() {
				modelResource.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
				modelResource.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
				modelResource.getContents().add(spec);
			}
		});
		
	}
	
	private Resource createFileResource(URI fileURI, ResourceSet rs) {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		
		IResource file;
		try {
			String tmp = fileURI.toPlatformString(true);
			file = workspaceRoot.findMember(tmp);
		} catch(NullPointerException e) {
			//Case where the shipeditor provides a file:/ path instead of URI
			File f = new File(fileURI.toFileString());
			Path p = (Path) Path.fromOSString(f.toString());
			file = workspaceRoot.getFileForLocation(p);
		}
		
		if (file == null || !file.exists()) {
			Resource createResource = rs.createResource(fileURI);
			try {
				createResource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			createResource.setTrackingModification(true);
		}
		System.out.println("DPFResourcehandler#createFileResource" + rs);
		
		return rs.getResource(fileURI, true);
	}
	
	public void saveSpecification() {
		//FIXME: Obs! 
		final Resource res = ted.getResourceSet().getResource(model.eResource().getURI(), true);
		
		Assert.isNotNull(res);
		CommandStack cs = ted.getCommandStack();
		cs.execute(new RecordingCommand(ted) {
			
			@Override
			protected void doExecute() {
				res.getContents().add(model);
			}
		});
		
		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void saveSpecificationWithTransaction() {
		CommandStack cs = ted.getCommandStack();
		cs.execute(new RecordingCommand(ted) {
			
			@Override
			protected void doExecute() {
				
				ResourceSetImpl resourceSet = (ResourceSetImpl) ted.getResourceSet();
				
				Resource modelResource = resourceSet.createResource(model.eResource().getURI());
				resourceSet.getURIResourceMap().put(modelResource.getURI(), modelResource);
				
				Assert.isNotNull(modelResource);
				
				modelResource.getContents().add(model);
				
				try {
					modelResource.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	/**
	 * Getter for model spec
	 * 
	 * @return The specification which contains the lower model tier
	 */
	public Specification getModel() {
		return model;
	}

	
	//We only create an instance in the partmaker
	public void createInstanceSpecification(URI diagramURI, String graphName) {
		Specification typeSpec = loadSpecification(ted.getResourceSet().getResource(M1_URI, true));
		Assert.isTrue(!typeSpec.eIsProxy());
		
		//The actual file resource in which our instance model should reside
		final Resource res = createFileResource(createURI(diagramURI, "xmi"), ted.getResourceSet());
		
		if(res.getContents().size() == 0) {
			model = CoreFactory.eINSTANCE.createSpecification();
			model.setType(typeSpec);
			model.createGraph(graphName);
			model.getGraph().setType(typeSpec.getGraph());
			
			CommandStack cs = ted.getCommandStack();
			cs.execute(new RecordingCommand(ted) {
				
				@Override
				protected void doExecute() {
					res.getContents().add(model);
				}
			});
		} else {
			//We assume the relevant stuff comes first
			try {
				res.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			model = (Specification) res.getContents().get(0);
		}
		EcoreUtil.resolve(model.getType(), res);
//		EcoreUtil.resolveAll(res);
//		EcoreUtil.resolveAll(ted.getResourceSet());
	}
	
	private Specification loadSpecification(Resource res) {
		Specification spec;
		try {
			res.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//The presedence of objects contained in a resource is important
			spec = (Specification) res.getContents().get(0); 
		}
		Assert.isNotNull(spec);
		return spec;
	}

	/**
	 * Strips the last segment of an URI and appends the desired ending
	 * 
	 * @param uri The URI to modify
	 * @param postfix The postfix to append
	 * @return URI
	 */
	private static URI createURI(URI uri, String postfix) {
		URI res = uri;
		res = res.trimFragment();
		res = res.trimFileExtension();
		res = res.appendFileExtension(postfix);
		
		return res;
	}
	
	public static URI findFile(String bundleId, String path) {
		Bundle b = Platform.getBundle(bundleId);
		URL url = FileLocator.find(b, new Path(path), null);
		
		try {
			return URI.createURI(url.toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public void createResource(URI uri) {
//	ResourceSet rs = ted.getResourceSet();
//	
//	modelResource = createFileResource(createURI(uri, "part.xmi"), rs);
//	
//	CommandStack cs = ted.getCommandStack();
//	cs.execute(new RecordingCommand(ted) {
//		
//		@Override
//		protected void doExecute() {
//			modelResource.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
//			modelResource.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
//			modelResource.getContents().add(model);
//		}
//	});
//	
//}
	
//	public TransactionalEditingDomain getTed() {
//	return ted;
//}
	
//	private Resource getResource(URI modelFileURI) {		
//	ResourceSetImpl resourceSet = (ResourceSetImpl) ted.getResourceSet();
//	//TODO: Sjekk om createResource lagar ny res uansett
//	Resource model = resourceSet.createResource(modelFileURI);
//	resourceSet.getURIResourceMap().put(modelFileURI, model);
//	
//	return model;
//}
	
//	//Refactor -> no need to handle resources in the manner below
//	public Specification loadModelWithTransaction(final URI uri, final URI... additionalSpecs) {
//		
//		CommandStack cs = ted.getCommandStack();
//		cs.execute(new RecordingCommand(ted) {
//			
//			@Override
//			protected void doExecute() {
////				ResourceSetImpl resourceSet = new ResourceSetImpl();
//				ResourceSetImpl resourceSet = (ResourceSetImpl)ted.getResourceSet();
//				
//				resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
//				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
//				
//				Resource defaultSpecification = resourceSet.createResource(DPFConstants.DefaultSpecification);
//
//				//WTF: These statements result in a TED write error (probably because the writing is done
//				//outside the doExecute). However, it works after the first exeception beeing thrown.
////				defaultSpecification.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
////				defaultSpecification.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
//				
//				resourceSet.getURIResourceMap().put(DPFConstants.DefaultSpecification, defaultSpecification);
//				
//				if(additionalSpecs != null) {
//					for(URI specURI : additionalSpecs) {
//////						DPFCoreUtil.loadSpecification(specURI);
//						Resource res = resourceSet.createResource(specURI);
//						resourceSet.getURIResourceMap().put(specURI, res);
//						try {
//							res.load(null);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//				
//				Resource modelResource = resourceSet.createResource(uri);
//				resourceSet.getURIResourceMap().put(uri, modelResource);
//				
//				Assert.isNotNull(modelResource);
//				
//				try {
//					modelResource.load(null);
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					EcoreUtil.resolveAll(resourceSet);
//					model = (Specification) modelResource.getContents().get(0);
//				}
//			}
//		});
//		System.out.println("Model loaded");
//		return model;
//	}
	
//	public Specification loadHierarchy(final URI... specs) {
//		
//		if(specs == null) return null;
//		
//		CommandStack cs = ted.getCommandStack();
//		cs.execute(new RecordingCommand(ted) {
//			
//			@Override
//			protected void doExecute() {
//				ResourceSetImpl resourceSet = (ResourceSetImpl)ted.getResourceSet();
//				
//				resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
//				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
//				
//				Resource defaultSpecification = resourceSet.createResource(DPFConstants.DefaultSpecification);
//
//				//WTF: These statements result in a TED write error (probably because the writing is done
//				//outside the doExecute). However, it works after the first exeception beeing thrown.
//				defaultSpecification.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
//				defaultSpecification.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
//				
//				resourceSet.getURIResourceMap().put(DPFConstants.DefaultSpecification, defaultSpecification);
//				
//				URI m1uri = DPFResourceHandler.findFile("no.hials.mums.shared", "models/m1.xmi");
//				Resource m1 = resourceSet.createResource(m1uri);
//				resourceSet.getURIResourceMap().put(m1uri, m1);
//				
//				Resource instanceModel = resourceSet.createResource(specs[0]);
//				resourceSet.getURIResourceMap().put(specs[0], instanceModel);
//				
//				Assert.isNotNull(instanceModel);
//				
//				try {
//					instanceModel.load(null);
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					model = (Specification) instanceModel.getContents().get(0);
//				}
//			}
//		});
//		System.out.println("Model loaded");
//		ModelUtil.printSpecification(model);
//		return model;
//	}
}
