package ua.homework.mine;

public class Worker implements Runnable {
	private String name;
	private int step;
	private int gold;

	private Thread thread;
	private Mine mine;

	public Worker(String name, int step, int gold, Mine mine) {
		this.name = name;
		this.step = step;
		this.gold = gold;
		this.mine = mine;
		this.thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println(name + " start work");
		while (!thread.isInterrupted()) {
			mine.goldMining(this);
		}
		System.out.println(name + " end work. Gold: " + gold);
	}

	public String getName() {
		return name;
	}

	public int getStep() {
		return step;
	}

	public int getGold() {
		return gold;
	}

	public Mine getMine() {
		return mine;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void addGold(int gold) {
		this.gold += gold;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}
	
	
}
