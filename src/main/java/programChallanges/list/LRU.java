package programChallanges.list;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
	
		LinkedList<Integer> list = null;
		HashMap<Integer, Integer> map = null;
		int size = 0;
		int capacity =0;
	 public LRU(int capacity) {
	        list = new LinkedList<>();
	        map = new HashMap<>();
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        int result = map.getOrDefault(key, -1);
	        if(result !=-1) {
	        	list.remove((Integer)key);
	    		list.add(key);
	        }
	        return result;
	    }
	    
	    public void set(int key, int value) {
	    	if(get(key)!=-1) {
	    		map.put(key, value);
	    	}
	    	else {
	    	if(size==capacity) {
	    		Integer removedNode = list.poll();
	    		map.remove(removedNode);
	    	}
	    	else {
	    		size++;
	    	}
	    	map.put(key, value);
	    	list.add(key);
	    	
	    	}
	        	
	        	
	    }
	    public static void main(String[] args) {
	    	//4 S 5 13 
	    	//S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 
	    	//S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10
	    	//S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
			LRU l = new LRU(4);
			
			l.set(5,13);
			l.set(9, 6);
			l.set(4, 1);
			System.out.println(l.get(4)); 
			l.set(6, 1); //5,9,4,6
			l.set(8, 11); //9,4,6,8
			System.out.println(l.get(13));
			System.out.println(l.get(1));
			l.set(12,12);
			System.out.println(l.get(10));
			l.set(15,13);
			l.set(2,13);
			l.set(7,5);
			l.set(10,3);
			System.out.println(l.get(6));
			System.out.println(l.get(10));
			
			l.set(15,14); 
			l.set(5,12);
			System.out.println(l.get(5));
			System.out.println(l.get(7));
			System.out.println(l.get(15));
			System.out.println(l.get(5));
			System.out.println(l.get(6));
			System.out.println(l.get(10));
			l.set(7,13);
			System.out.println(l.get(14));
			l.set(8, 9); 
			System.out.println(l.get(4));
			l.set(6, 11); 
			System.out.println(l.get(9));
			l.set(6, 12);
			System.out.println(l.get(3));
			
			
		}
}
