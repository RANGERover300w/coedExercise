import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) { //使用双指针的方法，两个指针分别遍历两个字符串。
        // write code here
        int n1 = version1.length();
        int n2 = version2.length();

        int i = 0;
        int j = 0;
        while(i < n1 || j <n2){//只要有一个字符串没有遍历完，就继续遍历。
        long num1 = 0;//当第一个字符串遍历完成之后，再循环的时候将数字赋值为0；
        while(i < n1 && version1.charAt(i) != '.'){//将. 之前的数字都取出来  一位一位取
           num1 = num1*10 +(version1.charAt(i) - '0');//将字符串转换为数字 通过ASCII num1*10的作用是进位。
           i++;
        }
        i++;//将.跳过
        long num2 = 0;
        while(j < n2 && version2.charAt(j) != '.'){
            num2 = num2*10 + (version2.charAt(j) - '0');
            j++;
        }
        j++;
        if(num1 > num2){
            return 1;
        }
        if(num1 < num2){
            return -1;
        }
      }
        
        return 0;
    }
}