package programChallanges.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixConversion {
	
	
	    public String solve(String A) {
	        Deque<Character> stack = new ArrayDeque<Character>();
	        StringBuilder str= new StringBuilder();
	        for(int i=0;i<A.length();i++){
	            char c= A.charAt(i);
	            if(Character.isLetterOrDigit(c)){
	                str.append(c);
	            }
	            else if(c=='('){
	                stack.push(c);
	            }
	            else if(c==')'){
	                while(!stack.isEmpty() && stack.peek()!='('){
	                    str.append(stack.peek());
	                    stack.pop();
	                }
	                //remove the'('
	                stack.pop();
	            }
	            else{
	                while(!stack.isEmpty() && getExpressionOrder(c)>=getExpressionOrder(stack.peek())){
	                    str.append(stack.peek());
	                    stack.pop();
	                }
	                stack.push(c);
	            }  
	            
	        }
	        while(!stack.isEmpty()){
	                str.append(stack.peek());
	                    stack.pop();
	            }
	        return str.toString();
	    }

	    int getExpressionOrder(char c){
	        if(c=='^'){
	            return 0; 
	        }
	        if(c=='*'||c=='/'){
	            return 1;
	        }
	        if(c=='+'||c=='-'){
	            return 2;
	        }
	        return 3;
	    }
	    public static void main(String[] args) {
			PostfixConversion p = new PostfixConversion();
			System.out.println(p.solve("a*(r+o*h)"));
		}


}
