
import java.util.*;
public class LC_3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring( s));

	}
	  public static int lengthOfLongestSubstring(String s) {
	       
	        Set<Character> hs = new HashSet<>();
	        char[] ch = s.toCharArray();  
	        hs.add(ch[0]);
	        int i =0;
	        int j =1;
	        int a =1;
	        int max = 0;
	        while(j<ch.length){
	        	
	            if(i>j){
	                break;
	            }
	            if(hs.contains(ch[j])){
	            	 hs.remove(ch[i]);
	                i=i+1;
	               
	                max = Math.max(max,a);
	                a=a-1;
	            }else {
	            hs.add(ch[j]);
	            a=a+1;
	      
	            max = Math.max(max,a);
	            System.out.println(hs);
	            System.out.println(max);
	            j=j+1;
	            
	            }
	            
	        }
	        return max;
	    }

}
