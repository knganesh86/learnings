package programChallanges.sorting;

import java.util.Comparator;

public class InsertionSortGroup implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		if(o1.length != o1.length) {
			return o1.length-o2.length;
		}
		for(int i=0;i<o1.length;i++) {
			if(o1[i]==o2[i]) {
				continue;
			}
			else {
				return o1[i]-o2[i];
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int a[]= {1,2,3};
		int b[] ={1,2,4};
		System.out.println(new InsertionSortGroup().compare(a, b));
	}


}
