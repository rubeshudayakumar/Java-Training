package builderpattern;

public class Kitchen {
	public Stove stove;
	public Chimney chimney;

	public Kitchen(Stove stove, Chimney chimney) {
		this.stove = stove;
		this.chimney = chimney;
	}

	static class KitchenBuilder {
		public Stove stove;
		public Chimney chimney;

		public KitchenBuilder setStove(Stove stove) {
			this.stove = stove;
			return this;
		}

		public KitchenBuilder setChimney(Chimney chimney) {
			this.chimney = chimney;
			return this;
		}

		public Kitchen build() {
			return new Kitchen(this.stove, this.chimney);
		}
	}
}

class Stove {
	public void useStove() {
		System.out.println("cooking in stove");
	}
}

class Chimney {
	public void useChimey() {
		System.out.println("using chimney");
	}
}
