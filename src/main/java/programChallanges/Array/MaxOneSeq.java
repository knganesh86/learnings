package programChallanges.Array;

public class MaxOneSeq {
	 public int[] maxone(int[] A, int B) {
	        int i =0;
	        int j =0;
	        int n = A.length;
	        int max = 0;
	        int sMax = 0;
	        int zCount =0;
	        while(j<n){
	            if(A[j]==0){
	                zCount++;
	            }
	            if(zCount>B){
	                
	                while(A[i]!=0){
	                    i++;
	                }
	                i++;
	                
	                zCount--;
	            }
	            int length = j-i+1;
                if(length>max){
                    sMax = i;
                    max = length;
                }
	            j++;
	            
	        }
	        int ans[]=new int[max];
	        for(int x =0; x<max;x++){
	            ans[x]= sMax+x;
	        }
	        return ans;
	    }
	 public static void main(String[] args) {
		MaxOneSeq ms = new MaxOneSeq();
		int a[]= {1, 0, 0, 0, 1, 0, 1};
		int result[]=ms.maxone(a, 2);
		for(int x:result) {
			System.out.print(x+" ");
		}
	}

}
