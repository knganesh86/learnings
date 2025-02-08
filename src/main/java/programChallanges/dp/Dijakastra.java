package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import programChallanges.dp.GraphBfs.WeightedEdge;

public class Dijakastra {
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
	public int[] solve(int A, int[][] B, int C) {
			int []ans = new int[A];
			for(int i=0;i<A;i++) {
				ans[i]=Integer.MAX_VALUE;
			}
		  HashMap<Integer, ArrayList<WeightedEdge>> edge = new HashMap<>();
	        for(int i=0;i<B.length;i++){
	            ArrayList<WeightedEdge> list  = edge.computeIfAbsent(B[i][0], k-> new ArrayList<>());
	            list.add(new WeightedEdge(B[i][0],B[i][1], B[i][2]));
	    		list  = edge.computeIfAbsent(B[i][1], k-> new ArrayList<WeightedEdge>());
	    		list.add(new WeightedEdge(B[i][1],B[i][0], B[i][2]));
	        }
	        PriorityQueue<WeightedEdge> edgeList = new PriorityQueue<>();
	        edgeList.addAll(edge.getOrDefault(C, new ArrayList<>()));
	        ans[C]=0;
	        while(!edgeList.isEmpty()) {
	        	WeightedEdge e =edgeList.poll();
	        	if(ans[e.destination]==Integer.MAX_VALUE) {
	        		ans[e.destination]= e.weight;
	        		for(WeightedEdge child: edge.getOrDefault(e.destination, new ArrayList<>())) {
	        			child.weight=child.weight+e.weight;
	        			edgeList.add(child);
	        		}
	        	}
	        }
	        for(int i=0;i<A;i++) {
	        	if(ans[i]==Integer.MAX_VALUE) {
	        		ans[i]=-1;
	        	}
	        }
	        return ans;
    }
	public static void main(String[] args) {
		Dijakastra d = new Dijakastra();
		int A=6;
		int B[][]= {{0, 4, 9},{3, 4, 6},{1, 2, 1},{2, 5, 1},{2, 4, 5},{0, 3, 7},{0, 1, 1},{4, 5, 7},{0, 5, 1}};
		int C = 4;
	
		int ans[]=d.solve(A,B,C);
		for(int a: ans) {
			System.out.print(a+" ");
		}
	}
}
