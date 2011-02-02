from org.eclipse.emf.ecore.resource.impl import ResourceSetImpl
from org.eclipse.emf.ecore.xmi.impl import XMLResourceFactoryImpl
from no.hib.dpf.metamodel import MetamodelFactory

def save(filename, graph):
    """docstring for save"""
    resourceSet = ResourceSetImpl()
    resourceSet.getResrouceFactoryRegistry().getExtensionToFactoryMap()['xmi'] = XMLResourceFactoryImpl()
   
class Graph(object):
    """Graph..."""
    def __new__(cls):
        return MetamodelFactory.eINSTANCE.createGraph()
