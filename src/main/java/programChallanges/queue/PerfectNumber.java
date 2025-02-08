package programChallanges.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumber {
	public String solve(int A) {
		String ans="";
		Queue<String> queue = new LinkedList<>();
		if(A>=1) {
			queue.add("1");
			ans = "11";
		}
		if(A>=2) {
			queue.add("2");
			ans = "22";
		}
		
		int i=2;
		while(i<A) {
			String x= queue.poll();
			if(i+1<=A) {
				StringBuilder b = new StringBuilder(x+"1");
				queue.add(b.toString());
				ans = b.toString()+b.reverse().toString();
			}
			if(i+2<=A) {
				StringBuilder b = new StringBuilder(x+"2");
				queue.add(b.toString());
				ans = b.toString()+b.reverse().toString();
			}
			i+=2;
		}
		return ans;
		
    }
	public static void main(String[] args) {
		PerfectNumber p = new PerfectNumber();
		System.out.println(p.solve(9));
	}
}
