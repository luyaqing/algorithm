package 面试遇到的;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按顺序打印ABC
 */
public class ThreadTest2 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition cA = lock.newCondition();
    private static Condition cB = lock.newCondition();
    private static Condition cC = lock.newCondition();

    private static CountDownLatch latchB = new CountDownLatch(1);
    private static CountDownLatch latchC = new CountDownLatch(1);

    public static void main(String[] args) {


        Thread threadA = new Thread(() -> {

            lock.lock();

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    cB.signal();
                    if (i == 0) latchB.countDown();
                    cA.await();
                }
                cB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "threadA");

        Thread threadB = new Thread(() -> {

            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    cC.signal();
                    if (i == 0) latchC.countDown();
                    cB.await();
                }
                cC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "threadB");

        Thread threadC = new Thread(() -> {

            lock.lock();

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    cA.signal();
                    if (i == 0) latchC.countDown();
                    cC.await();
                }
                cA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "threadB");

        threadA.start();
        threadB.start();
        threadC.start();

    }

}
