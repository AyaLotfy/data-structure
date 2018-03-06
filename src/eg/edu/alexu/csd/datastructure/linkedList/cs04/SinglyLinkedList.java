/**
 * 
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs04;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs04.DoublyLinkedList.doubleListNode;

/**
 * 
 * @author lenovo
 *
 */
/**
 * 
 * 
 *
 */
public class SinglyLinkedList implements ILinkedList {
	/**
	 * 
	 * 
	 *
	 */
	public class SListNode {
		public Object value;
		public SListNode next = null;

		public SListNode(final Object v) {
			this.value = v;
		}
	}

	private SListNode head = null;
	private SListNode tail = null;
	public int size = 0;

	public void addTail(Object element) {
		if (this.isEmpty()) {
			SListNode adder = new SListNode(element);
			SListNode i = head;
			SListNode j = tail;
			tail = adder;
			head = adder;
			size++;

		} else {
			SListNode adder = new SListNode(element);
			// SListNode i = head;
			SListNode j = tail;
			j.next = adder;
			tail = adder;
			size++;

		}

	}

	// public Object removeAtHead() {
	// if(this.isEmpty()){
	// throw new RuntimeException("emp ya yoyo");
	// }
	// Object ret = this.get(0);
	// SListNode i = head;
	// i = i.next;
	// head = i;
	// return ret;
	//
	// }
	public Object removeAtHead() {
		SListNode i = head;
		Object ob;
		if (size == 0 || head == null) {
			throw new RuntimeException("no element empty list or out of bound");
		} else {

			ob = i.value;
			head = head.next;
			size--;

		}
		return ob;
	}

	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub

		SListNode adder = new SListNode(element);
		SListNode i = head;
		if (index > size || index < 0) {// added new index<0
			throw new RuntimeException("index greater than the size can't be available");
		} else {

			if (index == 0) {
				adder.next = head;
				head = adder;
				size++;
			} else {
				adder.value = element;
				for (int counter = 0; counter < index - 1; counter++) {
					i = i.next;
				}
				adder.next = i.next;
				i.next = adder;

				size++;
			}

		}

	}

	@Override
	public void add(final Object element) {

		add(size, element);

	}

	@Override
	public Object get(final int index) {

		SListNode i = head;
		if (size == 0 || index < 0 || index >= size || head == null) {
			throw new RuntimeException("no element empty list or out of bound");
		} else {
			if (index == 0) {

				return i.value;

			} else {

				for (int counter = 0; counter < index; counter++) {
					i = i.next;
				}

				return i.value;

			}
		}

	}

	public void print() {
		SListNode i = head;
		if (i == null) {
			System.out.println("empty");
		}
		while (i != null) {
			System.out.print(i.value + " ");
			i = i.next;
		}
		System.out.println();
	}

	public static void main(final String[] args) {
		SinglyLinkedList ob = new SinglyLinkedList();
		ob.add(0, 5);
		ob.print();
		ob.add(0, 7);
		ob.print();
		ob.add(0, 9);
		ob.print();
		ob.add(0, 55);
		ob.print();
		ob.add(0, 77);
		ob.print();
		ob.add(0, 99);
		ob.print();
		ob.add(0, 100);
		ob.print();
		int i = ob.size();
		System.out.println(i);
		ob.add(4, 88);
		ob.print();
	}

	@Override
	public void set(final int index, final Object element) {

		SListNode adder = new SListNode(element);
		SListNode i = head;
		SListNode j = head;

		if (index >= size || index < 0) {
			throw new RuntimeException("can't replace ");
		}
		if (index == 0) {
			adder.next = i.next;
			head = adder;
			// size++;
		} else {
			adder.value = element;
			for (int counter = 0; counter < index - 1; counter++) {
				j = j.next;
			}
			for (int counter = 0; counter < index; counter++) {
				i = i.next;
			}
			adder.next = i.next;
			j.next = adder;
			// i.next = null;
			// size++;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		SListNode i = head;
		if (i == null) {

			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(final int index) {

		if (index < 0 || index >= size) {
			throw new RuntimeException(" already empty or out of bound");

		} else {

			SListNode i = head;
			if (index == 0) {
				head = head.next;
				size--;
			} else {
				if (head == null) {
					throw new RuntimeException(" already empty or out of bound.");

					// added new
				}

				for (int counter = 0; counter < index - 1; counter++) {

					i = i.next;// while i!=null cased the error do not put it
								// again

				}
				SListNode remover = i.next;
				i.next = remover.next;
				size--;

			}
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {

		// SListNode i = head;
		SinglyLinkedList tempList = new SinglyLinkedList();
		if (size == 0 || toIndex < fromIndex || toIndex < 0 || toIndex >= size || fromIndex < 0 || fromIndex >= size) {
			throw new RuntimeException("no ellement empty list or out of bound");
		} else {

			for (int counter = fromIndex; counter <= toIndex; counter++) {
				tempList.add(this.get(counter));
			}
			return tempList;
		}

	}

	// changed == to.equals
	public boolean contains(final Object o) {

		boolean flag = false;
		SListNode i = head;

		if (size == 0) {
			throw new RuntimeException("size is zero");
		}
		if (size == 1) {
			if (i.value.equals(o)) {
				flag = true;
			}
		} else {
			if (i.value.equals(o)) {
				flag = true;
			}
			for (int counter = 1; (counter <= size - 1) && (flag == false); counter++) {

				i = i.next;
				if (i.value.equals(o)) {
					flag = true;
				}

			}
		}
		return flag;
	}

}
