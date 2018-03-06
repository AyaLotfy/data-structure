package eg.edu.alexu.csd.datastructure.linkedList.cs04.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Assert;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

import eg.edu.alexu.csd.datastructure.linkedList.cs04.SinglyLinkedList;

public class Yoyo {

@Test

public void test1() {

Point p = new Point(1,2);

SinglyLinkedList test = new SinglyLinkedList();

test.add(p);

Assert.assertEquals(p, test.get(0));

p=new Point(3,4);

test.add(p);

Assert.assertEquals(p, test.get(1));

p=new Point(3,4);

test.add(p);

Assert.assertEquals(p, test.get(2));

}

@Test

public void test2(){

SinglyLinkedList test = new SinglyLinkedList();

String tester="lets test the list !!";

tester.concat(tester+"Good luck");

test.add(tester);

Assert.assertEquals(tester, test.get(0));

}

@Test

public void test3() {

SinglyLinkedList test_list = new SinglyLinkedList();

test_list.clear();

test_list.add(0, 5);

test_list.add(0, 88);

test_list.add("FNSY");

test_list.add("AYA");

test_list.add(4, 45.98);// 88 5 FNSY AYA 45.98

assertEquals(88, test_list.get(0));

assertEquals(5, test_list.get(1));

assertEquals("FNSY", test_list.get(2));

assertEquals("AYA", test_list.get(3));

assertEquals(45.98, test_list.get(4));

test_list.set(0, 77);

test_list.set(1, 4);

test_list.set(2, "FNSY");

test_list.set(4, 54.89);// 77 4 FNSY AYA 54.89

assertEquals(77, test_list.get(0));

assertEquals(4, test_list.get(1));

assertEquals("FNSY", test_list.get(2));

assertEquals(54.89, test_list.get(4));

}

@Test(expected = RuntimeException.class)

public void test4() {

SinglyLinkedList test = new SinglyLinkedList();

test.remove(0);

}

@Test(expected = RuntimeException.class)

public void test5(){

SinglyLinkedList test = new SinglyLinkedList();

test.add(1,"FNSY was Here");

}

@Test

public void test6(){

SinglyLinkedList test = new SinglyLinkedList();

test.isEmpty();

Assert.assertTrue(test.isEmpty());

Integer FNSY =new Integer(5);

test.add(FNSY);

test.isEmpty();

Assert.assertFalse(test.isEmpty());

}

@Test

public void test7() {

SinglyLinkedList test_list = new SinglyLinkedList();

test_list.add("my easy test ");

test_list.add("not easy any more ");

test_list.add(123456);

test_list.add(7890);

assertTrue(test_list.contains("my easy test "));

assertTrue(test_list.contains("not easy any more "));

assertTrue(test_list.contains(123456));

assertTrue(test_list.contains(7890));

assertFalse(test_list.contains(100000));

}

@Test

public void test8() {

SinglyLinkedList test_list = new SinglyLinkedList();

ILinkedList new_list = new SinglyLinkedList();

test_list.add(5);

test_list.add(88);

test_list.add("yOyo");

test_list.add("salma");

test_list.add(45.98);

new_list = test_list.sublist(1, 3);

assertEquals(88, new_list.get(0));

assertEquals("yOyo", new_list.get(1));

assertEquals("salma", new_list.get(2));

assertEquals(3, new_list.size());

}

@Test

public void test9() {

SinglyLinkedList test_list = new SinglyLinkedList();

test_list.add("hello");

test_list.add("world");

test_list.add(123456);

test_list.add(7890);// hello world 123456 7890

test_list.remove(0);// world 123456 7890

assertEquals("world", test_list.get(0));

test_list.remove(2);// world 123456

assertEquals(123456, test_list.get(1));

test_list.remove(0);

test_list.remove(0);

test_list.add(9);

}

@Test

public void test10() {

SinglyLinkedList test_list = new SinglyLinkedList();

assertTrue(test_list.isEmpty());

assertEquals(0, test_list.size());

test_list.add(5);

assertFalse(test_list.isEmpty());

assertEquals(1, test_list.size());

test_list.add("salma");

assertFalse(test_list.isEmpty());

assertEquals(2, test_list.size());

test_list.clear();

assertEquals(0, test_list.size());

assertTrue(test_list.isEmpty());

}

}