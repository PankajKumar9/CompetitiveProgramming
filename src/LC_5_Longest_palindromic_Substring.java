/**
 * @author pankajkumar
 *
 */
public class LC_5_Longest_palindromic_Substring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(longestPalindrome("ac"));
	}
	public static String longestPalindrome(String s) {
        int max = 1;
        int a = 0;
        String ans = "";
        for(int i =0;i<s.length();i++){
            
            for(int j = s.length()-1;j>i-1;j--){
               a= isP(s,i,j);
                   if(a!= -1){
                   if(a>max){
                       max = a;
                       ans = s.substring(i,j+1);
                   }
                       break;
                   }
                
            }
            
            
            
        }
        return ans;
    }
    public static int isP(String s,int i,int j){
    	int a = i;
    	int b = j;
        if(i==j){
            return 1;
        }
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return -1;
            }
            i++;j--;
            
            
        }
      
        return b-a+1;
        
        
        
    }

}
