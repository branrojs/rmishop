
package SERVIDOR;
import java.sql.*;
import java.util.*;

public class Mysqlmetods {
    static Connection conn = null;
    static String myDriver = "org.gjt.mm.mysql.Driver";
    static String myUrl = "jdbc:mysql://localhost:3306/TiendaRMI";
    static String user = "root";
    static String pass = "admin123";
    
    
    public String save_user(String cedula, String nombre, String correo, String passw){
        try
            {
              //conn
              Class.forName(myDriver);
              conn = DriverManager.getConnection(myUrl,user,pass);
              //query
              String query = " INSERT INTO RMIusuarios (cedula,nombre, correo, pass) VALUES (?,?,?,?)";

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setInt(1,Integer.parseInt(cedula));
              preparedStmt.setString(2,nombre);
              preparedStmt.setString(3, correo);
              preparedStmt.setString(4, passw);

              // execute the preparedstatement
              preparedStmt.execute();
                
              conn.close();
            }
            catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
              return "0";
            }
        System.out.println("Insertado exitoso");
        return "1";
    }
    
    
    public String loggin(String nombre, String pasw) throws SQLException{
        String responce="";
        try{
            //query
            String query = "SELECT * FROM RMIusuarios WHERE nombre='"+nombre+"' AND pass='"+pasw+"'; ";
            //conexion
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl,user,pass);
            //statement
            Statement s = conn.createStatement();
            //result set
             ResultSet rs = s.executeQuery (query);
             //verificar si encontro resultado
             if (rs.next()) {
                 responce="1";
             } else {
                 responce= "0";
             }
             //cierra conexion
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println("Excepcion encontrada!!");
            System.err.println(e.getMessage());
        }
        
        System.out.println("Loggin exitoso");
        return responce;
    }
    
    //select de articulos y los devuelve
    public List<String> get_articulos(){
        String query = "SELECT * FROM RMIarticulos";
         List<String> List = new ArrayList<String>();
        try
            {
              //conn
              Class.forName(myDriver);
              conn = DriverManager.getConnection(myUrl,user,pass);
              //statement
              Statement s = conn.createStatement();
              //result set
               ResultSet rs = s.executeQuery (query);
             
              // meter en lista los resultados
               while (rs.next())
            {
                String producto = rs.getString("id")+"-"+rs.getString("nombre")+"-"+rs.getString("precio")+"-"+rs.getString("cantidad");
                List.add(producto);
                
            }
              
              conn.close();
            }
            catch (Exception e)
            {
              System.err.println("Excepcion encontrada!!");
              System.err.println(e.getMessage());
            }
        System.out.println("Transaccion exitosa");
        return List;
        
    }
    
    public String crear_factura(String nombre, String monto){
        try
            {
              //conn
              Class.forName(myDriver);
              conn = DriverManager.getConnection(myUrl,user,pass);
              //query
              String query = "INSERT INTO Factura (Cliente, Montototal) VALUES (?,?);;";

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setString(1,nombre);
              preparedStmt.setString(2,monto);
            

              // execute the preparedstatement
              preparedStmt.execute();
              conn.close();
            }
            catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
              return "0";
            }
        System.out.println("Factura creada");
        return "1";
    }
    
    public String articulos_factura(String nombre, String idarticulo, String cantidad) throws ClassNotFoundException{
        String id = null;
        try
            {
                
              //conn
              Class.forName(myDriver);
              conn = DriverManager.getConnection(myUrl,user,pass);
              
              String queryS = "Select idFactura from Factura where cliente='"+nombre+"' ORDER BY idFactura DESC LIMIT 1";
              Statement s = conn.createStatement();
              ResultSet rs = s.executeQuery (queryS);
              while(rs.next()){
                  id=rs.getString("idFactura");
                  break;
              }
              
             
            }
            catch (SQLException e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
              return "0";
            }
        
        try {
            //conn
              Class.forName(myDriver);
              conn = DriverManager.getConnection(myUrl,user,pass);
            //query
              String queryI = "INSERT INTO AxF (idF, idA, cantidad) VALUES (?,?,?);";
              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(queryI);
              preparedStmt.setString(1,id);
              preparedStmt.setString(2,idarticulo);
              preparedStmt.setString(3,cantidad);
              // execute the preparedstatement
              preparedStmt.execute();
                
              conn.close();
        } catch (Exception e) {
        }
        
        System.out.println("Factura completada");
        return "1";
    }
    
}
