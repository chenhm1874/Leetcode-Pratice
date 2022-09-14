package Amazon;

public class findEarliestMonth {
    public static int findEarliestMonth(int[] stockPrices){
        int sum1=0;
        int sum2=SumWithoutUsingStream(stockPrices);
        int month=0;
        float min=Integer.MIN_VALUE;
        int n=stockPrices.length;
        for(int i=0;i<n;i++){
            sum1+=stockPrices[i];
            sum2-=stockPrices[i];
            float avg1=sum1/(i+1);
            float avg2=sum2/(n-1-i);
            float diff=Math.abs(avg1-avg2);
            if(diff<min){
                min=diff;
                month=i+1;
            }
        }
        return month;
    }
    public static int SumWithoutUsingStream(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
