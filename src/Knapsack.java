//从左往右模型2：给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表i位置物品的重量和价值
//给定一个正数bag，表示一个载重为bag的袋子，所装物品的总重量不能超过bags
//返回能获得的价值的最大值
public class Knapsack {
    public static int getMaxValue(int[] w,int[] v,int bag){
        return process(w,v,0,0,bag);
    }
    public static int process(int[] w,int[] v,int index,int alreadyW,int bag){
        if (alreadyW>bag){
            return -1;
        }
        if (index==w.length){
            return 0;
        }
        int p1=process(w,v,index+1,alreadyW,bag);
        int p2next=process(w,v,index+1,alreadyW+w[index],bag);
        int p2=-1;
        if (p2next!=-1){
            p2=v[index]+p2next;
        }
        return Math.max(p1,p2);
    }
    public static int MaxValue(int[] w, int[] v,int bag){
        return process1(w,v,0,bag);
    }
    //只有两个可变参数，可构造dp表将暴力递归结果记录在dp表，从而改为动态规划
    //只有在评估暴力递归的过程中是否有重复计算的步骤才去改动态规划
    public static int process1(int[] w,int[] v,int index,int rest){
        if (rest<0){
            return -1;
        }
        if (index==w.length){
            return 0;
        }
        int a1=process1(w,v,index+1,rest);
        int a2=-1;
        int a2next=process1(w,v,index+1,rest-w[index]);
        if (a2next!=-1){
            a2=v[index]+a2next;
        }
        return Math.max(a1,a2);
    }
    public static int dpWay(int[] w,int[] v,int bag){
        int N=w.length;
        int[][] dp=new int[N+1][bag+1];
        for (int index=N-1;index>0;index--){
            for (int rest=1;rest<bag;rest++){
                dp[index][rest]=dp[index+1][rest];
                if (rest>=w[index]){
                    dp[index][rest]=Math.max(dp[index][rest],v[index]+dp[index+1][rest-w[index]]);
                }
            }
        }
        return dp[0][bag];
    }
    public static void main(String[] args){
        int[] weights={3,2,4,7};
        int[] values={5,6,3,19};
        int bag=11;
        System.out.println(getMaxValue(weights,values,bag));
        System.out.println(dpWay(weights,values,bag));
    }
}
