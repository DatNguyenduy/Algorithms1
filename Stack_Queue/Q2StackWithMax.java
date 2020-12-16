package week2;

public class Q2StackWithMax {
	GenericStack<Double> stack = new GenericStack<Double>();
	GenericStack<Double> maxInStack = new GenericStack<Double>();
	public void push(Double item)
	{
		stack.push(item);
		Double olditem = maxInStack.pop();
		maxInStack.push(olditem);
		if (olditem < item) maxInStack.push(item);
		else maxInStack.push(olditem);
	}
	public Double pop()
	{
		Double item = stack.pop();
		maxInStack.pop();
		return item;
	}
	public Double maxValue()
	{
		Double item = maxInStack.pop();
		maxInStack.push(item);
		return item;
	}
}
