package Blind75;

import java.util.List;

public class minOfSorted {
    public static int minInRotated(List<Integer> array1){
        int left=0;
        int right=array1.size()-1;
        if (array1.size()==1){
            return array1.get(0);
        }
        if(array1.get(left)<array1.get(right)){
            return left;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(array1.get(mid-1)>array1.get(mid)){
                return array1.get(mid);
            }
           if(array1.get(mid)>array1.get(0)){
               left=mid+1;
           }
           else {
               right=mid-1;
           }
        }
        return Integer.MAX_VALUE;
    }
}
