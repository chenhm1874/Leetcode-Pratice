import java.util.HashMap;

//给定一个字符串str，给定一个字符串类型的数组arr，arr中的每个字符串代表一张贴纸，贴纸中的每个字母都可以单独剪出来用
//最终要拼出str来，请返回最少需要的贴纸数
public class StringToStickers {
    public static int minStickers1(String target,String[] stickers){
        int n= stickers.length;;
        int[][] map=new int[n][26];
        for (int i=0;i<n;i++){
            char[] str=stickers[i].toCharArray();
            for(char c:str){
                map[i][c-'a']++;
            }
        }
        //dp为单纯的缓存结构
        HashMap<String,Integer> dp=new HashMap<>();
        dp.put("",0);
        return process1(dp,target,map);
    }
    //若t已经被计算过，则直接返回dp表中的值
    //0..N每一个字符的词频统计
    public static int process1(HashMap<String,Integer> dp,String rest,int[][] map){
        if (dp.containsKey(rest)){
            return dp.get(rest);
        }
        int ans=Integer.MAX_VALUE;
        int n=map.length;
        int[] tmap=new int[26];
        char[] target=rest.toCharArray();
        for(char c:target){
            tmap[c-'a']++;
        }
        //map->tmap
        for(int i=0;i<n;i++){
            if(map[i][target[0]-'a']==0){
                continue;
            }//保证选中的sticker至少有剩余字符串中的其中一种字符，避免出现选中sticker的所有字母都不在字符串中，进入死循环
            StringBuilder sb=new StringBuilder();
            //i贴纸，j枚举A-Z字符
            for(int j=0;j<26;j++){
                if(tmap[j]>0){
                    for (int k=0;k<Math.max(0,tmap[j]-map[i][j]);k++){
                        sb.append((char) ('a'+j));
                    }
                }
            }
            String s=sb.toString();
            int tmp=process1(dp,s,map);
            if(tmp!=-1){
                ans=Math.min(ans,1+tmp);
            }
        }
        dp.put(rest,ans==Integer.MAX_VALUE ? -1:ans);
        return dp.get(rest);
    }
    public static void main(String[] args){
        String[] arr={"aaaa","bbaa","ccddd"};
        String str="abccccddddddaaabbb";
        System.out.println(minStickers1(str,arr));
    }
}
