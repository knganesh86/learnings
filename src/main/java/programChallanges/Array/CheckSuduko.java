package programChallanges.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckSuduko {

	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public static int isValidSudoku(final List<String> A) {
	        //verify the each row is isValidSudoku  
	        for(int i=0;i<9;i++){
	              Set<Character> set = new HashSet<>();
	              int count =0;
	            for(int j=0;j<9;j++){
	               char ch = A.get(i).charAt(j);
	                if(ch>48 && ch<58) {
	                    set.add(ch);
	                    count++;
	                }
	            }
	              // Add the array to set
	             if(set.size()!=count){
	                 return 0;
	             }
	        }
	        //verify the each column is isValidSudoku  
	        for(int i=0;i<9;i++){
	              Set<Character> set = new HashSet<>();
	              int count=0;
	               for(int j=0;j<9;j++){
	                   char ch = A.get(j).charAt(i);
	                    if(ch>48 && ch<57) {
	                         set.add(ch);
	                         count++;
	                    }
	               }    
	               if(set.size()!=count){
	                 return 0;
	             }
	        }

	        //verify the each block is isValidSudoku  
	        for(int i=0;i<3;i++){
	            for(int j=0;j<3;j++){
	               Set<Character> set = new HashSet<>();
	                int count =0;
	                for(int k=0;k<3;k++){
	                    for(int l=0;l<3;l++){
	                    char ch = A.get(k+(i*3)).charAt(l+(3*j));
	                    if(ch>48 && ch<57) {
	                         set.add(ch);
	                         count++;
	                    }
	                    }
	                }
	              
	               if(set.size()!=count){
	                 return 0;
	             }
	            }
	        }
	        return 1;

	    }
	    public static void main(String[] args) {
			String arr[] = new String[] { "........4", ".9.7...9.", ".......6.", ".7.......", ".1.......", ".........", ".8.....1.", "3....2..6", ".......7."};
			System.out.println(isValidSudoku(new ArrayList<String>(Arrays.asList(arr))));
		}

}
