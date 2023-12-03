import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @return int整型
     */
    public int Fibonacci (int n) {
        // write code here
        if(n == 2 || n ==1){
            return 1;
        }else{
            return Fibonacci(n -1 )+Fibonacci(n -2 );
        }
    }
}