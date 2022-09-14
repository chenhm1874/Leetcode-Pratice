import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> ThreeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i< num.length;i++){
            if(i==0 || num[i-1]!=num[i]){
                Twosum(num,i,res);
            }
        }
        return res;
    }
    public static void Twosum(int[] nums,int i ,List<List<Integer>> ans){
        HashSet<Integer> s1=new HashSet<>();
        for(int j=i+1;j< nums.length;++j){
            int remain= -nums[i]-nums[j];
            if(s1.contains(remain)){
                ans.add(Arrays.asList(nums[i],nums[j],remain));
                while(j+1<nums.length && nums[j]==nums[j+1]){
                    ++j;
                }
                s1.add(nums[j]);
            }
        }
    }
}
