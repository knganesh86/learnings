package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CityBridgePrim {
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
		boolean visited[] = new boolean[A+1];
		 HashMap<Integer, ArrayList<WeightedEdge>> edge = new HashMap<>();
		PriorityQueue<WeightedEdge> edgeList = new PriorityQueue<>();
		

		for(int i=0;i<B.length;i++) {
			ArrayList<WeightedEdge> list  = edge.computeIfAbsent(B[i][0], k-> new ArrayList<WeightedEdge>());
    		list.add(new WeightedEdge(B[i][0],B[i][1], B[i][2]));
    		list  = edge.computeIfAbsent(B[i][1], k-> new ArrayList<WeightedEdge>());
    		list.add(new WeightedEdge(B[i][1],B[i][0], B[i][2]));
    		
		}
		edgeList.addAll(edge.get(1));
		visited[1]=true;
		while(!edgeList.isEmpty()) {
			WeightedEdge minEdge = edgeList.poll();
			if(!visited[minEdge.destination]) {
				result+=minEdge.weight;
				visited[minEdge.destination]=true;
				edgeList.addAll(edge.getOrDefault(minEdge.destination, new ArrayList<>()));
			}
		}
		
		return result;
    }
	
	
	public static void main(String[] args) {
		int b[][] = {{1,2,10},{2,3,5},{1,3,9}};
	
		int a = 4;
		//int d = 6;
		CityBridgePrim bs = new CityBridgePrim();
		System.out.println(bs.solve(a,b));
	}
}
