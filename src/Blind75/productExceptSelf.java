package Blind75;

public class productExceptSelf {
    public static int[] solution(int[] nums){
        int length=nums.length;
        int[] ans=new int[length];
        int[] l=new int[length];
        int[] r=new int[length];
        l[0]=1;
        for(int i=1;i<length;i++){
            l[i]=l[i-1]*nums[i-1];
        }
        r[length-1]=1;
        for(int j=length-2;j>=0;j--){
            r[j]=r[j+1]*nums[j+1];
        }
        for(int k=0;k<length;k++){
            ans[k]=l[k]*r[k];

        }
        return ans;
    }
}
