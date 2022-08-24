package ua.homework.rest;

import java.time.LocalDateTime;

public class GeneratorID implements Runnable {
	private RestService restService;

	public GeneratorID(RestService restService) {
		this.restService = restService;
		new Thread(this).start();
	}

	@Override
	public void run() {
		int id = 0;
		while (true) {
			try {
				Thread.sleep(2_000);
				restService.getIdMap().put(id++, LocalDateTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
