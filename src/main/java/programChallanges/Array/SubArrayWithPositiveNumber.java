package programChallanges.Array;

import java.util.Arrays;

public class SubArrayWithPositiveNumber {
	public static int[] solve(int[] A) {
        int n = A.length;
        int length =0;
        int index =-1;
        int i=0;
        Arrays.sort(A);
        while(i<n){
            int subArrayLength=0;
            while(i<n && A[i]>=0){
                subArrayLength++;
                i++;
            }
            if(subArrayLength>length){
                length=subArrayLength;
                index = i-subArrayLength;
            }
            else if(subArrayLength == length && subArrayLength>0){
                if(A[index]>A[i-subArrayLength]){
                    index= i-subArrayLength;
                }
            }
            while(i<n && A[i]<0){
                i++;
            }
        }
        int result[] = new int[length];
        for(i=0;i<length;i++){
            result[i]=A[i+index];
        }
        return result;
    }
	public static void main(String[] args) {
		int a[] = { -4549634, -3196682, 8455838, -1432628, -263819, -3928366, -5556259, -2114783, 3923939, -4183708};
		solve(a);
	}
	
}
