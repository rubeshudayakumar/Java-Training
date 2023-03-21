package builderpattern;

public class Bedroom {
	public Bed bed;
	public AC ac;

	public Bedroom(Bed bed, AC ac) {
		this.bed = bed;
		this.ac = ac;
	}

	static class BedroomBuilder {
		public Bed bed;
		public AC ac;

		public BedroomBuilder setBed(Bed bed) {
			this.bed = bed;
			return this;
		}

		public BedroomBuilder setAc(AC ac) {
			this.ac = ac;
			return this;
		}

		public Bedroom build() {
			return new Bedroom(this.bed, this.ac);
		}
	}
}

class Bed {
	public void useBed() {
		System.out.println("sleeping bed");
	}
}

class AC {
	public void useAC() {
		System.out.println("using AC");
	}
}