/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHelp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bangquanhung
 */
public class ConfigConnect {
    private String host="";
    private String user="";
    private String pass="";
    //method get connection voi mysql
    public Connection getCon(){
        Connection cn = null;
        try{
            //neu la sql
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.host = "jdbc:sqlserver://BNGQUNHNG0A40\\BNGQUNHNG0A40:1433;databaseName=quanlybanhangbyjava";
            this.user = "sa";
            this.pass = "1";
            if(cn == null){
                cn = DriverManager.getConnection(host, user, pass);
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return cn;
    }
   
    
    
}
