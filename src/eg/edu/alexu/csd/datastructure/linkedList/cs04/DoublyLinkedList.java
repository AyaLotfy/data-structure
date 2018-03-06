package eg.edu.alexu.csd.datastructure.linkedList.cs04;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs04.SinglyLinkedList.SListNode;

public class DoublyLinkedList implements ILinkedList {

	public static void main(String[] args) {
		// System.out.println("fnsy");
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0, 5);
		System.out.println(test.get(0));
		Integer f = 0;
		test.add(f);
		System.out.println("node0  " + test.get(0));
		test.add(++f);
		System.out.println("node1   " + test.get(1));
		test.add(++f);
		System.out.println("node2  " + test.get(2));
		test.add(++f);
		System.out.println("node3   " + test.get(3));

		test.remove(3);
		if (test.contains(3) == false) {
			System.out.println("right");

		}
		test.remove(2);
		System.out.println("" + test.get(1));
		test.remove(1);
		System.out.println("" + test.get(0));
		test.remove(0);

	}

	public class doubleListNode {
		public Object value;
		public doubleListNode next = null;
		public doubleListNode previous = null;

		public doubleListNode(Object v) {
			this.value = v;
		}
	}

	private doubleListNode header = null;
	private doubleListNode trailer = null;
	public int size = 0;

	public void print() {
		doubleListNode i = header;
		if (i == null) {
			System.out.println("empty");
		}
		while (i != null) {
			System.out.print(i.value + " ");
			i = i.next;
		}
		System.out.println();
	}

	// Finished doubly!
	public void add(int index, Object element) {

		doubleListNode toBeAdded = new doubleListNode(element);
		doubleListNode forwardMovablePointer = header;

		if (index > size || index < 0) {// added new index<0
			throw new RuntimeException("index greater than the size can't be available");
		} else {

			if (index == 0) {

				size++;
				toBeAdded.next = header;
				// forwardMovablePointer = toBeAdded ;
				header = toBeAdded;
				toBeAdded.previous = null;

				if (size == 1) {
					trailer = toBeAdded;
				} else {
					forwardMovablePointer.previous = toBeAdded;

				}

			} else {

				for (int counter = 0; counter < index - 1; counter++) {
					forwardMovablePointer = forwardMovablePointer.next;
				}
				toBeAdded.next = forwardMovablePointer.next;
				forwardMovablePointer.next = toBeAdded;
				toBeAdded.previous = forwardMovablePointer;
				forwardMovablePointer = forwardMovablePointer.next;
				forwardMovablePointer.previous = toBeAdded;
				size++;

			}

		}

	}

	// Finished doubly!
	public void add(Object element) {

		add(size, element);

	}

	// I do not think that needs a lot of change to be doubly
	public Object get(int index) {

		doubleListNode forwardMovablePointer = header;

		if (size == 0 || index < 0 || index >= size || header == null) {
			throw new RuntimeException("no element empty list or out of bound");
		} else {
			if (index == 0) {

				return forwardMovablePointer.value;

			} else {

				for (int counter = 0; counter < index; counter++) {
					forwardMovablePointer = forwardMovablePointer.next;
				}

				return forwardMovablePointer.value;

			}
		}
	}

	// Finished doubly!
	public void set(int index, Object element) {

		remove(index);
		add(index, element);

	}

	// Finished doubly!
	public void clear() {

		header = null;
		trailer = null;
		size = 0;

	}

	// Finished doubly!
	public boolean isEmpty() {
		doubleListNode forwardMovablePointer = header;
		doubleListNode backwardMovablePointer = trailer;
		if (forwardMovablePointer == null && backwardMovablePointer == null) {

			return true;
		}
		return false;
	}

	// Finished doubly!
	public void remove(int index) {

		if (index < 0 || index >= size || header == null || trailer == null) {

			throw new RuntimeException(" already empty or out of bound");

		}

		else {

			doubleListNode forwardMovablePointer = header;
			doubleListNode forwardMovablePointer2 = header;
			if (index == 0) {

				if (header.next == null) {
					header = null;
					trailer = null;
				} else {
					header = header.next;
					header.previous = null;
				}
				size--;

			} else if (index == size - 1) {

				for (int counter = 0; counter < index - 1; counter++) {

					forwardMovablePointer2 = forwardMovablePointer2.next;

				}

				doubleListNode removalPointer2 = forwardMovablePointer2.next;
				forwardMovablePointer2.next = removalPointer2.next;
				trailer = forwardMovablePointer2;
				size--;
			}

			else

			{
				for (int counter = 0; counter < index - 1; counter++) {

					forwardMovablePointer = forwardMovablePointer.next;// while
																		// i!=null
																		// caused
																		// the
																		// error
																		// do
																		// not
																		// put
																		// it
																		// again

				}
				doubleListNode removalPointer = forwardMovablePointer.next;
				forwardMovablePointer.next = removalPointer.next;
				doubleListNode swapPointer = removalPointer.next;
				swapPointer.previous = forwardMovablePointer;
				size--;

			}
		}

	}

	// Finished doubly!
	public int size() {
		return size;
	}

	// waiting for Aia's edit or postponed
	// done grin emotion

	public ILinkedList sublist(int fromIndex, int toIndex) {

		DoublyLinkedList tempList = new DoublyLinkedList();
		if (size == 0 || toIndex < fromIndex || toIndex < 0 || toIndex >= size || fromIndex < 0 || fromIndex >= size) {
			throw new RuntimeException("no element empty list or out of bound");
		} else {
			for (int counter = fromIndex; counter <= toIndex; counter++) {
				tempList.add(this.get(counter));
			}
			return tempList;
		}

	}

	public boolean contains(Object o) {

		boolean flag = false;
		doubleListNode forwardMovablePointer = header;
		doubleListNode backwardMovablePointer = trailer;

		if (size == 0) {
			throw new RuntimeException("size is zero");
		}
		if (size == 1) {
			if (forwardMovablePointer.value.equals(o) && backwardMovablePointer.value.equals(o)) {
				flag = true;
			}
		} else {
			if (forwardMovablePointer.value.equals(o)) {
				flag = true;
			}
			for (int counter = 1; (counter <= size - 1) && (flag == false); counter++) {

				forwardMovablePointer = forwardMovablePointer.next;
				if (forwardMovablePointer.value.equals(o)) {
					flag = true;
				}

			}
		}
		return flag;
	}

}