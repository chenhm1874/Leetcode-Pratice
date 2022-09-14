import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    public static List<String> generateParentheses(int n){
        List<String> ans=new ArrayList<String>();
        if(n<=0){
            return ans;
        }
        helper(0,0,"",n,ans);
        return ans;
    }
    private static void helper(int left,int right,String nowAns ,int n,List<String> ans){
        if(left>n||right>n){
            return;
        }
        if(left<right){
            return;
        }
        if(left==n&& right==n){
            ans.add(nowAns);
            return;
        }
        helper(left+1,right,nowAns+"(",n,ans);
        helper(left,right+1,nowAns+")",n,ans);

    }
}
