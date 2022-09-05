package ua.homework.entity;

public class Build {
	private PluginManagement management;

	public Build() {
	}

	public Build(PluginManagement management) {
		this.management = management;
	}

	@Override
	public String toString() {
		return "Build [management=" + management + "]";
	}

	public PluginManagement getManagement() {
		return management;
	}

	public void setManagement(PluginManagement management) {
		this.management = management;
	}
}
