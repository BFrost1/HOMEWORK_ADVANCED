package ua.homework.mine;

public class Barrack implements Runnable {
	private int numberWorkers = 4;

	private Mine mine;
	private Thread thread;

	public Barrack(Mine mine) {
		this.mine = mine;
		this.thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();

	}

	@Override
	public void run() {
		while (!thread.isInterrupted()) {
			try {
				Thread.sleep(10_000);
				new Worker("Worker " + (numberWorkers++), 3, 0, mine);
				System.out.println("Create Worker " + numberWorkers);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
