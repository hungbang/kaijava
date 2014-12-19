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

/**
 *
 * @author bangquanhung
 */
public class CustomerController {
    DataHelp db = new DataHelp();
    //get all order 
    public List<Customers> getCusByAll() throws SQLException{
	List<Customers> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Customer_GetAll}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    rs = call.executeQuery();
	    while(rs.next())
	    {
		Customers p = new Customers(rs.getInt("CustomerID"), rs.getString("CustomerName"), rs.getString("CompanyName"), rs.getString("Address"), rs.getString("City"), rs.getString("Region"), rs.getString("Zipcode"), rs.getString("Country"), rs.getString("Phone"), rs.getString("Email"));
		list.add(p);
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
    //get order by id
    public List<Customers> getOrderByID(int id) throws SQLException{
	List<Customers> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Customer_GetByID(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("CustomerID", id);
	    rs = call.executeQuery();
	    while(rs.next())
	    {
		Customers p = new Customers(rs.getInt("CustomerID"), rs.getString("CustomerName"), rs.getString("CompanyName"), rs.getString("Address"), rs.getString("City"), rs.getString("Region"), rs.getString("Zipcode"), rs.getString("Country"), rs.getString("Phone"), rs.getString("Email"));
		list.add(p);
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
    //insert into order 
    public int insertCustomer(Customers p) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Customer_Insert(?,?,?,?,?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    //call.setInt("CustomerID", p.getCustomerID());
	    call.setString("CustomerName", p.getCustomerName());
	    call.setString("CompanyName", p.getCompanyName());
	    call.setString("Address", p.getAddress());
	    call.setString("City", p.getCity());
	    call.setString("Region", p.getRegion());
	    call.setString("Zipcode", p.getZipcode());
	    call.setString("Country", p.getCountry());
	    call.setString("Phone", p.getPhone());
	    call.setString("Email", p.getEmail());
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
    //update order 
    public int updateOrder(Customers p) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Customer_Update(?,?,?,?,?,?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("CustomerID", p.getCustomerID());
	    call.setString("CustomerName", p.getCustomerName());
	    call.setString("CompanyName", p.getCompanyName());
	    call.setString("Address", p.getAddress());
	    call.setString("City", p.getCity());
	    call.setString("Region", p.getRegion());
	    call.setString("Zipcode", p.getZipcode());
	    call.setString("Country", p.getCountry());
	    call.setString("Phone", p.getPhone());
	    call.setString("Email", p.getEmail());
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
    //delete order 
    public int deleteOrder(Customers p) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_Delete(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("CustomerID", p.getCustomerID());
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
