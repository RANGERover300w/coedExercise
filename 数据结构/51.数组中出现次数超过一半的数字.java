import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    //解法是遍历数组，如果不存在key就加入，如果存在key就+1
    //如果值大于一半就返回
    public int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        HashMap<Integer, Integer> hash = new HashMap<>();
        //遍历数组
        for (int i = 0; i < numbers.length ; i++) {
            if (!hash.containsKey(numbers[i])) {
                hash.put(numbers[i], 1);
            } else {
                hash.put(numbers[i], hash.get(numbers[i]) + 1);
            }
            if (hash.get(numbers[i]) > numbers.length / 2) {
            return numbers[i];
        }
        }
        return 0;
    }
}