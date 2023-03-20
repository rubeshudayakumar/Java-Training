package excercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventorySystem {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);

		Inventory inventory = new Inventory();

		String productNames[] = new String[] { "Shirt", "Shoe", "Pant", "Watch", "Bag" };

		es.execute(() -> {
			for (int i = 0; i < productNames.length; i++) {
				inventory.produce(productNames[i]);
			}
		});

		es.execute(() -> {
			for (int i = 0; i < productNames.length; i++) {
				inventory.consume();
			}
		});

	}
}

class Inventory {
	Product products[];

	Inventory() {
		products = new Product[0];
	}

	synchronized public void produce(String name) {

		if (products.length != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			products = new Product[1];
			products[0] = new Product(name);
			System.out.println("Product produced : " + name);
			notify();
		}
	}

	synchronized public void consume() {
		if (products.length == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Product consumed : " + products[0].name);
			products = new Product[0];
			notify();
		}
	}

}

class Product {
	String name;

	Product(String name) {
		this.name = name;
	}
}