package programChallanges.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import programChallanges.tries.XorTries.TrieNode;

public class XorTries {
	  class TrieNode{
	        HashMap<Integer, TrieNode> children = new HashMap<>();
	        Integer data;
	        Integer index;
	        boolean isEndOfNode;

	    }
	    class Trie{
	        TrieNode root = new TrieNode();
	        public void insert(Integer number, Integer index){
	            TrieNode current = root;
	            for (int i = 29; i >=0; i--) {
	                Integer b= (number>>i)&1;
	               
	                current = current.children.computeIfAbsent(b, c -> new TrieNode());
	                
	            }
	            current.data = number;
	            current.index = index;
	            current.isEndOfNode =true;
	        }

	          public TrieNode findXorNode(Integer number) {
	            TrieNode current = root;
	            for (int i = 29; i >=0; i--) {
	                Integer b= (number>>i)&1;
	                Integer t = 1-b;
	               
	                TrieNode node = current.children.get(t);
	                if (node == null) {
	                    node = current.children.get(b);
	                }
	                current = node;
	            }
	            return current;
	        }
	    }
	    public ArrayList<Integer> solve(ArrayList<Integer> A) {
	    	ArrayList<Integer> list = new ArrayList<Integer>();
	        Trie t = new Trie();
	        int  maxXor=A.get(0);
	        int start =1;
	        int end = 1;
	        int preFixXor = maxXor;
	        t.insert(maxXor, 1);
	        for(int i=1;i<A.size();i++){
	          preFixXor^= A.get(i);
	          System.out.println("Prefix "+ preFixXor);
	          if(preFixXor>maxXor) {
	        	  start = 1;
	        	  end = i+1;
	        	  maxXor= preFixXor;
	          }
	          TrieNode node = t.findXorNode(preFixXor);
	          int bestXorPair = preFixXor^node.data;
	          System.out.println("BestXor "+ bestXorPair);
	          if(bestXorPair>maxXor) {
	        	  start = node.index+1;
	        	  end = i+1;
	        	  maxXor= bestXorPair;
	          }
	         t.insert(preFixXor, i+1);
	        }
	        list.add(start);
	        list.add(end);
	        return list;
	    }
	    public static void main(String[] args) {
			XorTries x = new XorTries();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(33);
			list.add(29);
			list.add(18);
			//list.add(4);
			//list.add(3);
			System.out.println(x.solve(list));
		}
}
