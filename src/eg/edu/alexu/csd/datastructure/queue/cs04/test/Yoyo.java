package eg.edu.alexu.csd.datastructure.queue.cs04.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Assert;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

import eg.edu.alexu.csd.datastructure.linkedList.cs04.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.cs04.Queue;
import eg.edu.alexu.csd.datastructure.queue.cs04.QueueList;

public class Yoyo {

	@Test

	public void test1() {

		Point p = new Point(1, 2);

		QueueList test = new QueueList();

		test.enqueue(p);

		Assert.assertEquals(p, test.dequeue());

		p = new Point(3, 4);

		test.enqueue(p);

		p = new Point(3, 4);
		test.enqueue(p);

		Assert.assertEquals(p, test.dequeue());

	}

	@Test

	public void test2() {

		QueueList test = new QueueList();

		String tester = "lets test the list !!";

		tester.concat(tester + "Good luck");

		test.enqueue(tester);

		Assert.assertEquals(tester, test.dequeue());

	}

	@Test

	public void test6() {

		QueueList test = new QueueList();

		test.isEmpty();

		Assert.assertTrue(test.isEmpty());

		Integer aia = new Integer(5);

		test.enqueue(aia);

		test.isEmpty();

		Assert.assertFalse(test.isEmpty());

	}

	@Test

	public void test8() {

		QueueList test = new QueueList();

		test.enqueue(5);
		test.enqueue(88);
		test.enqueue("yOyo");
		test.enqueue("salma");
		test.enqueue(45.98);

		assertEquals(5, test.size());

	}

	@Test

	public void test11() {

		Point p = new Point(1, 2);

		Queue test = new Queue(5);

		test.enqueue(p);

		Assert.assertEquals(p, test.dequeue());

		p = new Point(3, 4);

		test.enqueue(p);

		p = new Point(3, 4);
		test.enqueue(p);

		Assert.assertEquals(p, test.dequeue());

	}

	@Test

	public void test22() {

		Queue test = new Queue(5);

		String tester = "lets test the list !!";

		tester.concat(tester + "Good luck");

		test.enqueue(tester);

		Assert.assertEquals(tester, test.dequeue());

	}

	@Test

	public void test66() {

		Queue test = new Queue(3);

		test.isEmpty();

		Assert.assertTrue(test.isEmpty());

		Integer aia = new Integer(5);

		test.enqueue(aia);

		test.isEmpty();

		Assert.assertFalse(test.isEmpty());

	}

	@Test

	public void test88() {

		Queue test = new Queue(10);

		test.enqueue(5);
		test.enqueue(88);
		test.enqueue("yOyo");
		test.enqueue("salma");
		test.enqueue(45.98);

		assertEquals(5, test.size());

	}

}