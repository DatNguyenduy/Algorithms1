package week2;

public class GenericQueue<Item> {
	private Node first, last;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void enQueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else oldLast.next = last;
	}
	public Item deQueus() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		return item;
	}
}
