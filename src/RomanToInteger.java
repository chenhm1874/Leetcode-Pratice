import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static Map<String,Integer> sb=new HashMap<>();
    static{
        sb.put("I",1);
        sb.put("V",5);
        sb.put("X",10);
        sb.put("L",50);
        sb.put("C",100);
        sb.put("D",500);
        sb.put("M",1000);
        sb.put("IV",4);
        sb.put("IX",9);
        sb.put("XL",40);
        sb.put("XC",90);
        sb.put("CD",400);
        sb.put("CM",900);
    }
    public static int RomanToInteger(String s){
        int sum=0;
        int i=0;
        while(i<s.length()){
            if(i+1<s.length()){
                String DoubleSymbol=s.substring(i,i+2);
                if(sb.containsKey(DoubleSymbol)){
                    sum+=sb.get(DoubleSymbol);
                    i+=2;
                    continue;
                }
            }
            String SingleSymbol=s.substring(i,i+1);
            sum+=sb.get(SingleSymbol);
            i+=1;
        }
        return sum;
    }
    public static void main(String[] args){
        String s1="MCMXCIV";
        int ans=RomanToInteger(s1);
        System.out.println(s1);
    }
}
