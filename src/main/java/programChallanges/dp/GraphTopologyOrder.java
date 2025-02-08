package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class GraphTopologyOrder {
	 // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public int solve(int A, int B[][]) {
        List<Integer> q = new ArrayList<>();
        int result = 0;
        HashMap<Integer, Set<Integer>> edge = new HashMap<>();
        int[] inNode = new int[A+1];
        //Construct the graph
        for(int i=0;i<B.length;i++){
        		Set<Integer> list  = edge.computeIfAbsent(B[i][0], k-> new TreeSet<Integer>());
        		list.add(B[i][1]);
        		inNode[B[i][1]]++;
        	}
        for(int i=1;i<A+1;i++) {
        	if(inNode[i]==0) {
        		q.add(i);
        	}
        }
        int n=0;
        while(!q.isEmpty()) {
        	List<Integer> zero= new ArrayList<Integer>(q);
        	System.out.println("iter "+result);
        	System.out.println(zero);
        	q.clear();
        	result++;
        	for(Integer aNode: zero) {
        		n++;
        		for(Integer adjNode: edge.getOrDefault(aNode, new TreeSet<>())) {
        		if(inNode[adjNode]!=0) {
        			inNode[adjNode]--;
        			if(inNode[adjNode]==0) {
        				q.add(adjNode);
        			}
        		}
        		}
        	}
        	
        }
        if(n!=A) {
        	return -1;
        }
    	
    	return result;
    }

//    private boolean dfs(HashMap<Integer, Set<Integer>>  edge, boolean visited[], boolean path[], int dest, int[] result){
//      
//        visited[dest]= true;
//        path[dest]= true;
//        List<Integer> adjList = new ArrayList<>(edge.getOrDefault(dest, new TreeSet<>()));
//        for(int j = adjList.size()-1;j>=0;j--) {
//        	Integer node = adjList.get(j);
//        	if(path[node]) {
//        		return true;
//        	}
//            if(!visited[node]){
//                if(dfs(edge, visited, path, node, result)) {
//                	return true;
//                }
//            }
//        }
//        path[dest]= false;
//        result[n]=dest;
//        n--;
//        return false;
//    }
    public static void main(String[] args) {
		int a[][] = {{7,4},{6,1},{6,5},{3,4},{2,1},{5,8},{2,6}};
		GraphTopologyOrder g = new GraphTopologyOrder();
		int ans =g.solve(8,a);
	
			System.out.print(ans+" ");
			System.out.println(Math.abs(3-8));
		
	}

}
