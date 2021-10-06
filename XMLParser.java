package com.rward.recharge;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLParser {
    String rawxml;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    Element element;

    public XMLParser(String xml) {
        this.rawxml = xml;
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new InputSource(new StringReader(rawxml)));
            element = doc.getDocumentElement();
            element.normalize();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String getElementValue(String element) {
        String value = null;
        try {
            NodeList nList = doc.getElementsByTagName(element).item(0).getChildNodes();
            Node node = nList.item(0);
            value = node.getNodeValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public String getElementValue(String element, int index) {
        String value = null;
        try {
            NodeList nList = doc.getElementsByTagName(element).item(index).getChildNodes();
            Node node = nList.item(0);
            value = node.getNodeValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public String getAttribute(String element, String attribute) {
        String attr = null;
        try {

            NodeList nList1 = doc.getElementsByTagName(element);
            Node node1 = nList1.item(0);
            Element el = (Element) node1;
            if (el.hasAttributes()) {
                attr = el.getAttribute(attribute);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return attr;
    }

    public String getAttribute(String element, String attribute, int index) {
        String attr = null;
        try {

            NodeList nList = doc.getElementsByTagName(element);
            Node node = nList.item(index);
            Element el = (Element) node;
            if (el.hasAttributes()) {
                attr = el.getAttribute(attribute);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return attr;
    }
    public boolean isElementEmpty(String element) {
        boolean val = false;
        try {

            NodeList nList = doc.getElementsByTagName(element);
            if (nList.getLength() > 0) {
                val = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean isAttributeEmpty(String element, String attribute) {
        boolean val = false;
        try {

            NodeList nList = doc.getElementsByTagName(element);

            Node node = nList.item(0);

            Element ele = (Element) node;
            val = ele.getAttribute(attribute).isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean isAttributeEmpty(String element, String attribute, int index) {
        boolean val = false;
        try {

            NodeList nList = doc.getElementsByTagName(element);
            Node node = nList.item(index);
            Element el = (Element) node;
            val = el.getAttribute(attribute).isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

}
