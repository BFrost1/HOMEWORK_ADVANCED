package ua.homework.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
	private int step;

	private Exchanger<Trolley> exchangerLoader;

	private Warehouse warehouse;
	private Trolley trolley;

	public Loader(int step, Exchanger<Trolley> exchangerLoader, Warehouse warehouse, Trolley trolley) {
		this.step = step;
		this.exchangerLoader = exchangerLoader;
		this.warehouse = warehouse;
		this.trolley = trolley;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (warehouse.getProducts() > 0) {
			try {
				System.out.println("Loder working");
				TimeUnit.SECONDS.sleep(2);
				trolley.add(warehouse.take(step >= trolley.getFreeSpace() ? trolley.getFreeSpace() : step));
				System.out.println(warehouse + " " + trolley);
				if (trolley.getFreeSpace() == 0 || warehouse.getProducts() == 0) {
					trolley = exchangerLoader.exchange(trolley);
					trolley = exchangerLoader.exchange(null);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Mission accomplished");
	}
}
