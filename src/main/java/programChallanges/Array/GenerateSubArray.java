package programChallanges.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSubArray {
	
	public static  ArrayList<ArrayList<Integer>> solve(List<Integer> A) {
      
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int n= A.size();
        int p = 0;
  
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
            	//int q=0;
            	ArrayList<Integer> subArray  = new ArrayList<Integer>();  
                for(int k =i;k<=j;k++){
                	subArray.add(A.get(k));
                }
                ans.add(subArray);
                
            }
        }
        ans.toArray(new Integer[0]);
        return ans;
    }
	public static void main(String[] args) {
		Integer  []a = new Integer[] {2,4,6};
		ArrayList<ArrayList<Integer>> ans = solve(Arrays.asList(a));
		System.out.println(ans);
	}

}
