package programChallanges.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class TriangleSum {

	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	
	ArrayList<Integer> finalList = new ArrayList();
	int rows = a.size();
	finalList = a.get(rows-1);
	int index =rows-2;
	while(index>=0) {
		ArrayList<Integer> currentList = a.get(index);
		ArrayList<Integer> sumList = new ArrayList();
		for(int i =0;i<currentList.size();i++) {
		
			sumList.add(currentList.get(i)+Math.min(finalList.get(i), finalList.get(i+1)));
		}
		finalList = sumList;
		index--;
	}
	
	return finalList.get(0);
	}
	public static void main(String[] args) {
		Integer r1[] = {1};
		Integer r2[] = {2,3};
		Integer r3[]= {6,4,7};
		Integer r4[]= {1,6,8,9};
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		input.add(new ArrayList<>(Arrays.asList(r1)));
		//input.add(new ArrayList<>(Arrays.asList(r2)));
		//input.add(new ArrayList<>(Arrays.asList(r3)));
		//input.add(new ArrayList<>(Arrays.asList(r4)));
		TriangleSum t = new TriangleSum();
		System.out.println(t.minimumTotal(input));
	}
}
