package programChallanges;

import java.util.HashSet;

public class HashinColorNumber {
	public int colorful(int A) {
		int digit[] = new int[12];
		int nd=0;
		int temp=A;
		while(temp!=0) {
			digit[nd++]=temp%10;
			temp/=10;
		}
		HashSet<Integer> number = new HashSet<>();
		for(int i=0;i<nd;i++) {
			int ans = 1;
			for(int j=i;j<nd;j++) {
				ans*=digit[j];
				if(!number.add(ans)) {
					return 0;
				}
			}
		}
		return 1;
    }
	public static void main(String[] args) {
		HashinColorNumber hc= new HashinColorNumber();
		hc.colorful(23);
	}
}
