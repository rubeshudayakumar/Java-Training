package commandpattern;

public class PlayWithMeCommand extends Command{
	
	Feather feather;
	Ball ball;

	public PlayWithMeCommand(Feather feather, Ball ball) {
		this.feather = feather;
		this.ball = ball;
	}

	@Override
	public void execute() {
		feather.shakeFeather();
		ball.rollBall();
	}
}


class Feather{
	public void shakeFeather() {
		System.out.println("Shaking the feather");
	}
}
class Ball{
	public void rollBall() {
		System.out.println("Rolling the ball");
	}
}

