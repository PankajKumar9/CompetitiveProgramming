import java.util.*;
public class IB_KthManhattanDistance {
    public static void main(String args[]){
        Solution s = new Solution();
        int[][] a = new int[][]{{1,2,4},{4,5,8}};



        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        for(int i =0;i<a.length;i++){
            x = new ArrayList<>();
            for(int j = 0;j<a[0].length;j++) {
                x.add(a[i][j]);

            }
            B.add(x);
        }
        ArrayList<ArrayList<Integer>> Ans =  s.solve(2,B);
        String ss = "";
        for(int i = 0;i<Ans.size();i++){
            ss = "";
            for(int j = 0;j<Ans.get(i).size();j++){
                ss+=Ans.get(i).get(j)+" ";


            }
            System.out.println(ss);

        }

//1 2 4
//4 5 8
        //int a[] = new int[1000];
//        while(true){
//            for(int i = 0;i<1000;i++){
//                a[i]= getRandomNumberUsingNextInt(1,1900);
//            }
//            int[] ans1 = bruteForce(a,130);
//            int[] ans2 = KthLargest(a,130);
//            if(!compare(ans1,ans2)){
//                System.out.println(Arrays.toString(a));
//                System.out.println(Arrays.toString(ans1));
//                System.out.println(Arrays.toString(ans2));
//                break;
//            }else{
//                //System.out.println("ok");
//            }
//
//        }



    }
    public static boolean compare(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }
        for(int i = 0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }

        }
        return true;
    }
    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int[] bruteForce(int[] a,int L){
        int ans[] = new int[a.length];
        ans[0] = Integer.MIN_VALUE;
        for(int i = 1;i<a.length;i++){
           int N =  Math.max(0,i-L);
           int curr = Integer.MIN_VALUE;
            for(int j =i-1;j>=N;j--){
                if(a[j]>curr){
                    curr = a[j];
                }

            }
            ans[i]= curr;
        }

        return ans;
    }


    public static int[] KthLargest(int[] a,int L){
        int ans[] = new int[a.length];
        Deque<Integer> deque = new LinkedList<Integer>();
        ans[0]= Integer.MIN_VALUE;
        deque.addLast(0);
        int k = 0;

        for(int i = 1;i<a.length;i++){

            ans[i]= a[deque.peekFirst()];
            k++;
            if(a[i]>a[deque.peekFirst()]){
                deque.clear();
                deque.add(i);
                k = 0;
                continue;
            }
            while(a[i]>a[deque.peekLast()]){
                deque.removeLast();
            }
            deque.add(i);
            if(k == L){
                deque.removeFirst();
                k=i-deque.peekFirst();
                continue;
            }







        }

        return ans;

    }
    public static class Solution2 {
        public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
            int dp[][] = new int[B.size()][B.get(0).size()];
            int[] call ;
            int[] ans ;
            for(int i = 0;i<B.size();i++){
              call = new int[B.get(i).size()];
                for(int j=0 ; j< B.get(i).size();j++ ){
                    call[i] = B.get(i).get(j);
                }
                ans= KthLargest(call,A);
                dp[i]= ans;
                call = new int[B.get(i).size()];
                for(int j=0 ; j< B.get(i).size();j++ ){
                    call[B.get(i).size()-1-i] = B.get(i).get(j);
                }
                ans = KthLargest(call,A);
                for(int j = 0;j<ans.length;j++){
                    dp[i][j] = Math.max(ans[B.get(i).size()-1-j],dp[i][j]);

                }


            }
            int dp2[][] = new int[B.size()][B.get(0).size()];
            int N = B.size();
            int M = B.get(0).size();
            int[] ans2;
            for(int i = 0;i<M;i++){
                call = new int[N];
                for(int j = 0;j<N;j++){
                    call[j]=B.get(j).get(i);
                }
                ans= KthLargest(call,A);
                ans2 = KthLargest(rev(call),A);

                for(int j =0;j<N;j++){
                    dp2[j][i] = Math.max(ans[j],ans2[N-1-j]);
                }


            }

            ArrayList<ArrayList<Integer>> rans = new ArrayList<>();
            ArrayList<Integer> xy = new ArrayList<>();
            for(int i = 0;i<B.size();i++){
                xy = new ArrayList<>();
                for(int j  =0;j<M;j++){
                    dp[i][j]= Math.max(dp[i][j],dp2[i][j]);
                    xy.add(dp[i][j]);
                }
                rans.add(xy);


            }

            return rans;

        }
        public int[] rev(int[] a){

            int[] rev = new int[a.length];
            for(int i = 0;i<a.length;i++){
                rev[i]= a[a.length-1-i];
            }
            return rev;
        }
        public int[] KthLargest(int[] a,int L){
            int ans[] = new int[a.length];
            Deque<Integer> deque = new LinkedList<Integer>();
            ans[0]= Integer.MIN_VALUE;
            deque.addLast(0);
            int k = 0;

            for(int i = 1;i<a.length;i++){

                ans[i]= a[deque.peekFirst()];
                k++;
                if(a[i]>a[deque.peekFirst()]){
                    deque.clear();
                    deque.add(i);
                    k = 0;
                    continue;
                }
                while(a[i]>a[deque.peekLast()]){
                    deque.removeLast();
                }
                deque.add(i);
                if(k == L){
                    deque.removeFirst();
                    k=i-deque.peekFirst();
                    continue;
                }







            }

            return ans;

        }


    }

    public static class Solution3 {
        public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
            HashMap<String,Integer> mp = new HashMap<String,Integer>();
            //int[][] dp = new int[B.size()][B.get(0).size()];
            ArrayList<ArrayList<Integer>> f = new ArrayList<>();
            ArrayList<Integer> x = new ArrayList<>();
            for(int i = 0;i<B.size();i++){
                x = new ArrayList<>();
                for(int j = 0;j<B.get(0).size();j++){
                    x.add(run(A,B,i,j,mp));


                }

                f.add(x);



            }


            return f;

        }
        public int run(int A,ArrayList<ArrayList<Integer>> B,int i,int j,HashMap<String,Integer> mp){
            String ss= A+"&"+i+"$"+j;
            if(mp.containsKey(ss)){
                return mp.get(ss);
            }
            if(i>B.size()-1){
                return Integer.MIN_VALUE;
            }
            ///int ans = 0;
            int ans = B.get(i).get(j);
            if(A==0){
                return ans;
            }
            if(j>B.get(0).size()-1){
                return Integer.MIN_VALUE;
            }
            if(i==B.size()-1 && j ==B.get(0).size()-1){
                if(j!=0){
                    ans =Math.max(run(A-1,B,i,j-1,mp),ans);
                }
                if(i!=0){
                    ans =Math.max(run(A-1,B,i-1,j,mp),ans);
                }
                return ans;
            }
            if(j==B.get(0).size()-1){
                ans =Math.max(run(A-1,B,i+1,j,mp),ans);
                if(j!=0){
                    ans =Math.max(run(A-1,B,i,j-1,mp),ans);
                }
                if(i!=0){
                    ans =Math.max(run(A-1,B,i-1,j,mp),ans);
                }
                mp.put(ss,ans);
                return ans;
            }
            if(i==B.size()-1){
                ans =Math.max(run(A-1,B,i,j+1,mp),ans);
                if(j!=0){
                    ans =Math.max(run(A-1,B,i,j-1,mp),ans);
                }
                if(i!=0){
                    ans =Math.max(run(A-1,B,i-1,j,mp),ans);
                }
                mp.put(ss,ans);
                return ans;
            }
            ans =Math.max(run(A-1,B,i+1,j,mp),ans);
            ans =Math.max(run(A-1,B,i,j+1,mp),ans);
            if(j!=0){
                ans =Math.max(run(A-1,B,i,j-1,mp),ans);
            }
            if(i!=0){
                ans =Math.max(run(A-1,B,i-1,j,mp),ans);
            }
            mp.put(ss,ans);
            return ans;


        }
    }
    public static class Solution {
        public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
            int N = B.size();int M = B.get(0).size();
            int dp[][][] = new int[N][M][A+1];
            for(int i = 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    dp[i][j][0]=B.get(i).get(j);
                }
            }
            for(int k = 1;k<A+1;k++){
                for(int i = 0;i<N;i++){
                    for(int j = 0;j<M;j++){
                        dp[i][j][k]=dp[i][j][k-1];
                        if(j+1<M){
                            dp[i][j][k]=Math.max(dp[i][j][k],dp[i][j+1][k-1]);
                        }
                        if(j>0){
                            dp[i][j][k]=Math.max(dp[i][j][k],dp[i][j-1][k-1]);
                        }
                        if(i+1<N){
                            dp[i][j][k]=Math.max(dp[i][j][k],dp[i+1][j][k-1]);
                        }
                        if(i>0){
                            dp[i][j][k]=Math.max(dp[i][j][k],dp[i-1][j][k-1]);
                        }

                    }

                }
            }
            ArrayList<ArrayList<Integer>> q = new ArrayList<>();
            ArrayList<Integer> r = new ArrayList<>();
            for(int i = 0;i<N;i++){
                r = new ArrayList<>();
                for(int j=0;j<M;j++){
                    r.add(dp[i][j][A]);
                }
                q.add(r);
            }





            return q;

        }
        public void printMat(ArrayList<ArrayList<Integer>> Ans){
            String ss = "";
            for(int i = 0;i<Ans.size();i++){
                ss = "";
                for(int j = 0;j<Ans.get(i).size();j++){
                    ss+=Ans.get(i).get(j)+" ";


                }
                System.out.println(ss);

            }



        }
    }

}
