package programChallanges.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ZigZagLevelView {

	 public ArrayList<ArrayList<Integer>> zigZagLevelView(TreeNode A) {
		 ArrayList<ArrayList<Integer>> ans = new  ArrayList<>();
         Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
         queue.add(A);
         TreeNode last = A;
         ArrayList<Integer> list = new ArrayList<>();
         int i=0;
         while(!queue.isEmpty()){

             TreeNode a = queue.pop();
             if(i%2==0) {
             list.add(a.val);
             }
             else {
            	 list.add(0, a.val);
             }
             if(a.left!=null){
                 queue.add(a.left);
             }
             if(a.right!=null){
                 queue.add(a.right);
             }
             if(last==a ){
                 ans.add(list);
                 list = new ArrayList<>();
                 if(!queue.isEmpty()){
                     last=queue.getLast();
                 }
                 i++;
             }
            
         }
         return ans;
	 }
	 public static void main(String[] args) {
		 ZigZagLevelView vv= new ZigZagLevelView();
		 TreeNode a = new TreeNode(6);
		 TreeNode b = new TreeNode(9);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(8);
		 TreeNode e = new TreeNode(3);
		 TreeNode f = new TreeNode(10);
		 TreeNode g = new TreeNode(16);
		 TreeNode h = new TreeNode(21);
		 TreeNode i = new TreeNode(26);
		 TreeNode j = new TreeNode(28);
		 TreeNode k = new TreeNode(29);
		 a.left = b;
		 a.right=c;
		 b.left=d;
		 b.right=e;
		 c.left = f;
		 c.right=g;
		 d.left =h;
		 d.right=i;
		 g.left=j;
		 g.right=k;
		 
		 vv.zigZagLevelView(a);
	}

}
