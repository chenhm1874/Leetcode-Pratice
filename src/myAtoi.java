public class myAtoi {
    public static int myAtoi(String s){
        if(s==null){
            return 0;
        }
        s=s.trim();
        if (s.length()==0){
            return 0;
        }
        int flag=1;
        long ans=0;
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        if(s.charAt(0)=='-'){
            flag=-1;
        }
        int i=s.charAt(0)=='-'? 1:0;
        while(i<s.length()){
            if(s.charAt(i)==' '|| !Character.isDigit(s.charAt(i))){
                break;
            }
            ans=ans*10+(s.charAt(i)-'0');
            if(flag==-1&& flag*ans<min){
                return min;
            }
            if(flag==1 && ans>max){
                return max;
            }
            i++;
        }
        return (int) ((int)flag*ans);
    }
    public static void main(String args[]){
        String s1="     -1111     ";
        int x= myAtoi(s1);
        System.out.println(x);
    }
}
