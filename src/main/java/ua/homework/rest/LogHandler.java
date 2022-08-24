package ua.homework.rest;

import java.util.concurrent.Semaphore;

public class LogHandler implements Runnable {
	private Semaphore semaphore;
	private RestService restService;

	public LogHandler(RestService restService, Semaphore semaphore) {
		this.restService = restService;
		this.semaphore = semaphore;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				semaphore.acquire();
				restService.addLog();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
