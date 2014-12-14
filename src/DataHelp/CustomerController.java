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
public class CustomerController {
    DataHelp db = new DataHelp();
    //get all order 
    public List<Customers> getCusByAll(){
	List<Customers> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_Customer_GetAll}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    ResultSet rs = call.executeQuery();
	    while(rs.next())
	    {
		Customers p = new Customers(rs.getInt("CustomerID"), rs.getString("CustomerName"), rs.getString("CompanyName"), rs.getString("Address"), rs.getString("City"), rs.getString("Region"), rs.getString("Zipcode"), rs.getString("Country"), rs.getString("Phone"), rs.getString("Email"));
		list.add(p);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //get order by id
    public List<Customers> getOrderByID(int id){
	List<Customers> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_Customer_GetByID}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("CustomerID", id);
	    ResultSet rs = call.executeQuery();
	    while(rs.next())
	    {
		Customers p = new Customers(rs.getInt("CustomerID"), rs.getString("CustomerName"), rs.getString("CompanyName"), rs.getString("Address"), rs.getString("City"), rs.getString("Region"), rs.getString("Zipcode"), rs.getString("Country"), rs.getString("Phone"), rs.getString("Email"));
		list.add(p);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //insert into order 
    public int insertCustomer(Customers p){
	int row = 0;
	try{
	    String strSql = "call{sp_Customer_Insert(?,?,?,?,?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
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
	return row;
    }
    //update order 
    public int updateOrder(Customers p){
	int row = 0;
	try{
	    String strSql = "call{sp_Customer_Update(?,?,?,?,?,?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
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
	return row;
    }
    //delete order 
    public int deleteOrder(Customers p){
	int row = 0;
	try{
	    String strSql = "call{sp_Order_Delete(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("CustomerID", p.getCustomerID());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
}
