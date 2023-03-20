package builderpattern;

public class Bathroom{
	public Bathtub bathtub;
	public Shower shower;
	
	public Bathroom(Bathtub bathtub, Shower shower) {
		this.bathtub = bathtub;
		this.shower = shower;
	}
	
	static class BuildBathroom{
		public Bathtub bathtub;
		public Shower shower;
		
		public BuildBathroom setBathtub(Bathtub bathtub) {
			this.bathtub = bathtub;
			return this;
		}
		
		public BuildBathroom setShower(Shower shower) {
			this.shower = shower;
			return this;
		}
		
		public Bathroom build() {
			return new Bathroom(this.bathtub,this.shower);
		}
	}	
}
class Bathtub{
	public void useBathtub() {
		System.out.println("bathing in bathtub");
	}
}
class Shower{
	public void useShower() {
		System.out.println("bathing in shower");
	}
}
