package eg.edu.alexu.csd.datastructure.stack.cs04;

import java.io.PushbackInputStream;

import java.io.*;
import java.util.Scanner;

import org.junit.internal.runners.ErrorReportingRunner;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

import eg.edu.alexu.csd.datastructure.linkedList.cs04.SinglyLinkedList;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * <h1>Stack implementation ,Converting infix expression to postfix epression
 * and evaluate it</h1> This program implements stack and an application on it
 * that converting infix expression to postfix epression and evaluate it
 * 
 * @author Aia Lotfy
 * @version 1.0
 * @since 2016-04-28
 */
public class Stack implements IExpressionEvaluator, IStack {
	/**
	 * object is object of {@link SinglyLinkedList} type used to import
	 * {@link SinglyLinkedList} class to use it in the methods of the stack
	 */
	SinglyLinkedList object = new SinglyLinkedList();

	/**
	 * This method is used to add an object with its index into the stack. This
	 * is
	 * 
	 * @param index
	 *            This is the first paramter to add method which is the object's
	 *            index
	 * @param element
	 *            This is the second parameter to add method which is the
	 *            object's value
	 */
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		int i = this.size();
		object.add(i - index, element);
	}

	/**
	 * This method is used to get the last element added at the stack at top and
	 * remove it from the stack.
	 * 
	 * @return top of stack element, or through exception if empty
	 */
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		Object o = object.get(0);
		object.remove(0);
		return o;
	}

	/**
	 * Get the element last added to the stack without removing it.
	 * 
	 * @return last element of stack element, or through exception if empty
	 */
	@Override
	public Object peek() {
		Object o = object.get(0);
		// TODO Auto-generated method stub
		return o;
	}

	/**
	 * add element onto the top of this stack.
	 * 
	 * @param element
	 *            to insert
	 */

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		object.add(0, element);

	}

	/**
	 * Tests if this stack is empty
	 * 
	 * @return true if stack empty else return false
	 */
	@Override
	public boolean isEmpty() {

		return object.isEmpty();
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 */

	@Override
	public int size() {
		return object.size;
	}

	/**
	 * coverting infix expression to postfix and return it
	 * 
	 * @param expression
	 *            is infix expression
	 * 
	 * @return postfix expression
	 */
	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		boolean bolly = false;
		expression = expression.replaceAll("\\s+", "");
		String tr = expression.trim();

		if (expression.equals("")) {
			throw new RuntimeException("empty ya yoyo");
		}
		if (expression == null) {
			throw new RuntimeException("empty ya yoyo");
		}
		StringBuilder returned = new StringBuilder();
		Stack stackTemp = new Stack();
		// String[] strIni = expression.split("");
		String current;
		int j = 0;
		boolean bool = false;
		int len = expression.length() - 1;
		if (expression.charAt(0) == '-' || expression.charAt(0) == '+' || expression.charAt(0) == '*'
				|| expression.charAt(0) == '/') {
			throw new RuntimeException("eshara awel");
		}
		if (expression.charAt(len) == '-' || expression.charAt(len) == '+' || expression.charAt(len) == '*'
				|| expression.charAt(len) == '/') {
			throw new RuntimeException("eshara a5er");
		}
		for (int i = 0; i < expression.length(); i++) {
			char chary = 0;
			j = i;
			current = "" + expression.charAt(i);
			if (current.equals(" ")) {

			} else {
				if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'
						|| expression.charAt(i) == '/') {
					counter3++;
					if (bolly == true) {
						throw new RuntimeException("2222 ope");
					}
					bolly = true;
				}

				// j = i;
				if (j != expression.length() - 1) {
					String tryFirst = "" + expression.charAt(j);
					String trySecond = "" + expression.charAt(j + 1);
					while ((tryFirst.equals("0") || tryFirst.equals("1") || tryFirst.equals("2") || tryFirst.equals("3")
							|| tryFirst.equals("4") || tryFirst.equals("5") || tryFirst.equals("6")
							|| tryFirst.equals("7") || tryFirst.equals("8") || tryFirst.equals("9"))
							&& (trySecond.equals("0") || trySecond.equals("1") || trySecond.equals("2")
									|| trySecond.equals("3") || trySecond.equals("4") || trySecond.equals("5")
									|| trySecond.equals("6") || trySecond.equals("7") || trySecond.equals("8")
									|| trySecond.equals("9"))) {
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

				if (!(current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/")
						|| current.equals("(") || current.equals(")"))) {
					returned.append(current);
					returned.append(" ");
					bolly = false;

				} else if (stackTemp.isEmpty() || stackTemp.peek().equals("(") || current.equals("(")) {
					stackTemp.push(current);
				}

				else if (current.equals(")")) {
					counter2++;
					returned.append(stackTemp.pop());
					returned.append(" ");
					String s = (String) stackTemp.pop();
					if (!s.equals("(")) {
						throw new RuntimeException("unvalid input");
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
			throw new RuntimeException("akwas");
		}
		if (counter3 == 0) {
			throw new RuntimeException("only objs");
		}
		return returned.toString();
	}

	/**
	 * Evaluating a postfix expression, with a single space separator
	 * 
	 * @param expression
	 *            is a postfix expression
	 * 
	 * @return the value of it
	 */

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		// throw new RuntimeException(expression);
		// float f = Float.parseFloat("25");
		// throw new RuntimeException(expression);
		String tr = expression.trim();
		if (tr.equals("")) {
			throw new RuntimeException("empty ya yoyo");
		}
		if (expression == null) {
			throw new RuntimeException("empty ya yoyo");
		}
		//
		// expression = infixToPostfix(expression);
		double firstInput, secondInput, result = 0;
		// String[] strIni = expression.split("");
		String current = "";
		int j = 0;
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
					while ((fiString.equals("0") || fiString.equals("1") || fiString.equals("2") || fiString.equals("3")
							|| fiString.equals("4") || fiString.equals("5") || fiString.equals("6")
							|| fiString.equals("7") || fiString.equals("8") || fiString.equals("9"))
							&& (seString.equals("0") || seString.equals("1") || seString.equals("2")
									|| seString.equals("3") || seString.equals("4") || seString.equals("5")
									|| seString.equals("6") || seString.equals("7") || seString.equals("8")
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
				if (!(current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/"))) {
					double d = Double.parseDouble(current);

					stackTemp.push(d);

				} else if (current.equals("+")) {
					double fStr = (Double) stackTemp.pop();
					double sStr = (Double) stackTemp.pop();
					// firstInput = Double.parseDouble(fStr);
					// secondInput = Double.parseDouble(sStr);

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
			throw new RuntimeException("aaktar mn 1");
		}
		result = (double) stackTemp.pop();
		return (int) result;
	}

}