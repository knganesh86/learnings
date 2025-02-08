package programChallanges.tree;

public class SumTillLeaf {
	int isPathAvailable = 0;
    public int hasPathSum(TreeNode A, int B) {
        travelTreeSum(A,A.val,B);
        return isPathAvailable;
    }
	 void travelTreeSum(TreeNode A,int sum, int B) {
		 	System.out.println("visited"+A.val);
	     //   System.out.println(sum +" "+B);
	        if(A.left==null&& A.right==null){
	         //    System.out.println("checking"+sum);
	            if(sum==B){
	                isPathAvailable = 1;
	            }
	        }
	        if(A.left!=null){
	            travelTreeSum(A.left, sum+A.left.val, B);
	        }
	        if(A.right!=null){
	            travelTreeSum(A.right, sum+A.right.val, B);
	        }       
	    }
	 public static void main(String[] args) {
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
		 i.left=j;
		 i.right=k;
		 SumTillLeaf s = new SumTillLeaf();
		 s.hasPathSum(a,56 );
	}
}
