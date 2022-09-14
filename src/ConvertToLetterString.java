// 从左往右的尝试模型1：规定1和A对应，2和B对应，依次类推
//那么一个数字串'111'就可以转化为："AAA"，"KA"，"AK"
//给定一个只有数字字符组成的字符串，返回有多少种转化结果

public class ConvertToLetterString {
    public static int number(String str){
        if (str == null || str.length()==0){
            return 0;
        }
        return process(str.toCharArray(),0);
    }
    //str[0..i-1]已经完成转化，固定值
    //i到str.length共有多少种转化结果
    public static int process(char[] str,int i){
        //i处在字符串终止位置
        if (i==str.length){
            return 1;
        }
        if (str[i]=='0'){
            return 0;
        }
        if (str[i]=='1'){
            int res=process(str,i+1);//i单独作为一部分转化
            if (i+1<str.length){
                res+=process(str,i+2);//i，i+1不越界可以作为一部分转化
            }
            return res;
        }
        if (str[i]=='2'){
            int res=process(str,i+1);
            if (i+1<str.length && str[i+1]>='0' && str[i+1]<='6'){
                res+=process(str,i+2);
            }
            return res;
        }
        //str[i]=='3'-'9'
        return process(str,i+1);
    }
    public static int dpWay(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N =str.length;
        int[] dp=new int[N+1];
        dp[N]=1;
        for(int i=N-1;i>=0;i--){
            if(str[i]=='0'){
                dp[i]=0;
            }
            else if(str[i]=='1'){
                dp[i]=dp[i+1];
                if (i+1<str.length) {
                    dp[i] += dp[i + 2];
                }
            }
            else if(str[i]=='2'){
                dp[i]=dp[i+1];
                if (i+1<str.length && str[i+1]>='0' && str[i+1]<='6') {
                    dp[i] += dp[i + 2];
                }
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        System.out.println(number("1111111"));
        System.out.println(dpWay("1111111"));
    }
}
