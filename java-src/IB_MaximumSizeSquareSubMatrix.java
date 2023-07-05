import java.util.*;
public class IB_MaximumSizeSquareSubMatrix {
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] a = new int[][]{{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0}
        };
        a= new int[][]{{0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0}};
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            x= new ArrayList<Integer>();
            for(int j:a[i]){
                x.add(j);
            }
        A.add(x);


        }
        s.solve(A);
    }


    public static class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            int N = A.size();
            int M = A.get(0).size();
            int[][] dp = new int[N][M];
            int[][] dph = new int[N][M];
            int[][] dpv = new int[N][M];
            int MM = 0;
            for(int i =0;i<M;i++){
                dp[N-1][i]= A.get(N-1).get(i);
                dpv[N-1][i]= A.get(N-1).get(i);
            }
            for(int i = N-2;i>=0;i--){
                for(int j = M-1;j>=0;j--){
                    if(j==M-1){

                        if(A.get(i).get(j)!=0){
                            dph[i][j]=A.get(i).get(j);
                            dpv[i][j]+=dp[i+1][j];
                            dp[i][j]=A.get(i).get(j);
                            MM= Math.max(dp[i][j],MM);
                        }



                    }else{


                        if(A.get(i).get(j)!=0){
                            dph[i][j]=dp[i][j+1]+1;
                            dpv[i][j]+=dp[i+1][j]+1;
                            dp[i][j]=Math.min(dp[i+1][j+1]+1,dph[i][j]);
                            dp[i][j]=Math.min(dp[i][j],dpv[i][j]);
                            MM= Math.max(dp[i][j],MM);
                        }

                    }
                }
            }
            for(int[] ax : dp){
                System.out.println(Arrays.toString(ax));
            }

            return MM;
        }
    }

}
