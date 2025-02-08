import java.util.ArrayList;

public class Parenthesis {
    static void getParenthesis(char str[], int pos,
            int n, int open,
            int close, ArrayList<String> result) {
    	if(close == n) {
    		String s= new String(str);
    		result.add(s);
    	}
    	else {
    		
    		if(open<n) {
    			str[pos]='(';
    			getParenthesis(str, pos+1, n, open+1, close, result);
    		}
    		if(open>close) {
    			str[pos]=')';
    			getParenthesis(str, pos+1, n, open, close+1, result);
    		}
    	}
    }
    public ArrayList<String> generateParenthesis(int A) {
    	ArrayList<String> result = new ArrayList<>();
    	if(A>0) {
    		char[] str = new char[2 * A];
    		getParenthesis(str, 0, A, 0, 0, result);
    	}
    	return result;
    }
    public static void main(String[] args) {
		Parenthesis p = new Parenthesis();
		ArrayList<String> result = p.generateParenthesis(3);
		System.out.println(result);
	}
}
