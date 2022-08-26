package ua.homework.waitNotify;

public class Synchronizer<T> {
	private T obj;

	public synchronized T getTrolley() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public synchronized void setTrolley(T obj) {
		this.obj = obj;
		notify();
	}

}
