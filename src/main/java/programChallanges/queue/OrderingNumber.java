package programChallanges.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OrderingNumber {
	
	public ArrayList<Integer> solve(int A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		if(A>=1) {
			queue.add(1);
			ans.add(1);
		}
		if(A>=2) {
			queue.add(2);
			ans.add(2);
		}
		if(A>=3) {
			queue.add(3);
			ans.add(3);
		}
		int i=3;
		while(i<A) {
			int x= queue.poll();
			if(i+1<=A) {
				queue.add(x*10+1);
				ans.add(x*10+1);
			}
			if(i+2<=A) {
				queue.add(x*10+2);
				ans.add(x*10+2);
			}
			if(i+3<=A) {
				queue.add(x*10+3);
				ans.add(x*10+3);
			}
			i+=3;
		}
		return ans;
    }
	public static void main(String[] args) {
		OrderingNumber orderImp = new OrderingNumber();
		System.out.println(orderImp.solve(7));
	}

}
