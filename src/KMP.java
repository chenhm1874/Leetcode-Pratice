public class KMP {
    public static int getIndexOf(String s,String m){
        if(s==null||m==null||s.length()<m.length()||m.length()<1){
            return -1;
        }
        char[] str1=s.toCharArray();
        char[] str2=m.toCharArray();
        int i1=0;
        int i2=0;
        int[] next=getNextArray(str2);
        while(i1< str1.length && i2< str2.length){
            if(str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if(next[i2]==-1){     //在next数组中只有0位置认为设置为-1
                i1++;
            }else{
                i2=next[i2];
            }
        }
        return i2==str2.length?i1-i2:-1;
    }
    //next数组计算方法，0，1，2位置人为规定，i位置由i-1位置值判断，下一个若和前缀下一个相等则+1，若不等就从前缀复用该方法
    public static int[] getNextArray(char[] ms){
        if(ms.length==1){
            return new int[] {-1};
        }
        int[] next=new int[ms.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cn=0;       //与i-1位置比较的位置
        while(i<next.length){
            if(ms[i-1]==ms[cn]){
                next[i++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                next[i++]=0;
            }
        }
        return next;
    }
}
