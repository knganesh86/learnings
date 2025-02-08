package programChallanges.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargeAreaInMatrix {
	
	public int solve(int[][] A) {
		int ans=0;
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(A[i][j]!=0) {
					A[i][j]+=A[i-1][j];
				}
			}
		}
		for(int i=0;i<A.length;i++) {
			ans = Math.max(ans, largestRectangleArea(A[i]));
		}
		return ans;
	}
	
	 public int largestRectangleArea(int[] A) {
	        int ans =0;
	        int left[]=prevSmaller(A);
	        int right[]=nextSmaller(A);
	        for(int i=0;i<A.length;i++){
	            ans = Math.max(ans, A[i]*(right[i]-left[i]-1));
	        }
	        return ans;
	    }

	    public int[] prevSmaller(int[] A) {
		        Deque<Integer> stack = new ArrayDeque<Integer>();
		        int ans[]=new int[A.length];
		        for(int i=0;i<A.length;i++){
		            while(!stack.isEmpty() && A[stack.peek()]>=A[i]){
		                stack.pop();
		            }
		            if(stack.isEmpty()){
		                ans[i]=-1;
		            }
		            else{
		                ans[i]=stack.peek();
		            }
		            stack.push(i);
		        }
		        return ans;
		    }
		    public int[] nextSmaller(int[] A) {
		        Deque<Integer> stack = new ArrayDeque<Integer>();
		        int ans[]=new int[A.length];
		        for(int i=A.length-1;i>=0;i--){
		            while(!stack.isEmpty() && A[stack.peek()]>=A[i]){
		                stack.pop();
		            }
		            if(stack.isEmpty()){
		                ans[i]=A.length;
		            }
		            else{
		                ans[i]=stack.peek();
		            }
		            stack.push(i);
		        }
		        return ans;
		    }
		     public int[] prevGreater(int[] A) {
		        Deque<Integer> stack = new ArrayDeque<Integer>();
		        int ans[]=new int[A.length];
		        for(int i=0;i<A.length;i++){
		            while(!stack.isEmpty() &&  A[stack.peek()]<=A[i]){
		                stack.pop();
		            }
		            if(stack.isEmpty()){
		                ans[i]=-1;
		            }
		            else{
		                ans[i]=stack.peek();
		            }
		            stack.push(i);
		        }
		        return ans;
		    }
		     
		     public static void main(String[] args) {
				LargeAreaInMatrix l = new LargeAreaInMatrix();
				int a[][]= {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,0,0,1}};
				System.out.println(l.solve(a));
						
						
			}

}
