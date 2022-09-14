public class nextPermutation {
    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public static void swapList(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public int[] nextPermutation(int[] nums){
        if(nums==null || nums.length<0){
            return null;
        }
        if (nums.length==1){
            return nums;
        }
        int len=nums.length;
        int i=len-1;
        while(i>0 && nums[i]<nums[i+1]){
            i--;
        };
        swap(nums,i,len-1);
        if(i!=0){
            int j=i;
            while(nums[j]<nums[i-1]) j++;
            swap(nums,i-1,j);
        }
        return nums;

    }
}
