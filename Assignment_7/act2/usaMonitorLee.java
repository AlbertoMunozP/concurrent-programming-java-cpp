public class usaMonitorLee extends Thread{
    private monitorLE monitor;
    private boolean tipo;
    public usaMonitorLee(monitorLE m, boolean b){
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
        monitorLE mo = new monitorLE();
        while (true){ 
            new usaMonitorLee(mo,true).start();
            new usaMonitorLee(mo,false).start();
        }

    }
}