package Amazon;

import java.util.HashMap;

public class longestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        // maxFreq 以打擂台的方式记录出现最多的字符数量
        int j = 0, answer = 0, maxFreq = 0, count;
        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 当j作为下标合法 且 最少需要被替换的字母数目<=k
            while (j < s.length() && j - i - maxFreq <= k) {
                count = counter.getOrDefault(s.charAt(j), 0) + 1;
                counter.put(s.charAt(j), count);
                // 更新出现最多的字符数量
                maxFreq = Math.max(maxFreq, count);
                j++;
            }
            // 如果替换 除出现次数最多的字母之外的其他字母 的数目>k,
            // 说明有一个不能换，答案与j-i-1进行比较；
            // 否则说明直到字符串末尾替换数目都<=k，可以全部换掉
            // 答案与子串长度j-i进行比较
            if (j - i - maxFreq > k) {
                answer = Math.max(answer, j - i - 1);
            }
            else {
                answer = Math.max(answer, j - i);
            }
            // 起点后移一位，当前起点位置的字母个数-1
            count = counter.get(s.charAt(i)) - 1;
            counter.put(s.charAt(i), count);
        }
        return answer;
    }
}
