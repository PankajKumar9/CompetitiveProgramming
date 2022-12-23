import java.util.*;
public class Heap {


    public static void main(String args[]){
        System.out.println("this is some stuff");

        int a[] = {12,54,12,34,56,14,65,23,12,0,77};
        PriorityQueue x = new PriorityQueue(a);
        System.out.println(Arrays.toString(a));
        x.HeapSort(a);
        System.out.println(Arrays.toString(a));

    }
    public static class PriorityQueue{
        public int[] heap;
        public int maxSize;
        public int size;

        public PriorityQueue(){
            return ;
        }
        public PriorityQueue(int[] x){
            this.maxSize = x.length;
            this.size = x.length;
            heap =x;
            BuildHeap(x);
            return ;
        }
        public int Parent(int i){
            return (i-1)/2;
        }
        public int LeftChild(int i){
            return (2*i)+1;
        }
        public int RightChild(int i){
            return 2*i+2 ;
        }

        public void SiftUp(int i){
            int temp;
            while(i>=0  && heap[Parent(i)]<heap[i]){
                temp = heap[Parent(i)];
                heap[Parent(i)]= heap[i];
                heap[i] = temp;
            }
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

        public void Insert(int p){
            if(size == maxSize){
                int[] xx = new int[maxSize*2];
                for(int i = 0;i<size;i++){
                    xx[i]= heap[i];
                }
                heap = xx;
                maxSize = 2*maxSize;

            }
            size = size+1;
            heap[size] = p;
            SiftUp(size);

        }

        public int ExtractMax(){
            int result = heap[0];
            heap[0]=heap[size-1];
            size = size-1;
            SiftDown(0);
            return result;
        }

        public void Remove(int i){
            heap[i]= Integer.MAX_VALUE;
            SiftUp(i);
            ExtractMax();
        }

        public void ChangePriority(int i ,int p){
            int oldp = heap[i];
            heap[i]=p;
            if(p>oldp){
                SiftUp(i);
            }else{
                SiftDown(i);
            }
        }
        //there is a lot of maths behind it
        //but build heap is O(N) operations
        //so partial sorting is O(N+klogN)

        public void BuildHeap(int[] a){
            int size = a.length;
            for(int i = a.length-1;i>=0;i--){
                SiftDown(i);
            }

        }
        public void HeapSort(int[] a){
            BuildHeap(a);
            for(int i =0;i<a.length;i++){
                size = size-1;
                int temp = a[0];
                a[0]=a[size];
                a[size]=temp;
                SiftDown(0);
                System.out.println(Arrays.toString(a));
            }

        }


    }

}


//parent ,siftup and change priority can be ignored for most use