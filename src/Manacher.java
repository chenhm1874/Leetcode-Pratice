public class Manacher {
    //将一个字符串转化成每个字符都用#隔开
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(s);
        int[] pArr = new int[charArr.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;     //包含多种情况：i在R外，则至少不用验证的回文长度为1，除此之外i关于C的对称点i'的回文半径是否在整个L。。R之间
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {      //对于所有情况都进行往外扩，最多失败一次，该操作的时间复杂度O（n）
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {     //不越界
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {      //更新右边界以及获得右边界是的中心点
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;     //由于之前扩写过，故最终答案要减去1

    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
