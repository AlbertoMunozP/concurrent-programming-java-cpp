import java.util.concurrent.*;
public class UsaBarreras {
 public static void main ( String [] args ) {
    int numHilos = 3;  
    CyclicBarrier PasoANivel = new CyclicBarrier ( numHilos ) ;
    new Hilo(PasoANivel).start();
    new Hilo(PasoANivel).start();
    new Hilo(PasoANivel).start();
 
}
}