package ua.homework.entity;


public abstract class Cat {
	protected String name;
	protected int age;
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	public abstract void voice();
	
	public abstract void run();
	
	public abstract void eat();

}
