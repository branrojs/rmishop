package SERVIDOR;

import RMIEJEMPLO.RMIEJEMPLO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RMISERVIDOR extends UnicastRemoteObject implements RMIEJEMPLO{
    public RMISERVIDOR() throws RemoteException{
        
        super();
    }
    //metodo para saber si funciona la conexion :D
    @Override
    public String Funciona() throws RemoteException{
        String serie = "Funciona :D";

        return serie;
    }
    //Metodo para obtener articulos (SELECT)
    @Override
    public List<String> get_articulo() throws RemoteException  {
        List<String> List = new ArrayList<String>();
        Mysqlmetods mysql = new Mysqlmetods();
        List=mysql.get_articulos();
        System.out.println("Lista de articulos enviada\n\n");
        return List;
    }
    
    @Override
    public String save_user(String cedula, String nombre, String correo, String passw) throws RemoteException{
        Mysqlmetods mysql = new Mysqlmetods();
        String responce = mysql.save_user(cedula, nombre, correo, passw);
        if (responce.equals("1")) {
           System.out.println("Usuario Registrado\n\n");
            return"1"; 
        }else{
            System.out.println("Usuario no Registrado\n\n");
            return"0";
        }
        
    }
    
    @Override
    public String loggin(String usuario, String passw) throws RemoteException {
        Mysqlmetods mysql = new Mysqlmetods();
        String responce ="";
        try {
            responce=mysql.loggin(usuario,passw);
        } catch (SQLException ex) {
            Logger.getLogger(RMISERVIDOR.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (responce.equals("1")) {
            return"1"; 
        }else{
            return"0";
        }
    }
    
    @Override
    public String crear_compra( String nombre, String monto) throws RemoteException {
       Mysqlmetods mysql = new Mysqlmetods();
       String responce = mysql.crear_factura(nombre, monto);
        if (responce.equals("1")) {
            return "1";
        }else{
            return "0";
        }
        
    }
    @Override
    public String terminar_compra(String[][] articulos,String nombre){
        
       Mysqlmetods mysql = new Mysqlmetods();
       int terminal =0;
        for (int j = 0; j < articulos.length; j++) {
            String responce = null;
           try {
               responce = mysql.articulos_factura(nombre,articulos[j][0], articulos[j][1]);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(RMISERVIDOR.class.getName()).log(Level.SEVERE, null, ex);
           }
            if(responce.equals("1")){
                terminal++;
            }
        }
       
        if (terminal==articulos.length) {
            return "1";
        }else{
            return "0";
        }
        
       
    }
    
    public static void main(String[] args) {
    
        try {
            
              System.setProperty("java.rmi.server.hostname","172.16.40.57");
            
            Registry registro = LocateRegistry.createRegistry(7777);
            //7777 cadena para enlazar el cliente-server
            //registry : registro de objetos remotos. almacenar-recuperar            
            registro.rebind("Ejemplo", new RMISERVIDOR());
            //rebind se usa para acceder al rmi
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }finally{
            System.out.println("Servidor Iniciado");
        }
        
        }

   

    

    

    
    }
    

