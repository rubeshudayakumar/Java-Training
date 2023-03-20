package visitorpattern;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		Batsman viratKohli = new Batsman();
		
		System.out.println("1.Flick\n2.SquareDrive\n3.Sweep");
		System.out.println("Enter the shot name : ");
		String shotName = scanner.next();
	
		Shot shot = (Shot)Class.forName("visitorpattern."+shotName).getDeclaredConstructor().newInstance();
		viratKohli.playShot(shot);
		
		scanner.close();
		
	}
}


class Response{
	public void doResponse(BowledException e) {
		System.out.println("Get out of the pitch sadly");
	}
	
	public void doResponse(SixerShotException e) {
		System.out.println("Celebrate with your striker");
	}
	
	public void doResponse(FielderSavedTheBall e) {
		System.out.println("Run to the another striker to get a run");
	}
}


class Batsman {
	public void playShot(Shot shot) {
		try {
			shot.hitBall();
		}
		catch(CricketException e) {
			e.printStackTrace();
			e.visit();
		}
	}
}


abstract class CricketException extends Exception{
	String msg;
	public abstract void visit();
	public String toString() {
		return "Exception...."+this.msg;
	}
}

class BowledException extends CricketException{

	BowledException(String msg){
		this.msg = msg;
	}
	
	@Override
	public void visit() {
		new Response().doResponse(this);
	}
	
}

class SixerShotException extends CricketException{
	
	public SixerShotException(String msg) {
		this.msg = msg;
	}

	@Override
	public void visit() {
		new Response().doResponse(this);
	}
	
}

class FielderSavedTheBall extends CricketException{
	
	public FielderSavedTheBall(String msg) {
		this.msg = msg;
	}

	@Override
	public void visit() {
		new Response().doResponse(this);
	}
	
}
