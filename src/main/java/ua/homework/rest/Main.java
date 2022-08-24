package ua.homework.rest;

import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		RestService restService = new RestService("result.txt", new TreeMap<Integer, LocalDateTime>());
		Semaphore semaphore = new Semaphore(0, true);
		new GeneratorID(restService);
		new ArrayHandler(restService, semaphore);
		new LogHandler(restService, semaphore);
	}
}
