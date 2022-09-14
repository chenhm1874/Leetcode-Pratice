public class maxGap {
    public static int maxGap(int[] nums){
        if(nums==null || nums.length<2){
            return 0;
        }
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        if(min==max){
            return 0;
        }
        int[] mins=new int[nums.length+1];
        int[] maxs=new int[nums.length+1];
        boolean[] hasNum=new boolean[nums.length+1];
        int bid =0;
        for(int i=0;i< nums.length;i++){
            bid=bucket(nums[i],nums.length,min,max);
            mins[bid]=hasNum[bid]?Math.min(nums[i],mins[bid]):nums[i];
            maxs[bid]=hasNum[bid]?Math.max(nums[i],maxs[bid]):nums[i];
            hasNum[bid]=true;
        }
        int res=0;
        int lastMax=0;
        int i=1;
        for(;i< nums.length;i++){
            res=Math.max(res,mins[i]-lastMax);
            lastMax=maxs[i];
        }
        return res;
    }
    public static int bucket(long num,long len,long min,long max){
        return (int)((num-min)*len/(max-min));
    }
}
