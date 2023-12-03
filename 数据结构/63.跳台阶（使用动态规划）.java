import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param number int整型 
     * @return int整型
     */
    int count = 0;
    public int jumpFloor (int number) {
        // write code here
       int a = 1;//表示第0阶
       int b = 1;//表示第一阶；
       int c = 1;//临时变量
       for(int i = 2; i <= number;i++){
        c = a+b; a = b; b = c; //一个一个向前导。 //这里的 b 表示前一节， a表示后一姐，c表示其和也就是下一届。
       }
       return c;
    }
}