package programChallanges.string;

public class OccurenceOfString {
	 public int solve(String A, String B) {
		 if(B.isEmpty())
			 return A.length()+1;
		 int count=0;
		 long aValue = getHash(B);
		 long bValue = getHash(A.substring(0, B.length()));
		 if(aValue==bValue) {
			 count++;
		 }	
		 long multi=1;
		 for (int i = 1; i < B.length(); i++)
	            multi = (multi * 29) % 1000000007;
		 for(int i=B.length();i<A.length();i++) {
			 int removedVal = A.charAt(i-B.length())-'a'+1;
			 bValue = bValue-removedVal;
			 bValue/=29;
			 bValue+=((A.charAt(i)-'a'+1)*multi)%1000000007;
			 bValue%=1000000007;
			 if(bValue==aValue) {
				 count++;
			 }
		 }
		 return count;
	    }

	    long getHash(String A){
	        long m=1000000007;
	        long p=29l;
	        long result=0l;
	        long multi = 1;
	        for(int i=0;i<A.length();i++){
	            result+=((A.charAt(i)-'a'+1)*multi)%m;
	            result%=m;
	            multi*=p;
	        }
	        return result;
	    }
	    public static void main(String[] args) {
			OccurenceOfString o = new OccurenceOfString();
			System.out.println(o.solve("aaaaa", ""));
		}

}
