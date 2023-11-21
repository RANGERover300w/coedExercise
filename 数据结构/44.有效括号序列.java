import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串 
     * @return bool布尔型
     */
     //注意括号的特性，最后一次入栈的其右侧最近的括号一定是其反括号。
     //解法是如果是左括号就将其反括号压入栈，如果有发括号出现，一定和栈顶匹配。
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }
            else if(s.charAt(i) =='{'){
                stack.push('}');
            }else if(s.charAt(i) == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != s.charAt(i)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}