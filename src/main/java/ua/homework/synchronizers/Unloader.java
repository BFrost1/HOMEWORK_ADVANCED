package ua.homework.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable {
	private int step;
	private Thread thread;

	private Exchanger<Trolley> exchangerUnloader;

	private Warehouse warehouse;
	private Trolley trolley;

	public Unloader(int step, Exchanger<Trolley> exchangerUnloader, Warehouse warehouse) {
		this.step = step;
		this.exchangerUnloader = exchangerUnloader;
		this.warehouse = warehouse;
		this.thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				trolley = exchangerUnloader.exchange(null);
				while (trolley.getFreeSpace() != trolley.getVolume()) {
					System.out.println("Unloader started working");
					TimeUnit.SECONDS.sleep(2);
					warehouse.add(trolley.take(step));
					System.out.println(warehouse + " " + trolley);
				}
				trolley = exchangerUnloader.exchange(trolley);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
