package programChallanges.heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class KthLargestElement {
	class Heap{
        int a[];
        int size;
        Heap(int size){
            a= new int[size];
            size=0;
        }
        public void insert(int value){
            a[size]=value;
            int i=size;
            size++;
            while(i>0){
               int p=(i-1)/2;
                if(a[p]>a[i]){
                    swap(a,p,i);
                    i=p;
                }
                else{
                    break;
                }
            }
        }

        public int getMin(){
            int ans = a[0];
            size--;
            a[0]=a[size];
           
            int i=0;
            while(i<size){
                int left = (i*2)+1;
                int right=left+1;
                if(right<size){
                    if(a[i]>=a[left] && a[left]<=a[right]){
                        swap(a,left,i);
                        i=left;
                    }
                    else if(a[i]>=a[right] && a[left]>=a[right]){
                        swap(a, right,i);
                        i=right;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(left<size && a[i]>=a[left]){
                        swap(a,left,i);
                        i=left;
                    }
                    else{
                        break;
                    }

                }
            }
            return ans;
        }
        public int viewMin(){
            return a[0];
        }
        public void swap(int a[], int x,int y){
            int temp = a[x];
            a[x]=a[y];
            a[y]=temp;
        }
        public int getSize(){
            return size;
        }
    }
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Heap h = new Heap(A);
        for(int value:B){
            if(h.getSize()<A-1){
                h.insert(value);
                ans.add(-1);
            }
            else if(h.getSize()==A-1){
                h.insert(value);
                ans.add(h.viewMin());
            }
            else{
                int current = h.viewMin();
                if(current<value){
                    h.getMin();
                    h.insert(value);
                    current=h.viewMin();
                }
                ans.add(current);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		KthLargestElement k = new KthLargestElement();
		Integer x[]= {1, 2, 3, 4, 5, 6};
		
		k.solve(2, new ArrayList<>(Arrays.asList(x)));
	}

}
