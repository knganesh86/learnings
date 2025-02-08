package programChallanges.stack;

import java.util.LinkedList;

public class StackImpl {
	 LinkedList<Integer> list = new LinkedList<>();
    int currentMin =-1;
	    public void push(int x) {
	    	
	        if(list.isEmpty()){
	            currentMin = x;
	        }
	        else {
	        	currentMin = Math.min(currentMin, x);
	        }
	        list.push(x);
	    }

	    public void pop() {
	        if(list.isEmpty()){
	            return;
	        }
	       int topValue = list.pop();
	     
	       if(currentMin==topValue){
	           if(!list.isEmpty()){
	               currentMin = list.get(0);
	                for(Integer value: list){
	                    if(currentMin>value){
	                        currentMin = value;
	                    }
	                    
	                }
	           }
	           else{
	               currentMin = -1;
	           }
	       }
	        
	    }

	    public int top() {
	        if(list.isEmpty()){
	            return -1;
	        }
	        return list.peek();
	    }

	    public int getMin() {
	        return currentMin;
	    }
	    public static void main(String[] args) {
			StackImpl s = new StackImpl();
			//19 P 10 P 9 g P 8 g 
			//P 7 g P 6 g p g p g 
			//p g p g p g
			s.push(10);
			s.push(9);
			System.out.println(s.getMin());
			s.push(8);
			System.out.println(s.getMin());
			s.push(7);
			System.out.println(s.getMin());
			s.push(6);
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
		}

}
