import java.util.HashSet;
import java.util.Set;

public class missingNumber {
    public static int missingNumber(int[] nums){
        Set<Integer> numSet= new HashSet<>();
        for(int num:nums)numSet.add(num);
        int eL=nums.length+1;
        for(int i=0;i<eL;i++){
            if(!numSet.contains(nums[i])){
                return i;
            }
        }
        return -1;
    }

}
