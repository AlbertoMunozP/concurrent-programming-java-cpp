import java.util.Random;

public class usaPC extends Thread{
    private buffer_acotado b;
    private boolean tipo;
    public usaPC(buffer_acotado bb, boolean t){
        b = bb;
        tipo = t;
    }
    public void run(){
        Random r = new Random(System.currentTimeMillis());
        if(tipo)
            try {
                b.put(r.nextInt()%11);
            } catch (InterruptedException e) {}
            
        else
            try {
                System.out.println(b.take());
            } catch (InterruptedException e) {}    
    }
    public static void main(String[] args) {
        buffer_acotado buffer = new buffer_acotado();
        while (true) {
            new usaPC(buffer, true).start();
            new usaPC(buffer, false).start();
        }
    }
}
