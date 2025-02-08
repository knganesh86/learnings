
public class MergeSort {
	private static int  mergeSort(int[] A, int s, int e){
        if(s==e){
            return 0;
        }
        int ans=0;
        int n=(e-s)/2;
        ans+=mergeSort(A,s,s+n);
        ans+=mergeSort(A,s+n+1,e);
        ans+=merge(A, s, s+n, e);
        return ans;
    }

	private static int merge(int[] A, int s, int m, int e) {
		int i=s;
        int j=m+1;
        int k=0;
        int ans =0;
        int result[]=new int[e-s+1];
        while(i<=m&&j<=e){
            if(A[i]<A[j]){
                result[k]=A[i];
                i++;
            }
            else{
                result[k]=A[j];
                j++;
                ans+=(m-i)+1;
            }
            k++;
        }
        while(i<=m){
            result[k]=A[i];
                i++;
                k++;
        }
        while(j<=e){
            result[k]=A[j];
                j++;
                k++;
        }
        int p=0;
        for(int n=s;n<=e;n++) {
        	A[n]=result[p++];
        }
		return ans;
	}
	public static void main(String[] args) {
		int A[]= {4,5,1,2,6,3};
		int ans=mergeSort(A, 0, 5);
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}
		System.out.println(ans);
	}

}
