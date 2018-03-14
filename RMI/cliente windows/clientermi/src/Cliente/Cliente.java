package Cliente;


import RMIEJEMPLO.RMIEJEMPLO;
import java.rmi.registry.*;
import java.util.*;

public class Cliente {
    
     public static void main(String[] args) {
         Cliente client = new Cliente();
         client.connectserver();
     }
    
    private void connectserver(){
        try {
            
            Registry registro = LocateRegistry.getRegistry("192.168.0.17",7777);
            RMIEJEMPLO RMI = (RMIEJEMPLO)registro.lookup("Ejemplo");
            List list = new ArrayList();
            list = RMI.get_articulo();
            System.out.println(list.get(2));
        }catch (Exception ex){
              System.out.println(ex);
        }
    }
}
