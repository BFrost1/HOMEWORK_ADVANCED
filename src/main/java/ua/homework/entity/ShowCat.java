package ua.homework.entity;

import ua.homework.annotations.Color;

public class ShowCat extends Cat {
	@Color(color = "Blue")
	public String color;

	public ShowCat(String name, int age) {
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

}
