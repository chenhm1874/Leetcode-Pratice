//给定一个数组arr，数组中的值分别代表不同面值的币种，每个币种假设都有无数张，arr中的所有值都为正数且无重复值
//给定一个aim钱数，求能达到钱数的方法数多少
public class Money {
    public static int way(int[] arr,int aim){
        if(arr.length==0 || aim<0 || arr==null){
            return 0;
        }
        return process(arr,0,aim);
    }
    //可以自由使用[index..]中的所有面值，每种面值都可以用无数张
    public static int process(int[] arr,int index,int rest){
        if(index==arr.length){//没有币种可以选择了
            return rest==0 ? 1:0;
        }
        int way=0;
        //for循环可以判断rest不会小于0，故base case不需要考虑rest<0的情况
        for(int zhang=0;zhang*arr[index]<=rest;zhang++){
            way+=process(arr,index+1,rest-zhang*arr[index]);
        }
        return way;
    }
    public static int dpWay(int[] arr,int aim){
        if(arr.length==0 || aim<0 || arr==null){
            return 0;
        }
        int[][] dp=new int[arr.length+1][aim+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return process2(arr,0,aim,dp);
    }
    public static int process2(int[] arr,int index,int rest,int[][] dp){
        if (dp[index][rest]!=-1){
            return dp[index][rest];
        }
        if(index==arr.length){//没有币种可以选择了
            dp[index][rest]=rest==0 ? 1:0;
            return dp[index][rest] ;
        }
        int way=0;
        //for循环可以判断rest不会小于0，故base case不需要考虑rest<0的情况
        for(int zhang=0;zhang*arr[index]<=rest;zhang++){
            way+=process(arr,index+1,rest-zhang*arr[index]);
        }
        dp[index][rest]=way;
        return way;
    }
    public static int dpWay2(int[] arr,int aim){
        if(arr.length==0 || aim<0 || arr==null){
            return 0;
        }
        int N= arr.length;
        int[][] dp=new int[N +1][aim+1];
        dp[N][0]=1;
        for (int index=N-1;index>=0;index--){
            for(int rest=0;rest<=aim;rest++){
                int way=0;
                //for循环可以判断rest不会小于0，故base case不需要考虑rest<0的情况
                for(int zhang=0;zhang*arr[index]<=rest;zhang++){
                    way+=dp[index+1][rest-(zhang*arr[index])];
                }
                dp[index][rest]=way;
            }
        }
        return dp[0][aim];
    }
    public static int dpWay3(int[] arr,int aim){
        if(arr.length==0 || aim<0 || arr==null){
            return 0;
        }
        int N= arr.length;
        int[][] dp=new int[N +1][aim+1];
        dp[N][0]=1;
        for (int index=N-1;index>=0;index--){
            for(int rest=0;rest<=aim;rest++){
                dp[index][rest]=dp[index+1][rest];
                if(rest-arr[index]>=0){
                    dp[index][rest]+=dp[index][rest-arr[index]];
                }

            }
        }
        return dp[0][aim];
    }
    public static void main(String[] args){
        int[] arr={5,10,50,100};
        int aim=1000;
        System. out.println(way(arr,aim));
        System. out.println(dpWay(arr,aim));
        System. out.println(dpWay2(arr,aim));
        System. out.println(dpWay3(arr,aim));
    }
}
