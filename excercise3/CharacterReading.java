package excercise3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharacterReading {
	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		CharacterReader characterReader = new CharacterReader();

		while (true) {
			try {
				char character = (char) bufferedReader.read();
				characterReader.displayCharacter(character);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class CharacterReader {
	public void displayCharacter(char character) throws Exception {
		if (Character.isAlphabetic(character) == false && character != '\n') {
			throw new Exception();
		}
		System.out.println(character);
	}
}
