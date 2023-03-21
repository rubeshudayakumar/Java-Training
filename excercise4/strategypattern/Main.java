package strategypattern;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the shape which you want to draw : ");
		String shapeName = scanner.next();

		ShapeInserter shapeInsert = new ShapeInserter();
		try {
			shapeInsert.shape = (Shape) Class.forName("strategypattern." + shapeName).getConstructor().newInstance();
			shapeInsert.shape.drawShape();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		scanner.close();
	}
}
