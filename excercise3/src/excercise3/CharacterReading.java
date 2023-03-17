package excercise3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharacterReading {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		AcceptCharacter ac = new AcceptCharacter();
		
		while(true) {
			try {
				char c = (char)br.read();
				ac.displayCharacter(c);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

class AcceptCharacter{
	public void displayCharacter(char c) throws Exception{
		if(Character.isAlphabetic(c)==false && c!='\n') {
			throw new Exception();
		}
		System.out.println(c);
	}
}