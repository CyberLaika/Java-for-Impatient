package n8;

import java.util.concurrent.locks.ReentrantLock;

public class Main8 {
    public static void main(String[] args) {
        Resource resource= new Resource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 0; i < 3; i++){
            Thread t = new Thread(new MyThread(resource, locker));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}
