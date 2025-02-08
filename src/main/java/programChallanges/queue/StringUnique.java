package programChallanges.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class StringUnique {
	public static String solve(String A) {
		 Deque<Character> stack = new ArrayDeque<Character>();
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 StringBuilder str = new StringBuilder();
		 for(int i=0;i<A.length();i++) {
			 char c = A.charAt(i);
			 int count = map.getOrDefault(c,0);
			 count++;
			 map.put(c, count);
			 if(count==1) {
				 stack.add(c);
			 }
			 while(!stack.isEmpty() && map.get(stack.peek())>1) {
				 stack.pop();
			 }
			 if(stack.isEmpty()) {
				 str.append("#");
			 }
			 else {
				 str.append(stack.peek());
			 }
		 }
		 return str.toString();
		 
    }
	public static void main(String[] args) {
		System.out.println(solve("abcabc"));
	}
}
