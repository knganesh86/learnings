package programChallanges.greedy;

public class Seats {
 public int solve(String A) {
	 int n = A.length();
	 int pos[]=new int[n];
	 int noOfX=0;
	 for(int i=0;i<n;i++) {
		 char c = A.charAt(i);
		 if(c=='x') {
			 pos[noOfX]=i;
			 noOfX++;
		 }
	 }
	 int mid=noOfX/2;
	 int left=mid-1;
	 int ans=0;
	 int k=1;
	 while(left>=0) {
		 ans+=pos[mid]-k-pos[left];
		 left--;
		 k++;
	 }
	 k=1;
	 int right = mid+1;
	 while(right<noOfX) {
		 ans+=pos[right]-k-pos[mid];
		 right++;
		 k++;
	 }
	 return ans;
 }
 public static void main(String[] args) {
	Seats s = new Seats();
	System.out.println(s.solve("....xxx"));
}
}
