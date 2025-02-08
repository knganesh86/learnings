package programChallanges.tree;

public class ConstructBBT {
	public TreeNode sortedArrayToBST(final int[] A) {
		TreeNode ans = sortedArrayToBST(A,0, A.length-1);
		return ans;
    }
	TreeNode sortedArrayToBST(final int[] A, int s, int e) {
		 if(s==e) {
			 return new TreeNode(A[s]);
		 }
		 else if(s>e) {
			 return null;
		 }
		 else {
			 int size = e-s+1;
			 int mid = size/2;
			 TreeNode a = new TreeNode(A[s+mid]);
			 a.left= sortedArrayToBST(A, s, s+mid-1);
			 a.right = sortedArrayToBST(A, s+mid+1, e);
			 return a;
		 }
	    }
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6};
		ConstructBBT cb = new ConstructBBT();
		cb.sortedArrayToBST(a);
	}
}
