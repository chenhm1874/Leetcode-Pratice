package Amazon;

import java.util.HashSet;
import java.util.Set;

public class maxStockPrice {
    public static long maxStockPrice(int[] stockPrice,int k){
        if (stockPrice.length<k){
            return -1;
        }
        int n=stockPrice.length;
        int left=0,right=0;
        int maxProfit=0;
        int sum=0;
        Set<Integer> seen=new HashSet<>();
        while(right<n){
            if(seen.contains(stockPrice[right])){
                left=right;
                sum=0;
                seen.clear();
            }
            sum+=stockPrice[right];
            seen.add(stockPrice[right]);
            if(right-left==k-1){
                if(seen.size()==k){
                    maxProfit=Math.max(maxProfit,sum);
                }
                seen.remove(stockPrice[left]);
                sum-=stockPrice[left];
                left++;
            }
            right++;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] stockPrice={1,2,7,7,4,3,6};
        long profit=maxStockPrice(stockPrice,3);
        System.out.println(profit);
    }
}
