package programChallanges.Array;

import java.util.ArrayList;

public class AlternatingSubArray {
	
	 public static int[] solve(int[] A, int B) {
	        ArrayList<Integer> resultArray = new ArrayList<>();
	        int n = A.length;
	        int s =B*2+1;
	        for(int i=0;i<(n-s);i++){
	            boolean isEven = A[i]%2==0;
	            boolean isValid=true;
	            for(int j=i+1;j<(i+s);j++){
	                boolean currentFlag = A[j]%2==0;
	                if((isEven && currentFlag)|| (!isEven && !currentFlag)){
	                    isValid = false;
	                    break;
	                }
	                else {
	                	isEven =currentFlag;
	                }
	            }
	            if(isValid){
	                resultArray.add(i+B);
	            }
	        }
	        System.out.println(resultArray);
	        return resultArray.stream().mapToInt(i -> i).toArray();
	    }
	 public static void main(String[] args) {
		int a[] = {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1 };
		solve(a, 1);
	}

}
