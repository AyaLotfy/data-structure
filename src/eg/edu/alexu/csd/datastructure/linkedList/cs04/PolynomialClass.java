package eg.edu.alexu.csd.datastructure.linkedList.cs04;

import java.awt.Point;


import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;


public class PolynomialClass implements IPolynomialSolver {
	SinglyLinkedList A = new SinglyLinkedList();
	SinglyLinkedList B = new SinglyLinkedList();
	SinglyLinkedList C = new SinglyLinkedList();
	SinglyLinkedList R = new SinglyLinkedList();
	SinglyLinkedList S = new SinglyLinkedList();

	public void setPolynomial(char poly, int[][] terms) {

		if (poly == 'A') {
			mySet(A, terms);
		} else if (poly == 'B') {
			mySet(B, terms);
		} else if (poly == 'C') {
			mySet(C, terms);
		} else {
			throw new RuntimeException("NOT VALID INPUT");
		}

	}

	public String print(char poly) {

		if (poly == 'A') {
			if(A.isEmpty())
				return null;
			return myPrint(A);
		} else if (poly == 'B') {
			return myPrint(B);
		} else if (poly == 'C') {
			return myPrint(C);
		} else if (poly == 'R') {
			return myPrint(R);
		} else {
			return null;
		}

	}

	public void clearPolynomial(char poly) {// changed to=new SinglyLinkedList()
		if (poly == 'A') {
			if (A.isEmpty()) {
				
			} else {
				A.clear();
			}

		} else if (poly == 'B') {
			if (B.isEmpty()) {

			} else {
				B.clear();
			}

		} else if (poly == 'C') {
			if (C.isEmpty()) {

			} else {
				C.clear();
			}

		} else {
			throw new RuntimeException("NOT VALID INPUT");
		}

	}

	public float evaluatePolynomial(char poly, float value) {

		if (poly == 'A') {
			return substitute(A, value);
		} else if (poly == 'B') {
			return substitute(B, value);
		} else if (poly == 'C') {
			return substitute(C, value);
		} else {
			throw new RuntimeException("NOT VALID INPUT");
		}

	}

