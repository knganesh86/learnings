package programChallanges.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubSet {
	 ArrayList<ArrayList<Integer>> ans ;
	    int n ;
	    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
	        n=A.size();
	        ans= new ArrayList<>(); 
	        ArrayList<Integer> comp= new ArrayList<>();
	        Collections.sort(A);
	        subsets(A, comp, 0);
	        return ans;
	    }
	    public void subsets(ArrayList<Integer> a,  ArrayList<Integer> comp, int i ){
	        if(i==n){
	            ans.add(new ArrayList<>(comp));
	            return;
	        }
	    
	        subsets(a,comp, i+1);
		         
		             // add it in array
		            comp.add(a.get(i));
		            subsets(a,comp, i+1);
	                comp.remove(a.get(i));
	        

	    }
	    static class ListSorter implements Comparator<ArrayList<Integer>>{

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				int i=0;
				int n = Math.min(o1.size(), o2.size());
				while(i<=n) {
					int value1=0;
					int value2=0;
					if(i<o1.size()) {
						value1=o1.get(i);
					}
					else {
						return -1;
					}
					if(i<o2.size()) {
						value2=o2.get(i);
					}
					else {
						return 1;
					}
					if(value1!=value2) {
						return value1-value2;
					}
					i++;
				}
				return o1.size()-o2.size();
			}
	    	
	    }
	    public static void main(String[] args) {
			Integer a[]= {9,-20,-11,-8,-4,2,-12,14,1,-18};
			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
			SubSet s = new SubSet();
			ArrayList<ArrayList<Integer>> result = s.subsets(list);
			result.sort(new ListSorter());
			System.out.println(result);
		}
}
