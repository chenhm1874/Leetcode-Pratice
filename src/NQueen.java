//在N*N的棋盘上摆放N个皇后，要求保证任意两个皇后不在同一行，同一列及同一斜线上
//给定整数N，求满足条件的方法数

public class NQueen {
    public static int num1(int n){
        if(n<1){
            return 0;
        }
        int[] record=new int[n];//第i行的皇后，放在了第几列
        return process1(0,record,n);
    }
    public static int process1(int i,int[] record,int n){
        if(i==n){
            return 1;
        }
        int res=0;
        for(int j=0;j<n;j++){       //在0..j列上依次尝试可能摆放位置的可能性
            if(isValid(record,i,j)){
                record[i]=j;
                res+=process1(i+1,record,n);
            }
        }
        return res;
    }
    public static boolean isValid(int[] record,int i,int j){
        for (int k=0;k<i;k++){
            if (j==record[k] || Math.abs(record[k]-j)==Math.abs(i-k)){
                return false;
            }

        }
        return true;
    }
    public static int num2(int n){
        if (n==1 || n>32){
            return 0;
        }
        int limit= n == 32 ? -1 : (1<<n)-1;
        return process2(limit,0,0,0);
    }
    public static int process2(int limit,int colLim,int leftDiaLim,int rightDiaLim){
        if (colLim==limit){
            return 1;
        }
        //limit与上左右列limit所得结果是去掉左边无效的0，同时也保证右边的limit不越界
        //mostRightOne通过pos与上自己的取反再加一得到，计算完后减去已被计算的1
        int pos=limit& (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne=0;
        int res =0;
        while (pos!=0){
            mostRightOne=pos+(~pos+1);
            pos=pos-mostRightOne;
            res+=process2(limit,colLim|mostRightOne,(leftDiaLim|mostRightOne)<<1,(rightDiaLim |mostRightOne)>>>1);
        }
        return res;
    }

    public static void main(String[] args){
        int n=13;
        long start=System.currentTimeMillis();
        System.out.println(num1(n));
        long end=System.currentTimeMillis();
        System.out.println("cost time:"+(end-start)+"ms");
        //start=System.currentTimeMillis();
        //System.out.println(num1(n));
        //end=System.currentTimeMillis();
        //System.out.println("cost time:"+(end-start)+"ms");
    }
}