	public int[][] add(char poly1, char poly2) {
		if ((poly1 == 'A' && poly2 == 'A')) {
			return myAdd(A, A);
		} else if ((poly1 == 'B' && poly2 == 'A') || (poly1 == 'A' && poly2 == 'B')) {
			return myAdd(A, B);
		} else if ((poly1 == 'B' && poly2 == 'B')) {
			return myAdd(B, B);
		} else if (((poly1 == 'C' && poly2 == 'C'))) {
			return myAdd(C, C);
		} else if ((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B')) {
			return myAdd(C, B);
		} else if ((poly1 == 'C' && poly2 == 'A') || (poly1 == 'A' && poly2 == 'C')) {
			return myAdd(A, C);
		} else
			throw new RuntimeException("unvalid input");

	}

	public int[][] subtract(char poly1, char poly2) {

		if ((poly1 == 'A' && poly2 == 'A')) {
			int[][] toBeRet = new int [1][2];
			toBeRet[0][0]=0;
			toBeRet[0][1]=0;
			Point P = new Point(0,0);
			R.add(P);
			return toBeRet;
		} else if ((poly1 == 'B' && poly2 == 'B')) {
			int[][] toBeRet = new int [1][2];
			toBeRet[0][0]=0;
			toBeRet[0][1]=0;
			Point P = new Point(0,0);
			R.add(P);
			return toBeRet;
		} else if ((poly1 == 'C' && poly2 == 'C')) {
			int[][] toBeRet = new int [1][2];
			toBeRet[0][0]=0;
			toBeRet[0][1]=0;
			Point P = new Point(0,0);
			R.add(P);
			return toBeRet;
		} else if ((poly1 == 'A' && poly2 == 'B')) {
			S = mySubtract(B);
			return myAdd(A, S);
		} else if ((poly1 == 'B' && poly2 == 'A')) {
			S = mySubtract(A);
			return myAdd(B, S);
		} else if ((poly1 == 'B' && poly2 == 'C')) {
			S = mySubtract(C);
			return myAdd(B, S);
		} else if ((poly1 == 'C' && poly2 == 'B')) {
			S = mySubtract(B);
			return myAdd(C, S);
		} else if ((poly1 == 'A' && poly2 == 'C')) {
			S = mySubtract(C);
			return myAdd(A, S);
		} else if ((poly1 == 'C' && poly2 == 'A')) {
			S = mySubtract(A);
			return myAdd(C, S);
		} else {
			throw new RuntimeException("NOT VALID INPUT");
		}
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {

		if ((poly1 == 'A' && poly2 == 'A')) {
			return myMulti(A, A);
		} else if ((poly1 == 'B' && poly2 == 'A') || (poly1 == 'A' && poly2 == 'B')) {
			return myMulti(A, B);
		} else if ((poly1 == 'B' && poly2 == 'B')) {
			return myMulti(B, B);
		} else if (((poly1 == 'C' && poly2 == 'C'))) {
			return myMulti(C, C);
		} else if ((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B')) {
			return myMulti(C, B);
		} else if ((poly1 == 'C' && poly2 == 'A') || (poly1 == 'A' && poly2 == 'C')) {
			return myMulti(A, C);
		} else
			throw new RuntimeException("unvalid input");

	}

	// new added method by me for -1*coeff of x
	public SinglyLinkedList mySubtract(SinglyLinkedList negativePoly) {

		if (negativePoly.size == 0) {
			throw new RuntimeException("empty");
		}
		int iterator;

		int[][] myArray = new int[negativePoly.size][2];

		for (iterator = 0; iterator < negativePoly.size; iterator++) {
			Point workOn = new Point();
			workOn = (Point) negativePoly.get(iterator);
			myArray[iterator][0] = -1 * workOn.x;
			myArray[iterator][1] = workOn.y;

		}

		int myIterator;
		Point myTerm = new Point();
		SinglyLinkedList myList = new SinglyLinkedList();
		for (myIterator = 0; myIterator < myArray.length; myIterator++) {

			myTerm = new Point(myArray[myIterator][0], myArray[myIterator][1]);
			myList.add(myTerm);
		}

		return myList;
	}

	public int[][] myMulti(SinglyLinkedList list1, SinglyLinkedList list2) {

		if (list1 == null || list2 == null || list1.size == 0 || list2.size == 0) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}
		// added new
		Point checker1 = new Point();
		checker1 = (Point) list1.get(0);
		Point checker2 = new Point();
		checker2 = (Point) list2.get(0);
		if (list1.size == 1 && checker1.x == 0 && checker1.y == 0) {
			throw new RuntimeException("cleared or empty");

		}
		if (list2.size == 1 && checker2.x == 0 && checker2.y == 0) {
			throw new RuntimeException("cleared or empty");

		}

		int[][] arrayList1 = new int[list1.size][2];
		int[][] arrayList2 = new int[list2.size][2];

		for (int iterator = 0; iterator < list1.size; iterator++) {
			Point point1 = new Point();
			point1 = (Point) list1.get(iterator);
			arrayList1[iterator][0] = point1.x;
			arrayList1[iterator][1] = point1.y;
		}

		for (int iterator = 0; iterator < list2.size; iterator++) {
			Point point2 = new Point();
			point2 = (Point) list2.get(iterator);
			arrayList2[iterator][0] = point2.x;
			arrayList2[iterator][1] = point2.y;
		}
		int maxExp = arrayList2[0][1] + arrayList1[0][1];
		int minExp = arrayList2[list2.size - 1][1] + arrayList1[list1.size - 1][1];
		int[][] arrayMultiply = new int[maxExp - minExp + 1][2];

		for (int i = 0; i < list1.size; i++) {
			for (int j = 0; j < list2.size; j++) {

				int index = arrayList1[i][1] + arrayList2[j][1] - minExp;
				arrayMultiply[index][0] += arrayList1[i][0] * arrayList2[j][0];
				arrayMultiply[index][1] = arrayList1[i][1] + arrayList2[j][1];

			}
		}

		int[][] multiReverse = new int[arrayMultiply.length][2];
		boolean done;
		int j = arrayMultiply.length - 1;
		for (int i = 0; i < arrayMultiply.length; i++) {
			done = false;
			while (j >= 0 && done == false) {
				done = true;
				multiReverse[j][0] = arrayMultiply[i][0];
				multiReverse[j][1] = arrayMultiply[i][1];
				j--;

			}
		}

		for (int iterator = 0; iterator < arrayMultiply.length; iterator++) {
			arrayMultiply[iterator][0] = multiReverse[iterator][0];
			arrayMultiply[iterator][1] = multiReverse[iterator][1];

		}

		SinglyLinkedList multiply = new SinglyLinkedList();
		for (int i = 0; i < maxExp - minExp + 1; i++) {
			Point addPoint = new Point(arrayMultiply[i][0], arrayMultiply[i][1]);

			multiply.add(i, addPoint);

		}

		R = multiply;
		return arrayMultiply;

	}

	// new added method by me for addition
	public int[][] myAdd(SinglyLinkedList list1, SinglyLinkedList list2) {

		
		if (list1.size == 0 || list2.size == 0) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}
		int[][] arrayList1 = new int[list1.size][2];
		boolean[] boolList1 = new boolean[list1.size];
		int[][] arrayList2 = new int[list2.size][2];
		boolean[] boolList2 = new boolean[list2.size];

		for (int iterator = 0; iterator < list1.size; iterator++) {
			Point point1 = new Point();
			point1 = (Point) list1.get(iterator);
			arrayList1[iterator][0] = point1.x;
			arrayList1[iterator][1] = point1.y;
			boolList1[iterator] = false;
		} // putting 1st poly into array

		for (int iterator = 0; iterator < list2.size; iterator++) {
			Point point2 = new Point();
			point2 = (Point) list2.get(iterator);
			arrayList2[iterator][0] = point2.x;
			arrayList2[iterator][1] = point2.y;
			boolList2[iterator] = false;

		} // putting 2nd poly into array

		int max = arrayList1[0][1];
		int min = arrayList1[list1.size - 1][1];
		if (max < arrayList2[0][1]) {
			max = arrayList2[0][1];
		}
		if (min > arrayList2[list2.size - 1][1]) {
			min = arrayList2[list2.size - 1][1];
		}

		int[][] arrayAdd = new int[max + 1][2];// 1st change on aia's

		for (int i = 0; i < list1.size; i++) {

			for (int j = 0; j < list2.size; j++) {
				if ((arrayList1[i][1] > arrayList2[j][1]) && boolList1[i] == false) {
					int index = arrayList1[i][1];
					arrayAdd[index][0] = arrayList1[i][0];
					arrayAdd[index][1] = arrayList1[i][1];
					boolList1[i] = true;

				}

				if ((arrayList2[j][1] > arrayList1[i][1]) && boolList2[j] == false) {
					int index = arrayList2[j][1];
					arrayAdd[index][0] = arrayList2[j][0];
					arrayAdd[index][1] = arrayList2[j][1];
					boolList2[j] = true;

				}

				if ((arrayList1[i][1] == arrayList2[j][1]) && boolList1[i] == false && boolList2[j] == false) {
					int index = arrayList1[i][1];
					arrayAdd[index][0] = arrayList1[i][0] + arrayList2[j][0];
					arrayAdd[index][1] = arrayList1[i][1];
					boolList1[i] = true;
					boolList2[j] = true;
				}

			}
		}

		for (int i = 0; i < list1.size; i++) {
			if (boolList1[i] == false) {
				int index = arrayList1[i][1];
				arrayAdd[index][0] = arrayList1[i][0];
				arrayAdd[index][1] = arrayList1[i][1];

			}
		}

		for (int i = 0; i < list2.size; i++) {
			if (boolList2[i] == false) {
				int index = arrayList2[i][1];
				arrayAdd[index][0] = arrayList2[i][0];
				arrayAdd[index][1] = arrayList2[i][1];

			}
		}


		int[][] addReverse = new int[arrayAdd.length][2];
		boolean done;
		int j = arrayAdd.length - 1;
		for (int i = 0; i < arrayAdd.length; i++) {
			done = false;
			while (j >= 0 && done == false) {
				done = true;
				addReverse[j][0] = arrayAdd[i][0];
				addReverse[j][1] = arrayAdd[i][1];
				j--;

			}
		}

		
		for (int iterator = 0; iterator < arrayAdd.length; iterator++) {
			arrayAdd[iterator][0] = addReverse[iterator][0];
			arrayAdd[iterator][1] = addReverse[iterator][1];

		}
		
		int counter=0;
		for (int i = 0; i < max - min + 1; i++) {
			if (arrayAdd[i][0] != 0) {
				counter++;
			}

		}
		int[][] returnAdd = new int[counter][2];
		counter = 0;
		SinglyLinkedList sum = new SinglyLinkedList();
		for (int i = 0; i < max - min + 1; i++) {
			Point addPoint = new Point(arrayAdd[i][0], arrayAdd[i][1]);
			if (arrayAdd[i][0] != 0) {
				returnAdd[counter][0] = arrayAdd[i][0];
				returnAdd[counter][1] = arrayAdd[i][1];
				sum.add(i, addPoint);
				counter++;
			}

		}
	

		
		R = sum;

		return returnAdd;

	}

	public float substitute(SinglyLinkedList toWork, float value) {
		if (toWork.size == 0) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}

		float sigma = 0;
		int iterator;
		Point doneOn = new Point();

		for (iterator = 0; iterator < toWork.size; iterator++) {
			doneOn = (Point) toWork.get(iterator);
			sigma += (float) (doneOn.x * Math.pow(value, doneOn.y));
		}
		return sigma;

	}

