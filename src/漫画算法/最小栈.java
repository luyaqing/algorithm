package 漫画算法;

import java.util.Stack;

/**
 * @Description 实现一个最小栈  入栈、出栈、获取最小元素， 三个操作的时间复杂度都是O(1)的
 * @Author Hasee
 * @Date 2022/4/19 16:29
 * @Version 1.0
 */
public class 最小栈 {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        if (minStack.empty() || minStack.peek() >= element) {
            minStack.push(element);
        }
        mainStack.push(element);
    }

    public Integer pop() {
        if (mainStack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() {
        if (mainStack.empty()) {
            System.out.println("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
