import java.util.*;
//Con el API estandar
public class monitorLE{
    private static int n = 0;
    private static int numLectores = 0;
    private static boolean escribiendo = false;
    public monitorLE(){}
    public synchronized void abrirlectura() throws InterruptedException{
        while (escribiendo) {wait();}
        numLectores++;
        System.out.println(n);
        notifyAll();
    }
    public synchronized void abrirescribir() throws InterruptedException{
        while (numLectores != 0 || escribiendo) {wait();}
        escribiendo = true;
        n++;
    }
    public synchronized void cerrarlectura(){
        numLectores--;
        if (numLectores == 0) {notifyAll();}
    }
    public synchronized void cerrarescribir(){
        escribiendo = false;
        notifyAll();
    }
}