package week2;

public class LinkedListStackOfStrings {
	private Node first = null;
	private class Node{
		String item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void push(String s) {
		Node oldfirst = first;
		first = new Node();
		first.item = s;
		first.next = oldfirst;
	}
	public String pop(){
		String s = first.item;
		first = first.next;
		return s;
	}
}
