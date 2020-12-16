package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackOfString {
	public static void main(String args[]) throws FileNotFoundException {
		LinkedListStackOfStrings stack = new LinkedListStackOfStrings();
		Scanner in = new Scanner(new File("E:/LearnAlgorithms/LearnAlgorithms1/src/week2/tobe.txt"));
		while(in.hasNext()) {
			String s = in.next();
			if (s.equals("-")) {
				System.out.print(stack.pop());
			}
			else {
				stack.push(s);
			}
		}
	}
}
