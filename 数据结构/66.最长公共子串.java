import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    //本题的最优解法就是使用一维数组记录最长的公共子串。
    //因为在同一个字符串有两个相同的字符与零一字符串字符相同的话，要保存第一个，用来继续遍历，但是如果j是正序的话，走完一次j就保留的最后一个相同字母
    public String LCS (String str1, String str2) {
        // write code here
        int maxLenth = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[] dp = new int[str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = str2.length() ; j > 0 ; j--) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                    if (dp[j] > maxLenth) {
                        maxLenth = dp[j];
                        maxLastIndex = i-1;
                    }
                }else{
                    dp[j] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1); 
    }
}