package strategypattern;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the shape which you want to draw : ");
		String shapename = scanner.next();
		
		InsertShape shapeInsert = new InsertShape();
		shapeInsert.shape =  (Shape)Class.forName("strategypattern."+shapename).getConstructor().newInstance();
		shapeInsert.shape.drawShape();
		
		scanner.close();
	}
}
