import java.util.*;
public class IB_MaxProductSubarray {
    public static void main(String args[]){

        Solution s = new Solution();
        int[] a = { 0, -3, 4, -10, -1, -6, 0, 8, -8, -6, -5, -5, 0, -3, -9, 1, 5, -8, 0, 6, 1, -6, -8, 3, 0, -8, -9, 6, 8, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for(int i= 0;i<a.length;i++){
            A.add(a[i]);
        }
        //17280;
        System.out.println(s.maxProduct(A));

    }
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int maxProduct(final List<Integer> A) {
            List<Integer> D = new ArrayList<>();
            D.addAll(A);
            D.add(0);
            ArrayList<Integer> B = new ArrayList<>();
            ArrayList<Integer> C = new ArrayList<>();
            int i = 0;
            while(i<D.size()){
                if(D.get(i)==0){
                    if(B.size()>0){
                        C.add(maxP(B));
                    }
                    B = new ArrayList<>();
                    i++;
                    continue;
                }
                B.add(D.get(i));
                i++;

            }

            int max1 = Integer.MIN_VALUE;
            for(int iz : C){
                if(iz>max1){
                    max1 =iz;
                }
            }
            return max1;
        }
        public int maxP(final List<Integer> A) {
            int dp[] = new int[A.size()];
            dp[0]= A.get(0);
            for(int i = 1;i<A.size();i++){

                dp[i]=dp[i-1]*A.get(i);

            }

            int max = dp[0];
            int ans = 0;
            int prev = 1;
            int p;
            for(int i = 0;i<dp.length;i++){
                if(i!=0){
                    prev = dp[i-1];
                }
                if(prev == 0){
                    prev=1;
                }
                for(int j=i+1;j<dp.length;j++){
                    p = dp[j]/prev;
                    if(p>max){
                        max =p;
                    }

                }

            }
            return max;

        }
    }

}
