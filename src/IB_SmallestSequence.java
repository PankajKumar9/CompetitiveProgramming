import java.util.*;
public class IB_SmallestSequence {
    public static void main(String[] args){
        Solution S = new Solution();
        //773 787 797 , 3;
        System.out.println(S.solve(11,7,3,50));

    }

    public static class Solution {
        public ArrayList<Integer> solve(int A, int B, int C, int D) {
            HashSet<Integer> set = new HashSet<>();
            if(B>A){
                A= A+B;
                B= A-B;
                A= A-B;
            }
            if(C>A){
                A= C+A;
                C= A-C;
                A= A-C;
            }
            if(C>B){
                B=B+C;
                C=B-C;
                B=B-C;
            }
            long trr = A*B;
            if(trr>Integer.MAX_VALUE){
                trr=Integer.MAX_VALUE-10;

            }else{
                trr= trr*C;
                if(trr>Integer.MAX_VALUE){
                    trr=Integer.MAX_VALUE-10;

                }

            }

            double Nr = Math.log((int)trr);
            int Ai = (int)(Nr/(Math.log(A)));
            Ai+=1;
            int Bi = (int)(Nr/(Math.log(B)));
            Bi+=1;
            int Ci = (int)(Nr/(Math.log(C)));
            Ci+=1;
            int count= 0;
            int Na = 1;
            System.out.println("Ai = "+ Ai);
            System.out.println("Bi = "+ Bi);
            System.out.println("Ci = "+ Ci);

            for(int i =0;i<Ai;i++){
                for(int j = 0;j<Bi;j++){
                    for(int k = 0;k<Ci;k++){
                        if(i==0&&j==0&&k==0){
                            continue;
                        }
                        Na= (int)Math.pow(A,i);
                        Na*=(int)Math.pow(B,j);
                        Na*=(int)Math.pow(C,k);
                        if(Na>trr){
                            continue;
                        }
                        set.add(Na);
                    }
                }

            }





            if(D==0){
                return new ArrayList<Integer>();
            }
            // HashSet<Integer> set = new HashSet<>();
            // long R = A*B;
            // if(R+1>Integer.MAX_VALUE){
            //     R = Integer.MAX_VALUE-1;
            // }else{
            //     R= R*C;
            //     if(R+1>Integer.MAX_VALUE){
            //     R = Integer.MAX_VALUE-1;
            // }
            // }

            // int RR = (int)R;
            // int x = 0;
            // x= RR/A;
            // x=Math.min(D,x);
            // for(int i = 1;i<x+1;i++){
            //     set.add(A*i);
            // }
            // x= RR/B;
            // x=Math.min(D,x);
            // for(int i = 1;i<x+1;i++){
            //     set.add(B*i);
            // }
            // x= RR/C;
            // x=Math.min(D,x);
            // for(int i = 1;i<x+1;i++){
            //     set.add(C*i);
            // }
            int RR = (int)trr;
            ArrayList<Integer> X = new ArrayList<Integer>();
            Iterator<Integer> ij = set.iterator();
            while (ij.hasNext()){
                X.add(ij.next());
            }
            Collections.sort(X);
            System.out.println(" ");
            for(int i =0;i<X.size();i++){
                System.out.print(X.get(i)+" ");
            }
            System.out.println(" ");
            ArrayList<Integer> ans = new ArrayList<Integer>();
            int p = D/X.size();
            int r = D%X.size();
            for(int i = 0;i<p;i++){
                for(int j=0;j<X.size();j++){
                    if(i==0){
                        ans.add(X.get(j));
                    }else{
                        ans.add((X.get(i-1)*RR)+X.get(j));
                    }
                }

            }

            for(int i = 0;i<r;i++){
                if(p==0){
                    ans.add(X.get(i));
                }else{
                    ans.add((X.get(p-1)*RR)+X.get(i));
                }


            }
            return ans;




        }



    }



}
