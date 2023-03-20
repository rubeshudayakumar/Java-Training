package commandpattern;

class GiveFoodCommand extends Command{
	
	Plate plate;
	Food food;
	Pet pet;

	public GiveFoodCommand(Plate plate, Food food, Pet pet) {
		this.plate = plate;
		this.food = food;
		this.pet = pet;
	}

	@Override
	public void execute() {
		plate.providePlate();
		food.pourFood();
		pet.doPet();
	}
}

class Plate{
	public void providePlate() {
		System.out.println("Providing the plate");
	}
}
class Food{
	public void pourFood() {
		System.out.println("Pouring the food");
	}
}
class Pet{
	public void doPet() {
		System.out.println("Doing some pet");
	}
}
