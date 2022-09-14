//范围尝试模型：给定一个整形数组，代表数值不同的纸牌排成一直线，玩家A和B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿
//但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和B都绝顶聪明，请返回获胜者的分数
//由于暴力递归包括两个递归函数，每个递归函数有两个变量，所以需准备两张二维dp表
public class CardsInLine {
    public static int win1(int[] arr){
        if (arr==null || arr.length==0){
            return 0;
        }
        return Math.max(
                 f(arr,0, arr.length-1),
                s(arr,0, arr.length-1)
        );
    }
    public static int f(int[] arr,int L,int R){
        if (L==R){
            return arr[L];
        }
        return Math.max(arr[L]+s(arr,L+1,R),arr[R]+s(arr,L,R-1));
    }
    public static int s(int[] arr,int i,int j){
        if (i==j){
            return 0;
        }
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }
    public static int win2(int[] arr){
        if (arr==null || arr.length==0){
            return 0;
        }
        int N= arr.length;
        int[][] f=new int[N][N];
        int[][] s=new int[N][N];
        for(int i=0;i<N;i++){
            f[i][i]=arr[i];
        }
        //s[i][i]位置默认初始化为0
        for(int i=1;i<N;i++){
            int L=0;
            int R=i;
            while(L<N && R<N){
                f[L][R]=Math.max(arr[i]+s[L+1][R],arr[i]+s[L][R-1]);
                s[L][R]=Math.min(f[L+1][R],f[L][R-1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N-1],s[0][N-1]);
    }
    public static void main(String[] args){
        int[] arr={4,7,9,5,19,29,80,4};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }
}
