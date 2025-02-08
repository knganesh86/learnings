package programChallanges.string;

import programChallanges.heaps.MinLargestElement;

public class StringPermRank {
	public int findRank(String A) {
        int n=A.length();
        long result=1l;
        for(int i=0;i<n-1;i++){
            int count=0;
            char ch=A.charAt(i);
            for(int j=i+1;j<n;j++){
                if(ch>A.charAt(j)){
                    count++;
                }
            }
            result+=((count*fact(n-i-1))%1000003);
            result%=1000003;
        }
        return (int)result;
    }
    private int fact(int n){
        if(n<=1){
            return 1;
        }
        return (n*fact(n-1))%1000003;
    }
    public static void main(String[] args) {
		StringPermRank sp = new StringPermRank();
		System.out.println(sp.findRank("baa"));
	}

}
