/**
 * <copyright>
 * Copyright (c) 2012 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * @author Anders Sandven <anders.sandven@gmail.com>
 * </copyright>
 *
 * $Id$
 */

package no.hib.dpf.codegen.xpand.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WorkflowParser {
	private DocumentBuilder builder = null;
	private DocumentBuilderFactory domfac;
	private Document doc = null;
	
	public WorkflowParser(String pathToXml) throws ParserConfigurationException, SAXException, IOException {
		domfac = DocumentBuilderFactory.newInstance();
		builder = domfac.newDocumentBuilder();
		doc = builder.parse(pathToXml);
	}
	
	public WorkflowParser(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		domfac = DocumentBuilderFactory.newInstance();
		builder = domfac.newDocumentBuilder();
		doc = builder.parse(is);
	}
	
	public void setProperty(String nameOfProperty, String value) {
		NodeList propTags = doc.getElementsByTagName("property");
		for(int i = 0; i < propTags.getLength(); ++i) {
			Node n = propTags.item(i);
			String propName = n.getAttributes().getNamedItem("name").getNodeValue();
			if(propName.contains(nameOfProperty)) {
				Element tmp = (Element)n;
				tmp.setAttribute("value", value);
			}
		}
	}
	
	public String getProperty(String nameOfProperty) {
		NodeList propTags = doc.getElementsByTagName("property");
		for(int i = 0; i < propTags.getLength(); ++i) {
			Node n = propTags.item(i);
			String propName = n.getAttributes().getNamedItem("name").getNodeValue();
			if(propName.contains(nameOfProperty)) {
				Element tmp = (Element)n;
				return tmp.getAttribute("value");
			}
		}
		return "";
	}
	
	public void setXpandEntryPoint(String entryPoint) {
		NodeList tmp = doc.getElementsByTagName("expand");
		for(int i = 0; i < tmp.getLength(); ++i) {
			Node n = tmp.item(i);
			Element e = (Element)n;
			e.setAttribute("value", entryPoint);
		}
	}
	
	public String getXml() throws TransformerException {
		TransformerFactory tfac = TransformerFactory.newInstance();
		Transformer trans = tfac.newTransformer();

		StringWriter sw = new StringWriter();
		StreamResult res = new StreamResult(sw);
		DOMSource src = new DOMSource(doc);
		trans.transform(src, res);
		return sw.toString();
	}
	
	public void writeXml(String filePath) throws TransformerException {
		TransformerFactory tfac = TransformerFactory.newInstance();
		Transformer trans = tfac.newTransformer();

		StreamResult res = new StreamResult(new File(filePath));
		DOMSource src = new DOMSource(doc);
		trans.transform(src, res);
	}
	public static void main(String[] args) {
		try {
			WorkflowParser p = new WorkflowParser(
					"/home/anders/Master/Code/main/generator-branch/no.hib.dpf.codegen.xpand.ui/resources/workflowtemplate.txt");
			p.setProperty("dpf_metamodel", "TEST");
			System.out.println(p.getXml());
			p.writeXml("/home/anders/Master/Code/main/generator-branch/no.hib.dpf.codegen.xpand.ui/resources/workflowtemplate2.txt");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
