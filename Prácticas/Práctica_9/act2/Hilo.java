import java.util.concurrent .*;

class Hilo extends Thread {
    CyclicBarrier barrera = null ;
    public Hilo (CyclicBarrier bar) {
        barrera = bar;    
    }

    public void run () {
        try {
            int i = barrera.await();
        } catch ( BrokenBarrierException e ) {} catch( InterruptedException e ) {}
            System.out.println("El hilo " + this . toString () + " paso la barrera ...") ;
    }
}


