import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits){
        Map<Integer,String> PHONE=new HashMap<>();
        PHONE.put(1,"");
        PHONE.put(2,"abc");
        PHONE.put(3,"def");
        PHONE.put(4,"ghi");
        PHONE.put(5,"jkl");
        PHONE.put(6,"mno");
        PHONE.put(7,"pqrs");
        PHONE.put(8,"tuv");
        PHONE.put(9,"wxyz");
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        dfs(0,"",digits, (HashMap<Integer, String>) PHONE,ans);
        return ans;
    }
    private void dfs(int index, String current, String digits, HashMap<Integer, String> PHONE, List<String> result) {
        if (index == digits.length()){
            result.add(current);

            return;
        }

        int d = digits.charAt(index) - '0';

        for (char c : PHONE.get(d).toCharArray()) {

            dfs(index + 1, current + c, digits, PHONE, result);

        }

    }
}
