//		//
//		//Add missing Ids: (while keeping comments)
//		//
//		final ICompositeNode c = NodeModelUtils.findActualNodeFor(model);
//		final StringBuffer buffer = new StringBuffer();
//		BidiTreeIterator<INode> ti = c.getAsTreeIterable().iterator();
//		StringBuffer cache = new StringBuffer();
//		boolean incompleteDpfId=false;
//		DpfId id = null;
//		while(ti.hasNext()){
//			final INode n = ti.next();
//			if(n instanceof LeafNode){		
//				if(n.getSemanticElement() instanceof DpfId){
//					id = (DpfId)n.getSemanticElement(); 
//					if(id.getId() < 1){
//						incompleteDpfId=true;
//						cache.append(n.getText());
//					}else{
//						buffer.append(n.getText());
//					}
//				}else{
//					if(incompleteDpfId){
//						buffer.append(cache.toString().replaceFirst(id.getName(),id.getName() + "@100"));
//						cache = new StringBuffer();
//					    incompleteDpfId=false;
//					}
//					buffer.append(n.getText());
//				}
//			}
//		}


	public static Document parse(String path) {
		// System.err.println("should open the file, may have parse error [not found in editor by XtextDocumentUtil.get(IFile)]");
		// cf. IXtextDocument xtextDoc = XtextDocumentUtil.get(currFile);
		URI uri = URI.createURI(path);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		XtextDocument xdoc = new XtextDocument();
		resource.setModified(true);
		xdoc.setInput((XtextResource) resource);

		return parse(xdoc);
	}

	public static Document parse(IFile f) {
		IXtextDocument xd = XtextDocumentUtil.get(f);
		if (xd == null) { // open the file
			IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			IWorkbenchPage activePage = window.getActivePage();
			activePage.saveAllEditors(true);
			try {
				IEditorPart editorPart = IDE.openEditor(activePage, f);
				xd = XtextDocumentUtil.get(editorPart);
				return parse(xd);
			} catch (PartInitException e) {
			}
			return parse(f.getFullPath().toPortableString());
		} else
			return parse(xd);
	}

	public static Document parse(IXtextDocument xd) {
		return xd.readOnly(new IUnitOfWork<Document, XtextResource>() {
			public Document exec(XtextResource resource) throws Exception {
				Model model = EcoreUtil.copy((Model) resource.getContents().get(0));
				return Gaml2JDOM.doConvert(model);
			}
		});
	}
