import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberCombo {
	static void getNumber(int n, int pos, int length, int max, Integer[]arr, ArrayList<ArrayList<Integer>> list){
		arr[pos]=n;
		pos++;
		if(length==pos) {
			ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(arr));
			list.add(numList);
			return;
		}
		for(int i=n;i<max;i++) {
			getNumber(i+1, pos, length, max, arr, list);
		}
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> resultarray = new ArrayList<>();
		int a=7;
		int b=3;
		Integer arr[]= new Integer[b];
		for(int i=1;i<=a;i++) {
			getNumber(i, 0, b, a, arr, resultarray);
		}
		System.out.println(resultarray);
	}

}
