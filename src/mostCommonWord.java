import java.util.*;

public class mostCommonWord {
    public static String mostCommonWord(String p,String[] banned){
        Set<String> bannedWords=new HashSet<>();
        Map<String,Integer> count= new HashMap<>();
        int max=0;
        String res="";
        for(int i=0;i<banned.length;i++){
            bannedWords.add(banned[i]);
        }
        String[] words= p.toLowerCase().split("[!?,;. ]");
        for(String word:words){
            if(!bannedWords.contains(word) && word.length()>0){
                count.put(word, count.getOrDefault(word,0)+1);
            }
            if(max<count.get(word)){
                max=count.get(word);
                res=word;
            }
        }
        return res;
    }
}
