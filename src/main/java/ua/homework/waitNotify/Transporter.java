package ua.homework.waitNotify;

import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {
	private Synchronizer<Trolley> loader;
	private Synchronizer<Trolley> unloader;
	private Trolley trolley;
	private Thread thread;

	public Transporter(Synchronizer<Trolley> loader, Synchronizer<Trolley> unloader) {
		this.loader = loader;
		this.unloader = unloader;
		this.thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				trolley = loader.getTrolley();
				System.out.println("Transporter transports the trolley to the Unloader");
				TimeUnit.SECONDS.sleep(5);
				unloader.setTrolley(trolley);
				trolley = null;

				trolley = unloader.getTrolley();
				System.out.println("Transporter transports the trolley to the Loader");
				TimeUnit.SECONDS.sleep(5);
				loader.setTrolley(trolley);
				trolley = null;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
