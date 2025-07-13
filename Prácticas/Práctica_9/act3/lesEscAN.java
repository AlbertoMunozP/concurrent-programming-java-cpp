import java.util.*;
import java.util.concurrent.locks.*;
//Con el API de alto nivel
public class lesEscAN{
    private static int n = 0;
    private static int numLectores = 0;
    private static boolean escribiendo = false;
    final Lock cerrojo = new ReentrantLock(); 
    final Condition noEscritor = cerrojo.newCondition();
    final Condition noLector = cerrojo.newCondition();
    public lesEscAN(){}
    public void abrirlectura() throws InterruptedException{
        cerrojo.lock();
        try{
            while (escribiendo) {noEscritor.await();}
            numLectores++;
            System.out.println(n);
        } finally {
            cerrojo.unlock();
        }
    }

    public void abrirescribir() throws InterruptedException{
        cerrojo.lock();
        try{
            while (numLectores != 0 && escribiendo) {noLector.await();}
            escribiendo = true;
            n++;
        } finally {
            cerrojo.unlock();
        }
        
    }
    public void cerrarlectura(){
        cerrojo.lock();
        try{
            numLectores--;
            if (numLectores == 0) {
                noLector.signalAll();
                noEscritor.signalAll();
            }
            
        } finally {
            cerrojo.unlock();
        }
        
    }
    public void cerrarescribir(){
        cerrojo.lock();
        try{
            escribiendo = false;
            noLector.signalAll();
            noEscritor.signalAll();
        } finally {
            cerrojo.unlock();
        }       
    }
}