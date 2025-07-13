import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz que hereda las funcionalidades de Remote y además define otros métodos
 * @version 1.0
 */
public interface iPiMonteCarlo extends Remote{

	public void aceptarContribucion(int c[]) throws RemoteException;
	/**
	 * Obtiene la aproximación de la integral.
	 * @return
	 * @throws RemoteException
	 */
	public double getAproximacion() throws RemoteException;
	/**
	 * Obtiene el número de puntos que se encuentran debajo de la curva.
	 * @return
	 * @throws RemoteException
	 */
	public double getPuntosDebajo() throws RemoteException;
	/**
	 * Obtiene el número de puntos generados en total
	 * @return
	 * @throws RemoteException
	 */
	public double getPuntosTotal() throws RemoteException;
	
}
