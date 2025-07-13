public class usamonitorImpresoras extends Thread{
    private monitorImpresoras m;
    private int imp;
    public usamonitorImpresoras(monitorImpresoras moni){
        m = moni;
        imp = 0;
    }
    public void run() {
        
        imp = m.pedirImpresora();
        System.out.println(Thread.currentThread().getName()+" usa la impresora "+imp);
        try{
            sleep(3000);
        }catch(InterruptedException e){}
        m.liberarImpresora(imp);
        
    }
    public static void main(String[] args) throws InterruptedException{

        monitorImpresoras mo = new monitorImpresoras(3);
        Thread hilos[] = new Thread[10];
        for(int j = 0; j < 10; j++)
                hilos[j] = new usamonitorImpresoras(mo);
                
        for(int j = 0; j < 10; j++){
            hilos[j].start();
        }    
        for(int j = 0; j < 10; j++){
            hilos[j].join();
        }
    }
}
