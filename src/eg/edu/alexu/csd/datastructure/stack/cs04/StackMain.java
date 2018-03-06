
package eg.edu.alexu.csd.datastructure.stack.cs04;

import java.io.IOException;

import java.util.*;

/**
 * <h1>Stack implementation</h1> This program implements stack
 * 
 * @author Aia Lotfy
 * @version 1.0
 * @since 2016-04-28
 */
public class StackMain {
	/**
	 * This is the main method which makes use of all methods push, pop,peek,set
	 * stack size ,check if the stack is empty or not and add an object in a
	 * location You are able to do any action of thosez shown above by choosing
	 * from the menu.
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
		Scanner scan = new Scanner(System.in);
		int option = 0;
		Object ob;
		System.out.println("Hey,It is application more efficient with stack ");
		System.out.println("If you are interested in it please choose anaction you want.");
		int x = 1;
		do {
			try {

				System.out.println("1: Push\n2: Pop\n3: Peek\n4: Get size\n5: Check if empty\n6: To end");
				option = scan.nextInt();
				if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6)) {
					option = 1 / 0;
				}
				if (option == 1) {
					System.out.println("insert you input");
					ob = scan.next();
					stackObj.push(ob);
				} else if (option == 2) {
					if (!stackObj.isEmpty()) {
						ob = stackObj.pop();
						System.out.println(ob);
					}

					else {
						System.out.println("empty");
					}
				} else if (option == 3) {
					if (!stackObj.isEmpty()) {
						ob = stackObj.peek();
						System.out.println(ob);
					}

					else {
						System.out.println("empty");
					}
				} else if (option == 4) {
					System.out.println(stackObj.size());
				} else if (option == 5) {
					if (stackObj.isEmpty()) {
						System.out.println("empty stack.");
					} else {
						System.out.println("not empty stack");
					}

				} else if (option == 6) {
					System.out.println("bye :D ");
					break;
				}
			} catch (Exception e) {
				System.out.println("please choose valid input.");
			}
		} while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6);

	}

}
