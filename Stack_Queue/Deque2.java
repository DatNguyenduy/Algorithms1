package week2;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Deque2<Item> implements Iterable<Item>
{
	private final Node first;
	private int size;
	private final Node last;
	private class Node
	{
		Node pre;
		Item item;
		Node next;
	}
	public Deque2()
	{
		first = new Node();
		last = new Node();
		first.next = last;
		last.pre = first;
		size = 0;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{
			return current.next != last;
		}
		public Item next()
		{
			if (size == 0) throw new java.util.NoSuchElementException("RandomizedDeque is empty aaaaaaa");
			current = current.next;
			return current.item;
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public int size()
	{
		return size;
	}
	public void addFirst(Item item)
	{
		if (item == null) throw new IllegalArgumentException("null argument");
		Node temp = new Node();
		temp.item = item;
		temp.next = first.next;
		first.next.pre = temp;
		first.next = temp;
		temp.pre = first;
		size++;
	}
	public void addLast(Item item)
	{
		if (item == null) throw new IllegalArgumentException("null argument");
		Node temp = new Node();
		temp.item = item;
		temp.pre = last.pre;
		last.pre.next = temp;
		last.pre = temp;
		temp.next = last;
		size++;
	}
	public Item removeFirst()
	{
		if (size == 0) throw new java.util.NoSuchElementException("Deque is empty");
		Node afterFirst = first.next;
		first.next = afterFirst.next;
		afterFirst.next.pre = first;
		size--;
		return afterFirst.item;
	}
	public Item removeLast()
	{
		if (size == 0) throw new java.util.NoSuchElementException("Deque is empty");
		Node preLast = last.pre;
		last.pre = preLast.pre;
		preLast.pre.next = last;
		size--;
		return preLast.item;
	}
	public static void main(String[] args)
	{
		Deque2<Integer> deque = new Deque2<Integer>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addLast(5);
		deque.removeFirst();
		deque.removeLast();
		Iterator<Integer> s = deque.iterator();
		while (s.hasNext())
		{
			Integer i = s.next();
			System.out.println(i);
		}
	}
}
