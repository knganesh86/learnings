package programChallanges.backtrace;

import java.util.ArrayList;
import java.util.HashMap;

public class StringDictionary {
	public int wordBreak(String A, ArrayList<String> B) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(A);
		
		if(wordBreakSolve(A, B, 0)) {
			return 1;
		}
		return 0;
    }
	HashMap<Integer, Boolean> resultMap = new HashMap<>();
	private boolean wordBreakSolve(String a, ArrayList<String> b, int i) {
		boolean result=false;
		if(i==a.length()) {
			return true;
		}
		for(int x=i+1;x<=a.length();x++) {
			String s = a.substring(i,x);
			if(b.contains(s)) {
				result|= resultMap.computeIfAbsent(x, k->wordBreakSolve(a,b,k));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		StringDictionary s = new StringDictionary();
		ArrayList<String> list = new ArrayList<>();
		list.add("c");
		list.add("ab");
		list.add("abb");
		System.out.println(s.wordBreak("ababbc", list));
	}

	
}
