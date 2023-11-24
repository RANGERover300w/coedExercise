import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型一维数组
     */
     //用hash存放次数和值
    public int[] FindNumsAppearOnce (int[] nums) {
        // write code here
        //遍历数组如果发现相同的就加1
        HashMap<Integer,Integer> hash = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i< nums.length;i++){
            if (!hash.containsKey(nums[i])){
                hash.put(nums[i],1);
            }else{
                hash.put(nums[i],hash.get(nums[i])+1);
            }
        }
        //放入arraylist中
        for(int i = 0 ; i < nums.length; i++){
            if(hash.get(nums[i]) == 1){
                res.add(nums[i]);
            }
        }
        if(res.get(0) > res.get(1)){
            return new int[]{res.get(1),res.get(0)};
        }else{
            return new int[]{res.get(0),res.get(1)};
        }
    }
}