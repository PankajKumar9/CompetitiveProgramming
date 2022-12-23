import java.util.*;
public class IB_Arrange {
    public static void main(String args[]){
        Solution s= new Solution();
       int ans =  s.arrange("WWWB",2);
System.out.println("ans = "+ans);
    }
    public static class Solution {
        public int arrange(String A, int B) {
            HashMap<String,Integer> mp = new HashMap<>();
            int[] a= new int[A.length()];
            if(A.charAt(0)=='B'){
                a[0]=1;
            }
            for(int i =1;i<a.length;i++){
                a[i]=a[i-1];
                if(A.charAt(i)=='B'){
                    a[i]+=1;
                }
            }

          int ans=  solve(A,B,0,mp,a);
            return ans;
        }
        public int solve(String A,int B,int x,HashMap<String,Integer> mp ,int[] a){
            String sx = B+"$"+x;

            if(mp.containsKey(sx)){
                return mp.get(sx);
            }
            int Bh = 0;
            int Wh = 0;
            int sum = 0;
            if(B<0){
                return 0;
            }
            if(B==1){
                Bh = a[a.length-1]-a[x-1];
                Wh = a.length-x-Bh;
                return Bh*Wh;
            }
            if(x>=A.length()){
                return 0;
            }

            int ans = Integer.MAX_VALUE;
            for(int i = x;i<A.length()-B+1;i++){
                if(x==0){
                   Bh = a[i];
                   Wh = i-x+1-Bh;
                }else{
                    Bh = a[i]-a[x-1];
                    Wh = i-x+1-Bh;
                }
                if(Bh*Wh<0){
                    System.out.println("Sx = "+sx+" --x = "+x+" i = "+i);
                }
                sum = (Bh*Wh)+solve(A,B-1,i+1,mp,a);
                ans = Math.min(sum,ans);

            }
            mp.put(sx,ans);
            return ans;


        }
    }

}
