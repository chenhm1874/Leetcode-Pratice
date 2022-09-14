public class LongestSubstring {
    public int longestSubstring(String s){
        int longest=0;
        int[] nextIndex=new int[128];
        int n=s.length();
        for(int r=0,l=0;r<n;r++){
            l = Math.max(nextIndex[s.charAt(r)], l);
            longest = Math.max(longest, r - l + 1);
            nextIndex[s.charAt(r)] = r + 1;
        }
        return longest;
    }
}
