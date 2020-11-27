package week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DynamicConnectivityClient {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("E:\\LearnAlgorithms\\LearnAlgorithms1\\src\\week1\\tinyUF.txt"));
		int N = in.nextInt();
		WeightedQU uf = new WeightedQU(N);
		while (in.hasNextInt()) {
			int p = in.nextInt();
			int q = in.nextInt();
			if (!uf.isConnected(p,q)) {
				uf.union(p, q);
				System.out.println(p+" "+q);
			}
			for (int i=0;i<N;i++) {
				System.out.print(uf.id[i]+ " ");
			}
			System.out.println("\n''''''''''''''");
			for (int i=0;i<N;i++) {
				System.out.print(uf.sz[i]+ " ");
			}
			System.out.println("\n''''''''''''''");
			for (int i=0;i<N;i++) {
				System.out.print(uf.find1(i)+ " ");
			}
			System.out.println("\n''''''''''''''");
		}
		System.out.println("MAxxxxxxxxx6:" + uf.find(4)+";"+uf.find1(8));
		uf.union(7, 3);
		System.out.println(7+" "+3);
		for (int i=0;i<N;i++) {
			System.out.print(uf.id[i]+ " ");
			
		}
		System.out.println();
		for (int i=0;i<N;i++) {
			System.out.print(uf.sz[i]+ " ");
		}
		System.out.println();
	}
}
