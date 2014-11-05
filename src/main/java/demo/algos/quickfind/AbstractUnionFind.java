package demo.algos.quickfind;

public abstract class AbstractUnionFind {
	
	protected int[] elems;

	public AbstractUnionFind(int N) {
		super();
		elems= new int[N];
		for(int i=0;i<N;i++){
			elems[i]=i;
		}
	}
	
	abstract boolean connected (int elem1,int elem2);
	
	abstract void union(int elem1,int elem2);
	
	
}
