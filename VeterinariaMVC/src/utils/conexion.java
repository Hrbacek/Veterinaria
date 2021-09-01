package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;

public class conexion {

    public static Connection getConnection() {
        JSONParser parser = new JSONParser();
        Connection conex = null;
        // conectar
        try {
            String ruta_credenciales = System.getProperty("user.dir") + "/src/utils/credenciales.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(ruta_credenciales));
   
            String db         = (String)jsonObject.get("db_name");
            String host       = (String)jsonObject.get("db_ip");
            String puerto     = (String)jsonObject.get("db_port");
            String usuario    = (String)jsonObject.get("db_user");
            String contra     = (String)jsonObject.get("db_pssword");
            
            String dbURL = "jdbc:mysql://" + host + ":" + puerto + "/" + db ;
            
            conex = DriverManager.getConnection(dbURL, usuario, contra);
            if( conex != null ) {
                System.out.println ( "***Conectado a " + db + "***"  );
            }
             
        } 
        catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        }
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        
        return conex;
    }
    
}