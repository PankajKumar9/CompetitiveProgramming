import java.util.*;

public class IB_MinimumDiffSubset {
    public static void main(String[] args){
        int a[]= new int[]{68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45};
        ArrayList<Integer> A = new ArrayList<>();
        for(int i : a){
            A.add(i);
        }
        Solution s = new Solution();
        int ans = s.solve(A);
        System.out.println(ans);
    }
    public static class Solution {
        public int solve(ArrayList<Integer> A) {
            int B;
            int sum = 0;
            for(int i = 0;i<A.size();i++){
                sum+= A.get(i);
            }
                System.out.println("SUm = "+sum);
            B = sum/2;


            boolean dp[][] = new boolean[A.size()+1][B+1];
            dp[0][0]= true;
            for(int i = 1;i<A.size()+1;i++){
                dp[i][0]= true;
            }
            for(int i = 1;i<A.size()+1;i++){
                for(int j = 1;j<B+1;j++){
                    if(dp[i-1][j]){
                        dp[i][j]= true;
                        continue;
                    }
                    if(j<A.get(i-1)){
                        continue;
                    }
                    if(dp[i-1][j-A.get(i-1)]){
                        dp[i][j]= true;
                    }

                }

            }
            //for(boolean[] bx: dp){System.out.println(Arrays.toString(bx));}
            int N1 = 0;
            for(int j = B;j>=0;j--){
                if(dp[A.size()][j]){
                    N1 = j;
                    break;
                }
            }
            int N2 = sum - N1;
            System.out.println();






            return Math.abs(N1-N2);
        }
    }
}
