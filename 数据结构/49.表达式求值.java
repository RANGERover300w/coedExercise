import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    //解题思路:如果是遇到乘号就直接计算，如果是加号就放入站中，如果是减号就将负数放入站中，如果是括号，就将括号里的数字递归计算完成后，放入站中。最后将栈中的数字相加。
    public ArrayList<Integer> cal(String s, int index) {
        Stack<Integer> stack = new Stack<Integer>();
        char op = '+';
        int i;
        int num = 0;
        //遍历字符串
        for (i = index; i < s.length(); i++) {
            //如果是数字就将其变成数字压入栈中
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                //将其转换成int类型。
                num = num * 10 + s.charAt(i) - '0';
                if ( i != s.length() - 1)
                    continue;
            }
            //如果是左括号就递归进入
            if (s.charAt(i) == '(') {
                ArrayList<Integer> res = cal(s, i + 1);
                num = res.get(0);
                i = res.get(1);
                if (i != s.length() - 1)
                    continue;
            }
            //知道遇到下一个符号才算一整个个数字，然后进行压栈计算
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    int temp = stack.pop();
                    stack.push(temp * num);
                    break;
            }
            num = 0;
            //右括号结束递归
            if (s.charAt(i) == ')')
                break;
            else
                op = s.charAt(i);
        }
        int sum = 0;
        //栈中元素相加
        while (!stack.isEmpty())
            sum += stack.pop();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(sum);
        temp.add(i);
        return temp;
    }
    public int solve (String s) {
        // write code here
         ArrayList<Integer> res = cal(s, 0);
        return res.get(0);
    }
}