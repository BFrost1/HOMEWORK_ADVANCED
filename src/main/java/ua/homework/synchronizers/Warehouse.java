package ua.homework.synchronizers;

public class Warehouse {
	private volatile String name;
	private volatile int products;

	public Warehouse() {
	}

	public Warehouse(String name, int product) {
		this.name = name;
		this.products = product;
	}

	@Override
	public String toString() {
		return "Warehouse " + name + " balance: " + products;
	}

	public String getName() {
		return name;
	}

	public int getProducts() {
		return products;
	}

	public int take(int amount) {
		int take = 0;
		if (amount > 0) {
			if (this.products - amount > 0) {
				this.products -= amount;
				take = amount;
			} else {
				take = this.products;
				this.products = 0;
			}
		}
		return take;
	}

	public void add(int product) {
		this.products += product;
	}

}
