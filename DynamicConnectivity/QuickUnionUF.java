package week1;

public class QuickUnionUF {
	private int[] id ;
	public QuickUnionUF(int N){
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
	}
	private int root(int p) {
		while (p!=id[p]) {p=id[p];}
		return p;
	}
	public boolean isConnected(int p, int q) {
		return root(p)==root(q);
	}
	public void union(int p,int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}
