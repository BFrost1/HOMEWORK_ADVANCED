package ua.homework.entity;

import java.util.List;

public class PluginManagement {
	private List<Plugin> plugins;

	public PluginManagement() {
	}

	@Override
	public String toString() {
		return "PluginManagement [plugins=" + plugins + "]";
	}

	public PluginManagement(List<Plugin> plugins) {
		this.plugins = plugins;
	}

	public List<Plugin> getPlugins() {
		return plugins;
	}

	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}

}
