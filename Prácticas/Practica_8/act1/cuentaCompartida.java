public class cuentaCompartida{
    private static int saldo;
    public cuentaCompartida(){
        saldo = 0;
    }
    public synchronized void ingreso(int cuantia){
        saldo += cuantia;
        notifyAll();
    }
    public synchronized int saldo() {return saldo;}
    public synchronized void reintegro(int cuantia){
        while (saldo < cuantia) {
            try{
                wait();
            }catch(InterruptedException e){}
        }
        saldo -= cuantia;
        notifyAll();
    }

}
