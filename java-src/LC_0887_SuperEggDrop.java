import java.util.*;
public class LC_0887_SuperEggDrop {
    public static void main(String args[]){

   Solution s = new Solution();
 // int ans=  s.superEggDrop(3,200);

  int dp[][] = new int[100][200];
  for(int i = 1;i<100;i++){
      for(int j = 0;j<50;j++){
          dp[i][j] = s.superEggDrop(i,j);
      }


  }
  for(int[] xx: dp)
  System.out.println(Arrays.toString(xx));
    }
    public static class Solution {
        HashMap<String,Integer> mp;
        public int superEggDrop(int k, int n) {
            mp = new HashMap<String,Integer>();
            return superEgg(k,n);
        }
        public int superEgg2(int k,int n){
            int[][] dp = new int[k+1][n+1];
            for(int i =0;i<n+1;i++){
                dp[0][i]=1;
            }
            int mid = 0;
            int l = 0;
            int ans = 0;
            for(int i = 2;i<k+1;i++){
                for(int j = 1;j<n+1;j++){
                    mid = j/3;
                    //mid = 2*j/3;
                    if(mid>2 && j-mid+2>0){
                        mid = mid-2;
                    }

                    l=0;

                    while(mid>=0 && l<5){
                        if(mid<1){
                            mid=1;
                        }
                       ans = dp[i-1][mid-1];
                       //System.out.println(j);
                       if(j-mid<0){
                           break;
                       }
                       ans = Math.max(ans,dp[i][j-mid]);
                       ans = ans+1;
                       if(l==0){
                           dp[i][j]= ans;
                       }else{
                           dp[i][j] = Math.min(ans,dp[i][j]);
                       }
                        mid++;
                       l++;
                    }




                }

            }

            return dp[k][n];

        }
        public int superEgg(int k, int n) {
            if(k==1){
                return n;
            }
            if(n<2){
                return n;
            }
            String s = k+"*"+n;
            if(mp.containsKey(s)){
                return mp.get(s);
            }
            int ans = Integer.MAX_VALUE;
            int fin = 0;
            System.out.println("---- ");
          for(int i = 1;i<n;i++){
              int a = superEgg(k-1,i-1);
              int b = superEgg(k,n-i);

             a= Math.max(a,b)+1;
             if(ans>a){
                 fin = i;

             }
              System.out.print(a+", ");
             ans=Math.min(ans,a);

          }
            System.out.println("i = "+fin +" S = "+s);
          mp.put(s,ans);
            return mp.get(s);
        }
    }

}
//2,4 -> ans 3
//1,4 ->4
//2,6 ->3
//3,200 ->11;

//30-> any
//28->15,16(mid+1);
//26->13,14,15,16(mid+1);
//24->11,12,13,14,15,16(mid)
//22->9,10,11,12,13,14,15,16
//20->7-16

