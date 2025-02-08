package programChallanges.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Permute {
	
	  int count=0;
	  HashSet<ArrayList<Integer>> visitedSets = new HashSet<>();
	  public int solve(ArrayList<Integer> A) {
	        if(A.size()<2){
	            return 0;
	        }
	        //Arrays.sort(A);
	        permute(0,A);
	        return count;
	    }

	    private void permute(int i, ArrayList<Integer> a){
			     if (i == a.size() - 1 && isSquare(a.get(i)+a.get(i-1)) && visitedSets.add(a)) {
			    	 
			    	 count++;
			     }
			     for (int j = i; j<a.size(); j++){
			    	 if(i!=j && a.get(i).equals(a.get(j))) {
			    		 continue;
			    	 }
			       Collections.swap(a, i, j);
	              if(i==0 || isSquare(a.get(i)+a.get(i-1))){
			       permute(i+1,a);
	               }
			       Collections.swap(a, j, i);
			     }
			   }
	            private boolean isSquare(int a){
	                for(int i=1;i<=a;i++){
	                    if(i*i==a){
	                         
	                        return true;
	                       
	                    }
	                    if(i*i>a){
	                        return false;
	                    }
	                }
	                return false;
	            }
	            
		  public static void main(String[] args) {
			  Integer a[]= {36229,1020,69,127,162,127};
			  Permute p = new Permute();
			  ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
			  System.out.println(p.solve(list));
		}
		
}
