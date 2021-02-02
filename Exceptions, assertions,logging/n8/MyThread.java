package n8;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements   Runnable {
    Resource res;
    ReentrantLock locker;


    MyThread(Resource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }

    public  void run() {
        locker.lock(); // устанавливаем блокировку
        try {
            res.x = 1;
            for (int i = 0; i < 3; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }


    }
}