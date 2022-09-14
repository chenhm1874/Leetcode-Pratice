//假设有排成一行的位置标记为1-N（N>=2)。开始时机器人在M位置上（M一定在1-N范围上）
//当机器人在1位置上时，它只能向右移动到2；当机器人在N位置上，它只能向左移动到N-1位置上，若它处在中间位置则可以自由向左或向右移动
//给定K步，要求机器人在K步后必须移动到P位置（必须走K步），给定四个参数N，M，K，P，返回方法数
public class RobotRoute {
    public static int way1(int N,int M,int K,int P){
        if(N<2 || K<1 || M<1 || M>N || P<1 || P>N){
            return 0;
        }
        //主函数调用walk函数M位置剩余K步目标位置P的点，返回方法数
        return walk1(N,M,K,P);
    }
    //cur为当前所处位置，rest为所剩步数，这两个为可变参数
    //N为整个路线长度，P为目标位置两个固定参数
    public static int walk1(int N,int cur,int rest,int P){
        if (rest==0){
            return cur==P ? 1:0;
        }
        if(cur==1){
            return walk1(N,2,rest-1,P);
        }
        if (cur==N){
            return walk1(N,N-1,rest-1,P);
        }
        return walk1(N,cur+1,rest-1,P)+walk1(N,cur-1,rest-1,P);
    }
    public static int way2(int N,int M,int K,int P){
        if(N<2 || K<1 || M<1 || M>N || P<1 || P>N){
            return 0;
        }
        int[][] dp=new int[N+1][K+1];
        for (int row=0;row<N+1;row++){
            for (int col=0;col<K+1;col++){
                dp[row][col]=-1;
            }
        }
        //主函数调用walk函数M位置剩余K步目标位置P的点，返回方法数
        return walk2(N,M,K,P,dp);
    }
    //cur为当前所处位置，rest为所剩步数，这两个为可变参数
    //N为整个路线长度，P为目标位置两个固定参数
    public static int walk2(int N,int cur,int rest,int P,int[][ ] dp){
        if (dp[cur][rest]!=-1){
            return dp[cur][rest];
        }
        if (rest==0){
            dp[cur][rest]=cur==P ? 1:0;
            return dp[cur][rest];
        }
        if(cur==1){
            dp[cur][rest]=walk2(N,2,rest-1,P,dp);
            return dp[cur][rest];
        }
        if (cur==N){
            dp[cur][rest]=walk2(N,N-1,rest-1,P,dp);
            return dp[cur][rest];
        }
        dp[cur][rest]=walk2(N,cur+1,rest-1,P,dp)+walk2(N,cur-1,rest-1,P,dp);
        return dp[cur][rest];
    }
    public static void main(String[] args){
        System.out.println(way1(7,3,9,5));
        System.out.println(way2(7,3,9,5));
    }
}
