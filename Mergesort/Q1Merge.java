package week3;

public class Q1Merge {
	private static void merge(int[] a, int lo, int mid, int hi) {
		int[] aux = new int[(hi - lo + 1 + 1)/2];
		for (int k = lo; k < (aux.length + lo); k++)
			aux[k-lo] = a[k];
		int i = 0, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i + lo > mid) a[k] = a[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (a[j] < aux[i]) a[k] = a[j++];
			else a[k] = aux[i++];
		}
	}
	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	public static void main(String[] args) {
		int[] a = new int[] {3,47,125,124,12,5,5,4,1};
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
	}
}
