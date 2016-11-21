/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.ibm.apitester;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLDecoder {
	public Document ConvertString2Document(String input) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		Document doc = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new InputSource(new StringReader(input)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public String Orderdecoder(String output) {
		Document doc = ConvertString2Document(output);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("Order");

		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;

		String ItemOutput = "OrderNo : " + eElement.getAttribute("OrderNo") + "<br>" + "OrderHeaderKey : "
				+ eElement.getAttribute("OrderHeaderKey") + "<br>" + "EnterpriseCode : "
				+ eElement.getAttribute("EnterpriseCode") + "<br>" + "PaymentStatus : "
				+ eElement.getAttribute("PaymentStatus");
		return ItemOutput;
	}

	public String Itemdecoder(String output) {
		Document doc = ConvertString2Document(output);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("Item");

		Node ItemNode = nList.item(0);

		Element ItemElement = (Element) ItemNode;

		Element primaryInfoElement = (Element) ItemElement.getElementsByTagName("PrimaryInformation").item(0);
		String Description = primaryInfoElement.getAttribute("Description");

		String ItemOutput = "ItemKey : " + ItemElement.getAttribute("ItemKey") + "<br>" + "OrganizationCode : "
				+ ItemElement.getAttribute("OrganizationCode") + "<br>" + "ItemID : "
				+ ItemElement.getAttribute("ItemID") + "<br>" + "UnitOfMeasure : "
				+ ItemElement.getAttribute("UnitOfMeasure") + "<br>" + "Description : " + Description;

		return ItemOutput;
	}
}