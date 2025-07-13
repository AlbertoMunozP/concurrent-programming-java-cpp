import java.rmi.*;
import java.rmi.registry.*;

public class sBonoLoto{

  public static void main(String[] args) throws Exception{
    int a =  10;
    int b = -10;
    //SIEMPRE debe convertirse el retorno del metodo Naming.lookup a la interfaz remota
		
  iBonoLoto RefObRemoto =  (iBonoLoto)Naming.lookup("//localhost/Servidor");
	int c = {1,1,1,1,1,1}	  	
    if(RefObRemoto.compApuesta(c))
        System.out.println("No es correcta");
    else
    System.out.println("Es correcta");
  }	
}	