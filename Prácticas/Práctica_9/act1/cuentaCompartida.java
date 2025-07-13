import java.util.concurrent.locks.*;

public class cuentaCompartida{
    private static int saldo;
    final Lock cerrojo = new ReentrantLock();
    final Condition suficiente = cerrojo.newCondition();
    public cuentaCompartida(){
        saldo = 0;
    }
    public void ingreso(int cuantia){
        cerrojo.lock();
        try {
        saldo += cuantia;
        suficiente.signalAll();
        } finally {
            cerrojo.unlock();
        }
    }
    public int saldo() {return saldo;}
    public void reintegro(int cuantia){
        cerrojo.lock();
        try{
            while (saldo < cuantia) {
                try{
                    suficiente.await();
                }catch(InterruptedException e){}
            }
        saldo -= cuantia;    
        } finally {
            cerrojo.unlock();
        }
    }

}
