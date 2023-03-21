package builderpattern;

public class Hall{
	public Sofa sofa;
	public TV tv;
	
	public Hall(Sofa sofa, TV tv) {
		this.sofa = sofa;
		this.tv = tv;
	}	
	
	static class HallBuilder{
		public Sofa sofa;
		public TV tv;
		
		public HallBuilder setSofa(Sofa sofa) {
			this.sofa = sofa;
			return this;
		}
		
		public HallBuilder setTv(TV tv) {
			this.tv = tv;
			return this;
		}
		
		public Hall build() {
			return new Hall(this.sofa,this.tv);
		}
	}
	
}
class Sofa{
	public void useSofa() {
		System.out.println("sitting on sofa");
	}
}
class TV{
	public void useTV() {
		System.out.println("watching TV");
	}
}