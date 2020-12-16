package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueueOfStrings {
	public static void main(String args[]) throws FileNotFoundException {
		LinkedListQueuesOfStrings queue = new LinkedListQueuesOfStrings();
		Scanner in = new Scanner(new File("E:/LearnAlgorithms/LearnAlgorithms1/src/week2/tobe.txt"));
		while(in.hasNext()) {
			String s = in.next();
			if (s.equals("-")) {
				System.out.print(queue.dequeue());
			}
			else {
				queue.enqueue(s);
			}	
		}
	}
}