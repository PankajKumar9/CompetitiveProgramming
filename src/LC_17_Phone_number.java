
import java.util.*;
public class LC_17_Phone_number {
	public static HashMap<Character, ArrayList<String>> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is something");
		letterCombinations("23");
	}
	 public static List<String> letterCombinations(String digits) {
	      give();
	        ArrayList<String> ans = new ArrayList<>();
	        for(int i =0;i<digits.length();i++){
	        	ArrayList<String> x = map.get(digits.charAt(i));
	        	
	        	System.out.println(Arrays.toString(x.toArray()));
	            ans = merge(ans,map.get(digits.charAt(i)));
	            
	        }
	        return ans;
	        
	        
	    }
	    public static ArrayList<String> merge(ArrayList<String> a1,ArrayList<String> a2){
	        ArrayList<String> ans = new ArrayList<>();
	        if(a1.size()==0){
	            return a2;
	        }
	        if(a2.size()==0){
	            return a1;
	        }
	        String S="";
	        for(int i =0;i<a1.size();i++){
	            for(int j = 0;j<a2.size();j++){
	                S = "";
	                S = a1.get(i)+a2.get(j);
	                ans.add(S);
	                
	                
	            }
	            
	        }
	        return ans;
	        
	        
	        
	        
	    }
	    public static void give(){
	        map = new HashMap<>();
	        ArrayList<String> x = new ArrayList<>();
	        x.add("a");x.add("b");x.add("c");
	        map.put('2',x);
	        x = new ArrayList<>();
	         x.add("d");x.add("e");x.add("f");
	        map.put('3',x);
	        x = new ArrayList<>();
	        x.add("g");x.add("h");x.add("i");
	        map.put('4',x);
	        x = new ArrayList<>();
	        x.add("j");x.add("k");x.add("l");
	        map.put('5',x);
	        x = new ArrayList<>();
	        x.add("m");x.add("n");x.add("o");
	        map.put('6',x);
	        x = new ArrayList<>();
	        x.add("p");x.add("q");x.add("r");x.add("s");
	        map.put('7',x);
	        x = new ArrayList<>();
	        x.add("t");x.add("u");x.add("v");
	        map.put('8',x);
	        x = new ArrayList<>();
	        x.add("w");x.add("x");x.add("y");x.add("z");
	        map.put('9',x);
	        x = new ArrayList<>();
	        return ;
	    }
}
