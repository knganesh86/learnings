package programChallanges.stack;

public class BallPass {
	public static int solve(int A, int B, int[] C) {
        int stack[] = new int[A];
        int prev = B;
        int i=0;
         int current = -1;
        for(int x=0;x<A;x++){
            current = C[x];
            if(current==0 && i>0){
                current = stack[i-1];
                i--;
            }
            else{
                stack[i]=prev;
                i++;
            }
            prev=current;
        }
        return current;
    }
	public static void main(String[] args) {
		int A=10;
		int B= 38;
		int C[]= {23,0,2,0,39,28,19,0,0,0};
		System.out.println(solve(A, B, C));
	}

}