	// new added method by me for printing
	public String myPrint(SinglyLinkedList poly) {

		if (poly.isEmpty()) {
			return null;

		}
		if (poly == A && A.isEmpty()) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}
		if (poly == B && B.isEmpty()) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}
		if (poly == C && C.isEmpty()) {
			throw new RuntimeException("ERROR EMPTY LIST");

		}

		int iterator = 0;
		String toBeReturned = new String();
		Point workOn = (Point) poly.get(iterator);
		if (workOn.x != 0) {
			if (workOn.x == 1) {
				if (workOn.y == 0) {
					toBeReturned = workOn.x + "";
				} else if (workOn.y == 1) {
					toBeReturned = "x";
				} else {
					toBeReturned = "x^" + workOn.y;
				}
			} else {
				if (workOn.y == 0) {
					toBeReturned = workOn.x + "";
				} else if (workOn.y == 1) {
					toBeReturned = workOn.x + "x";
				} else {
					toBeReturned = workOn.x + "x^" + workOn.y;
				}
			}
		} else {
			iterator += 1;
			while (workOn.x == 0 && iterator < poly.size) {
				workOn = (Point) poly.get(iterator);
				iterator++;

			}
			if (workOn.x == 1) {
				if (workOn.y == 0) {
					toBeReturned = workOn.x + "";
				} else if (workOn.y == 1) {
					toBeReturned = "x";
				} else {
					toBeReturned = "x^" + workOn.y;
				}
			} else {
				if (workOn.y == 0) {
					toBeReturned = workOn.x + "";
				} else if (workOn.y == 1) {
					toBeReturned = workOn.x + "x";
				} else {
					toBeReturned = workOn.x + "x^" + workOn.y;
				}

			}
		}

		iterator += 1;
		while (iterator < poly.size) {

			workOn = (Point) poly.get(iterator);

			String toBeAdded = new String();
			if (workOn.x != 0) {
				if (workOn.x < 0) {
					if (workOn.x == -1) {
						if (workOn.y == 0) {
							toBeAdded = workOn.x + "";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else if (workOn.y == 1) {
							toBeAdded = "-x";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else {
							toBeAdded = "-" + "x^" + workOn.y;
							toBeReturned = toBeReturned.concat(toBeAdded);

						}
					} else {
						if (workOn.y == 0) {
							toBeAdded = workOn.x + "";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else if (workOn.y == 1) {
							toBeAdded = workOn.x + "x";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else {
							toBeAdded = workOn.x + "x^" + workOn.y;
							toBeReturned = toBeReturned.concat(toBeAdded);

						}
					}

				}

				if (workOn.x > 0) {
					if (workOn.x == 1) {
						if (workOn.y == 0) {
							toBeAdded = "+" + workOn.x + "";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else if (workOn.y == 1) {
							toBeAdded = "x";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else {
							toBeAdded = "+" + "x^" + workOn.y;
							toBeReturned = toBeReturned.concat(toBeAdded);

						}
					} else {
						if (workOn.y == 0) {
							toBeAdded = "+" + workOn.x + "";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else if (workOn.y == 1) {
							toBeAdded = "+" + workOn.x + "x";
							toBeReturned = toBeReturned.concat(toBeAdded);

						} else {
							toBeAdded = "+" + workOn.x + "x^" + workOn.y;
							toBeReturned = toBeReturned.concat(toBeAdded);

						}
					}

				}

			} else {
				if (workOn.y == 0) {

				} else {
					toBeAdded = Integer.toString(workOn.y);
					toBeReturned = toBeReturned.concat(toBeAdded);

				}

			}

			iterator++;

		}

		return toBeReturned;

	}

	// my setter
	public void mySet(SinglyLinkedList myList, int[][] terms) {

		int checker;
		boolean greater = true;

		for (checker = 0; checker < terms.length && greater == true; checker++) {
			if (terms[checker][1] < 0) {
				greater = false;
			}
			if (checker + 1 < terms.length) {

				if (terms[checker][1] <= terms[checker + 1][1])

				{
					greater = false;
				}
			}
		}

		if (greater == false) {
			throw new RuntimeException("Not Polynomial retry");
		}

		int coeffIterator;
		Point myTerm = new Point();

		for (coeffIterator = 0; coeffIterator < terms.length; coeffIterator++) {

			myTerm = new Point(terms[coeffIterator][0], terms[coeffIterator][1]);
			myList.add(myTerm);
		}

	}

}
