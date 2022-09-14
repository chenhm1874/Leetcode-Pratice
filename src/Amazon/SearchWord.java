package Amazon;

public class SearchWord {
    public static int SearchWord(String search,String result){
         if(result==null ||result.length()==0){
             return -1;
         }
         int n1=0;
         int n2=0;
         while(n1<search.length()){
             if(search.charAt(n1)==result.charAt(n2)){
                 n2+=1;
                 if(n2==result.length()){
                     return 0;
                 }
             }
             n1+=1;
         }
         return result.length()-n2;
    }

    public static void main(String[] args) {
        String s="armaze";
        String r="amazon";
        int ans=SearchWord(s,r);
        System.out.println(ans);
    }
}
