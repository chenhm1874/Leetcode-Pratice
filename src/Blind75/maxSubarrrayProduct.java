package Blind75;

import java.util.List;

public class maxSubarrrayProduct {
    public static int solution(List<Integer> array){
        int length=array.size();
        int[] max=new int[length];
        int[] min=new int[length];
        int res=0;
        min[0]= array.get(0);
        max[0]= array.get(0);
        for(int i=0;i<length;i++){
            min[i]=max[i]=array.get(i);
            if(array.get(i)>0){
                min[i]=Math.min(min[i],min[i-1]*array.get(i));
                max[i]=Math.max(max[i],max[i-1]*array.get(i));
            }
            else if(array.get(i)<0){
                max[i]=Math.max(max[i],min[i-1]*array.get(i));
                min[i]=Math.min(min[i],max[i-1]*array.get(i));
            }
            res=Math.max(res,max[i]);
        }
        return res;
    }
}
