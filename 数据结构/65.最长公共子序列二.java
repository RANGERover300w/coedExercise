import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    //维护dp二维数组，遍历两个字符串。双层for循环，之后如果遇到相等的字符串就存进dp中，并在二维数组b中记录方向。
    private String x = "";
    private String y = "";
    String ans(int i, int j, int[][] b) {
        String res = "";
        //递归终止条件
        if (i == 0 || j == 0)
            return res;
        //根据方向，往前递归，然后添加本级字符
        if (b[i][j] == 1) {
            res += ans(i - 1, j - 1, b);
            res += x.charAt(i - 1);
        } else if (b[i][j] == 2)
            res += ans(i - 1, j, b);
        else if (b[i][j] == 3)
            res += ans(i, j - 1, b);
        return res;
    }
        public String LCS (String s1, String s2) {
            // write code here
            if (s1.length() == 0 || s2.length() == 0)
                return "-1";
            int len1 = s1.length();
            int len2 = s2.length();
            x = s1;
            y = s2;
            int dp[][] = new int [len1 + 1][len2 + 1];
            int[][] b = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    //如果第i位和s2的第j位相等
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        b[i][j] = 1;
                    } else {
                        //如果i向前一位 公共序列比较大
                        //左边的选择更大，即第一个字符串后退一位
                        if (dp[i - 1][j] > dp[i][j - 1]) {
                            dp[i][j] = dp[i - 1][j];
                            //来自于左方
                            b[i][j] = 2;
                        }
                        //右边的选择更大，即第二个字符串后退一位
                        else {
                            dp[i][j] = dp[i][j - 1];
                            //来自于上方
                            b[i][j] = 3;
                        }
                    }
                }
            }
            String res = ans(len1, len2, b);
            //检查答案是否位空
            if (res.isEmpty())
                return "-1";
            else
                return res;
        }
    }