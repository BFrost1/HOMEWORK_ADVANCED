package ua.homework.mine;

public class Mine {
	private volatile int amountGold;

	public Mine(int amountGold) {
		this.amountGold = amountGold;
	}

	public int getAmountGold() {
		return amountGold;
	}

	public synchronized void goldMining(Worker worker) {
		if (amountGold != 0) {
			try {
				Thread.sleep(1_000);
				if (amountGold - worker.getStep() > 0) {
					worker.addGold(worker.getStep());
					amountGold -= worker.getStep();
				} else {
					worker.addGold(amountGold);
					amountGold = 0;
					Thread.currentThread().interrupt();
				}
				System.out.println("Mine gold: " + amountGold + ", " + worker.getName() + ": " + worker.getGold() + " gold");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			Thread.currentThread().interrupt();
		}
	}
}
