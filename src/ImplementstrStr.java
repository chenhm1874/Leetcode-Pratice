public class ImplementstrStr {
    public static int ImplementstrStr(String s,String needle){
        if(needle ==null || s==null){
            return 0;
        }
        int s1=s.length();
        int n1=needle.length();
        if(s1<n1){
            return -1;
        }
        for(int i=0;i<s1-n1+1;i++){
            int j=0;
            for( j=0;j<n1;j++){
                if(needle.charAt(j)!=s.charAt(i+j)){
                    break;
                }
            }
            if(j==n1){
                return i;
            }
        }
        return -1;
    }
}
