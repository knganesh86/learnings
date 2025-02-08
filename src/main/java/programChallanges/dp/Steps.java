package programChallanges.dp;

public class Steps {
	 public static int climbStairs(int A) {
	        if(A<2){
	            return A;
	        }
	        int x =1;
	        int y=2;
	        for(int i=2;i<A;i++){
	            long z=x+y;
	            x=y;
	            y=(int)z%1000000007;
	        }
	        return y;
	        
	    }
	 public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

}
