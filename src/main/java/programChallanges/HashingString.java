package programChallanges;

import java.util.HashMap;

public class HashingString {
	public String minWindow(String A, String B) {
	 int n = B.length();
     int m = A.length();
     HashMap<Character, Integer> aMap = new HashMap<>();
     HashMap<Character, Integer> bMap = new HashMap<>();
   
     for(int i=0;i<n;i++){
         char c =A.charAt(i);
         int freq = aMap.getOrDefault(c, 0);
         aMap.put(c, freq+1);
     }
     for(int i=0;i<n;i++){
         char c =B.charAt(i);
         int freq = bMap.getOrDefault(c, 0);
         bMap.put(c, freq+1);
     }
     int h=0; 
     int r = n-1;
     int count =Integer.MAX_VALUE;
     String result="";
     while(h<m){
         if(compare(aMap,bMap)){
             int cLength = r-h+1;
             if(cLength<count){
                 count = cLength;
                 result = A.substring(h, r+1);
             }
             char c =A.charAt(h);
             int freq = aMap.getOrDefault(c, 0);
             aMap.put(c, freq-1);
             h++;
         }
         else{
             r++;
             if(r==m){
                 break;
             }
              char c =A.charAt(r);
              int freq = aMap.getOrDefault(c, 0);
              aMap.put(c, freq+1);
         }
     }
     return result;

 }
 private boolean compare(HashMap<Character, Integer> aMap, HashMap<Character, Integer> bMap){
	 for(Character c:bMap.keySet()) {
		 if(aMap.getOrDefault(c,0)<bMap.get(c)) {
			 return false;
		 }
	 }
     return true;
 }
 public static void main(String[] args) {
	HashingString hs = new HashingString();
	System.out.println(hs.minWindow("Aa91b","ab"));
}

}
