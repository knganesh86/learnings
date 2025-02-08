package programChallanges.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class VerticalView {
	class TreeNodePair{
		TreeNode node;
		Integer location;
		public TreeNodePair(TreeNode node, Integer location) {
			this.node = node;
			this.location = location;
		}
		
	}
	 public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    ArrayList<ArrayList<Integer>> ans = new  ArrayList<>();
    Deque<TreeNodePair> queue = new ArrayDeque<>();
   
    queue.add(new TreeNodePair(A,0));
    TreeNode last = A;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int start = 0;
    int end = 0;
    while(!queue.isEmpty()){

    	TreeNodePair a = queue.pop();
    	ArrayList<Integer> list = map.getOrDefault(a.location, new ArrayList<Integer>());
    	list.add(a.node.val);
    	map.put(a.location, list);
        if(a.node.left!=null){
            queue.add(new TreeNodePair(a.node.left, a.location-1));
            start = Math.min(start, a.location-1);
        }
        if(a.node.right!=null){
        	queue.add(new TreeNodePair(a.node.right, a.location+1));
        	end = Math.max(start, a.location+1);
        }
        if(last==a.node && !queue.isEmpty()){
                last=queue.getLast().node;
        }
    }
    for(int i = start;i<=end;i++) {
    	ans.add(map.get(i));
    }
    return ans;
	 }
	 public static void main(String[] args) {
		 VerticalView vv= new VerticalView();
		 TreeNode a = new TreeNode(6);
		 TreeNode b = new TreeNode(9);
		 TreeNode c = new TreeNode(4);
		 TreeNode d = new TreeNode(8);
		 TreeNode e = new TreeNode(3);
		 a.left = b;
		 b.left=c;
		 c.right=d;
	//	 d.right=e;
		 
		 vv.verticalOrderTraversal(a);
	}

}
