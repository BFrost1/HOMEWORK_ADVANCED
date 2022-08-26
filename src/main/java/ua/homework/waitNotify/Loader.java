package ua.homework.waitNotify;

import java.util.concurrent.TimeUnit;

public class Loader implements Runnable {
	private int step;
	private Synchronizer<Trolley> synchronizer;

	private Warehouse warehouse;
	private Trolley trolley;

	public Loader(int step, Synchronizer<Trolley> synchronizer, Warehouse warehouse, Trolley trolley) {
		this.step = step;
		this.synchronizer = synchronizer;
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
					synchronizer.setTrolley(trolley);
					trolley = null;
					trolley = synchronizer.getTrolley();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Mission accomplished");
	}

	public void setTrolley(Trolley trolley) {
		this.trolley = trolley;
		notify();
	}
}
