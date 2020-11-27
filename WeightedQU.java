package week1;

public class WeightedQU {
	 int[] id;
	 int[] sz;
	 int[] max;
	public WeightedQU(int N) {
		id = new int[N];
		sz = new int[N];
		max = new int[N];
		for (int i=0;i<N;i++) {
			id[i] = i;
			max[i] = i;
			sz[i] = 1;
		}
	}
	private int root(int p) {
		while (p!=id[p]) {p = id[p];}
		return p;
	}
	public boolean isConnected(int p, int q) {
		return root(p)==root(q);
	}
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		int k= Math.max(max[i],max[j]);
		if (sz[i]<sz[j]){
			id[i]=j; sz[j]+=sz[i];
			if(k>max[j]) {max[j]=k;}
		}
		else {
			id[j]=i; sz[i]+=sz[j];
			if(k>max[i]) {max[i]=k;}
		}
		
	}
	public int find(int i) {
		int max = i;
		int j = i+1;
		while (j<id.length) {
			if (isConnected(i,j)) {
				max = j;
			}
			j=j+1;
		}
		return max;
	}
	public int find1(int i) {
		return max[root(i)];
	}
	/*public static void main(String[] args) {
		Percolation systemP = new Percolation(8);
		int[][] multi = new int[][]{
			  {  0, 0, 1, 1, 1, 0, 0, 0 },
			  {  1, 0, 0, 1, 1, 1, 1, 1 },
			  {  1, 1, 1, 0, 0, 1, 1, 0 },
			  {  0, 0, 1, 1, 0, 1, 1, 1 },
			  {  0, 1, 1, 1, 0, 1, 1, 0 },
			  {  0, 1, 0, 0, 0, 0, 1, 1 },
			  {  1, 0, 1, 0, 1, 1, 1, 1 },
			  {  1, 1, 1, 1, 0, 1, 0, 0 }
			};
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				if (multi[i][j] == 1) {
					systemP.open(i+1, j+1);
				}
			}
		}
		System.out.println("is site at row 1 column 8 open?"+ systemP.isOpen(1,8));
		System.out.println("is site at row 7 column 5 full?"+ systemP.isFull(7,5));
		System.out.println("is site at row 8 column 1 full?"+ systemP.isFull(8,1));
		System.out.println("does systemP percolate?"+ systemP.percolates());
	}
*/
}
