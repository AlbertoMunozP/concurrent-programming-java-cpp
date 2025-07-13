// COMPILACION : javac -cp .; %MPJ_HOME%/lib/mpj.jar distributedIntegers.java
// EJECUCION : mpjrun.bat -np 2 distributedIntegers

import java.util.ArrayList;
import java.util.List;
import mpi.*;
/**
 * El proceso master reparte la búsqueda de primos en un rango de 0 a 10 elevado a 7 equitativamente entre los esclavos. 
 * Cada esclavo responde con la cantidad de números primos que ha encontrado en su rango asignado.
 * Se suman mediante un Reduce y el proceso master imprime el resultado.
 * @version 1.0
 */
public class distributedIntegers {
	
	public static final int RANGO_TOTAL=1000;
	
	
	public static void main(String[] args) {
		MPI.Init ( args );
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int emisor = 0; int receptor = 1;
		int tag = 100; int unitSize = 10;
		int intervalos[]=new int[size];
		int[] nprimos = new int[1];
		if(rank==0) {
			
			int tamanyoBase=RANGO_TOTAL/size;
			int resto=RANGO_TOTAL%(intervalos.length-1);
			
			intervalos[0]=0;
			for(int i=1 ; i<intervalos.length;i++) 
				intervalos[i]=intervalos[i-1]+tamanyoBase;
		}
		MPI.COMM_WORLD.Bcast(intervalos,0,intervalos.length,MPI.INT,0);
		if(rank>0){
			
			nprimos[0]=0;
			for(int i=intervalos[rank-1];i<intervalos[rank];i++) {
				if(esPrimo(i)) {
					nprimos[0]++;
				}
			}
			MPI.COMM_WORLD.Reduce(nprimos,0,nprimos,0,1,MPI.INT,MPI.SUM,0);
			
		}
		MPI.Finalize();
		System.out.println("Numero de primos "+nprimos[0]);
	}
	
	
	public static List<Integer> calcularPrimos(int inicio,int fin) {
		List<Integer> primos=new ArrayList<>();
		for(int i=inicio;i<fin;i++) {
			if(esPrimo(i)) {
				primos.add(i);
			}
		}
		return primos;
	}
	
	public static boolean esPrimo(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}
