import java.util.*;
import java.io.*;

public class IB_Max_Sum_Triplet {
    public static void main(String[] args) {
        System.out.println("running ");
        Solution x = new Solution();
        int[] A = { 2, 5, 3, 1, 4, 9 };
        System.out.println(x.solve(A));
    }

    public static class Solution {
        public int solve(int[] A) {
            ArrayList<Integer>[] next = new ArrayList[A.length];

            for(int i =0;i<A.length;i++){
                next[i] = new ArrayList<Integer>();
            }

            for (int i = A.length - 1; i > -1; i--) {
                for(int j=i-1;j>-1;j--){
                    if(A[i]>A[j]){
                        next[j].add(0,i);
                    }
                }
            }

            int ma = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j:next[i]) {
                    for (int k :next[j]) {
                        if (A[j] >= A[k]) {
                            continue;
                        }
                        ma = max(ma, A[i] + A[j] + A[k]);
                    }
                }
            }
            return ma;
        }

        public int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
        }
    }
}
