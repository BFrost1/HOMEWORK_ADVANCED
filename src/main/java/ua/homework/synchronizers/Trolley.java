package ua.homework.synchronizers;

public class Trolley {
	private volatile int volume;
	private volatile int filledPlace;

	public Trolley() {
	}

	public Trolley(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Trolley: " + volume + " | " + filledPlace;
	}

	public int getVolume() {
		return volume;
	}

	public int getFreeSpace() {
		return volume - filledPlace;
	}

	public int take(int amount) {
		int take = 0;
		if (amount > 0) {
			if (this.filledPlace - amount > 0) {
				this.filledPlace -= amount;
				take = amount;
			} else {
				take = this.filledPlace;
				this.filledPlace = 0;
			}
		}
		return take;
	}

	public void add(int amount) {
		if (amount > 0 && filledPlace + amount <= volume) {
			filledPlace += amount;
		}
	}

}
