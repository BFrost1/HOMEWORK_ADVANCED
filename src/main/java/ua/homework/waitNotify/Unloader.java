package ua.homework.waitNotify;

import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {
	private int step;
	private Synchronizer<Trolley> synchronizer;
	private Warehouse warehouse;
	private Trolley trolley;
	private Thread thread;

	public Unloader(int step, Synchronizer<Trolley> synchronizer, Warehouse warehouse) {
		this.step = step;
		this.warehouse = warehouse;
		this.synchronizer = synchronizer;
		this.thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				trolley = synchronizer.getTrolley();
				while (trolley.getFreeSpace() != trolley.getVolume()) {
					System.out.println("Unloader started working");
					TimeUnit.SECONDS.sleep(2);
					warehouse.add(trolley.take(step));
					System.out.println(warehouse + " " + trolley);
				}
				synchronizer.setTrolley(trolley);
				trolley = null;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setTrolley(Trolley trolley) {
		this.trolley = trolley;
		notify();
	}

}
