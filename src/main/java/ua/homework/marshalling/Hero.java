package ua.homework.marshalling;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hero {
	protected String name;
	protected int healthPoints;
	protected int intelligence;
	protected int agility;
	protected int strength;
		
	public Hero() {

	}

	public Hero(String name, int healthPoints, int intelligence, int agility, int strength) {
		this.name = name;
		this.healthPoints = healthPoints;
		this.intelligence = intelligence;
		this.agility = agility;
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", healthPoints=" + healthPoints + ", intelligence=" + intelligence + ", agility="
				+ agility + ", strength=" + strength + "]";
	}

	public String getName() {
		return name;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getAgility() {
		return agility;
	}

	public int getStrength() {
		return strength;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
}
