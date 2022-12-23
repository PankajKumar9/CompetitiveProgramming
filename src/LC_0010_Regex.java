import java.util.Arrays;
import java.util.HashMap;

public class LC_0010_Regex {
    public static HashMap<String,Boolean> mp;
    public static String s;
    public static String p ;
    public static void main(String[] args){
    mp = new HashMap<String,Boolean>();
   p = "a*aa....a*aa*a*.aaaa..aa*aa*a.a*.a.a*a*a.a*.a*.aa*.a.a..a.a*aaa*.aaa..a*a*.a..a*..aa*a*a*a*a.a*a*a..aaa.a*.a*a.a*.a*a*..aaa*.a*a*a.a*.aa*a*a*.a..a*a*a*.a*a*.aa*.a*a..aaa*a*a.aaaa..aa....a*a*.a*a..a*.a*a*aaa*a*.a*..a*aaa.aaaa*.a*a..a*aa.a*aa*a*a*...aa*a*a*.....a*.a.a*a...aa*.aa*a..a*aaaa*aa*.aa*a.a*a.a*aa.aa..aaa.a.aaa*aa*aa*a.a*a*aa*a*a*a..aaa*a*.a*.a*a*.aaa*...a.a*a.a*a*a*.a*a*aaa*a*a*a*a..a.a*a*a*a*.a*.aa*a.a*aa.aaa*a..a*aa*..a.aa.aaaa*a*aa*.aa.a*a*aa*a*a.a*a.a*aaaa*.a..aaaa.a*a.aa*a*a*a*aaa*a*aa*a.a*aa*..aaaa*a*aaa*..aa.a*a*.a.aa*aa.aa*aa*aaa*aa*a*..a.a*aa*a*aa*aa...a*a*.aaa*a.a.a*a*aa*aaaa*a*aaa*a*aa.aa*a*aaa*.a*a*.a*a*a*a*a.a*aaa*a.aa*a*.a*.aaa.a*a*aa*a*..a*aaa*...a*..a*a*a*a..aa*aaa*a*a*aaaaa.a*a*..aa.a*.a*aaa.aa.a*a*a*a*a*aa*a*a*a*a*a*a*a*aaa..aa.a*aa*.a*a*a*aa*a....aa.a*a*aaa..aa*..aa.a.aa*..a*..a*a*..a*.a.aa*.aa...aaa*a*a*.a*aaa*a..aa*..a*aaa.aa*aaaa*.a.a*a*a..a*aa*a*aa*.a..a*a.aa*.aaa*aaa*.....a*a*aaa...a*.aa*a*.aaaaa*..a*a.aa*a.a..aaaaa*a.a*a*a*..aa..aaa*a*aaaaaaa*aaaa*.a..a.a.a......aa*a*.a.a*.aaa*a*aa*.a..a*.aa...a*a*a*a*aaaa*a*aa*a*a*a*aaa*a*a*.a*...a*.aa*a*a*.a*a*.....a.a.a*.a*.a*..a*a*a*aaaa.aa.a*a*..a*.a*a.a*a*a*aaa*a..aaa*a..a*aa..a*a.aa*a*a*..a*..a*a*...a*.aa.aaaa*aa*a*a*.a*aa.a*aa*aa*aa*.a*.a.aaa*a*aaa*aa*.aaa*a*a.a*.a*aa*a*a*...a*..aa*a*aaa*a...aa.a.aa..aaa*.aa*.a.a*aa*.aa.a*a*a*aa*aa*a*a*a*a*a*..aa*.a*aa*aa*aa*a*.a....a*aa*a.a.a*aa*aaa..aa*aaa.a*a*aa*a*a*a*aaa.a*aa..a*.aaa*a*aa*.aaa.a*..a*a.a.a*a*aa*aaa*a*aa...a*..a*.aa*a*aa..aa.aaaa*aaaa*.a.a*aaa*.a*a*a*aa*a*aa.a*a*aaaa.aa*a.a*.aaa*a.aa*a.a*.aaaa*aa*a...a*a*a.aa*a*..a*.aa*.a*aa*..a*a*a*a.aa*...aaaaa*aaa*a*.aa*aa*.a.a*.aaa*a*a*.a*.aa.aaaa*aa*.aa*.aa*a*..a*aa*a*.aa*.aa.a.aa*.aaa*.a.a*a*.aaaa*a.a.a*a*..aa.a*a*aa*.a*aa..a*a*.aaaa*a..a*a*a*.a.a*a*a*.a*..a*.a*a*a*a*.a*.a...a*....a*a*a.a*aa.a*.a*.aa*aa*.aa*..aa*....aaa*a*a.aa*aa*.a*a*a*a*..a.a*a.a*.a*a.a...aa.a*...a.a*a*a.aa*....aa.a.aa*a*.aa.aaaaaaa...a..a*a*aa*aa*aa.a..a*..aa*a*a..a*aa.aaaa*a.a*.aa.a*.a*a..a*..a*a*.aa*a*aa.a*a.aaa*a*a*aa*aa.aaa.a*.aaa....a*a*a*....aa*a*a*a*aa*a...aaa*.aa*a*a*aaa*a.a..a.aaaa*aa*aa*a.aa*aa*a*a*a*a.aa*.a*aa...a*a*aa*..a*a*..a*a*.a.a*a*.aa*a*a*..a*..a*a*a*a*a*aa*aa.a*.a.aa*a*.a..aaaaa.a.a*a*.a*.aa..aaa.a*a*a*aaaa*a*a*..a*aa*a.aa*a*aaaaaa*a.a*.a.a*..a*.a*a*aa..a.a*aaa..a*a.aa.aa*a....a*aa..a*a..a.a*aa*...aa*.a*..a*a*aa*.aa*.a.a...a*.a*...a*.aaa.a*a*.a*a*aa*.aaaa.a*a*a*..a*a*.a.a*aa*a.a.a*a*a.aa*a.aa...a*a*aa.a*aa.a*a*aaa*.a..a*....aa*.a*a.a*.aa.a*a*a*aa..a*.a*.a*aaaa*a..a*a*a*a.a*.aaaaaa*.aa.a*aa.a*aa.a.aa*.a.a*.a*a*.aa*.a...a.aa..a*aaa*..a*a*a*a*.aa*.a*aaaa*a..a*a.aa*aaa*aaaa.a*.aa*aa.a*....a*..aa*.a.a*.a*..aa*a.a*a.a...a*...a*a*aa*a*a*a.a*.aa...a..a*a.a*a*a*a*a*.a*a.a.a.a*a*a*..a*.aa*...a*.a*a*a*aa*..a.a*.a*a.aaa*aaaa*a*.aa.a*..aa.a*aa*aa...a..a*.a*aaaa.a...a*..a*a*a*a.aa..aa*aa*a*a..a*.a..aaa*a.a*aa*aaa*..a*aaa..aa*.a*.aa*aa*a*a..a.aa*aa*a*.a*.a*aa*aa*.aa*..a*..a*a.aa.a*.a*..a*.a.a*a*aaa.aa*.a*a*a*aa*a*.a.a*aaaa*.a*....a*aa*..aa*..a*aaa*a*a.a*a.a*a*aa*..a*a*aa.a*a*a*aaa*aa*.a*...a*a.a*..aa*a.aa*a...a*a.aa.a.a*aa*.a*a*a*a*aaa*a*a*.aa*..a*.aa.a*.a*.a*.aa*aa*a*..a*aa.aa.aaa*aaa*aa*a...a*a*aaaaa*a.a*.aa*.a*.a*a*a*a..a.a...a*..a*a*.a*a*aa*aaa*.a*a*.a*a*...a*a*a*a*a..a*a*a.aa.aaa*...a*a.a..aaa*a*.a*a*.a*..a*aa.aa*a..a.a*a*........a.aaa*a*...a*aaa.a*a*aa*a*a*a*";
    System.out.println("Length of p is "+p.length());
//"a"    ".*..a*" ye h false;

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


        boolean x = isBatch(0,0,'c');
            System.out.println(x);

    }
    public static boolean isBatch(int L,int M,char prev) {
        System.out.println("L = "+L+" M = "+M);
//s for L;
//p for M;
        String cache = L +"$" +M;

        if (mp.containsKey(cache)){
            return mp.get(cache);
        }
        boolean ans ;
        if (s.length()<=L){
            if(p.length()<=M){
                mp.put(cache,true);
                return true;
            }
            if(!isNext(M)){
                if(p.charAt(M)!= '*'){
                    mp.put(cache,false);
                    return false;
                }
                ans = isBatch(L,M+1,'*');
                mp.put(cache,ans);
                return ans;
            }else{
                ans = isBatch(L,M+1,p.charAt(M));
                mp.put(cache,ans);
                return ans;
            }

        }
        if(p.length()==0){
            mp.put(cache,false);
            return false;
        }

        if(p.charAt(M)=='.'){

            if(!isNext(M)){
                ans = isBatch(L+1,M+1,'#');
                mp.put(cache,ans);
                return ans;}else{

                ans =   isBatch(L,M+1,'.');
                mp.put(cache,ans);
                return ans;
            }
        }

        if(p.charAt(M)!='*'){
            if(!isNext(M)){
                if(p.charAt(M) != s.charAt(L)){
                    mp.put(cache,false);
                    return false;
                }
                ans = isBatch(L+1,M+1,p.charAt(0));
                mp.put(cache,ans);
                return ans;}else{
                ans =  isBatch(L,M+1,p.charAt(0));
                mp.put(cache,ans);
                return ans;
            }
        }
        boolean ax = false;
        if(prev == s.charAt(L) || prev =='.'){

            ax = isBatch(L+1,M,prev);
        }
        ans = ax || isBatch(L,M+1,prev) ;
        mp.put(cache,ans);
        return ans;



    }
    public static boolean isNext(int L){
        if(1+L>=p.length()){
            return false;
        }
        if(p.charAt(L+1)=='*'){
            return true;
        }
        return false;
    }
}
//"aab"
//        "c*a*b"

//expected true ?? wtf
//* k pehle ka charater 0 times bhi repeat ho sakta h , vo c bhi gayab kr sakta h * jo h



//"ab"
//        ".*..c*"
//True because first star eats first dot and next 2 dots are ab and last star eats c




//"a"    ".*..a*" ye h false;


//true hell is when you meet the person you are to the person you could have been

//