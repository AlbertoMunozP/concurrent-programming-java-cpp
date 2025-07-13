/*Ejemplo de servidor de sockets multihilo
 *@Alberto Munoz Pina
 *@version 2.0
*/


import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

public class ServidorHiloconPool implements Runnable {
	Socket enchufe;
	static ThreadPoolExecutor pool=new ThreadPoolExecutor(10,500,2,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(500));
	
	public ServidorHiloconPool(Socket s) {
		enchufe = s;
		pool.execute(this);
	}

	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
			String datos = entrada.readLine();
			int j;
			int i = Integer.valueOf(datos).intValue();
			for (j = 1; j <= 20; j++) {
				System.out.println("El hilo " + this.getName() + " escribiendo el dato " + i);
				Thread.sleep(1000);
			}
			enchufe.close();
			System.out.println("El hilo " + this.getName() + "cierra su conexion...");
		} catch (Exception e) {
			System.out.println("Error...");
		}
	}
	
	public static void main(String[] args) {
		
		int puerto = 2001;
		
		
		try {
			ServerSocket chuff = new ServerSocket(puerto, 3000);

			while (true) {
				System.out.println("Esperando solicitud de conexion...");
				Socket cable = chuff.accept();
				System.out.println("Recibida solicitud de conexion...");
				new ServidorHiloconPool(cable);
				chuff.close();
			} 
		} catch (Exception e) {
			System.out.println("Error en sockets...");
		}
	}
	
	public String getName() {
		return "Servidor";
	}

}