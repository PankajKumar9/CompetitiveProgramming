

public class LC_6_Zigzag_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING" ;
		int x = 3;
		System.out.println(convert(s,x));

	}
	
    public static String convert(String s, int numRows) {
        int curr1 = 0;
        int curr2 = 0;
        int l = 0;
        int next =1;
        int previous = -1;
        int temp =0;
        char[][] mat = new char[numRows][s.length()];
        boolean[][] matx = new boolean[numRows][s.length()];
        
        for(int i =0;i<s.length();i++){
        	if(curr1 == 0) {
        		next = 0;
        		l=0;
        	}
        
        	
        	if(next == 0) {
        		//down
        		mat[curr1][curr2] = s.charAt(i);
                matx[curr1][curr2] = true;
                
                l=l+1;
                if(l==numRows){
                    curr1 = curr1-1;
                    curr2= curr2+1;
                    
                    next = 1;
                    continue;
                    
                }
                curr1=curr1+1;
                
                
        		
        		
        		
        		
        		
        	}
        	
        	if(next == 1) {
        		//diagonally up 
        		mat[curr1][curr2] = s.charAt(i);
                matx[curr1][curr2] = true;
                curr1 = curr1-1;
                curr2= curr2+1;
        		
        	}
        
            
            
        }
        
        String ans = "";
        for(int i =0;i<numRows;i++){
            for(int j = 0;j<matx[0].length;j++){
                
                if(matx[i][j]){
                    ans=ans+mat[i][j];
                }
            }
            
            
        }
        return ans;
        
        
        
        
    }

}
