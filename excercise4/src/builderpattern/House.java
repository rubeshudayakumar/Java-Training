package builderpattern;

public class House {
	
	public Hall hall;
	public Kitchen kitchen;
	public Bathroom bathroom;
	public Bedroom bedroom;
	
	public House(Hall hall, Kitchen kitchen, Bathroom bathroom, Bedroom bedroom) {
		this.hall = hall;
		this.kitchen = kitchen;
		this.bathroom = bathroom;
		this.bedroom = bedroom;
	}

	static class BuildHouse{
		
		public Hall hall;
		public Kitchen kitchen;
		public Bathroom bathroom;
		public Bedroom bedroom;
		
		public BuildHouse setHall(Hall hall) {
			this.hall = hall;
			return this;
		}
		
		public BuildHouse setKitchen(Kitchen kitchen) {
			this.kitchen = kitchen;
			return this;
		}
		
		public BuildHouse setBathroom(Bathroom bathroom) {
			this.bathroom = bathroom;
			return this;
		}
		
		public BuildHouse setBedroom(Bedroom bedroom) {
			this.bedroom = bedroom;
			return this;
		}
		
		public House build() {
			return new House(this.hall,this.kitchen,this.bathroom,this.bedroom);
		}
		
	}
}

