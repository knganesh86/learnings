package programChallanges.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphTreeDistance {
		int distance =-1;
		int fNode = -1;
	//int max2 =0;
	 // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	  public int solve(int[] A) {
       
        HashMap<Integer, List<Integer>> edge = new HashMap<>();
        Integer root = 0;
        if(A.length==1) {
        	return 0;
        }
        System.out.println(A.length);
        //Construct the graph
        for(int i=0;i<A.length;i++){
        	if(A[i]==-1) {
        		root = i;
        	}
        	else {
        		List<Integer> list  = edge.computeIfAbsent(A[i], k-> new ArrayList<Integer>());
        		list.add(i);
        		list  = edge.computeIfAbsent(i, k-> new ArrayList<Integer>());
        		list.add(A[i]);
        	}
        }
       // int node= 0;
       
        dfs(edge, root, -1, 0 );
        dfs(edge, fNode, -1, 0);
    //    getMaxHeight(edge, 0, root);
        //find the root child count;
        return distance;
        
        
    }

    private void dfs(HashMap<Integer, List<Integer>> edge, int node, int parent, int d) {
		if(d>this.distance) {
			distance = d;
			fNode = node; 
		}
		List<Integer> childs = edge.get(node);
		if(childs == null|| childs.isEmpty()) {
			return;
		}
		for(Integer aChild: childs) {
			if(aChild!=parent) {
				dfs(edge, aChild, node, d+1);
			}
			
		}
	}

	

	
    public static void main(String[] args) {
		//int a[] = {-1,0,1,1,3,0,4,0,2,8,9,0,4,6,12,14,7,9,6,4,14,13,1,9,16,17,17,0,21,10,13,14,25,28,27,0,35,20,34,23,37,3,6,25,30,22,15,37,8,6,11,22,50,12,4,2,54,23,18,52,34,49,61,8,15,63,31,51,48,41,26,37,30,15,59,12,0,40,37,73,32,19,70,29,8,21,83,33,7,13,12,82,43,86,38,31,1,84,62,83};
		
    	int a[] = {-1,0};
    	GraphTreeDistance g = new GraphTreeDistance();
		System.out.println(g.solve(a));
	}

}
