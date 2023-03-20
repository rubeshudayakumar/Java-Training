package builderpattern;

public class Main {
	public static void main(String[] args) {
		
		Sofa sofa = new Sofa();
		TV tv =  new TV();
		Bed bed = new Bed();
		AC ac = new AC();
		Shower shower =  new Shower();
		Bathtub bathtub = new Bathtub();
		Chimney chimney = new Chimney();
		Stove stove = new Stove();
		
		House house  = new House.BuildHouse()
				.setHall(
						new Hall.BuildHall()
						.setSofa(sofa)
						.setTv(tv).build()
				)
				.setKitchen(
						new Kitchen.BuildKitchen()
						.setStove(stove)
						.setChimney(chimney)
						.build()
				).setBathroom(
						new Bathroom.BuildBathroom()
						.setBathtub(bathtub)
						.setShower(shower)
						.build()
				).setBedroom(
						new Bedroom.BuildBedroom()
						.setBed(bed)
						.setAc(ac)
						.build()
				)
		.build();
		
		watchTv(house);
		doShower(house);
		doCook(house);
		doSleep(house);
		
	}
	
	public static void watchTv(House house) {
		house.hall.tv.useTV();
	}
	
	public static void doShower(House house) {
		house.bathroom.shower.useShower();
	}
	
	public static void doCook(House house) {
		house.kitchen.stove.useStove();
	}
	
	public static void doSleep(House house) {
		house.bedroom.bed.useBed();
	}
	
}
