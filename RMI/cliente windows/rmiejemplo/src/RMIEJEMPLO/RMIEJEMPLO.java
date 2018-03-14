package RMIEJEMPLO;


import java.rmi.*;
import java.util.*;

public interface RMIEJEMPLO extends Remote {
     public String Funciona() throws RemoteException;
     public List<String> get_articulo() throws RemoteException;
     public String save_user(String cedula, String nombre, String correo, String passw) throws RemoteException;
     public String loggin(String usuario,String passw)throws RemoteException;
     public String crear_compra(String nombre,  String monto)throws RemoteException;
     public String terminar_compra(String[][] articulos,String nombre)throws RemoteException;
    
}
