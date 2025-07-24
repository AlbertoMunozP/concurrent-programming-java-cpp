import java.util.concurrent.*;

public class ccSem{
    private static int saldo;
    private static Semaphore sem = new Semaphore(1);
    public ccSem(){
        saldo = 0;
    }
    public void ingreso (int cuantia){
        try{
            sem.acquire();
        } catch (InterruptedException e){}
        saldo += cuantia;
        sem.release();
    }
    public int saldo() {return saldo;}
    public void reintegro(int cuantia){
        try{
            sem.acquire();
        } catch (InterruptedException e){}
        if(saldo >= cuantia)
            saldo -= cuantia;
        sem.release();    
}
}
