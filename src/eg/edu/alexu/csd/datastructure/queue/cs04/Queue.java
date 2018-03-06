package eg.edu.alexu.csd.datastructure.queue.cs04;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;

import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class Queue implements IArrayBased, IQueue {
	Object[] array;
	int first = -1;
	int last = -1;
	int currentSize = 0;
	int maxLen;

	/**
	 * 
	 * @param max
	 *            size
	 */
	public Queue(int max) {

		array = new Object[max];
		maxLen = max;
	}

	public static void main(String[] args) {
		int y = 10;
		Queue q = new Queue(y);
		// System.out.println(q.dequeue());
		q.enqueue(33);
		q.enqueue(44);
		q.enqueue(55);
		q.enqueue(66);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

	//
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (currentSize == maxLen) {
			throw new RuntimeException("full ya yoti");
		} else {
			if (first == last) {

				if (first == -1) {
					array[0] = item;
					currentSize++;
					first = 0;
					last = 0;
				} else if (currentSize == 1) {
					if (last == maxLen - 1) {
						array[0] = item;
						currentSize++;
						last = 0;
					} else {
						last++;
						array[last] = item;
						currentSize++;
					}
				} else if (currentSize == 0) {
					array[first] = item;
					currentSize++;
				}
			} else {
				if (last == maxLen - 1) {
					last = 0;
					array[last] = item;
					currentSize++;
				} else {
					last++;
					array[last] = item;
					currentSize++;
				}
			}
		}
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object temp;
		if (currentSize == 0) {
			throw new RuntimeException("empty ya yoyo");
		} else {

			if (first == last) {
				temp = array[first];
				currentSize--;
			} else {
				temp = array[first];

				currentSize--;
				if (first == maxLen - 1) {
					first = 0;
				} else {
					first++;
				}
			}
		}
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (currentSize == 0) {
			return true;
		}
		return false;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

}
