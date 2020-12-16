package week2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue2<Item> implements Iterable<Item>
{
	private final Node first, last;
	private int size;
	private class Node
	{
		Node pre;
		Item item;
		Node next;
	}
	public RandomizedQueue2()
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
			if (size == 0 || !hasNext()) throw new java.util.NoSuchElementException("Deque is empty");
			current = current.next;
			return current.item;
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
	public void enqueue(Item item)
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
	public Item dequeue()
	{
		if (isEmpty()) throw new java.util.NoSuchElementException("Deque is empty");
		int n = StdRandom.uniform(size) + 1;
		ListIterator iterator = new ListIterator();
		Item item = iterator.current.item;
		for (int i = 0; i < n; i++)
		{
			item = iterator.next();
		}
		iterator.current.pre.next = iterator.current.next;
		iterator.current.next.pre = iterator.current.pre;
		size--;
		return item;
	}
	public Item sample()
	{
		if (size == 0) throw new java.util.NoSuchElementException("Deque is empty");
		int n = StdRandom.uniform(size) + 1;
		ListIterator iterator = new ListIterator();
		for (int i = 0; i < n-1; i++)
		{
			iterator.next(); 
		}
		return iterator.next();
	}
	public static void main(String[] args)
	{
		RandomizedQueue2<String> randomQueue = new RandomizedQueue2<String>();
		randomQueue.enqueue("AB");
		StdOut.println(randomQueue.isEmpty());
		StdOut.println(randomQueue.sample());
		StdOut.println(randomQueue.dequeue());
		StdOut.println(randomQueue.size());
	}
}
