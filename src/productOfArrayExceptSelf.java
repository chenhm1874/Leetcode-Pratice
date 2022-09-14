public class productOfArrayExceptSelf {
    public static int[] ProductExceptSelf(int[] nums){
        int length=nums.length;
        int[] ans=new int[length];
        ans[0]=1;
        for(int i=1;i<length;i++){
            ans[i]=ans[i-1]*nums[i];
        }
        int R=1;
        for(int i=length-1;i>=0;i--){
            ans[i]=ans[i]*R;
            R=R*nums[i];
        }
        return ans;
    }
}
