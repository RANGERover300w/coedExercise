import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @return int整型ArrayList<ArrayList<>>
     */
     //首先是要排序，排序好后，使用双指针，将第一个数作为基数，我们的目标是再找两个数，和这个数相加为0那么其和就是这个数的负数。接着使用双指针，移动指针，知道找到。
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = num.length;
        if(n<3) { //如果个数小于三个就不符合条件
            return res;
        }
        //排序
        Arrays.sort(num);
        //遍历数组到倒数第三个
        for(int i = 0; i< n - 2;i++){
            //如果有重复的数就跳过一下。
            if(i!= 0 && num[i] ==  num[i-1]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            int targrt = -num[i];
            while(left< right){
                if(num[left] + num[right] == targrt){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    res.add(temp);
                    //如果找到了还要继续寻找，首先就要去重。
                    while(left +1  < right && num[left] == num[left+1]){
                        left++;
                    }
                    //left和right不能相遇，如果相遇了去判断就没有意义了，两个相同的值了，不符合题意。
                    while(right-1 > left && num[right] == num[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(num[left] + num[right] > targrt){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}