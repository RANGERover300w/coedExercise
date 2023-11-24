import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        //用hash存储下标和值
        int[] res = new int[0];
        HashMap<Integer,Integer> hash = new HashMap<>();
        //遍历数组
        for(int i = 0; i < numbers.length;i++){
            int temp = numbers[i];
            //如果这个数不能和hash里面的数求和等于target，就放进hash中，反之返回下标。
            if(!hash.containsKey(target-temp)){
                hash.put(numbers[i],i);
            }else{
                return new int[]{hash.get(target-temp)+1,i+1};
            }
        }
        return res;
    }
}