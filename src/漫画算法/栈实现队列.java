package 漫画算法;

import java.util.Stack;

/**
 * @Description 使用两个栈来实现队列
 *          队列是先进先出的
 *          栈是先进后出的
 * @Author Hasee
 * @Date 2022/5/2 20:35
 * @Version 1.0
 */
public class 栈实现队列 {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     * @param element
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队操作
     */
    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            transfer();
        }

        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        栈实现队列 stackQueue = new 栈实现队列();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
