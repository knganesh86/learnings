package programChallanges.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMax {
	
	  public int[] slidingMaximum(final int[] A, int B) {
		 int ans[]=new int[A.length-B+1];
		 int index=0;
		 Deque<Integer> stack = new ArrayDeque<Integer>();
	    	for(int i=0;i<A.length;i++) {
	    		if(i>B-1&& stack.peek()<=(i-B)) {
	    				   stack.pop();
	    			   
	    		   }
	    		   while(!stack.isEmpty() && A[stack.getLast()]<=A[i]){
		                stack.removeLast();
		            }
	    		   stack.add(i);
	    		   if(i>=B-1) {
	    			  ans[index++]=A[stack.peek()];
	    			   
	    		   }
	    		   
	    	}
	    	return ans;
	    }
	  public int[] slidingMinimum(final int[] A, int B) {
			 int ans[]=new int[A.length-B+1];
			 int index=0;
			 Deque<Integer> stack = new ArrayDeque<Integer>();
		    	for(int i=0;i<A.length;i++) {
		    		if(i>B-1&& stack.peek()<=(i-B)) {
		    				   stack.pop();
		    			   
		    		   }
		    		   while(!stack.isEmpty() && A[stack.getLast()]>=A[i]){
			                stack.removeLast();
			            }
		    		   stack.add(i);
		    		   if(i>=B-1) {
		    			  ans[index++]=A[stack.peek()];
		    			   
		    		   }
		    		   
		    	}
		    	return ans;
		    }
	 public static void main(String[] args) {
		 SlidingWindowMax s = new SlidingWindowMax();
		 int a[]= {1, 3, -1, -3, 5, 3, 6, 7};
		 System.out.println(s.slidingMaximum(a,3));
		 System.out.println(s.slidingMinimum(a,3));
	}

}
