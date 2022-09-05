package ua.homework.entity;

import ua.homework.annotations.Blochable;
import ua.homework.annotations.Color;
import ua.homework.annotations.OneEyed;

@Blochable

public class YardCat extends Cat {
	@Color
	public String color;

	public YardCat(String name, int age) {
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
