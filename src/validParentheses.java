import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s){
        Map<Character,Character> s1=new HashMap<>();
        s1.put(')','(');
        s1.put(']','[');
        s1.put('}','{');
        Stack<Character> s2=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (s1.containsKey(c)){
                char topElement=s2.empty()? '#':s2.pop();
                if(topElement!=s1.get(c)){
                    return false;
                }else{
                    s2.push(c);
                }
            }
        }
        return s2.isEmpty();

    }
}
