package eg.edu.alexu.csd.datastructure.stack.cs04;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * <h1>Stack applications</h1> This program implements converting from infix to
 * postfix and evalute a postfix expression
 * 
 * @author Aia Lotfy
 * @version 1.0
 * @since 2016-04-28
 */
public class AppsMain {
	/**
	 * This is the main method which makes use of all methods converting from
	 * infix to postfix and evalute a postfix expression You are able to do any
	 * action of those shown above by choosing from the menu.
	 * 
	 * @param args
	 *            Unused.
	 * @return Nothing.
	 * @exception IOException
	 *                On input error.
	 * @see IOException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stackObj = new Stack();
		// java.util.Scanner scan = new java.util.Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		int option = 0;
		String expression = null;
		String previous;
		String ss;
		int eva;
		System.out.println("Hey,It is application more efficient with stack's applications. ");
		System.out.println("You can convert infix expression to postfix expression and evaluate it.");
		System.out.println("If you are interested in it please choose anaction you want.");
		int x = 1;
		do {
			try {

				System.out.println("1:Convert from infix to postfix \n2: Evalute postfix\n3: To end");
				option = scan.nextInt();
				if (!(option == 1 || option == 2 || option == 3)) {
					option = 1 / 0;
				}
				if (option == 1) {
					// System.out.println("Insert your infix expression.");
					expression = scan.nextLine();

					expression = expression.replaceAll("\\s+", "");

					while (expression.equals("")) {
						System.out.println("Insert your infix expression.");
						expression = scan.nextLine();

						expression = expression.replaceAll("\\s+", "");

					}
					while (expression == null) {
						System.out.println("Insert your infix expression.");
						expression = scan.nextLine();

						expression = expression.replaceAll("\\s+", "");

					}
					int x1 = 1;
					do {
						try {
							int counter1 = 0;
							int counter2 = 0;
							int counter3 = 0;
							boolean bolly = false;
							StringBuilder returned = new StringBuilder();
							Stack stackTemp = new Stack();
							// String[] strIni = expression.split("");
							String current;
							int j = 0;
							boolean bool = false;
							int inf;
							int len = expression.length() - 1;
							if (expression.charAt(0) == '-' || expression.charAt(0) == '+'
									|| expression.charAt(0) == '*' || expression.charAt(0) == '/') {
								inf = 1 / 0;
							}
							if (expression.charAt(len) == '-' || expression.charAt(len) == '+'
									|| expression.charAt(len) == '*' || expression.charAt(len) == '/') {
								inf = 1 / 0;
							}
							for (int i = 0; i < expression.length(); i++) {
								char chary = 0;
								j = i;
								current = "" + expression.charAt(i);
								if (current.equals(" ")) {

								} else {
									if (expression.charAt(i) == '-' || expression.charAt(i) == '+'
											|| expression.charAt(i) == '*' || expression.charAt(i) == '/') {
										counter3++;
										if (bolly == true) {
											inf = 1 / 0;
										}
										bolly = true;
									}

									// j = i;
									if (j != expression.length() - 1) {
										String tryFirst = "" + expression.charAt(j);
										String trySecond = "" + expression.charAt(j + 1);
										while ((tryFirst.equals("0") || tryFirst.equals("1") || tryFirst.equals("2")
												|| tryFirst.equals("3") || tryFirst.equals("4") || tryFirst.equals("5")
												|| tryFirst.equals("6") || tryFirst.equals("7") || tryFirst.equals("8")
												|| tryFirst.equals("9"))
												&& (trySecond.equals("0") || trySecond.equals("1")
														|| trySecond.equals("2") || trySecond.equals("3")
														|| trySecond.equals("4") || trySecond.equals("5")
														|| trySecond.equals("6") || trySecond.equals("7")
														|| trySecond.equals("8") || trySecond.equals("9"))) {
											current += trySecond;

											j++;
											tryFirst = "" + expression.charAt(j);
											trySecond = "" + expression.charAt(j + 1);
											bool = true;
											if (j == expression.length()) {
												break;
											}

										}
									}

									i = j;

									if (!(current.equals("+") || current.equals("-") || current.equals("*")
											|| current.equals("/") || current.equals("(") || current.equals(")"))) {
										returned.append(current);
										returned.append(" ");
										bolly = false;

									} else if (stackTemp.isEmpty() || stackTemp.peek().equals("(")
											|| current.equals("(")) {
										stackTemp.push(current);
										
									}

									else if (current.equals(")")) {
										counter2++;
										returned.append(stackTemp.pop());
										returned.append(" ");
										String s = (String) stackTemp.pop();
										if (!s.equals("(")) {
											inf = 1 / 0;
										} else {
											counter1++;
										}

									} else if ((current.equals("*") || current.equals("/"))
											&& (stackTemp.peek().equals("+") || stackTemp.peek().equals("-"))) {
										stackTemp.push(current);

									} else if ((current.equals("*") || current.equals("/"))
											&& (stackTemp.peek().equals("*") || stackTemp.peek().equals("/"))) {
										returned.append(stackTemp.pop());
										returned.append(" ");
										stackTemp.push(current);

									} else if ((current.equals("+") || current.equals("-"))
											&& (stackTemp.peek().equals("*") || stackTemp.peek().equals("/"))) {
										returned.append(stackTemp.pop());
										returned.append(" ");
										if (!stackTemp.isEmpty()) {
											String peekMin = (String) stackTemp.peek();

											if ((peekMin.equals("-") || peekMin.equals("+"))) {
												returned.append(stackTemp.pop());
												returned.append(" ");
											}
										}

										stackTemp.push(current);

									} else if ((current.equals("+") || current.equals("-"))
											&& (stackTemp.peek().equals("+") || stackTemp.peek().equals("-"))) {
										returned.append(stackTemp.pop());
										returned.append(" ");
										stackTemp.push(current);
									}
								}
							}
							int size1 = stackTemp.size();
							for (int i = 0; i < size1 - 1; i++) {
								returned.append(stackTemp.pop());
								returned.append(" ");
							}
							if (!stackTemp.isEmpty())
								returned.append(stackTemp.pop());
							if (counter1 != counter2) {
								inf = 1 / 0;
							}
							if (counter3 == 0) {
								inf = 1 / 0;
							}
							ss = returned.toString();
							System.out.println(ss);
							x1 = 2;
						} catch (Exception e2) {
							System.out.println("Invalid input.");
							System.out.println("Insert a valid input.");
							expression = scan.nextLine();

							expression = expression.replaceAll("\\s+", "");

							while (expression.equals("")) {
								System.out.println("Insert your infix expression.");
								expression = scan.nextLine();

								expression = expression.replaceAll("\\s+", "");

							}
							while (expression == null) {
								System.out.println("Insert your infix expression.");
								expression = scan.nextLine();

								expression = expression.replaceAll("\\s+", "");

							}
						}
					} while (x1 == 1);

					// System.out.println(expression);
				} else if (option == 2) {
					// System.out.println("Insert your infix expression.");
					expression = scan.nextLine();

					expression = expression.replaceAll("\\s+", "");

					while (expression.equals("")) {
						System.out.println("Insert your postfix expression.");
						expression = scan.nextLine();

					}
					while (expression == null) {
						System.out.println("Insert your postfix expression.");
						expression = scan.nextLine();

					}
					int x1 = 1;
					do {
						try {
							double firstInput, secondInput, result = 0;

							String current = "";
							int j = 0;
							int inf;
							Stack stackTemp = new Stack();
							for (int i = 0; i < expression.length(); i++) {
								j = i;
								current = "" + expression.charAt(i);

								// current = strIni[i + 1];
								if (current.equals(" ")) {

								} else {
									if (j != expression.length() - 1) {
										String fiString = "" + expression.charAt(j);
										String seString = "" + expression.charAt(j + 1);
										while ((fiString.equals("0") || fiString.equals("1") || fiString.equals("2")
												|| fiString.equals("3") || fiString.equals("4") || fiString.equals("5")
												|| fiString.equals("6") || fiString.equals("7") || fiString.equals("8")
												|| fiString.equals("9"))
												&& (seString.equals("0") || seString.equals("1") || seString.equals("2")
														|| seString.equals("3") || seString.equals("4")
														|| seString.equals("5") || seString.equals("6")
														|| seString.equals("7") || seString.equals("8")
														|| seString.equals("9"))) {
											current += seString;

											j++;
											fiString = "" + expression.charAt(j);
											seString = "" + expression.charAt(j + 1);
											if (j == expression.length()) {
												break;
											}

										}
									}
									i = j;
									if (!(current.equals("+") || current.equals("-") || current.equals("*")
											|| current.equals("/"))) {
										double d = Double.parseDouble(current);

										stackTemp.push(d);

									} else if (current.equals("+")) {
										double fStr = (Double) stackTemp.pop();
										double sStr = (Double) stackTemp.pop();
										// firstInput =
										// Double.parseDouble(fStr);
										// secondInput =
										// Double.parseDouble(sStr);

										stackTemp.push(fStr + sStr);
									} else if (current.equals("-")) {
										double fStr = (Double) stackTemp.pop();
										double sStr = (Double) stackTemp.pop();
										stackTemp.push(sStr - fStr);
									} else if (current.equals("*")) {
										double fStr = (Double) stackTemp.pop();
										double sStr = (Double) stackTemp.pop();

										stackTemp.push(sStr * fStr);
									} else if (current.equals("/")) {
										double fStr = (Double) stackTemp.pop();
										double sStr = (Double) stackTemp.pop();
										stackTemp.push(sStr / fStr);
									}

								}

							}
							if (stackTemp.size() != 1) {
								inf = 1 / 0;
							}
							result = (double) stackTemp.pop();
							eva = (int) result;
							System.out.println(eva);
							x1 = 2;
						} catch (Exception e3) {
							System.out.println("Invalid input.");
							System.out.println("Insert a valid input.");
							expression = scan.nextLine();

							while (expression.equals("")) {
								System.out.println("Insert your posfix expression.");
								expression = scan.nextLine();

							}
							while (expression == null) {
								System.out.println("Insert your postfix expression.");
								expression = scan.nextLine();

							}
						}
					} while (x1 == 1);

					// System.out.println(expression);
				} else if (option == 3) {
					System.out.println("Bye :D");
					break;
				}
			} catch (Exception e) {
				System.out.println("please choose valid input.");
			}
		} while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6);

	}
}
