//给定一个数组，表示每个人喝完咖啡准备刷杯子的时间，只有一台咖啡机，一次只能洗一个杯子，耗时a，洗完才能洗下一个杯子
//每个咖啡杯也可以挥发干净，耗时b可以并行挥发
//返回让所有咖啡杯恢复干净的最早完成时间
//参数表：int[] arr,int a,int b
//drinks数组：每个员工喝完的时间，a洗杯子时间，b杯子晾干时间，这三个是固定变量
//drinks[0,index-1]的流程已经完成，需要考虑[index...arr.length-1]的最短时间
//主函数调用process1(drinks,a,b,0,0),washline表示咖啡机可用的时间点
public class CoffeeCupCleanup {
    public static int process1(int[] drinks, int a, int b, int index, int washline) {
        if (index == drinks.length - 1) {
            return Math.min(
                    //若要是用咖啡机必须等咖啡机空闲，若咖啡机空闲但咖啡还没喝完同样用不了，所以取max
                    Math.max(washline, drinks[index]) + a,
                    drinks[index] + b
            );
        }
        //可能性1：当前杯子我一定要洗它
        int wash = Math.max(washline, drinks[index]) + a;    //当前杯子洗完的时间
        int next1 = process1(drinks, a, b, index + 1, wash); //index+1到最后所有的杯子洗完的时间
        int p1 = Math.max(wash, next1);//所有的杯子都必须洗完
        //可能性2：我让当前杯子自己挥发变干净
        int dry = drinks[index] + b;
        int next2 = process1(drinks, a, b, index + 1, washline);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }

    //改动态规划，index变化范围0-N-1，washline根据题目业务需求（所有杯子都放进去洗）建立dp表
    public static int dp(int[] drinks, int a, int b) {
        if (a >= b) {
            return drinks[drinks.length - 1] + b;
        }
        int limit = 0;
        int N = drinks.length;
        for (int index = 0; index < N; index++) {
            limit = Math.max(limit, drinks[index]) + a;
        }
        int[][] dp = new int[N][limit + 1];
        for (int washline = 0; washline < limit; washline++) {
            dp[N - 1][washline] = Math.min(
                    //若要是用咖啡机必须等咖啡机空闲，若咖啡机空闲但咖啡还没喝完同样用不了，所以取max
                    Math.max(washline, drinks[N - 1]) + a,
                    drinks[N - 1] + b
            );
        }
        for (int index = N - 2; index >= 0; index--) {
            for (int washline = 0; washline <= limit; washline++) {
                int p1 = Integer.MAX_VALUE;
                int wash = Math.max(washline, drinks[index]) + a;
                if (wash <= limit) {
                    p1 = Math.max(wash, dp[index + 1][wash]);
                }
                int p2 = Math.max(drinks[index] + b, dp[index + 1][washline]);
                dp[index][washline] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 5, 7, 10, 12, 12, 12, 12, 12, 12, 15};
        int a = 3;
        int b = 10;
        System.out.println(process1(arr, a, b, 0, 0));
        System.out.println(dp(arr, a, b));
    }
}
