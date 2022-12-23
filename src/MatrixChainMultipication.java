
import java.util.*;
import java.io.*;
public class MatrixChainMultipication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//{40, 20, 30, 10, 30}
	public static int mcm2(int[] arr){
		int[][] dp = new int[arr.length+1][arr.length+1];
		int j =0;
		for(j =1;j<dp.length;j++){
			for(int i = 0;i<dp.length-j;i++){
				if(i==0){
					continue;
				}
				dp[i][i+j]=dp[i+1][i+j]+arr[i-1]*arr[i]*arr[j-1];
				dp[i][i+j]=dp[i][i+j-1]+arr[i+j-1]*arr[i+j-2];
			}


		}




		return 5;



	}



	public static int mcm(int[] arr) {
		//Traversing diagonally
//		for(int L = 0;L<9;L++){
//			for(int i =0,int j = L;i<9-L;i++  j++;){//start from first row at distance L and
//				//keep increasing rows and columns at the same time , so is i and j
//				a[i][j] = N;
//				N++;
//			}
//		}




		int[][] dp = new int[arr.length-1][arr.length-1];
		for(int g =0;g<dp.length;g++) {
			for(int i =0,j=g;j<dp.length;i++,j++) {
				if(g==0) {
					dp[i][j]=0;
				}else if(g==1){
					dp[i][j] = arr[i]*arr[j]*arr[j+1];
				}else {
					int min = Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
						//dp ->i,k left half and k+1,j right half
						//arr ->i*k+1 left half,k+1*j+1 right half
						int lc = dp[i][k];
						int rc = dp[k+1][j];
						int mc = arr[i]*arr[k-1]*arr[j+1];
						int tc = lc+rc+mc;
						if(tc<min) {
							min = tc;
						}


					}


					dp[i][j] = min;


				}


			}


		}


		return dp[0][dp.length -1];
	}

}
