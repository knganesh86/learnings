package programChallanges.string;

public class ZAlgString {
	public int[] getZArray(String A) {
		int n = A.length();
		int z[]= new int[n];
		int left=0;
		int right=0;
		char s[]=A.toCharArray();
		for(int i=1;i<n;i++) {
			//element not lying in segment
			if(i>right) {
				int j=i;
				int k = 0;
				while(j<n && s[j]==s[k]) {
					j++;
					k++;
				}
				z[i]=k;
				left = i;
				right = j-1;//update the segment.
			}
			else {
				if(z[i-left]<right-i+1) {
					//trust copy
					z[i]=z[i-left];
				}
				else {
					int j=right+1;
					int k =right-i+1;
					while(j<n && s[j]==s[k]) {
						j++;
						k++;
					}
					z[i]=k;
					left = i;
					right = j-1;
				}
			}
			
		}
		return z;
	}
	public int rotation(String A, String B) {
		int n = A.length();
		String str= B+"$"+A+A.substring(0,n-1);
		int[] ans =getZArray(str);

		int count =0;
		for(int i=n;i<str.length()-1;i++) {
			if(ans[i]==n) {
				count++;
			}
		}
		
		return count;
    }
	
	public int palindrome(String A) {
		int n = A.length();
		StringBuilder sb = new StringBuilder(A); 
		String str= A+"$"+sb.reverse().toString();
		int[] ans =getZArray(str);

		int count =0;
		for(int i=n;i<str.length();i++) {
			if(i+ans[i]==str.length()) {
				count = Math.max(count, ans[i]);
			}
		}
		
		return n-count;
    }
	public int period(String A) {
		int n = A.length();

		int[] ans =getZArray(A);
		
		for(int i=1;i<n/2;i++) {
			if(ans[i]>0) {
				int j=i;
				int k=1;
				while(j<n) {
					if(ans[j]!=ans[i]/k) {
						break;
					}
					j+=ans[i];
					k++;
					
				}
				if(j>=n) {
					return n-ans[i];
				}
			}
		}
		
		return n;
    }
	public static void main(String[] args) {
		ZAlgString zs= new ZAlgString();
		System.out.println(zs.period("aaaaab"));
	}
}
