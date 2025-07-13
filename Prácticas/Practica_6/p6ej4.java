package p6ej4;

public class deadlock {

   public static class hilo extends Thread {
        private Object lock1;
        private Object lock2;

        public hilo(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " tiene el lock1");
                try {
                    Thread.sleep(100); // Simular trabajo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " tiene el lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        hilo thread1 = new hilo(lock1, lock2);
        hilo thread2 = new hilo(lock2, lock3);
        hilo thread3 = new hilo(lock3, lock1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
