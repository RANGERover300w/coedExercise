import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型
     */
    //从第一个数开始遍历，如果此点加上前一个点的和小于此点，那么新数组将从词典开始。
    public int FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int max = array[0];
        int sum = 0;
        for(int i = 0;i<array.length;i++){
            //存下前面的最大值
            sum = Math.max(sum+array[i],array[i]);
            //保存最大和
            max = Math.max(max,sum);
        }
        return max;
    }
}