import java.util.*;
public class IB_K_Largest_Elements {
    public static void main(String args[]){
        int a[] = { 468, 335};
        ArrayList<Integer> A = new ArrayList<>();
        for(int i : a){
            A.add(i);
        }
        int B = 1;
        Solution s = new Solution();
        ArrayList<Integer> ans =s.solve(A,B);
        for(int i : ans){
            System.out.println(i+" ");
        }

    }


    public static class Solution {
        public int[] heap;
        public int maxSize;
        public int size;
        public int LeftChild(int i){
            return (2*i)+1;
        }
        public int RightChild(int i){
            return 2*i+2 ;
        }
        public void SiftDown(int i){
            int maxPos = i;
            int l = LeftChild(i);
            int r = RightChild(i);
            if(l<=size -1 && heap[l]>heap[maxPos]){
                maxPos = l;
            }
            if(r<=size -1 && heap[r]>heap[maxPos]){
                maxPos = r;
            }
            int temp;
            if(i != maxPos){
                temp = heap[i];
                heap[i]= heap[maxPos];
                heap[maxPos] = temp;
                SiftDown(maxPos);
            }

        }

        public void BuildHeap(int[] a){
            int size = a.length;
            for(int i = a.length-1;i>=0;i--){
                SiftDown(i);
            }

        }
        public void HeapSort(int[] a,int k){
            BuildHeap(a);
            for(int i =0;i<k;i++){
                size = size-1;
                int temp = a[0];
                a[0]=a[size];
                a[size]=temp;
                SiftDown(0);
                System.out.println(Arrays.toString(a));
            }

        }
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
            heap = new int[A.size()];
            size= A.size();
            maxSize= A.size();
            for(int i = 0;i<A.size();i++){
                heap[i]=A.get(i);
            }
            HeapSort(heap,B);
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i =0;i<B;i++){
                ans.add(heap[A.size()-B+i]);
            }
            return ans;

        }
    }
}
