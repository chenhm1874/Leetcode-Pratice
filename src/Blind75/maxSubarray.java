package Blind75;

public class maxSubarray {
    public static int max(int[] array){
        int l=array.length;
        int[] dp=new int[l];
        dp[0]=array[0];
        for(int i=1;i<l;i++){
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
        }
        int res=Integer.MIN_VALUE;
        for(int j=0;j<l;j++){
            if(dp[j]>res){
                res=dp[j];
            }
        }
        return res;
    }
}
