package no.hib.dpf.m2m.transformation.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.geometry.Point;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	public static void SmodlXMLParser(IFile file){
		/*
		 * Initial location point
		 */
		Point p = new Point(10,200);
		
		try {
			String filePath =file.getProject().getLocation().toPortableString()
					+ "/"
					+ file.getParent().getProjectRelativePath().toString()+"/"+file.getName();
			File filetoparse = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc;
			try {
				doc = dBuilder.parse(filetoparse);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("service");
				/* 
				 * iteration of the root element Service
				 */
				for (int temp = 0; temp < nList.getLength(); temp++) {
					 
					   Node nNode = nList.item(temp);
					   /*
					    * adding Node Service to the specification
					    */
					   if(nNode.getNodeType() == Node.ELEMENT_NODE)
						   DPFTemplates.SpecificationContent(nNode.getNodeName(),getNodeValue(nNode,"name"),null,null,p.getCopy());
					   /*
					    * translating location of the point to top of the GraphicalEditor
					    */
					   p.translate(250, -150);
					   p.getCopy();
					   Point methodP = new Point(p);
					   
					   /*
					    * getting the content of the child elements of Service and adding specification content of the 
					    * Struct first to the Graph,if it exists  , because it can referred by the methods results and method args
					   */
					   getMethodAndStructdetails("struct", nNode, p);
					   p.setLocation(methodP) ;
					   p.translate(0, 150);
					   getMethodAndStructdetails("method", nNode, p);

				  }
			} catch (SAXException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void getMethodAndStructdetails(String childName, Node nNode,Point p){
		 NodeList nServiceChildNodes = nNode.getChildNodes();
		 Point nextMethodOrStruct = new Point(p);
		for(int count=0; count<nServiceChildNodes.getLength(); count++){
			   Node nServiceChild = nServiceChildNodes.item(count);
			   
			   if(nServiceChild.getNodeType() == Node.ELEMENT_NODE) {
				   if(nServiceChild.getNodeName().equalsIgnoreCase(childName)){
					   
					   DPFTemplates.SpecificationContent(nServiceChild.getNodeName(), getNodeValue(nServiceChild,"name"), 
							   nNode.getNodeName(), getNodeValue(nNode,"name"), p.getCopy());
					   getChildNodes(nServiceChild,p);
					   p.setLocation(nextMethodOrStruct);
					   p.translate(0, 100);
					   nextMethodOrStruct.setLocation(p);
				
				   }
				   
				 
				   
			   }
		   }
	}
	
	public static void getChildNodes(Node nNode,Point p){
		NodeList nChildNodes = nNode.getChildNodes();
		boolean nextArg = false;
		Node firstArg = null;
		   for(int mChildCount=0; mChildCount<nChildNodes.getLength(); mChildCount++){
			   Node nChild = nChildNodes.item(mChildCount);
			   if(nChild.getNodeType() == Node.ELEMENT_NODE) {
				   switch(nChild.getNodeName().toLowerCase()){
				   case "arg" :
					   
					   if(nextArg){
						   p.translate(250, 0);
						   DPFTemplates.SpecificationContent(nChild.getNodeName(), getNodeValue(nChild,"name"), firstArg.getNodeName(), getNodeValue(firstArg,"name"), p.getCopy());
						   if(getNodeValue(nChild, "type")!=null){
							   p.translate(0, 50);
							   
							   DPFTemplates.SpecificationContent("type", getNodeValue(nChild,"type"), nChild.getNodeName(), getNodeValue(nChild,"name"), p.getCopy());
							  
						   }
					   }  
					   else{
						   p.translate(250, 0);
						   DPFTemplates.SpecificationContent(nChild.getNodeName(), getNodeValue(nChild,"name"), nNode.getNodeName(), getNodeValue(nNode,"name"), p.getCopy());
						   if(getNodeValue(nChild, "type")!=null){
							   p.translate(0, 50);
							  DPFTemplates.SpecificationContent("type", getNodeValue(nChild,"type"), nChild.getNodeName(), getNodeValue(nChild,"name"), p.getCopy());
						   }
					   }
					   firstArg = nChild;
					   nextArg = true;
					   
					   break;
				   case "result":
					   p.translate(250, 0);
					   DPFTemplates.SpecificationContent("type", getNodeValue(nChild,"type"), nNode.getNodeName(), getNodeValue(nNode,"name"), p.getCopy());
					   break;
				   case "field":
					   p.translate(200, 0);
					   DPFTemplates.SpecificationContent("type", getNodeValue(nChild,"type"), nNode.getNodeName(), getNodeValue(nNode,"name"), p.getCopy());
					   
					   break;
				   }
			   }
			   
		   }
		
	}
	
	
	public static String getNodeValue(Node nNode,String attributeName){
		
		for(int iter = 0; iter<nNode.getAttributes().getLength(); iter++){
			if(nNode.getAttributes().item(iter).getNodeName().equalsIgnoreCase(attributeName))
				return nNode.getAttributes().item(iter).getNodeValue();
		}
		return null;
	}

	public static String getTagValue(String sTag, Element eElement) {
		//NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		NamedNodeMap nlList = eElement.getElementsByTagName(sTag).item(0).getAttributes();
			        Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeName()+"---"+nValue.getNodeValue();
	  }

}
