package programChallanges.Array;

public class PickFromBothEndSum {
	public static int solve(int[] A, int B) {
        int sum1[] = new int[B];
        int sum2[] = new int[B];
        sum1[0]=A[0];
        sum2[B-1]=A[A.length-1];
        for(int i=1;i<B;i++){
            sum1[i]=sum1[i-1]+A[i];
            sum2[B-i-1]=sum2[B-i]+A[A.length-1-i];
        }
        int endIndex = B-1;
        int maxSum=sum2[0];
        for(int i=0;i<B-1;i++){

            maxSum = Math.max(maxSum, sum1[i]+sum2[i+1]);
            
        }
        maxSum = Math.max(maxSum, sum1[B-1]);
        return maxSum;
    }
	public static void main(String[] args) {
		int []a = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
		System.out.println(solve(a, 48));
	}

}
