import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;
import java.rmi.registry.*;
import java.net.*;
 
 public class cBonoloto
   extends UnicastRemoteObject //el servidor debe siempre extender esta clase
     implements iBonoLoto   //el servidor debe simpre implementar la interfaz remota definida con caracter previo
 {
   private int numeros[];
   public void resetServidor() throws RemoteException {}  
   public boolean compApuesta(int[] apuesta) throws RemoteException {
        if(apuesta.length!=numeros.length)
            return false;
        else{
            boolean b = true;
            for(int i = 0; i < apuesta.length && b; i++)
                b = (apuesta[i]==numeros[i]);
            return b;
        }

   }

 	
  //es necesario como minimo el constructor (nulo) para lanzar RemoteException
  public cBonoloto() throws RemoteException{
        Random rand = new Random();
		numeros=new int[6];
		int nGenerados=0;
		while(nGenerados<6) {
			//generar aleatorio n entre 1 y 49
			int n=rand.nextInt(49)+1;
			// guardarlo en la posicion nGenerados
			numeros[nGenerados]=n;
			// incrementar nGenerados
			nGenerados++;

		}
		for(int i=0; i<numeros.length; i++) {
			System.out.print(numeros[i]+" ");
		}

  }  
 	
  //el metodo main siguiente realiza el registro del servicio
 	
  public static void main(String[] args) throws Exception{
    //Se crea el objeto remoto. Podriamos crear mas si interesa.
    iBonoLoto ORemoto = new cBonoloto();
    //Se registra el servicio
    Naming.bind("Servidor", ORemoto);
    System.out.println("Servidor Remoto Preparado");
  }	  
}	                              
                               