//求两字符串的最大公共子序列
//dp[i][j]表示str1[0..i]和str2[0..j]的最大公共子序列
//dp[i][j]=Max(dp[i-1][j],dp[i][j-1],dp[i-1[j-1],dp[i-1[j-1]+1)
//当且仅当i==j时才存在最后一种情况
public class LongestSubsequence {
    public static int lcse(char[] arr1,char[] arr2){
        int[][] dp=new int[arr1.length][arr2.length];
        dp[0][0]=arr1[0]==arr2[0] ? 1:0;
        for(int i=0;i< arr1.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],arr1[i]==arr2[0]? 1:0);
        }
        for (int j=0;j< arr2.length;j++){
            dp[0][j]=Math.max(dp[0][j-1],arr1[0]==arr2[j]?1:0);
        }
        for(int i=1;i< arr1.length;i++){
            for(int j=1;j< arr2.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                if(arr1[i]==arr2[j]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp[arr1.length-1][arr2.length-1];

    }

}
