import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
     //建立一个优先队列，此队列自动排序。
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k == 0|| input.length == 0){
            return res;
        }
        //大顶堆
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        //将k个数存进大顶堆中
         for(int i =0; i < k; i++){
            q.offer(input[i]);
         }
         //将剩余的数存比较并存进大顶堆中 ,如果小于最大数就存放进去
         for(int i = k;i < input.length;i++){
            if(input[i] < q.peek()){
                q.poll();
                q.offer(input[i]);
            }
         }
         //将大顶堆存放进list中
         for(int i = 0;i< k;i++){
            res.add(q.poll());
         }
         return res;
    }
}