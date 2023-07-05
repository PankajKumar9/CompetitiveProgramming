import java.util.*;

public class IB_InterleavingStrings {
    public static void main(String args[]){

       Solution x = new Solution();
       x.a = "aabcc";
       x.b= "dbbca";
       x.c = "aadbbcbcac";
       System.out.println(x.isInterleave(x.a,x.b,x.c));

    }
    public static class Solution{
        public String a;
        public String b;
        public String c;
        public HashMap<String,Boolean> mp;
        public int isInterleave(String A, String B, String C) {
            a = A;
            b=B;
            c=C;
        mp = new HashMap<String,Boolean>();
        if(sol(0,0,0))
        return 1;

        return 0;
        }
        public boolean sol(int i,int j,int k){
            if(k==c.length()){
                return true;
            }

            String cache = i+"$"+j+"#"+k;
            if(mp.containsKey(cache)){
                return mp.get(cache);
            }
            boolean ans = false;
            if(i<a.length()){
                if(a.charAt(i)==c.charAt(k)){
                    ans = sol(i+1,j,k+1);
                }
            }
            if(ans){
                mp.put(cache,true);
                return true;
            }
            if(j<b.length()){
                if(b.charAt(j)==c.charAt(k)){
                    ans = sol(i,j+1,k+1);
                }
            }
            if(ans){
                mp.put(cache,true);
                return true;
            }
            mp.put(cache,false);
            return false;


        }

    }


}
