package programChallanges.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TrieAutoComplete {
	
	static class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        int[] order = new int[5];
        boolean isEndOfNode;

    }
    static class Trie{
        TrieNode root = new TrieNode();
        public void insert(String word, int priority){
           TrieNode current = root;
            for (char l: word.toCharArray()) {
                 current = current.children.computeIfAbsent(l, c -> new TrieNode());
                 for(int i=0;i<5;i++) {
                	 if (current.order[i]==0) {
                		 current.order[i]=priority;
                		 break;
                	 }
                 }
            }
            current.isEndOfNode =true;
        }
        public int[] getUnique(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                current = node;
                if(current==null) {
                	return new int[0];
                }
                
            }
            return current.order;
        }
    }
    public static void main(String[] args) {
    	Trie t = new Trie();
    	int testCase = 0;
    	Scanner sc = new Scanner(System.in);
    	testCase = sc.nextInt();
    	for(int i=0;i<testCase;i++) {
    		int numOfStr = sc.nextInt();
    		int numofSearch = sc.nextInt();
    		List<String> strList = new ArrayList<>();
    		List<Integer>  priorityList= new ArrayList<>();
    		for(int j=0;j<numOfStr;j++) {
    			strList.add(sc.next());
    		}
    		for(int j=0;j<numOfStr;j++) {
    			priorityList.add(sc.nextInt());	
    		}
    		HashMap<Integer, String> mapOfString = new HashMap<>();
    		int max =0;
    		for(int j=0;j<numOfStr;j++) {
    			mapOfString.put(priorityList.get(j), strList.get(j));
    			max = Math.max(max, priorityList.get(j));
    		}
    		for(int j=max;j>0;j--) {
    			String s = mapOfString.get(j);
    			if(s!=null) {
    				t.insert(s, j);
    			}
    		}
    		for(int j=0;j<numofSearch;j++) {
    			String s = sc.next();
    			int[] result =t.getUnique(s);
    			if(result.length==0) {
    				System.out.print(-1);
    			}
    			else {
    				for(int k=0;k<5;k++) {
    					if(result[k]!=0) {
    						System.out.print(mapOfString.get(result[k])+" ");
    					}
    				}
    			}
    			System.out.println();
    		}
    	}
    }


}
