package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphDfs {
	 // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(int[] A, final int B, final int C) {
        boolean visited[] = new boolean[A.length+1];
        HashMap<Integer, List<Integer>> edge = new HashMap<>();
        for(int i=1;i<A.length;i++){
           List<Integer> list  = edge.computeIfAbsent(A[i], k-> new ArrayList<Integer>());
            list.add(i+1);
        }
        return dfs(edge, visited, B, C);
    }

    private int dfs(HashMap<Integer, List<Integer>>  edge, boolean visited[], int dest, int source){
      
        if(source == dest){
            return 1;
        }
         if(source == visited.length-1){
           return 0;
       }
        if(visited[source]){
            return 0;
        }
        visited[source]= true;
        for(Integer node: edge.getOrDefault(source, new ArrayList<>())){
            if(!visited[node]){
                if(dfs(edge, visited, dest, node)==1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
		int a[] = {1,1,1,3,3,2,2,7,6};
		GraphDfs g = new GraphDfs();
		System.out.println(g.solve(a, 8, 1));
	}

}
