package programChallanges.backtrace;

import java.util.ArrayList;

public class PalindromePermutation {
	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		partitionPalindrome(a,0,ans, list);
		return ans;
	}

	private void partitionPalindrome(String a, int i, ArrayList<ArrayList<String>> ans, ArrayList<String> list) {
		if(i==a.length()) {
			ans.add(new ArrayList<>(list));
			return;
		}
		for(int x=i+1;x<=a.length();x++) {
			String s = a.substring(i,x);
			if(s.isEmpty()) {
				return;
			}
			if(isPalindrome(s)) {
				list.add(s);
				partitionPalindrome(a, x, ans, list);
				list.remove(list.size()-1);
			}
		}
		
	}

	public boolean isPalindrome(String s) {
		int n=s.length();
		if(n==1) {
			return true;
		}
		for(int i=0;i<n/2;i++) {
			if(s.charAt(i)!=s.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PalindromePermutation p = new PalindromePermutation();
		ArrayList<ArrayList<String>> result = p.partition("aab");
		System.out.println(result);
	}
}
