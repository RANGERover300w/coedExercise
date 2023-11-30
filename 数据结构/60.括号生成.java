import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public void recursion(ArrayList<String> res, String temp, int left, int right,
                          int n) {
        if (left == n && right == n) {
            res.add(temp);
            return;
        }
        if (left < n) {
            recursion(res, temp + "(", left + 1, right, n);
        }
        if (right < n && left > right) {
            recursion(res, temp + ")", left, right + 1, n);
        }
    }
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res = new ArrayList<String>();
        //递归
        recursion(res,"",0,0,n);
        return res;
    }
}