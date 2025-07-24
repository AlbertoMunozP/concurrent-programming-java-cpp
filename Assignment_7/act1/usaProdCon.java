import java.util.Random;

public class usaProdCon extends Thread{
    private static PCMonitor pc = new PCMonitor();
    private boolean type;
    public usaProdCon(boolean t) {
        type = t;
    }
    public void run() {
        if(type){
            Random r = new Random(System.nanoTime());
            pc.Append(r.nextInt(0, 100));
        }   
        else    
            pc.Take();
    }

    public static void main(String[] args) {
        new usaProdCon(true).start();
        new usaProdCon(true).start();
        new usaProdCon(true).start();
        new usaProdCon(true).start();
        new usaProdCon(false).start();
        
    }
}