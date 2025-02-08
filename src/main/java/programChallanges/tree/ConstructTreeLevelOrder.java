package programChallanges.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ConstructTreeLevelOrder {
	public TreeNode solve(int[] A) {

        if(A.length==0){
            return null;
        }
        int val = A[0];
        TreeNode head = new TreeNode(val);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        for(int i=1;i<A.length;i+=2){
           TreeNode parent = queue.pop();
            val = A[i];
            if(val !=-1){
                TreeNode node = new TreeNode(val);
                queue.add(node);
                parent.left=node;
            }
            val = A[i+1];
            if(val !=-1){
                TreeNode node = new TreeNode(val);
                queue.add(node);
                parent.right=node;
            }
        }
        return head;

    }
	public static void main(String[] args) {
		ConstructTreeLevelOrder ct = new ConstructTreeLevelOrder();
		int[] a= {1,2,3,4,5,-1,-1,-1,-1,-1,6,-1,-1};
		ct.solve(a);
	}

}
