/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHelp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author bangquanhung
 */
public class CategoriesController {
    DataHelp db = new DataHelp();
    //get all cate
    public List<Categories> getCateAll() throws SQLException{
	List<Categories> list = new ArrayList<>();
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;
	try{
	    String strSql = "{call sp_Cate_GetAll}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    rs = call.executeQuery();
	    while(rs.next()){
		Categories c = new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName"));
		list.add(c);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
            rs.close();
        }
	return list;
    }
    public Vector<Categories> getCateAllByVector() throws SQLException{
	Vector<Categories> list = new Vector<Categories>();
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;
	try{
	    String strSql = "{call sp_Cate_GetAll}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    rs = call.executeQuery();
	    while(rs.next()){
		Categories c = new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName"));
		list.add(c);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
            rs.close();
        }
	return list;
    }
    //get by id
    public List<Categories> getCateByID(int id) throws SQLException{
	List<Categories> list = new ArrayList<>();
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;
	try{
	    String strSql = "{call sp_Cate_GetByID(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("CategoryID", id);
	    rs = call.executeQuery();
	    while(rs.next()){
		Categories c = new Categories(rs.getInt("CategoryID"), rs.getString("CategoryName"));
		list.add(c);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
            rs.close();
        }
	return list;
    }
    //insert into cate
    public int insertCate(Categories c) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Cate_Insert(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setString("CategoryName", c.getCategoryName());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //update cate
    public int updateCate(Categories c) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "call{sp_Cate_Update(?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
            call.setInt("CategoryID", c.getCategoryID());
	    call.setString("CategoryName", c.getCategoryName());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //delete cate 
    public int deleteCate(Categories c) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Cate_Delete(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("CategoryID", c.getCategoryID());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
}
