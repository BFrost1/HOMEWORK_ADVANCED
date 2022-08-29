package ua.homework.waitNotify;


public class Main {

	public static void main(String[] args) {
		Warehouse warehouse1 = new Warehouse("#1", 100);
		Warehouse warehouse2 = new Warehouse("#2", 0);

		Synchronizer<Trolley> synchronizer1 = new Synchronizer<Trolley>();
		Synchronizer<Trolley> synchronizer2 = new Synchronizer<Trolley>();
		
		Trolley trolley = new Trolley(6);
		new Transporter(synchronizer1, synchronizer2);
		new Loader(2, synchronizer1, warehouse1, trolley);
		new Unloader(3, synchronizer2, warehouse2);
	}
}
