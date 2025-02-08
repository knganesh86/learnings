package programChallanges.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubArraySum {
	
	    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
	        ArrayList<Integer> result = new ArrayList<>();
	        HashSet<Integer> pfSet = new HashSet<Integer>();
	        int value=0;
	        for(int i=0;i<A.size();i++){
	            value+=A.get(i);
	            pfSet.add(value);
	        }
	        int prevSum=0;
	        for(int i=0;i<A.size();i++){
	            if(pfSet.contains(B+prevSum)){
	                value=0;
	                for(int j=i;j<A.size();j++){
	                    value+=A.get(j);
	                    if(value<=B){
	                        result.add(A.get(j));
	                    }
	                }
	                return result;
	            }
	            prevSum+=A.get(i);
	        }
	        result.add(-1);
	        return result;
	    }
	
	    public ArrayList<Integer> solve2(ArrayList<Integer> A, int B) {
	        ArrayList<Integer> result = new ArrayList<>();
	        ArrayList<Integer> pfSet = new ArrayList<Integer>();
	        int value=0;
	        for(int i=0;i<A.size();i++){
	            value+=A.get(i);
	            pfSet.add(value);
	            if(value ==B) {
	            	for(int k=0;k<=i;k++) {
		        		result.add(A.get(k));
		        	}
	            	return result;
	            }
	        }
	       
	        int prevSum=0;
	        int i=0;
	        int j=1;
	        while(j<A.size()) {
	        	int current = pfSet.get(j)-pfSet.get(i);
	        	if(current==B) {
	        		break;
	        	}
	        	else if(current<B){
	        		j++;
	        	}
	        	else {
	        		i++;
	        		if(i==j) {
	        			j++;
	        		}
	        	}
	        	
	        }
	        if(j>=A.size()) {
	        	result.add(-1);
	        }
	        else {
	        	for(int k=i+1;k<=j;k++) {
	        		result.add(A.get(k));
	        	}
	        }
	        return result;
	    }
	public static void main(String[] args) {
		SubArraySum s = new SubArraySum();
//		Integer a[]= new Integer[]{1,2,3,4,5};
//		ArrayList<Integer> b= new ArrayList<>(Arrays.asList(a));
//		System.out.println(s.solve2(b, 5));
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=1;i<2000;i++) {
			a.add(i);
		}
		System.out.println(s.solve2(a, 500500));
	}


}
