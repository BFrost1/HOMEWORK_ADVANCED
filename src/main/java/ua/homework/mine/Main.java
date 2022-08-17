package ua.homework.mine;

public class Main {

	public static void main(String[] args) {
		Mine mine = new Mine(1000);
		new Barrack(mine);
		new Worker("Worker 1", 3, 0, mine);
		new Worker("Worker 2", 3, 0, mine);
		new Worker("Worker 3", 3, 0, mine);
	}

}
