package ua.homework.synchronizers;

import java.util.concurrent.Exchanger;

public class Transporter implements Runnable {
	private Exchanger<Trolley> exchangerLoader;
	private Exchanger<Trolley> exchangerUnloader;
	private Thread thread;

	public Transporter(Exchanger<Trolley> exchangerLoader, Exchanger<Trolley> exchangerUnloader) {
		this.exchangerLoader = exchangerLoader;
		this.exchangerUnloader = exchangerUnloader;
		this.thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				exchangerUnloader.exchange(exchangerLoader.exchange(null));
				System.out.println("Transporter transports the trolley to the Unloader");
				exchangerLoader.exchange(exchangerUnloader.exchange(null));
				System.out.println("Transporter transports the trolley to the Loader");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
