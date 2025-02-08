package programChallanges.search;

public class Sqrt {
	 public int sqrt(int A) {
		 int l =0;
		 int r=A;
		 int mid=0;
		 long lA= (long)A;
		 long v = 0l;
		 while(l<=r) {
			 mid = (l+r)/2;
			 v = (long)mid*mid;
			 if(v==lA) {
				 return mid;
			 }
			 else if(v>lA) {
				 r=mid-1;
			 }
			 else {
				 l=mid+1;
			 }
		 }
		 v = mid*mid;
		 if(v>lA) {
			 mid--;
		 }
		 return mid;
	    }
	 public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(2147483647));
	}
}
