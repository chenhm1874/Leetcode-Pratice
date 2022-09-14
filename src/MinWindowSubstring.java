import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static String MinWindowSubstring(String source,String target){
        Map<Character,Integer> smap= new HashMap<>();
        Map<Character,Integer> tmap= new HashMap<>();
        for(int i=0;i<target.length();i++){
            int count= tmap.getOrDefault(target.charAt(i),0);
            tmap.put(target.charAt(i),count+1);
        }
        int left=0;
        int value=0;//target中的有效字符数
        int start=-1;
        int minlength=Integer.MAX_VALUE;
        for(int right=0;right<source.length();right++){
            char rc=source.charAt(right);
            if (tmap.containsKey(rc)){
                smap.put(rc,smap.getOrDefault(rc,0)+1);
            }
            if(smap.get(rc).compareTo(tmap.get(rc))==0){
                value++;
            }
            while(value==tmap.size()){
                if(right-left<minlength){
                    minlength=right-left;
                    start=left;
                }
            }
            char lc=source.charAt(left);
            left++;
            if (tmap.containsKey(lc)) {
                if (tmap.get(lc).equals(smap.get(lc))) {
                    value--;
                }
                smap.put(lc, smap.getOrDefault(lc, 0) - 1);
            }
        }
        // 返回最小覆盖子串
        return start == -1 ? "" : source.substring(start, start + minlength  + 1);
    }
}
