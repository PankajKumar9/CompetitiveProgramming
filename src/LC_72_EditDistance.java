
import java.util.*;
public class LC_72_EditDistance {
	public static void main(String args[]) {
		System.out.println("Oye hoye it works ");
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("Edit distance = "+minDistance(word1,word2));
		
}
    public static int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        
        for(int i =0;i<dp.length;i++){
            dp[i][0] = i;
        }
         for(int i =0;i<dp[0].length;i++){
            dp[0][i] = i;
        }
        int a = 0;int b = 0;int c = 0;
        for(int i =1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                	System.out.println("i = "+i+"j = "+j);
                    dp[i][j]= dp[i-1][j-1];
                }else{
                    a = Math.min(dp[i][j-1],dp[i-1][j-1]);
                    a = Math.min(a,dp[i-1][j]);
                    dp[i][j] = a+1;
                }
                
                
                
            }
            
            
        }
        for(int i =0;i<dp.length;i++) {
        	System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dp.length-1][dp[0].length-1];
        
    }
	


}
