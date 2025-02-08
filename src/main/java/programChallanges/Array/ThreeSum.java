package programChallanges.Array;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        long result =Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int j =i+1;
            int k =n-1;
            
            while(j<k){
               int sum=A[i]+A[j]+A[k];
                
               long v1 = Math.abs(result-B);
               long v2 = Math.abs(sum-B);
                if(v1>v2){
                   result = sum;
                }
                if(sum==B){
                    break;
                }
                if(sum<B){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return (int)result;
    }
    public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int a[]= {5,-2,-1,-10,10};
		System.out.println(ts.threeSumClosest(a, 5));
	}
}
