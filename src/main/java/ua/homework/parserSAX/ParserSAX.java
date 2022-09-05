package ua.homework.parserSAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.homework.entity.Build;
import ua.homework.entity.Dependency;
import ua.homework.entity.Plugin;
import ua.homework.entity.PluginManagement;
import ua.homework.entity.Project;

public class ParserSAX extends DefaultHandler {
	private static final String PROJECT = "project";
	private static final String MODEL_VERSION = "modelVersion";
	private static final String GROUP_ID = "groupId";
	private static final String ARTIFACT_ID = "artifactId";
	private static final String VERSION = "version";
	private static final String SCOPE = "scope";
	private static final String NAME = "name";
	private static final String URL = "url";
	private static final String PROPERTIES = "properties";
	private static final String DEPENDENCIES = "dependencies";
	private static final String DEPENDENCY = "dependency";
	private static final String BUILD = "build";
	private static final String PLUGIN_MANAGEMENT = "pluginManagement";
	private static final String PLUGINS = "plugins";
	private static final String PLUGIN = "plugin";
	private static final String ENCODING = "project.build.sourceEncoding";
	private static final String SOURCE = "maven.compiler.source";
	private static final String TARGET = "maven.compiler.target";

	private Project project;
	private StringBuilder stringBuilder;

	private String now;

	@Override
	public void startDocument() throws SAXException {
		project = new Project();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(project);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case PROJECT:
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < attributes.getLength(); i++) {
				list.add(attributes.getValue(i));
			}
			project.setAttributes(list);
			now = PROJECT;
			break;

		case PROPERTIES:
			project.setProperties(new ArrayList<String>());
			now = PROPERTIES;
			break;

		case DEPENDENCIES:
			project.setDependencies(new ArrayList<Dependency>());
			now = DEPENDENCIES;
			break;

		case DEPENDENCY:
			project.getDependencies().add(new Dependency());
			now = DEPENDENCY;
			break;

		case BUILD:
			project.setBuild(new Build());
			now = BUILD;
			break;

		case PLUGIN_MANAGEMENT:
			project.getBuild().setManagement(new PluginManagement());
			now = PLUGIN_MANAGEMENT;
			break;

		case PLUGINS:
			project.getBuild().getManagement().setPlugins(new ArrayList<Plugin>());
			now = PLUGINS;
			break;

		case PLUGIN:
			project.getBuild().getManagement().getPlugins().add(new Plugin());
			now = PLUGIN;
			break;

		default:
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case MODEL_VERSION:
			project.setModelVersion(stringBuilder.toString());
			break;
			
		case GROUP_ID:
			if (now.equals(PROJECT)) {
				project.setGroupId(stringBuilder.toString());
			} else if (now.equals(DEPENDENCY)) {
				int latestIndex = project.getDependencies().size() - 1;
				project.getDependencies().get(latestIndex).setGroupId(stringBuilder.toString().trim());
			}
			break;
			
		case ARTIFACT_ID:
			if (now.equals(PROJECT)) {
				project.setArtifactId(stringBuilder.toString());
			} else if (now.equals(DEPENDENCY)) {
				int latestIndex = project.getDependencies().size() - 1;
				project.getDependencies().get(latestIndex).setArtifactId(stringBuilder.toString().trim());
			} else if (now.equals(PLUGIN)) {
				int latestIndex = project.getBuild().getManagement().getPlugins().size() - 1;
				project.getBuild().getManagement().getPlugins().get(latestIndex)
						.setArtifactId(stringBuilder.toString().trim());
			}
			break;
			
		case VERSION:
			if (now.equals(PROJECT)) {
				project.setVersion(stringBuilder.toString());
			} else if (now.equals(DEPENDENCY)) {
				int latestIndex = project.getDependencies().size() - 1;
				project.getDependencies().get(latestIndex).setVersion(stringBuilder.toString().trim());
			} else if (now.equals(PLUGIN)) {
				int latestIndex = project.getBuild().getManagement().getPlugins().size() - 1;
				project.getBuild().getManagement().getPlugins().get(latestIndex).setVersion(stringBuilder.toString().trim());
			}
			break;
			
		case NAME:
			project.setName(stringBuilder.toString().trim());
			break;
			
		case URL:
			project.setUrl(stringBuilder.toString().trim());
			break;
			
		case SCOPE:
			int latestIndex = project.getDependencies().size() - 1;
			project.getDependencies().get(latestIndex).setScope(stringBuilder.toString().trim());
			break;
			
		case ENCODING:
			project.getProperties().add(stringBuilder.toString().trim());
			break;
			
		case SOURCE:
			project.getProperties().add(stringBuilder.toString().trim());
			break;
			
		case TARGET:
			project.getProperties().add(stringBuilder.toString().trim());
			break;
			
		default:
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		stringBuilder = new StringBuilder().append(ch, start, length);
	}
}
