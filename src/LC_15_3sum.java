
import java.util.*;
public class LC_15_3sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(a));

	}
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int j =0;int k = 0;
        for(int i =0;i<nums.length-2;i++){
            j = i+1;k = nums.length-1;
            while(j<k){
            if(nums[j]+nums[k] +nums[i]==0){
                ans.add(func(i,j,k));
                j=j+1;
                k=k-1;
            }else{
                if(nums[j]+nums[k] +nums[i]<0){
                    j=j+1;
                }else{
                    k = k-1;
                }
                
            }
            }
            
            
            
            
            
            
        }
        return ans;
        
    }
    public static ArrayList<Integer> func(int a, int b,int c){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a);ans.add(b);ans.add(c);
        return ans;
    }
}
