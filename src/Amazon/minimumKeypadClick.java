package Amazon;

import java.util.Arrays;

public class minimumKeypadClick {
    public static int minimumKeypadClick(String s){
        int[] letter=new int[26];
        int result=0;
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)-'a']++;
        }
        Arrays.sort(letter);
        for(int i=letter.length-1;i>0;i--){
            if(letter[i]==0){
                break;
            }
            if(i>=17){
                result+=letter[i];
            }
            else if(i<17 && i>=9){
                result+=letter[i]*2;
            }
            else {
                result+=letter[i]*3;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s="adsbdsnklgg";
        int ans=minimumKeypadClick(s);
        System.out.println(ans);
    }
}
