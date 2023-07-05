import java.util.*;
public class IB_CoinsInLine {
        public static void main(String args[]){
            Solution s = new Solution();
            int[] A = new int[]{5, 4, 8, 10 };
           int ans=  s.maxcoin(A);
           System.out.println(ans);
        }
    public static class Solution {
            public HashMap<String,Integer> mp;
        public int maxcoin(int[] A) {
            mp = new HashMap<String,Integer>();

           return solve(A,0,A.length-1);


        }
        public int solve(int[] A,int x,int y) {
            if(x>=y){
                return 0;
            }
            String s = x+"#"+y;
            if(mp.containsKey(s)){
                return mp.get(s);
            }

            int a = solve(A,x+1,y-1);
            int c = a;
            int b = solve(A,x+2,y);
            a=Math.min(a,b);
            a=a+A[x];
            //int c = solve(A,x+1,y-1);
            int d = solve(A,x,y-2);
            c=Math.min(c,d);
            c=c+A[y];
             mp.put(s,Math.max(a,c));



            return mp.get(s);



        }
    }

}
