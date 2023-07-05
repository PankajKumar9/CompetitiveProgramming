import java.util.*;
public class LC_0044_WildCardMatching {
    public static void main(String[] args){
        String s= "*";
        for(int i = 0;i<90000;i++){
            s = s+"*";
        }
        String p = "a";
        for(int i = 0;i<90000;i++){
            p=p+"a";
        }
        s= "*b";
        p="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        p="bacb";
        s="b**c*?*";
        System.out.println(is2(p,s));
    }

    public static int is2(String s, String p) {
//        String temp = s;
//        s=p;
//        p=temp;
        System.out.println();
        int[] curr = new int[s.length()+1];
        curr[s.length()]=1;
        int[] prev = curr;
        for(int i =p.length()-1;i>=0;i--){
            System.out.println("i == "+i+Arrays.toString(prev));
            curr = new int[s.length()+1];
            for(int j = s.length();j>=0;j--){
                if(j==s.length()){
                    if(p.charAt(i)=='*'){
                        System.out.println(p.charAt(i));
                        curr[j]=prev[j];
                    }
                }
                else{
                    if(p.charAt(i)=='*'){
                        if(prev[j+1]==1){
                            curr[j]=prev[j+1];
                        }else{
                            curr[j]=curr[j+1];
                        }
                    }else if(p.charAt(i)=='?'){
                        curr[j]=prev[j+1];
                    }else if(p.charAt(i)==s.charAt(j)){
                        curr[j]=prev[j+1];
                    }else{
                        curr[j]=0;
                    }


                }

            }
            prev=curr;
        }
        return curr[0];

    }
    public static int is(String s, String p) {
//        String temp = s;
//        s=p;
//        p=temp;
        System.out.println();
        int N = s.length();
        int M = p.length();
//        System.out.println("N= "+N);
//        System.out.println("M= "+M);
        int k = 0;
        //s is pattern and p is string
        int arr[][] = new int[N+1][M+1];
        arr[N][M] =1;
        for(int i= N-1;i>0;i--){
            arr[i][M]=0;
            if(s.charAt(i)=='*'){
                k=M;
                while(k<p.length()+1){
                    if (arr[i+1][k]==1){
                        arr[i][M]=1;
                        break;
                    }
                    k++;
                }
//
            }

        }
        for(int j=M-1;j>0;j--){
            arr[N][j-1]= 0;
        }


        int a, b;
        while(N>=0 || M>=0){
            N=N-1;
            M=M-1;
            a = N;
            b= M;
            if(N<0){
                N=0;
            }
            if(M<0){
                M=0;
            }

            for(int j=M;j>=0;j--){
//                System.out.println(N+","+j);
                if(s.charAt(N)==p.charAt(j)||s.charAt(N)=='*'||s.charAt(N)=='?'){
                    arr[N][j]= arr[N+1][j+1];
                }

                if(s.charAt(N)=='*' && arr[N][j]!=1){
                    k=j;
                    while(k<p.length()+1){
                        if (arr[N+1][k]==1){
                            arr[N][j]=1;
                            break;
                        }
                        k++;
                    }
                }
            }

            for(int i= N;i>=0;i--){
//                System.out.println(i+"."+M);
                if(s.charAt(i)==p.charAt(M)||s.charAt(i)=='*'||s.charAt(i)=='?'){
                    arr[i][M]= arr[i+1][M+1];
                }
                if(s.charAt(i)=='*' && arr[i][M]!=1){
                    k=M;
                    while(k<p.length()+1){
                        if (arr[i+1][k]==1){
                            arr[i][M]=1;
                            break;
                        }
                        k++;
                    }
                    //

                }

            }
            M=b;
            N=a;
        }


        for(int[] x : arr){
            System.out.println(Arrays.toString(x));
        }
        return arr[0][0];

    }

}
