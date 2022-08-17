package ua.homework.mcdonalds;

import java.util.Random;

public class Cashier {
	private String name;
	private boolean open;

	public Cashier(String name, boolean open) {
		this.name = name;
		this.open = open;
	}

	public synchronized void service(String name) {
		try {
			if (open) {
				System.out.println("Cashier " + this.name + ": I serve the customer " + name);
				Thread.sleep(((int) (Math.random() * (5 - 3 + 1)) + 3) * 1000);
				System.out.println("Cashier " + this.name + ": I finished serving the customer " + name);
				Thread.currentThread().interrupt();
				open = new Random().nextInt(100) <= 50 ? false : true;
			} else {
				Thread.currentThread().interrupt();
				System.out.println("Store checkout closed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
