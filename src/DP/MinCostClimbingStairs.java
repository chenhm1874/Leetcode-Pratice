package DP;

public class MinCostClimbingStairs {
    public static int minCost1(int[] cost){
        if(cost.length==0){
            return 0;
        }
        int[] minCost=new int[cost.length+1];
        for(int i=2;i<minCost.length;i++){
            minCost[i]=Math.min(cost[i-1]+minCost[i-1],cost[i-2]+minCost[i-2]);
        }
        return minCost[minCost.length-1];
    }

    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        int ans= minCost1(cost);
        System.out.println(ans);
    }
}
