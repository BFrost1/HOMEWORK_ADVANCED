package ua.homework.mcdonalds;

public class Сustomer implements Runnable {
	private String nameBuyer;
	private Cashier cashier;

	private Thread thread;

	public Сustomer(String name, Cashier cashier) {
		this.nameBuyer = name;
		this.cashier = cashier;
		this.thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (!thread.isInterrupted()) {
			cashier.service(nameBuyer);
		}
		System.out.println("Buyer " + nameBuyer + " left the store");
	}

	public String getNameBuyer() {
		return nameBuyer;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public Thread getThread() {
		return thread;
	}

}
