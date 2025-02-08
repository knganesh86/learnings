package programChallanges.string;

public class Palindrome {
	
	public static int solve(String A) {
        int count =0;
        StringBuilder B = new StringBuilder(A);
        B.append("$");
        B.append(new StringBuilder(A).reverse());
        int a[] = generateLCP(B.toString());
       	count = A.length()-a[B.length()-1];
        return count;
    }

	private static int[] generateLCP(String s) {
		int arr[]= new int[s.length()];
		int i=0;
		int j=1;
		while(j<s.length()) {
			if(s.charAt(i)==s.charAt(j)) {
				i++;
				arr[j]=i;
				j++;
				
			}
			else {
				if(i!=0) {
					i=arr[i-1];
				}
				else {
					arr[j]=0;
					j++;
				}
			}			
		}
		
		
		return arr;
	}
    public static void main(String[] args) {
		System.out.println(solve("aaaaa"));
	}

}
