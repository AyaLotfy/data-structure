/**
* 

* <p>

* lose. :D  
* </p>
* @since 19-May-2016
* @author Aia Lotfy
* @version 1.0 
 */
package eg.edu.alexu.csd.datastructure.queue.cs04;

import eg.edu.alexu.csd.datastructure.linkedList.cs04.SinglyLinkedList;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * Maze class.
 * 
 * @author Aia
 */
public class QueueList implements ILinkedBased, IQueue {
	SinglyLinkedList list = new SinglyLinkedList();

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		list.addTail(item);

	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object returned = list.get(0);
		list.remove(0);
		return returned;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return list.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub

		return list.size();
	}

}
