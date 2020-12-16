package week2;

public class Q1QueueTwoStacks<Item> {
	GenericStack<Item> firstStack = new GenericStack<Item>();
	GenericStack<Item> secondStack = new GenericStack<Item>();
	public boolean isEmpty() {
		return firstStack.isEmpty() && secondStack.isEmpty();
	}
	public void enQueue(Item item) {
		while (!firstStack.isEmpty()) {
			secondStack.push(firstStack.pop());
		}
		firstStack.push(item);
		while(!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());
		}
	}
	public Item deQueue() {
		if (firstStack.isEmpty())
		{
			return null;
		}
		Item item = firstStack.pop();
		return item;
	}
}
