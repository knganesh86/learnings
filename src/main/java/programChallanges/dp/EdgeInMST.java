package programChallanges.dp;

import java.util.ArrayList;
import java.util.Collections;

public class EdgeInMST {
	class WeightedEdge implements Comparable<WeightedEdge>{
		int source;
		int destination;
		int weight;
		int index;
		WeightedEdge(int s, int d, int w, int i){
			this.source = s;
			this.destination =d;
			this.weight = w;
			this.index =i;
		}
		@Override
		public int compareTo(WeightedEdge o) {
			return this.weight-o.weight;
		}
	}
	 public int[] solve(int A, int[][] B) {
		
		int result[] = new int[B.length];
		int parent[] = new int[A+1];
		ArrayList<WeightedEdge> edgeList = new ArrayList<>();
		for(int i=0;i<A+1;i++) {
			parent[i]=i;
		}

		for(int i=0;i<B.length;i++) {
			edgeList.add(new WeightedEdge(B[i][0], B[i][1], B[i][2], i));
		}
		Collections.sort(edgeList);
		int i=0;
		int m = B.length;
		while(i<m) {
			int j=i;
			while(j<m &&edgeList.get(j).weight==edgeList.get(i).weight) {
				if(root(edgeList.get(j).source, parent)!=root(edgeList.get(j).destination, parent)) {
					result[edgeList.get(j).index]=1;
				}
				j++;
			}
			j=i;
			while(j<m &&edgeList.get(j).weight==edgeList.get(i).weight) {
				if(root(edgeList.get(j).source, parent)!=root(edgeList.get(j).destination, parent)) {
					union(edgeList.get(j).source, edgeList.get(j).destination, parent);
				}
				j++;
			}
			i=j;
		}
		
		return result;
    }
	
	private boolean union(int i, int j, int[] parent) {
		int x = root(i, parent);
		int y = root(j, parent);
		
		if(x==y) {
			return false;
		}
		else if(x>y) {
			parent[x]=y;
		}
		else {
			parent[y]=x;
		}
		return true;
	}

	private int root(int node, int[] parent) {
		if(node == parent[node]) {
			return node;
		}
		parent[node]= root(parent[node], parent);
		return parent[node];
	}
	public static void main(String[] args) {
		int b[][] = {{1,2,1},{2,3,2},{3,4,1},{1,3,8},{1,4,12}};
	
		int a = 4;
		//int d = 6;
		EdgeInMST bs = new EdgeInMST();
		System.out.println(bs.solve(a,b));
	}
}
