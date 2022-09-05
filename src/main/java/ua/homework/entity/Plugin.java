package ua.homework.entity;

public class Plugin {
	private String artifactId;
	private String version;

	public Plugin() {
	}

	public Plugin(String artifactId, String version) {
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public String toString() {
		return "Plugin [artifactId=" + artifactId + ", version=" + version + "]";
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
