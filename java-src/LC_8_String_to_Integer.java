
import java.util.*;
public class LC_8_String_to_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("##");
		System.out.println(myAtoi("words and 987"));

	}
	  public static int myAtoi(String s) {
	       if(s.length()==0){
	        	System.out.print("001");
	            return 0;
	        }
       long x = 0;
	        int sign = 1;
	        String N = "";
	        boolean f = true;
	          boolean f2 = false;
	        for(int i =0;i<s.length();i++){
	        	System.out.print(s.charAt(i));
	            if(s.charAt(i)==' '){
	            	System.out.println("1");
	                continue;
	            }
	            if('0'>s.charAt(i) || s.charAt(i)>'9'){
	                if(s.charAt(i)!= '-' && s.charAt(i)!= '+' ){
	                	System.out.println("2");
	                    break;
	                }
	            }
	            
	            if(s.charAt(i)=='+' && f){
	                f = false;
	                sign = 1;
	            	System.out.println("3");
	                continue;
	            }
	             if(s.charAt(i)=='-' && f){
	                f = false;
	                sign = -1;
	            	System.out.println("4");
	                 continue;
	            }
	            if('0'<=s.charAt(i) && s.charAt(i)<='9'){
	                f = false;
	                f2 = true;
                   x =x*10;
                   x += Character.getNumericValue(s.charAt(i)); 
                   if(x>Integer.MAX_VALUE){
                       return 0;
                   }
	                N = N+ s.charAt(i);
	            	System.out.println("##");
	            	System.out.println("5");
	            	System.out.println(N);
	            	System.out.println("%%");
	            }
	            
	            
	        }
	        if(N.length()==0){
	            return 0;
	        }
	        int ans =Integer.parseInt(N);
	        return sign*ans;
	    }
}
