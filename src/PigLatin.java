import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String ask;
		System.out.println("Hi and welcome to the Pig Latin translator.");

		do {
			System.out.println("Please enter a sentence: ");

			String userSent = input.nextLine().toLowerCase();

			String[] userWords = userSent.split(" ");

			System.out.print("In Pig Latin: ");

			for (String i : userWords) { // for each word...
				char firstChar = i.charAt(0); // grab the first character
				String pigLatin;

				if (VowOrCon(firstChar)) { // if the word starts w a vowel...
					pigLatin = i + "way";
				} else { // if the word starts w a consonant...
					pigLatin = ConsonConversion(i, firstChar); // method call on the word to convert it to pig latin
				}
				System.out.print(pigLatin + " ");
			}
			System.out.println("\nWant to convert another sentence? Enter y/n: ");
			ask = input.nextLine();
		} while (ask.equalsIgnoreCase("y"));
		System.out.println("Goodbye - er, oodbyegay!");
	}

	public static boolean VowOrCon(char currentChar) {
		switch (currentChar) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		case 'y':
			return true;
		default:
			return false;
		}
	}

	public static String ConsonConversion(String word, char first) {
		int indexOfFirstVowel = 0; // outside main, u must initialize integers w a value
		String consonStr = "";

		for (char i : word.toCharArray()) { // for each character in the word...
			if (VowOrCon(i)) { // if current char is a vowel...
				indexOfFirstVowel = word.indexOf(i);
				break;
			} else { // if current char is a consonant...
				consonStr = consonStr + Character.toString(i);
			}
		}
		String restOfWord = word.substring(indexOfFirstVowel);
		String newWord = restOfWord + consonStr + "ay";
		return newWord;
	}

}
