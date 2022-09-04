package easy.链表相关;


/**
 * 单向链表，输入K，找到倒数第k个值
 */

/**
 *   代码解决
 *
 * 第一种做法
 *                    stack来实现， 先放到栈中， 然后倒数popK个出来即可；
 *
 *
 * 第二种做法
 *
 *                   使用快慢指针，两个指针， 让一个指针先走k步， 然后两个指针一起走，步长是1；
 * 然后当快的指针到达链表尾部的时候，慢的那个指针，直接就是k的位置了，取出即可
 */

public class 找到链表中的倒数第k个数 {


}

class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}