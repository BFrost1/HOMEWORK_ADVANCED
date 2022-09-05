package ua.homework.entity;

import java.util.List;

public class Project {
	private String modelVersion;
	private String groupId;
	private String artifactId;
	private String version;
	private String name;
	private String url;

	private Build build;

	private List<String> properties;
	private List<String> attributes;
	private List<Dependency> dependencies;

	public Project(String modelVersion, String groupId, String artifactId, String version, String name, String url,
			Build build, List<String> properties, List<String> attributes, List<Dependency> dependencies) {
		this.modelVersion = modelVersion;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.name = name;
		this.url = url;
		this.build = build;
		this.properties = properties;
		this.attributes = attributes;
		this.dependencies = dependencies;
	}

	public Project() {

	}

	@Override
	public String toString() {
		return "Project [modelVersion=" + modelVersion + ", groupId=" + groupId + ", artifactId=" + artifactId
				+ ", version=" + version + ", name=" + name + ", url=" + url + ", build=" + build + ", properties="
				+ properties + ", attributes=" + attributes + ", dependencies=" + dependencies + "]";
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Build getBuild() {
		return build;
	}

	public List<String> getProperties() {
		return properties;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}
}
