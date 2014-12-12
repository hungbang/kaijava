/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHelp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bangquanhung
 */
public class DataHelp {
    ConfigConnect cc = new ConfigConnect();
    
    //lay chuoi connect
    public Connection getCon(){
	Connection cn = null;
	try{
	    if(!cn.isClosed()){
		cn = cc.getCon();
	    }
	}
	catch(Exception ex){
	    ex.getMessage();
	}
	return cn;
    }
    
    //thuc hien truy van select 
    public ResultSet executeQuery(String strSql){
        ResultSet rs = null;
        try{
            Connection cn = cc.getCon();
            Statement st = cn.createStatement();
            rs = st.executeQuery(strSql);
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return rs;
    }
    //thuc hien truy van insert, delete , update by store procedure
    public int executeUpdate(String sqlSql){
        int row = 0;
        try{
            Connection cn = cc.getCon();
            Statement st = cn.createStatement();
            row = st.executeUpdate(sqlSql);
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return row;
    }
    
}
