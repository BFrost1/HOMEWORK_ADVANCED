package ua.homework.parserDOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ua.homework.entity.Build;
import ua.homework.entity.Dependency;
import ua.homework.entity.Plugin;
import ua.homework.entity.PluginManagement;
import ua.homework.entity.Project;

public class ParserDOM {
	private Document builder;

	public ParserDOM(String uri) {
		try {
			this.builder = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(uri);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public Project parserDocument() {
		Project project = new Project(
				builder.getDocumentElement().getElementsByTagName("modelVersion").item(0).getTextContent(),
				builder.getDocumentElement().getElementsByTagName("groupId").item(0).getTextContent(),
				builder.getDocumentElement().getElementsByTagName("artifactId").item(0).getTextContent(),
				builder.getDocumentElement().getElementsByTagName("version").item(0).getTextContent(),
				builder.getDocumentElement().getElementsByTagName("name").item(0).getTextContent(),
				builder.getDocumentElement().getElementsByTagName("url").item(0).getTextContent(),
				new Build(new PluginManagement(parserPlugin())), parserProperties(),
				parseAttributes(builder.getDocumentElement()), parserDependencies());
		return project;
	}

	private List<Plugin> parserPlugin() {
		List<Plugin> arrayList = new ArrayList<Plugin>();
		NodeList list = builder.getElementsByTagName("plugin");
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) list.item(i);
				arrayList.add(new Plugin(element.getElementsByTagName("artifactId").item(0).getTextContent(),
						element.getElementsByTagName("version").item(0).getTextContent()));
			}
		}
		return arrayList;
	}

	private List<Dependency> parserDependencies() {
		List<Dependency> arrayList = new ArrayList<Dependency>();
		NodeList list = builder.getElementsByTagName("dependency");
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) list.item(i);
				arrayList.add(new Dependency(element.getElementsByTagName("groupId").item(0).getTextContent(),
						element.getElementsByTagName("artifactId").item(0).getTextContent(),
						element.getElementsByTagName("version").item(0).getTextContent(),
						element.getElementsByTagName("scope").item(0).getTextContent()));
			}
		}
		return arrayList;
	}

	private List<String> parserProperties() {
		List<String> arrayList = new ArrayList<String>();
		NodeList list = builder.getElementsByTagName("properties").item(0).getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				arrayList.add(list.item(i).getTextContent());
			}
		}
		return arrayList;
	}

	private List<String> parseAttributes(Element element) {
		List<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < element.getAttributes().getLength(); i++) {
			arrayList.add(element.getAttributes().item(i).getTextContent());
		}
		return arrayList;
	}
}
