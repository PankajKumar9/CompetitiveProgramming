
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> pq = new ArrayList<Integer>();
        
        int[] dp = new int[n+1];
        int[] cp = new int[n+1];
        dp[0] = 0;dp[1] =0;
        cp[1] = 0;cp[0]=0;
        int a = n+1;
        int b = n+1;
        int c = n+1;
        for(int i =2;i<n+1;i++){
             a = n+1;
             b = n+1;
             c = n+1;
            if(i%3==0){
                if(i/3>0){
                    a = dp[i/3]+1;
                }
            }
            if(i%2==0){
                if(i/2>0){
                    b = dp[i/2]+1;
                }
            }
            c= dp[i-1]+1;

            if(a<b){
                if(a<c){
                    dp[i]= a;
                    cp[i] = i/3;
                }else{
                    dp[i]= c;
                    cp[i] = i-1;
                }
            }else{
                if(b<c){
                    dp[i]= b;
                    cp[i] = i/2;
                }else{
                    dp[i]= c;
                    cp[i] = i-1;
                }
            }



        }

        while(true){
           
            pq.add(0,n);
            if(n==1){
                break;
            }
            n= cp[n];
        }

        return pq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

