
import java.util.*;
import java.io.*;
public class LC_131_Palindrome_Partitioning {
	public static void main(String args[]) {
		
	}
	
	public static List<String> parts(String s){
		if(s.length()==0) {
			return null;
		}
		
		
		List<String> x = parts(s.substring(1,s.length()));
		List<String> y = parts(s.substring(1,s.length()));
		
		
		
		
		
		
		return x;
	}
	
	
	 public static List<List<String>> partition(String S) {
	       
		 return null;
		 
		 
	    }
}
