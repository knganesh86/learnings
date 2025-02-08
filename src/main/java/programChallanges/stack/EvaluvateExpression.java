package programChallanges.stack;

public class EvaluvateExpression {
	 public static int evalRPN(String[] A) {
	        int[] stack = new int[A.length];
	        int index=0;
	        for(int i=0; i<A.length;i++){
	            String str= A[i];
	            if(index>0 && isOperator(str)){
	                int operend2 = stack[index-1];
	                int operend1 = stack[index-2];
	                index--;
	                index--;
	                int value = performOperation(operend1, operend2, str);
	                stack[index]= value;
	                index++;

	            }
	            else{
	                int value = Integer.parseInt(str);
	                stack[index]=value;
	                index++;
	            }
	        }
	        return stack[index-1];
	    }

	    private static boolean isOperator(String s){
	        if(s.equals("*") || s.equals("/") || s.equals("+")|| s.equals("-")){
	            return true;
	        }
	        return false;
	    }

	    private static int performOperation(int a, int b, String operation){
	        if(operation.equals("+")){
	            return a+b;
	        }
	        else if(operation.equals("-")){
	            return a-b;
	        }
	        else if(operation.equals("*")){
	            return a*b;
	        }
	        else if(operation.equals("/")){
	            return a/b;
	        }
	        return 0;
	    }
	    public static void main(String[] args) {
			String a[] = {"4", "13", "5", "/", "+"};
			System.err.println(evalRPN(a));
		}
}
