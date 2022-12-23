import java.util.HashMap;
import java.util.*;
public class IB_DistinctSubsquences {
    public static HashMap<String,Integer> mp;
    public static void main(String[] args) {

        mp=new HashMap<String,Integer>();
        System.out.println(num("rabbbit","rabbit"));
    }

    public static int num(String A, String B) {
        System.out.println("A = "+A+" B= "+B);
        if(A.length() < B.length()){
            return 0;
        }
        if(B.length()==0){
            return 1;
        }
        String s = A+"$"+B;
        if(mp.containsKey(s)){return mp.get(s);}

        if(A.charAt(0)==B.charAt(0)){
            mp.put(s,num(A.substring(1,A.length()),B.substring(1,B.length()))+num(A.substring(1,A.length()),B));
        }else{
            mp.put(s,num(A.substring(1,A.length()),B));
        }
        return mp.get(s);



    }

}
