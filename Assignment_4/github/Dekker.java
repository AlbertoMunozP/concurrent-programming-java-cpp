/* Copyright (C) 2006 M. Ben-Ari. See copyright.txt */
/* Programmed by Panu Pitkämäki */

/* Dekker's algorithm */
class Dekker {
    /* Number of processes currently in critical section */
    static volatile int inCS = 0;
    /* Process p wants to enter critical section */
    static volatile boolean wantp = false;
    /* Process q wants to enter critical section */    
    static volatile boolean wantq = false;
      /* Process q wants to enter critical section */    
    static volatile boolean wantz = false;
    /* Which processes turn is it */
    static volatile int turn = 1;

    class P extends Thread {
        public void run() {
            while (true) {
                /* Non-critical section */
                wantp = true;
                while (wantq || wantz) {
                    if (turn == 2) {
                        wantp = false;
                        wantz = false;
                        while (turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                }
                inCS++;
                Thread.yield();
                /* Critical section */
                System.out.println("Hilo P");
                inCS--;
                turn = 2;
                wantp = false;
            }
        }
    }
    
    class Q extends Thread {
        public void run() {
            while (true) {
                /* Non-critical section */
                wantq = true;
                while (wantp || wantz) {
                    if (turn == 3) {
                        wantq = false;
                        wantp = false;
                        while (turn == 3)
                            Thread.yield();
                        wantq = true;
                    }
                }
                inCS++;
                Thread.yield();
                /* Critical section */
                System.out.println("Hilo Q");
                inCS--;
                turn = 3;
                wantq = false;
            }
        }
    }

    class Z extends Thread {
        public void run() {
            while (true) {
                /* Non-critical section */
                wantz = true;
                while (wantp || wantq) {
                    if (turn == 1) {
                        wantz = false;
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantz = true;
                    }
                }
                inCS++;
                Thread.yield();
                /* Critical section */
                System.out.println("Hilo Z");
                inCS--;
                turn = 1;
                wantz = false;
            }
        }
    }

    Dekker() {
        Thread p = new P();
        Thread q = new Q();
        Thread z = new Z();
        p.start();
        q.start();
        z.start();
    }

    public static void main(String[] args) {
        new Dekker();
    }
}