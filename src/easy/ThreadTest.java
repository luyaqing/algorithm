package easy;

/**
 * @Description
 * @Author Hasee
 * @Date 2022/4/28 11:04
 * @Version 1.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println("AAA");
        },"threadA");

        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BBB");
        },"threadB");

        Thread c = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CCC");
        },"threadC");

        a.start();
        b.start();
        c.start();
    }
}
