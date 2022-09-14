import java.util.HashMap;
import java.util.Map;

public class firstUniqueChar {
    public static int fUniqueChar(String s){
        Map<Character,Integer> s1=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char x=s.charAt(i);
            s1.put(x, s1.getOrDefault(x,0)+1);
        }
        for(int i=0;i<n;i++){
            if(s1.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
