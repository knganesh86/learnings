package programChallanges;

import java.util.ArrayList;
import java.util.TreeSet;

public class HashingFlipFlop {
	public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
		  char ch[] = A.toCharArray();
			ArrayList<Integer> ans = new ArrayList<>();
			TreeSet<Integer> set = new TreeSet<>();
			for (int i = 0; i < A.length(); i++) {
				if (ch[i] == '1') {
					set.add(i+1);
				}
			}
			for (int i = 0; i < B.size(); i++) {
				Integer type = B.get(i).get(0);
				Integer index = B.get(i).get(1);
				if (type == 1) {
					if (set.contains(index)) {
						set.remove(index);
					} else {
						set.add(index);
					}
				} else {
					
					if(set.contains(index)) {
						 ans.add(index); 
					}
					else {
						Integer r = set.higher(index);
						Integer l = set.lower(index);
						if (l == null && r == null) {
							ans.add(-1);
						} else if (l == null) {
							ans.add(r);
						} else if (r == null || ((r - index) == (index - l)) || ((r - index) > (index - 1))) {
							ans.add(l);
						} else {
							ans.add(r);
						}
					}
				}
			}
			return ans;
	    }
	public static void main(String[] args) {
		String a ="10010";
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> childList = new ArrayList<>();
		//[[1,3],[1,3],[2,4],[2,2],[1,1],[2,3],[1,5],[1,5]]
		childList.add(1);
		childList.add(3);
		list.add(childList);
		childList = new ArrayList<>();
		//[1,3],[2,4],[2,2],[1,1],[2,3],[1,5],[1,5]]
		childList.add(1);
		childList.add(3);
		list.add(childList);
		childList = new ArrayList<>();
		//[2,4],[2,2],[1,1],[2,3],[1,5],[1,5]]
		childList.add(2);
		childList.add(4);
		list.add(childList);
		childList = new ArrayList<>();
		//[2,2],[1,1],[2,3],[1,5],[1,5]]
		childList.add(2);
		childList.add(2);
		list.add(childList);
		childList = new ArrayList<>();
		//[1,1],[2,3],[1,5],[1,5]]
		childList.add(1);
		childList.add(1);
		list.add(childList);
		childList = new ArrayList<>();
		//[1,1],[2,3],[1,5],[1,5]]
		childList.add(2);
		childList.add(3);
		list.add(childList);
		HashingFlipFlop hf = new HashingFlipFlop();
		System.out.println(hf.solve(a, list));
		
	}
}
