package ua.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NumberHandler {

	public List<Integer> getRandomEvenNumbers(int limitThread, int quantityThread) {
		List<Integer> evenNumbers = new ArrayList<>();
		List<Future<Integer>> listFuture = new ArrayList<>();
		ExecutorService es = Executors.newFixedThreadPool(limitThread);

		while (evenNumbers.size() != 10) {
			for (int i = 0; i < quantityThread; i++) {
				listFuture.add(es.submit(() -> {
					TimeUnit.SECONDS.sleep(3);
					return new Random().nextInt(99) + 1;
				}));
			}

			for (Future<Integer> future : listFuture) {
				try {
					if (future.get() % 2 == 0) {
						evenNumbers.add(future.get());
					}
					if (evenNumbers.size() == 10) {
						break;
					}
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			listFuture = new ArrayList<>();
		}
		es.shutdown();
		return evenNumbers;
	}
}
