import java.util.*;

//使用插入排序对插进来的数进行排序，因为每次会插入一个数字，
public class Solution {
    ArrayList<Integer> val = new ArrayList<Integer>();
    public void Insert(Integer num) {
        if(val.isEmpty()){
            val.add(num);
        }else{
            int i = 0;
            for(; i < val.size();i++){
                if(num <= val.get(i)){
                    break;
                }
            }
            val.add(i, num);
        }
    }

    public Double GetMedian() {
        int n = val.size();
        if(n % 2==1){
            return (double)val.get(n/2);
        }else{
            double a = val.get(n/2);
            double b = val.get(n/2-1);
            return (a+b)/2;
        }
    }


}
