import java.util.*;
import java.util.Stack;

public class Solution {

    //用第二个栈来存放最小的数
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack(); 
    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty()||s2.peek()>node){
            s2.push(node);
        }else{//如果新节点比较大，就将之前的节点重复入栈
        s2.push(s2.peek());
        }
    }
    
    public void pop() {
        //记录最小值的栈也要跟着出战
        s1.pop();
        s2.pop();
    }
    
    public int top() {
       return s1.peek();
    }
    
    public int min() {
       return s2.peek();
    }
}
