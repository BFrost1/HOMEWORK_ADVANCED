package ua.homework.mcdonalds;

public class Main {

	public static void main(String[] args) {
        Cashier cashier = new Cashier("1", true);
        new Сustomer("Customer 1", cashier);
        new Сustomer("Customer 2", cashier);
        new Сustomer("Customer 3", cashier);
        new Сustomer("Customer 4", cashier);
        new Сustomer("Customer 5", cashier);
	}

}
