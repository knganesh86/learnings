package programChallanges.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Envelope {
	 public int solve(ArrayList<ArrayList<Integer>> A) {
		 int n = A.size();
		 int ans[]= new int[n];
		 A.sort(new MyListComparator());
		 for(int i=0;i<n;i++) {
			 int prev =0;
			 ArrayList<Integer> current = A.get(i);
			 for(int j=0;j<i;j++) {
				 ArrayList<Integer> prevValue = A.get(j);
				 if( prevValue.get(0)< current.get(0) && prevValue.get(1)< current.get(1)) {
					 prev =  Math.max(prev, ans[j]);
				 }
			 }
			 ans[i]=prev+1;
		 }
		 return ans[n-1];
	    }
	 
	 class MyListComparator implements Comparator<ArrayList<Integer>> {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			if(o1.get(0).equals(o2.get(0))) {
				return o1.get(1)-o2.get(1);
			}
			return o1.get(0)-o2.get(0);
		}
		 
	 }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		
	
		Integer a[][]= {{3,2},{2,3},{6,4},{3,1}};
		A.add(new ArrayList<>(	Arrays.asList(a[0])));
		A.add(new ArrayList<>(	Arrays.asList(a[1])));
		A.add(new ArrayList<>(	Arrays.asList(a[2])));
		A.add(new ArrayList<>(	Arrays.asList(a[3])));
		Envelope e = new Envelope();
		e.solve(A);
	}
	
	
	
}

