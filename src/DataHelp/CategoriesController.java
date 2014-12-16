/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHelp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class CategoriesController {
    DataHelp db = new DataHelp();
    //get all cate
    public List<Categories> getCateAll(){
	List<Categories> list = new ArrayList<>();
	try{
	    String strSql = "{call sp_Cate_GetAll}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    ResultSet rs = call.executeQuery();
	    while(rs.next()){
		Categories c = new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName"));
		list.add(c);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //get by id
    public List<Categories> getCateByID(int id){
	List<Categories> list = new ArrayList<>();
	try{
	    String strSql = "{call sp_Cate_GetByID(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("CategoryID", id);
	    ResultSet rs = call.executeQuery();
	    while(rs.next()){
		Categories c = new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName"));
		list.add(c);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //insert into cate
    public int insertCate(Categories c){
	int row = 0;
	try{
	    String strSql = "{call sp_Cate_Insert(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setString("CategoryName", c.getCategoryName());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //update cate
    public int updateCate(Categories c){
	int row = 0;
	try{
	    String strSql = "call{sp_Cate_Update(?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
            call.setInt("CategoryID", c.getCategoryID());
	    call.setString("CategoryName", c.getCategoryName());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //delete cate 
    public int deleteCate(Categories c){
	int row = 0;
	try{
	    String strSql = "{call sp_Cate_Delete(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("CategoryID", c.getCategoryID());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
}
