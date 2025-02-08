package programChallanges.backtrace;

import java.util.ArrayList;

public class PerfectSquarePremutation {
	ArrayList<ArrayList<Integer>> ans ;
    int n ;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
         n=A.size();
         int freq[]=new int[11];
        for(int a:A){
            freq[a]++;
        }
        ans= new ArrayList<>(); 
        ArrayList<Integer> comp= new ArrayList<>();

        permute(freq, comp, 0);
        return ans;
    }
    public void permute(int freq[], ArrayList<Integer> comp, int i ){
        if(i==n){
            ans.add(new ArrayList<>(comp));
            return;
        }
        for(int x=0;x<11;x++){
            if(freq[x]>0){
                freq[x]--;
                comp.add(i,x);
                permute(freq,comp, i+1);
                comp.remove(i);
                freq[x]++;
            }
        }

    }
}
