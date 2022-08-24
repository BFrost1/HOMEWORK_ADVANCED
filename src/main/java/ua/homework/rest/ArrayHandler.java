package ua.homework.rest;

import java.util.concurrent.Semaphore;

public class ArrayHandler implements Runnable {
	private Semaphore semaphore;
	private RestService restService;

	public ArrayHandler(RestService restService, Semaphore semaphore) {
		this.restService = restService;
		this.semaphore = semaphore;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10_000);
				restService.getCopyIdMap();
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
