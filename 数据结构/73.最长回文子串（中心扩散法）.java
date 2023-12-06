import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param A string字符串 
     * @return int整型
     */
    //解决方法一：使用发散思想分为奇数 偶数回文结构，遍历字符串以每个数为基点向两边扩散。
    public int fun(String A ,int begin,int end){
        while(begin >= 0 && end < A.length()&&A.charAt(begin) == A.charAt(end)){
            begin--;
            end++;
        }
            return end - begin -1;
        }
    public int getLongestPalindrome (String A) {
        // write code here
        
        int maxLen = 1;
        int max = 0;
        for(int i = 0;i < A.length();i++){
            maxLen = Math.max(fun(A,i,i),fun(A,i,i+1));
            max = Math.max(max,maxLen);
        }
        return max;
    }
}