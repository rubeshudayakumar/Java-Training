package visitorpattern;

class Flick extends Shot {
	@Override
	public void hitBall() throws CricketException {
		throw new BowledException("You are Bowled");
	}
}
