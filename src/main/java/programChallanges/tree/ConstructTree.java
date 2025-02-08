package programChallanges.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstructTree {
	 HashMap<Integer, Integer> mapIndex = new HashMap<>();
	    public TreeNode buildTree(int[] B, int[] A) {
	     for(int i=0;i<A.length;i++){
	            mapIndex.put(A[i],i);
	        }
	       return consturctNode(A,B, 0, A.length-1, 0);
	    }

	    private TreeNode consturctNode(int[] A, int[] B, int sIn, int eIn, int sPre){
	        if(sIn>eIn){
	            return null;
	        }
	        TreeNode root = new TreeNode(B[sPre]);
	        int index = mapIndex.get(root.val);
	        int stR= sPre+index+1;
	        root.left = consturctNode(A,B, sIn, index-1,sPre+1);
	        root.right = consturctNode(A,B, index+1, eIn, stR);
	        return root;
	    }
	    public static void main(String[] args) {
			ConstructTree ct = new ConstructTree();
			int i[]= {5,6,1,2,3,4};
			int p[]= {2,1,6,5,3,4};
			
			ct.buildTree(p,i);
		}
}
