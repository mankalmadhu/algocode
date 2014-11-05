package demo.algos.quickfind;

public class QuickFind extends AbstractUnionFind {

	public QuickFind(int elems) {
		super(elems);

	}

	@Override
	void union(int elem1, int elem2) {
		
		int elem1ent=elems[elem1];
		int elem2ent=elems[elem2];
		
		if(elem1ent== elem2ent){return;}
		
		for(int i=0;i<elems.length;i++){
			if(elems[i]==elem1ent){
				elems[i]=elem2ent;
			}
		}

	}

	@Override
	boolean connected(int elem1, int elem2) {

		return (elems[elem1] == elems[elem2]);
	}

}
