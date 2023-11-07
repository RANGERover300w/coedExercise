import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param target int整型 
     * @param array int整型二维数组 
     * @return bool布尔型
     */
    public boolean Find (int target, int[][] array) {
        // write code here
        if(array.length == 0){
            return false;
        }
        if(array[0].length == 0){
            return false;
        }
        int n = array.length - 1;
        int l = array[0].length - 1;
        int j = 0 ;
        while( n >=0 && j<=l) {  //此处用的并不是二分法，是以最左侧这一列，最下方为基准，如果大于就向右，如果小于就向上。然后依次寻找，超出长度就停止，代表没有找到。
            if(target > array[n][j]){
                j++;
            }else if(target < array[n][j]){
                n--;
            } else{
                return true;
            }
        } 
        return false;
    }
}