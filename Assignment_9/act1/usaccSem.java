public class usaccSem extends Thread{
    private ccSem c;
    private boolean b;
    public usaccSem(ccSem c, boolean tipo){
        this.c = c;
        b = tipo;
    }
    public void run(){
       while (true) {
        if(b)
            c.reintegro(10000);
        else
            c.ingreso(100);
            
        System.out.println(c.saldo());    //presentará entrelazado pero nos vale
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ccSem c = new ccSem();
        new usaccSem(c,true).start();
        new usaccSem(c,false).start();
    }
}
