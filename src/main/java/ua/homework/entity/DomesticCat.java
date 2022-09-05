package ua.homework.entity;

import ua.homework.annotations.Color;

public class DomesticCat extends Cat {
	@Color(color = "Green")
	public String color;

	public DomesticCat(String name, int age) {
		super(name, age);
	}

	@Override
	public void voice() {

	}

	@Override
	public void run() {

	}

	@Override
	public void eat() {

	}

	public void scratch() {

	}

}
