package visitorpattern;

class SquareDrive extends Shot{

	@Override
	public void hitBall() throws CricketException {
		throw new SixerShotException("You hit six");
	}
}
