// COMPILACION : javac -cp .; %MPJ_HOME%/lib/mpj.jar escalMultiple.java
// EJECUCION : mpjrun.bat -np 5 escalMultiple

import java.util.Random;
import mpi.*;


/**
 * El proceso padre envía un array a todos los procesos hijos mediante Broadcast, cada proceso hijo multiplica todos los elementos
 * del vector por su número rank e imprime el vector.
 * @version 1.0
 */
public class escalMultiple {
	/**
	 * Punto de entrada al programa principal
	 * @param args
	 */
	public static void main(String[] args) {
		int array1[] = new int[10];
		MPI.Init ( args );
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int emisor = 0; int receptor = 1;
		int tag = 100; int unitSize = 10;
		if(rank==0) {
			Random rnd=new Random();
			for (int i=0;i<array1.length;i++) {
				//array1[i]=rnd.nextInt();
				array1[i]=2;
			}
			
			
		}
		MPI.COMM_WORLD.Bcast(array1,0,array1.length,MPI.INT,0);
		if(rank>0) {
			for (int i=0;i<array1.length;i++) {
				array1[i]=array1[i]*rank;
			}
			
			for (int i=0;i<array1.length;i++) {
				System.out.println("Proceso con rank  "+rank+" posicion "+i+" "+array1[i]);
			}
		}
		MPI.Finalize();
	}

}
