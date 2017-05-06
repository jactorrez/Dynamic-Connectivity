
public class QuickUnion {
	private int[] id;
	
	public QuickUnion(int N){
		id = new int[N];
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
		
		id[proot] = qroot; 
	}
	
	public static void main(String[] args){
		QuickUnion test = new QuickUnion(10);
		System.out.println(test.root(4));
		System.out.println(test.connected(4, 5));
		test.union(4, 5);
		System.out.println(test.connected(4, 5));
	}
}
