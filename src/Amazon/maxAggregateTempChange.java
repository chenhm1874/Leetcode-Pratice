package Amazon;

public class maxAggregateTempChange {
     public int MaxTempChange(int[] changes){
         int[] Max=new int[changes.length];
         int[] prefix=new int[changes.length];
         for(int i=0;i<changes.length;i++){
             prefix[i]+=changes[i];
         }
         for(int i=0;i<changes.length;i++){
             Max[i]=Math.max(prefix[i],prefix[changes.length]-prefix[i]+changes[i]);
         }
         int max=0;
         for(int i=0;i<Max.length;i++){
             if(Max[i]>max){
                 max=Max[i];
             }
         }
         return max;
     }

}
