package visitorpattern;

class Sweep extends Shot{

	@Override
	public void hitBall() throws CricketException {
		throw new FielderSavedTheBall("You hit a defensive shot");
	}
	
}

