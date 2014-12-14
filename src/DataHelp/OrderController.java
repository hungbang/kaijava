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
public class OrderController {
    DataHelp db = new DataHelp();
    //get all order 
    public List<Orders> getOrderByAll(){
	List<Orders> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_Order_GetAll}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    ResultSet rs = call.executeQuery();
	    while(rs.next())
	    {
		Orders o = new Orders(rs.getInt("OrderID"), rs.getInt("CustomerID"), rs.getInt("EmployeeID"), rs.getDate("OrderDate"), rs.getBoolean("Status"), rs.getDate("ShippedDate"), rs.getDouble("Freight"), rs.getString("ShipName"), rs.getString("ShipAddress"), rs.getString("ShipCity"), rs.getString("ShipRegion"), rs.getString("ShipZipCode"), rs.getString("ShipCountry"));
		list.add(o);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //get order by id
    public List<Orders> getOrderByID(int id){
	List<Orders> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_Order_GetByID}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", id);
	    ResultSet rs = call.executeQuery();
	    while(rs.next())
	    {
		Orders o = new Orders(rs.getInt("OrderID"), rs.getInt("CustomerID"), rs.getInt("EmployeeID"), rs.getDate("OrderDate"), rs.getBoolean("Status"), rs.getDate("ShippedDate"), rs.getDouble("Freight"), rs.getString("ShipName"), rs.getString("ShipAddress"), rs.getString("ShipCity"), rs.getString("ShipRegion"), rs.getString("ShipZipCode"), rs.getString("ShipCountry"));
		list.add(o);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //insert into order 
    public int insertOrder(Orders o){
	int row = 0;
	try{
	    String strSql = "call{sp_Order_Insert(?,?,?,?,?,?,?,?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    //call.setInt("OrderID", o.getOrderID());
	    call.setInt("CustomerID", o.getCustomerID());
	    call.setInt("EmployeeID", o.getEmployeeID());
	    call.setDate("OrderDate", o.getOrderDate());
	    call.setBoolean("Status", o.isStatus());
	    call.setDate("ShippedDate", o.getShippedDate());
	    call.setDouble("Freight", o.getFreight());
	    call.setString("ShipName", o.getShipName());
	    call.setString("ShipAddress", o.getShipAddress());
	    call.setString("ShipCity", o.getShipCity());
	    call.setString("ShipRegion", o.getShipRegion());
	    call.setString("ShipZipCode", o.getShipZipCode());
	    call.setString("ShipCountry", o.getShipCountry());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //update order 
    public int updateOrder(Orders o){
	int row = 0;
	try{
	    String strSql = "call{sp_Order_Update(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", o.getOrderID());
	    call.setInt("CustomerID", o.getCustomerID());
	    call.setInt("EmployeeID", o.getEmployeeID());
	    call.setDate("OrderDate", o.getOrderDate());
	    call.setBoolean("Status", o.isStatus());
	    call.setDate("ShippedDate", o.getShippedDate());
	    call.setDouble("Freight", o.getFreight());
	    call.setString("ShipName", o.getShipName());
	    call.setString("ShipAddress", o.getShipAddress());
	    call.setString("ShipCity", o.getShipCity());
	    call.setString("ShipRegion", o.getShipRegion());
	    call.setString("ShipZipCode", o.getShipZipCode());
	    call.setString("ShipCountry", o.getShipCountry());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //delete order 
    public int deleteOrder(Orders o){
	int row = 0;
	try{
	    String strSql = "call{sp_Order_Delete(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", o.getOrderID());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
}
