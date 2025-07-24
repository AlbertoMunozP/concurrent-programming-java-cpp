import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Clase que representa al cliente
 * @version 1.0
 */
public class cPiMonteCarlo {
	

	
	public class intDefinidaMonteCarlo {
		
		
		private static class F1 implements Function<Double,Double>{

			@Override
			public Double apply(Double x) {
				return Math.sqrt(1-x*x);
			}
		}
				
		/**
		 * Punto de entrada al programa principal que calcula la integral del cos x entre 0 y 1
		 * @param args
		 */
		public static void main(String args[]) throws RemoteException, NotBoundException {
			 
				Registry reg=LocateRegistry.getRegistry();
				iPiMonteCarlo b=(iPiMonteCarlo)reg.lookup("iPiMonteCarlo");
				Random rnd=new Random();
				int n=rnd.nextInt(1000)+1;
				
				int r[]=aproximarIntegral(new F1(),n);
				
				b.aceptarContribucion(r);
				System.out.println(b.getAproximacion());
				
			}
			
		}
		
		
		private static int[] aproximarIntegral(Function<Double,Double> f, int npuntos) {
			
			int nPuntosDebajo=0;
			
			for(int i=0; i<npuntos; i++) {
				double xr=Math.random();
				double yr=Math.random();
				double y=f.apply(xr);
				if(yr<y) {
					nPuntosDebajo++;
				}
				
			}
			
			return new int[] {nPuntosDebajo,npuntos};
			
		}
		
		
	}


