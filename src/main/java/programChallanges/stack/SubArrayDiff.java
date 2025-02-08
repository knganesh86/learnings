package programChallanges.stack;

import java.util.Stack;

public class SubArrayDiff {
	/*
	 public int solve(int[] A) {
	        int ans = 0;
	        int leftSmall[] = prevSmaller(A);
	        int rightSmall[] = nextSmaller(A);
	        int leftGreat[] = prevGreater(A);
	        int rightGreat[] = nextGreater(A);
	        for(int i=0;i<A.length;i++){
	            int value = A[i]*((i-leftGreat[i])*(rightGreat[i]-i)-(i-leftSmall[i])*(rightSmall[i]-i))%1000000007;
	            ans+=value;
	            ans%=1000000007;
	            if(ans<0){
	                ans+=1000000007;
	            }
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
	    public int[] nextGreater(int[] A) {
	        Deque<Integer> stack = new ArrayDeque<Integer>();
	        int ans[]=new int[A.length];
	        for(int i=A.length-1;i>=0;i--){
	            while(!stack.isEmpty() && A[stack.peek()]<=A[i]){
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
	    }*/
	 int[] a;
	    public void findNextGreaterElement(int[] Next_greater_element, int n){
	        // this function calculates next_greater element index
	        Stack < Integer > s = new Stack < Integer > ();
	        for (int i = 0; i < n; i++) Next_greater_element[i + 1] = n + 1;
	        for (int i = 1; i <= n; i++) { 
	            if (s.empty()) {
	                s.push(i);
	            } else {
	                while (!s.empty() && a[s.peek()] <= a[i]) {
	                    Next_greater_element[s.peek()] = i;
	                    s.pop();
	                }
	                s.push(i);
	            }
	        }
	    }
	    public void findPreviousGreaterElement(int[] Previous_greater_element, int n){
	        // this function calculates Previous_greater element index
	        Stack < Integer > s = new Stack < Integer > ();
	        for (int i = n; i > 0; i--) { 
	            if (s.empty()) {
	                s.push(i);
	            } else {
	                while (!s.empty() && a[i] > a[s.peek()]) {
	                    Previous_greater_element[s.peek()] = i;
	                    s.pop();
	                }
	                s.push(i);
	            }
	        }
	    }
	    public void findPreviousSmallerElement(int[] Previous_smaller_element, int n){
	        // this function calculates Previous smaller element index
	        Stack < Integer > s = new Stack < Integer > ();
	        for (int i = n; i > 0; i--) { 
	            if (s.empty()) {
	                s.push(i);
	            } else {
	                while (!s.empty() && a[i] <= a[s.peek()]) {
	                    Previous_smaller_element[s.peek()] = i;
	                    s.pop();
	                }
	                s.push(i);
	            }
	        }
	    }
	    public void findNextSmallerElement(int[] Next_smaller_element, int n){
	        // function function calculates Next smaller element index
	        Stack < Integer > s = new Stack < Integer > ();
	        for (int i = 0; i < n; i++) Next_smaller_element[i + 1] = n + 1;
	        for (int i = 1; i <= n; i++) { 
	            if (s.empty()) {
	                s.push(i);
	            } else {
	                while (!s.empty() && a[i] < a[s.peek()]) {
	                    Next_smaller_element[s.peek()] = i;
	                    s.pop();
	                }
	                s.push(i);
	            }
	        }
	    }
	    
	    public int solve(int[] A) {
	        int n = A.length, mod = 1000 * 1000 * 1000 + 7;
	        a = new int[n + 1];
	        int Next_greater_element[] = new int[n + 1];
	        int Previous_greater_element[] = new int[n + 1];
	        int Previous_smaller_element[] = new int[n + 1];
	        int Next_smaller_element[] = new int[n + 1];
	        for (int i = 0; i < n; i++) {
	            a[i + 1] = A[i];
	        }
	        
	        findNextGreaterElement(Next_greater_element, n);
	        findPreviousGreaterElement(Previous_greater_element, n);
	        findPreviousSmallerElement(Previous_smaller_element, n);
	        findNextSmallerElement(Next_smaller_element, n);
	       
	        long ans = 0;
	        for (int i = 1; i <= n; i++) {
	            long right = Next_greater_element[i] - i;
	            long left = i - Previous_greater_element[i];
	            ans += (((left * right) % mod) * a[i]) % mod;
	            ans %= mod;
	            left = i - Previous_smaller_element[i];
	            right = Next_smaller_element[i] - i;
	            ans -= (((left * right) % mod) * a[i]) % mod;
	            ans += mod;
	            ans %= mod;
	        }
	        return (int) ans;
	    }
	    public static void main(String[] args) {
			SubArrayDiff s = new SubArrayDiff();
			int a[]= {992387,932142,971117,934674,988917,967890,948508,970347};
			System.out.println(s.solve(a));
		}

}
