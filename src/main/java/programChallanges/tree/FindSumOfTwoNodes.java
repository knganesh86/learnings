package programChallanges.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindSumOfTwoNodes {
	public int t2Sum(TreeNode A, int B) {
	    Deque<TreeNode> frontStack = new ArrayDeque<>();
	    Deque<TreeNode> reverseStack = new ArrayDeque<>();
	    TreeNode temp = A;
	    while(temp!=null) {
	    	reverseStack.push(temp);
	    	temp = temp.right;
	    }
	    temp = A;
	    while(temp!=null) {
	    	frontStack.push(temp);
	    	temp = temp.left;
	    }
	   TreeNode pointer1= getNextValue(frontStack);
	   TreeNode pointer2 = getPrevValue(reverseStack);
	   while(pointer1 !=null &&  pointer2!=null && pointer1.val<pointer2.val) {
		   int a = pointer1.val+pointer2.val;
		   if(a==B) {
			   return 1;
		   }
		   else if(a>B) {
			   pointer2=getPrevValue(reverseStack);
		   }
		   else {
			   pointer1=getNextValue(frontStack);
		   } 
		   
	   }
	   return 0;
	    

    }

	private TreeNode getNextValue(Deque<TreeNode> stack) {
		if(stack.isEmpty()) {
			return null;
		}
		else {
			TreeNode a = stack.pop();
			TreeNode temp = a.right;
			while(temp!=null) {
				stack.push(temp);
		    	temp = temp.left;
			}
			return a;
		}
		
	}
	
	private TreeNode getPrevValue(Deque<TreeNode> stack) {
		if(stack.isEmpty()) {
			return null;
		}
		else {
			TreeNode a = stack.pop();
			TreeNode temp = a.left;
			while(temp!=null) {
				stack.push(temp);
		    	temp = temp.right;
			}
			return a;
		}
		
	}
	public static void main(String[] args) {

		 TreeNode a = new TreeNode(18);
		 TreeNode b = new TreeNode(7);
		 TreeNode c = new TreeNode(20);
		 TreeNode d = new TreeNode(6);
		 TreeNode e = new TreeNode(8);
		 TreeNode f = new TreeNode(22);
		 TreeNode g = new TreeNode(2);
		 TreeNode h = new TreeNode(3);
		 a.left = b;
		 a.right=c;
		 b.left=d;
		 b.right=e;
		 c.right = f;
//		 f.right =g;
//		 g.right= h;
		 FindSumOfTwoNodes fs = new FindSumOfTwoNodes();
		 System.out.println(fs.t2Sum(a, 22));
	}

}
