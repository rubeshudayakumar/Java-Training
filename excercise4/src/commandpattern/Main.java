package commandpattern;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Food food = new Food();
		Plate plate = new Plate();
		Pet pet = new Pet();
		
		Feather feather = new Feather();
		Ball ball = new Ball();
		
		Bed bed = new Bed();
		Music music = new Music();
		
		CatOwner catOwner = new CatOwner();
		catOwner.setSlot(0, new GiveFoodCommand(plate, food, pet));
		catOwner.setSlot(1, new PlayWithMeCommand(feather, ball));
		catOwner.setSlot(2, new IamSleepyCommand(bed, music));
		
		System.out.println("1.Give food\n2.Play With me\n3.Iam Sleepy");
		System.out.println("Enter the command number : ");
		
		int commandNumber = scanner.nextInt();
		catOwner.catCommand[commandNumber-1].execute();
		
		scanner.close();
	}
}





