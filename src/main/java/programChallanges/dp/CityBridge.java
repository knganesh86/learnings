package programChallanges.dp;

import java.util.PriorityQueue;

public class CityBridge {
	class WeightedEdge implements Comparable<WeightedEdge>{
		int source;
		int destination;
		int weight;
		WeightedEdge(int s, int d, int w){
			this.source = s;
			this.destination =d;
			this.weight = w;
		}
		@Override
		public int compareTo(WeightedEdge o) {
			return this.weight-o.weight;
		}
	}
	 public int solve(int A, int[][] B) {
		
		int result =0;
		int parent[] = new int[A+1];
		PriorityQueue<WeightedEdge> edgeList = new PriorityQueue<>();
		for(int i=0;i<A+1;i++) {
			parent[i]=i;
		}

		for(int i=0;i<B.length;i++) {
			edgeList.add(new WeightedEdge(B[i][0], B[i][1], B[i][2]));
		}
		while(!edgeList.isEmpty()) {
			WeightedEdge edge = edgeList.poll();
			if(union(edge.source, edge.destination, parent)) {
				result += edge.weight;
				result+=1000000007;
				result%=1000000007;
			}
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
		CityBridge bs = new CityBridge();
		System.out.println(bs.solve(a,b));
	}
}
