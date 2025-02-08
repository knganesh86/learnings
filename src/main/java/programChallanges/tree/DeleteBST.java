package programChallanges.tree;

public class DeleteBST {
	
	public TreeNode solve(TreeNode A, int B) {
        if(A.val==B){
            if(A.left==null){
                return A.right;
            }
            else if(A.right==null){
                return A.left;
            }
            else{
                replaceLeftMost(A);    
            }
        }
        else{
            TreeNode parent = A;
            TreeNode deletedNode =null ;
            int i =0;
            while(deletedNode ==null && parent!=null){
                if(parent.left!=null && parent.left.val==B){
                	i=0;
                    deletedNode = parent.left;
                }
                else if(parent.right!=null && parent.right.val==B){
                	i=1;
                    deletedNode = parent.right;
                }
                else{
                    if(parent.val>B){
                        parent =parent.left;
                        i=0;
                    }
                    else{
                        parent = parent.right;
                        i=1;
                    }
                }
            }
            if(deletedNode!=null){
                 if(deletedNode.left==null){
                     if(i==0){
                         parent.left= deletedNode.right;
                     }
                     else{
                         parent.right = deletedNode.right;
                     }
                }
                 else if(deletedNode.right==null){
                     if(i==0){
                         parent.left= deletedNode.left;
                     }
                     else{
                         parent.right = deletedNode.left;
                     }
            }
            else {
                    replaceLeftMost(deletedNode);    
                 }
            }           
        }
         return A;
    }

    private void replaceLeftMost(TreeNode A){
        TreeNode parent = A;
        TreeNode temp=A.left;
        while(temp.right!=null){
            parent = temp;
            temp= temp.right;
        }
        if(parent==A){
            parent.left=temp.left;
        }
        else{
            parent.right= temp.left;
        }
        A.val = temp.val;
    }
    
    public static void main(String[] args) {

		 TreeNode a = new TreeNode(6);
		 TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(8);
		 TreeNode d = new TreeNode(1);
		 TreeNode e = new TreeNode(5);
		 TreeNode f = new TreeNode(7);
		 TreeNode g = new TreeNode(2);
		 TreeNode h = new TreeNode(3);
		 TreeNode i = new TreeNode(26);
		 TreeNode j = new TreeNode(28);
		 TreeNode k = new TreeNode(29);
		 a.left = b;
		 a.right=c;
		 b.left=d;
		 b.right=e;
		 c.left = f;
		 d.right =g;
		 g.right= h;
		// c.right=g;
		// d.left =h;
		// d.right=i;
		// g.left=j;
		//  g.right=k;
		 DeleteBST dB = new DeleteBST();
		dB.solve(a, 4);
	}

}
