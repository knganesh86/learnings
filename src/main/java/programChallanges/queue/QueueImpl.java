package programChallanges.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueImpl {
	 static Deque<Integer> queue;
	    /** Initialize your data structure here. */
	 QueueImpl() {
	        queue = new ArrayDeque<Integer>();
	    }
	    
	    /** Push element X to the back of queue. */
	    static void push(int X) {
	        queue.add(X);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    static int pop() {
	        if(!queue.isEmpty()){
	        	return queue.pop();
	        }
	        return -1;
	    }
	    
	    /** Get the front element of the queue. */
	    static int peek() {
	        return queue.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    static boolean empty() {
	        return queue.isEmpty();
	    }
	    
	    public static void main(String[] args) {
	    	QueueImpl s = new QueueImpl();
			//19 P 10 P 9 g P 8 g 
			//P 7 g P 6 g p g p g 
			//p g p g p g
			s.push(10);
			s.push(9);
			s.push(8);
			s.push(7);
			s.push(6);
			System.out.println(pop());
			System.out.println(pop());
			System.out.println(peek());
			s.pop();
			s.pop();
			
		}
}
