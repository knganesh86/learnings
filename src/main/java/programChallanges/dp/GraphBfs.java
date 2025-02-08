package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class GraphBfs {
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
	class NodePair implements Comparable<NodePair>{
        int node;
        int length;
        NodePair(int node, int length){
            this.node = node;
            this.length = length;
        }
        @Override
		public int compareTo(NodePair o) {
			return this.length-o.length;
		}
    }
    public int solve(int A, int[][] B, int C, int D) {
    	boolean visited[] = new boolean[A+1];
         HashMap<Integer, ArrayList<WeightedEdge>> edge = new HashMap<>();
        for(int i=0;i<B.length;i++){
            ArrayList<WeightedEdge> list  = edge.computeIfAbsent(B[i][0], k-> new ArrayList<>());
            list.add(new WeightedEdge(B[i][0],B[i][1], B[i][2]));
    		list  = edge.computeIfAbsent(B[i][1], k-> new ArrayList<WeightedEdge>());
    		list.add(new WeightedEdge(B[i][1],B[i][0], B[i][2]));
        }
        PriorityQueue<NodePair> queue = new PriorityQueue<>();
        queue.add(new NodePair(C,0));
        while(!queue.isEmpty()){
            NodePair nodePair = queue.poll();
            visited[nodePair.node]= true;
            for(WeightedEdge node: edge.getOrDefault(nodePair.node, new ArrayList<>())){
                if(node.destination==D){
                    return nodePair.length+node.weight;
                }
                if(!visited[node.destination]) {
                	queue.add(new NodePair(node.destination, nodePair.length+node.weight));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
		GraphBfs b = new GraphBfs();
		int A=11;
		int B[][]= {{4,10,2},{4,5,2},{3,9,2},{3,10,1},{5,6,1},{1,4,2},{7,10,1},{4,8,1},{0,6,2},{1,5,1},{5,9,2},{1,10,2},{0,7,1}};
		int C = 5;
		int D = 10;
		System.out.println(b.solve(A,B,C,D));
	}

}
