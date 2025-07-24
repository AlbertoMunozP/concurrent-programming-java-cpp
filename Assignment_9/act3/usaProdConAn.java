public class usaProdConAn extends Thread{
    private lesEscAN monitor;
    private boolean tipo;
    public usaProdConAn(lesEscAN m, boolean b){
        monitor = m;
        tipo = b;
    }
    public void run(){
        if (tipo){
            try {
                monitor.abrirescribir();
                monitor.cerrarescribir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        else {
            try {
                monitor.abrirlectura();
                monitor.cerrarlectura();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        lesEscAN mo = new lesEscAN();
        while (true){ 
            new usaProdConAn(mo,true).start();
            new usaProdConAn(mo,false).start();
        }

    }
}