package programChallanges.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubSetDuplicate {
	 	ArrayList<ArrayList<Integer>> ans ;
	    int n ;
	    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
	        n=A.size();
	        ans= new ArrayList<>(); 
	        ArrayList<Integer> comp= new ArrayList<>();
	        Collections.sort(A);
	        int freq[] = new int[11];
	        for(int a:A) {
	        	freq[a]++;
	        }
	        subsets(freq, comp, 0);
	        ans.sort(new ListSorter());
	        return ans;
	    }

		public void subsets(int freq[], ArrayList<Integer> comp, int i) {
			if (comp.size() == n) {
				ans.add(new ArrayList<>(comp));
				return;
			}
			ans.add(new ArrayList<>(comp));
			for(int x=i;x<freq.length;x++) {
				if(freq[x]>0) {
					freq[x]--;
					// add it in array
					comp.add(x);
					subsets(freq, comp, x);
					freq[x]++;
					comp.remove((Integer)x);
					
				}
			}
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
			Integer a[]= {1,2,2,3};
			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
			SubSetDuplicate s = new SubSetDuplicate();
			ArrayList<ArrayList<Integer>> result = s.subsets(list);
			result.sort(new ListSorter());
			System.out.println(result);
		}
}
