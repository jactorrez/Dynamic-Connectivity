public class WeightedQuickUnion {
private int[] id;
private int[] sz;
	
	public WeightedQuickUnion(int N){
		id = new int[N];
		sz = new int[N];
		
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	private int root(int i){
		while (i != id[i])
			i = id[i];
		
		return i; 
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int proot = root(p);
		int qroot = root(q);
		
		if(proot == qroot)
			return;
		
		if(sz[proot] < sz[qroot]){
			id[proot] = qroot;
			sz[qroot] += sz[proot];
		} else {
			id[qroot] = proot;
			sz[proot] += sz[qroot];
		}
	}
	
	public static void main(String[] args){
		WeightedQuickUnion test = new WeightedQuickUnion(10);
		System.out.println(test.connected(4, 5));
		test.union(4, 5);
		System.out.println(test.connected(4, 5));
	}
}
