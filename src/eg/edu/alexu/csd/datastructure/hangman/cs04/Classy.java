package eg.edu.alexu.csd.datastructure.hangman.cs04;

import java.util.Random;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Classy implements IHangman {
	Scanner scan = new Scanner(System.in);
	int order, i, finishCoding = 0, option = 0, j, counterWrong = 0, counterRight = 0;
	int randomIndex;
	String list[] = new String[20];
	String listInput;
	String arr[];
	// new String[20];
	String movieHeros[] = { "john mcclane", "frank castle", "sam witwicky", "katniss everdeen", "gordy brewer" };
	String cartoonHeros[] = { "aUrOra", "CindeRella", "rApoNzel", "niMo", "SNoW WHITE" };
	int index;
	int counter;
	int randomWordLength;
	boolean tryArr[] = new boolean[26];
	char[] hidenWord = new char[50];
	char guessInput;
	char[] userWrongGuess = new char[26 + 10];
	char[] userRightGuess = new char[26 + 10];
	String dashStr;
	int guessNumber = 0;
	int wrongGuess = 0;
	String myWord;
	int wrongAnswers = -1;
	String word;
	String randomSelected;
	int numIndex;
	String returned;
	int notNull;
	String settedArr;
	int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0;
	//
	//////////////////////////////////////////

	// @Override
	public void setDictionary(String[] words) {

		int size = words.length;
		int sum = 0;
		if (size == 0 || size < 0) {
			System.out.println("error");
		} else {
			String temp[] = new String[size];
			for (int poin = 0; poin < size; poin++) {
				if (words[poin] == null) {

				} else {
					temp[sum] = words[poin];
					sum++;
				}
			}

			if (sum == 0) {
				System.out.println("You Sould Insert a set of words");
			} else {
				arr = new String[sum];
				for (int counter = 0; counter < sum; counter++) {
					// for (int coun =0; coun< temp[counter].length();coun++){
					// char y= temp[counter].charAt(coun);
					// y=Character.toUpperCase(y);
					// temp[counter] =
					// temp[counter].replace(temp[counter].charAt(coun), y);
					// //System.out.print(y);
					// }

					arr[counter] = temp[counter];
				}
			}
		}
		flag1 = 1;

	}

	// @Override
	public String selectRandomSecretWord() {
		if (flag1 == 1) {
			flag2 = 1;
			Random rand = new Random();
			if (arr.length <= 0) {
				System.out.println("error can't be negative ");
				return null;

			} else {
				if (arr.length == 1) {
					if (arr[0] == null) {
						System.out.println("error");
					} else
						randomIndex = 0;
				} else {
					randomIndex = rand.nextInt(arr.length);
					// int flag =0 ;
					// while (arr[randomIndex]==null){
					// randomIndex = rand.nextInt(arr.length);
					//
					// }

				}

				dashStr = arr[randomIndex];

				for (int dash_ind = 0; dash_ind < dashStr.length(); dash_ind++) {
					if (dashStr.charAt(dash_ind) == ' ') {
						dashStr = dashStr.replace(' ', ' ');

					}

					else {
						char result = dashStr.charAt(dash_ind);
						dashStr = dashStr.replace(result, '-');
					}

				}
				System.out.println(dashStr);

				return arr[randomIndex];

			}

		}

		else {
			System.out.println("error set dictionary first");
			return null;
		}

	}

	public String guess(Character c) {
		if (flag1 == 1 && flag2 == 1) {
			flag3 = 1;
			if (arr[randomIndex].equals(dashStr)) {
				return null;
			}
			if (arr[randomIndex] == null) {
				return null;
			}
			if (arr.length == 0) {
				return null;
			}
			if (c == null) {
				return null;
			} else if (Character.isLetter(c)) {

				/*
				 * int try1 = c - 'A'; int try2 = c - 'a'; int try3 = 0; if
				 * (try1 >=0 && try1 <26) try3=try1; else if (try2 >=0 && try2
				 * <26) try3=try2; if (tryArr[try3]== true){
				 * System.out.println(
				 * "You Have Guessed it Please Guess another Alphabet"); return
				 * dashStr;
				 * 
				 * }
				 */
				if (false) {

				} else {
					String word = arr[randomIndex];
					int catch_place1, catch_place2;
					char s = '\0';
					if (Character.isLowerCase(c)) {
						s = Character.toUpperCase(c);
					} else if (Character.isUpperCase(c)) {
						s = Character.toLowerCase(c);
					}
					catch_place1 = word.indexOf(c);
					catch_place2 = word.indexOf(s);
					if (catch_place2 < 0 && catch_place1 < 0) {
						wrongAnswers++;
						if (wrongAnswers == wrongGuess)
							return null;
					}

					if (catch_place2 < 0) {
						if ((s >= 'A' && s <= 'Z')) {
							tryArr[s - 'A'] = true;
						} else if ((s >= 'a' && s <= 'z'))
							tryArr[s - 'a'] = true;
						// wrongAnswers++;
						if (wrongAnswers == wrongGuess)
							return null;
						else {
						} // wala 7aga

					} // if 3'alat

					else {
						char[] myNameChars = dashStr.toCharArray();

						myNameChars[catch_place2] = s;
						dashStr = String.valueOf(myNameChars);
						int last = word.lastIndexOf(s);
						while (catch_place2 != last && catch_place2 >= 0) {

							catch_place2 = word.indexOf(s, catch_place2 + 1);
							char[] myNameChars1 = dashStr.toCharArray();
							myNameChars1[catch_place2] = s;
							dashStr = String.valueOf(myNameChars1);
						} // while
						if ((s >= 'A' && s <= 'Z'))
							tryArr[s - 'A'] = true;
						else
							tryArr[s - 'a'] = true;

					}

					if (catch_place1 < 0) {
						if ((c >= 'A' && c <= 'Z')) {
							tryArr[c - 'A'] = true;
						} else if ((c >= 'a' && c <= 'z'))
							tryArr[c - 'a'] = true;
						// wrongAnswers++;
						if (wrongAnswers == wrongGuess)
							return null;
						else {
						} // wala 7aga

					} // if 3'alat

					else {
						char[] myNameChars = dashStr.toCharArray();

						myNameChars[catch_place1] = c;
						dashStr = String.valueOf(myNameChars);
						int last = word.lastIndexOf(c);
						while (catch_place1 != last && catch_place1 >= 0) {

							catch_place1 = word.indexOf(c, catch_place1 + 1);
							char[] myNameChars1 = dashStr.toCharArray();
							myNameChars1[catch_place1] = c;
							dashStr = String.valueOf(myNameChars1);
						} // while
						if ((c >= 'A' && c <= 'Z'))
							tryArr[c - 'A'] = true;
						else
							tryArr[c - 'a'] = true;

					} // mawgod

				}

			} else
				wrongAnswers++;

		} else {

			return null;
		}

		return dashStr;
	}

	// @Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max == '\0') {
			wrongGuess = 0;
		} else
			wrongGuess = max - 1;
	}
	//

	public static void main(String[] args) {

		Classy object = new Classy();
		object.setMaxWrongGuesses(5);
		// TODO Auto-generated method stub
		System.out.println("Start Game Press 1 ");
		// System.out.println("Enter Your Code Press 2 ");
		System.out.println("Create Word List Press 2 ");

		object.order = object.scan.nextInt();
		while (!(object.order == 1 || object.order == 2)) {
			object.order = object.scan.nextInt();
		}
		if (object.order == 2 && object.finishCoding == 0) {
			System.out.println("Add List of Words Separeted by Comma (,) ");
			object.listInput = object.scan.next();
			object.list = object.listInput.split(",");
			object.index = object.list.length;
			object.setDictionary(object.list);
		} else if (object.order == 1) {
			System.out.println("Enter a Number from 1 to 2");
			System.out.println("1. Movie Heroes");
			System.out.println("2. Cartoon Heroes");
			object.option = object.scan.nextInt();
			if (object.option == 1) {
				object.index = 5;
				object.setDictionary(object.movieHeros);
			} else if (object.option == 2) {
				object.index = 5;
				object.setDictionary(object.cartoonHeros);

			}

		}
		object.randomSelected = object.selectRandomSecretWord();

		object.randomWordLength = object.arr[object.randomIndex].length();
		while ((object.wrongAnswers < object.wrongGuess)) {
			System.out.println("Enter Your Guess");
			object.guessInput = object.scan.next().charAt(0);
			object.returned = object.guess(object.guessInput);
			if (object.returned == null) {
				System.out.println(object.dashStr);
			} else {
				System.out.println(object.returned);
			}
			if (object.dashStr.equals(object.arr[object.randomIndex])) {
				break;
			}

		}
		if (object.dashStr.equals(object.arr[object.randomIndex])) {
			System.out.println("CONGRATULATIONS!!");
		} else {
			System.out.println(object.arr[object.randomIndex]);
			System.out.println("YOU LOST!!");
		}
	}

}