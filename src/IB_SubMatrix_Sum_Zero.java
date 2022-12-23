//import java.util.*;
//public class IB_SubMatrix_Sum_Zero {
//    public static void main(String args[]){
//        System.out.println("This is some shit you know");
//        int[][] a =  {
//                {-6, 7, -10, 4, 10, 7, 6, 9, 0, 1, 1, -8, 0, -2, -11, 2},
//                {-7, 2, -12, -5, 7, -4, -8, 4, 9, 11, 0, -10, 1, 9, -8, 7},
//                {13, -7, 4, -7, -4, -8, -7, 1, -4, 5, -5, 7, 2, 3, -2, 9},
//                {-4, 11, 13, 9, 10, -13, 10, -13, 3, 0, 8, 13, -3, 0, -4, -13},
//                {-2, -5, 4, 3, -7, 7, -13, 1, -5, 9, -6, -12, 4, -11, -13, -4},
//                {10, -11, -13, -10, -9, -5, -2, -5, 8, 4, -13, -6, -2, 0, 12, 0},
//                {-9, -3, 1, 5, -12, 2, 11, 1, 2, 1, 13, -5, -11, 2, 0, 13},
//                {-6, -13, 4, 10, 1, 5, 12, 0, -12, -1, 2, 2, 1, -3, 5, 6},
//                {4, 1, 8, 13, 6, 7, 1, 13, -2, 7, 5, 13, -1, -13, -8, -2},
//                {2, 10, 6, 5, 0, 1, -4, 7, 13, 5, -4, -12, -5, -11, 9, 0},
//                {8, -4, -10, 11, 3, -9, -3, -10, -7, 13, -3, -5, -10, -12, 6, -5},
//                {-1, 1, -4, 3, 5, -9, -9, -2, 1, 7, 12, -1, 4, -13, 4, 11}
//        };
//        int N = a.length;
//        int M = a[0].length;
//        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
//        for(int i = 0;i<N;i++){
//            x.add(new ArrayList<Integer>());
//        }
//        for(int i = 0;i<N;i++){
//            for(int j = 0;j<M;j++){
//                x.get(i).add(a[i][j]);
//
//            }
//        }
//        Solution s = new Solution();
//        int f = s.solve(x);
//        System.out.println(f);
//
//    }
//
//    public static class Solution {
//        public int solve(ArrayList<ArrayList<Integer>> A) {
//            if(A.size()==0){
//                return 0;
//            }
//            if(A.get(0).size()==0){
//                return 0;
//            }
//            ArrayList<Integer>[][][] dp = new ArrayList[A.size()][A.get(0).size()][3];
//            for(int i =0;i<dp.length;i++){
//                for(int j = 0;j<dp[0].length;j++){
//                    for(int k=0;k<3;k++){
//                    dp[i][j][k] = new ArrayList<Integer>();}
//                }
//            }
//            boolean[][] vis = new boolean[A.size()][A.get(0).size()];
////            int sum = 0;
////            for(int i = 0;i<dp.length;i++){
////                for(int j = 0;j<dp[0].length;j++){
////                    sum = sum+A.get(i).get(j);
////                    dp[i][j] = sum;
////                }
////            }
//            int count = 0;
//            int prev = 0;
//            prev = 0;
//            int L = dp.length-1;
//            int M = dp[0].length-1;
//            int xj = L;
//            if(xj<M){
//                xj=M;
//            }
//            int []
//            while(xj>=0){
//                if(L<0){
//                    L=0;
//                }
//                if(M<0){
//                    M=0;
//                }
//                for(int i = dp[0].length;i>=0;i--){
//                    vis[L][i];
//                }
//                for(int i = dp.length;i>=0;i--){
//                    vis[i][M];
//                }
//                L--;
//                M--;
//                xj--;
//
//
//
//            }
//            for(int i = dp.length-1;i>=0;i--){
//                for(int j = 0;j<dp[0].length;j++){
//                    if(vis[i][j]){
//                        continue;
//                    }
//                    vis[i][j]= true;
//                    for(int p=i;p<dp.length;p++){
//                        for(int q = j;q<dp[0].length;q++){
//                            if(isOk(dp,i,j,p,q,prev)){
//                                count++;
//                            }
//
//                        }
//
//                    }
//                    prev = dp[i][j];
//                }
//            }
//            PrintMatrix(dp);
//            return count;
//        }
//        public boolean isOk(Integer[][] dp,int i, int j, int p, int q,int prev){
//            int sum1 = dp[p][q]-prev;
//            int prev2 = dp[i][q];
//            int curr =0;
//            if(j>0){
//                curr = dp[p][j-1];
//            }else{
//                if(p==0){
//                    curr = 0;
//                }else{
//                    curr = dp[p-1][dp[p-1].length-1];}
//            }
//            int sum2 = curr-prev2;
//            if(sum1-sum2==0){
//                return true;
//            }
//
//            return false;
//        }
//        public <E> void PrintMatrix(E[][] x) {
//            for (E[] a : x) {
//                System.out.println(Arrays.toString(a));
//            }
//        }
//    }
//
//
//
//}
////    The expected return value:
////        144
////        Your function returned the following:
////        173
