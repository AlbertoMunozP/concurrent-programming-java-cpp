import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Clase que representa al servidor
 * @version 1.0
 */
public class PiMonteCarlo implements iPiMonteCarlo{
	/**
	 * Representa el total de puntos generados.
	 */
	private int puntosTotal=0;
	/**
	 * Representa el número de puntos bajo la curva
	 */
	private int puntosPorDebajo=0;
	
	
	
	@Override
	public double getAproximacion() throws RemoteException{
		return 4*(double)puntosPorDebajo/(double)puntosTotal;
	}
	
	public static void main(String args[]) throws RemoteException {
		iPiMonteCarlo b=new PiMonteCarlo();
		iPiMonteCarlo stub=(iPiMonteCarlo)UnicastRemoteObject.exportObject((iPiMonteCarlo)b, 0);
		
		Registry reg=LocateRegistry.createRegistry(1099);
		reg.rebind("iPiMonteCarlo", stub);
	}

	@Override
	public void aceptarContribucion(int[] c) throws RemoteException {
		puntosTotal+=c[1];
		puntosPorDebajo+=c[0];
	}
	
	@Override
	public double getPuntosDebajo() throws RemoteException{
		return puntosPorDebajo;
	}
	
	@Override
	public double getPuntosTotal() throws RemoteException{
		return puntosTotal;
	}

}
