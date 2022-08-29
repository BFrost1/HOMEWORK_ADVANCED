package ua.homework.synchronizers;

import java.util.concurrent.Exchanger;

public class Main {

	public static void main(String[] args) {
		Warehouse warehouse1 = new Warehouse("#1", 100);
		Warehouse warehouse2 = new Warehouse("#2", 0);

		Trolley trolley = new Trolley(6);

		Exchanger<Trolley> exchangerLoader = new Exchanger<Trolley>();
		Exchanger<Trolley> exchangerUnloader = new Exchanger<Trolley>();

		new Loader(2, exchangerLoader, warehouse1, trolley);
		new Transporter(exchangerLoader, exchangerUnloader);
		new Unloader(3, exchangerUnloader, warehouse2);
	}
}
