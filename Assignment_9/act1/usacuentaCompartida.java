public class usacuentaCompartida extends Thread{
    private cuentaCompartida c;
    private boolean b;
    public usacuentaCompartida(cuentaCompartida c, boolean tipo){
        this.c = c;
        b = tipo;
    }
    public void run(){
       while (true) {
        if(b)
            c.reintegro(1000);        
        else
            c.ingreso(100);
        System.out.println(c.saldo());    //presentará entrelazado pero nos vale
        }
    }
    public static void main(String[] args) throws InterruptedException{
        cuentaCompartida c = new cuentaCompartida();
        usacuentaCompartida i = new usacuentaCompartida(c,true);
        usacuentaCompartida r = new usacuentaCompartida(c,false );
        i.start(); r.start();
        i.join(); r.join();

    }
}
