

/**
 * @author pankajkumar
 *
 */
import java.util.*;
public class LC_0099 {



	  public static class TreeNode {
	      int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	     public void xopy(TreeNode x) {
	    	 this.val = x.val;
	
	     }
	     public String toString() {
	    	 //
	    	 Stack<TreeNode> st = new Stack<>();
	         ArrayList<Integer> x = new ArrayList<>();
	         TreeNode curr = this;
	         
	         while(curr != null || st.size()>0){
	        
	         	
	             while(curr!=null){

	             	
	                 st.push(curr);
	   
	                 curr = curr.left;
	             }

	             curr = st.pop();

	             x.add(curr.val);
	             curr = curr.right;
	         
	         }
	        return x.toString();
	    	 //
	     }
	 }
	 
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode x = new TreeNode(1,new TreeNode(3,null,new TreeNode(2,null,null)),null);
		System.out.println(x.toString());
		recoverTree(x);
		System.out.println(x.toString());
		

	}
    public static void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<TreeNode> x = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null || st.size()>0){
      
        	
            while(curr!=null){
            	
            
            	
                st.push(curr);

                curr = curr.left;
            }
        
            curr = st.pop();
           
            x.add(curr);
            curr = curr.right;
        
        }
        int a = -1;int b = -1;
        System.out.println("This is in oder traversal"+x.get(0).val+" "+x.get(1).val+" "+x.get(2).val);
        for(int i = 1;i<x.size();i++){
        	
            if((!(x.get(i-1).val<x.get(i).val))&& a== -1){
                a = i-1;
                continue;
            }else {
            	
            	if((!(x.get(i-1).val<x.get(i).val))){
                    b = i;
                    break;
                }
            	
            	
            }
        }
        System.out.println(" a = "+a+" B ="+b);
      
            	  curr =new TreeNode();
            	  curr.xopy(x.get(a));
            	  x.get(a).xopy(x.get(b));
            	  x.get(b).xopy(curr);
            	  
     
                
                
                
         
        
        return;
        
    }

}
