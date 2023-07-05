
import java.util.*;
public class LC_0653 {

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
		 }
//	[2,1,3]
//			1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode x = new TreeNode(2,new TreeNode(1),new TreeNode(3));
		System.out.println(findTarget(x,1));
		

	}
	  public static boolean findTarget(TreeNode root, int k) {
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        Stack<TreeNode> st = new Stack<>();
	        TreeNode curr = root;
	        while(curr !=null || st.size()>0){
	            while(curr!=null){
	                st.push(curr);
	                curr = curr.left;
	            }
	            curr = st.pop();
	            arr.add(curr.val);
	            curr = curr.right;
	            
	        }
	        int i = 0;int j = arr.size()-1;
	        Collections.sort(arr);
	        while(i!=j){
	        	System.out.println("i = "+i+"j = "+j);
	            if(arr.get(i)+arr.get(j)<k){
	                i++;
	            }else{
	                if(arr.get(i)+arr.get(j)>k){
	                j--;}
	                else{
	                    return true;
	                }
	            }
	                
	            }
	            
	            return false;
	        }
}
