import java.util.*;

public class IB_ScrambleString {
   public static HashMap<String,Integer> mp;
    public static void main(String args[]){
          String A =  "abbbcbaaccacaacc" ;
            String B = "acaaaccabcabcbcb";
//         A ="great";
//         B = "rgeat";
        A = "abbbcbaaccacaacc";
        B = "acaaaccabcabcbcb";
            System.out.println("Len of A = "+A.length());
        System.out.println("Len of B = "+B.length());
        mp=new HashMap<String,Integer>();
            System.out.println("Ans - = - "+is(A,B));





    }
    public static int is(final String A, final String B) {
        String s = A+"$"+B;
        if(mp.containsKey(s)){return mp.get(s);}

        if(A.length() != B.length()){
            return 0;
        }
        if(A.length()==1){
            if(A.equals(B)){
                mp.put(s,1);
                return 1;
            }
        }
        String s1="";
        String s2="";
        String s3="";
        String s4="";
        String s5="";
        String s6="";
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int j = 0;
        for(int i = 1;i<A.length();i++){
            s1 = A.substring(0,i);
            s2 = A.substring(i,A.length());
            s3 = B.substring(0,i);
            s4 = B.substring(i,A.length());

            a = is(s1,s3);

            b=  is(s2,s4);
            if(a==1 && b==1){
                mp.put(s,1);
                return 1;
            }
            j = A.length()-i;
            s5 = B.substring(0,j);
            s6 = B.substring(j,A.length());
            c = is(s1,s6);
            d=  is(s2,s5);
            if(c==1 && d== 1){
                mp.put(s,1);
                return 1;
            }

        }
        mp.put(s,0);
        return 0;


    }


}
