public class jumpGame {
    public boolean canJump(int[] nums){
        return helper(nums,0);
    }
    public boolean helper(int[] nums,int start){
        if(start==nums.length-1){
            return true;
        }
        int furthestJump=Math.min(start+nums[start], nums.length-1);
        for(int nextPos=start+1;nextPos< furthestJump;nextPos++){
            if(helper(nums,nextPos)){
                return true;
            }
        }
        return false;
    }
}
