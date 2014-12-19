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
public class OrderController {
    DataHelp db = new DataHelp();
    //get all order 
    public List<Orders> getOrderByAll() throws SQLException{
	List<Orders> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_GetAll}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    rs = call.executeQuery();
	    while(rs.next())
	    {
		Orders o = new Orders(rs.getInt("OrderID"), rs.getInt("CustomerID"), rs.getInt("EmployeeID"), rs.getDate("OrderDate"), rs.getBoolean("Status"), rs.getDate("ShippedDate"), rs.getDouble("Freight"), rs.getString("ShipName"), rs.getString("ShipAddress"), rs.getString("ShipCity"), rs.getString("ShipRegion"), rs.getString("ShipZipCode"), rs.getString("ShipCountry"));
		list.add(o);
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
    public List<Orders> getOrderByID(int id) throws SQLException{
	List<Orders> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_GetByID(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("OrderID", id);
	    rs = call.executeQuery();
	    while(rs.next())
	    {
		Orders o = new Orders(rs.getInt("OrderID"), rs.getInt("CustomerID"), rs.getInt("EmployeeID"), rs.getDate("OrderDate"), rs.getBoolean("Status"), rs.getDate("ShippedDate"), rs.getDouble("Freight"), rs.getString("ShipName"), rs.getString("ShipAddress"), rs.getString("ShipCity"), rs.getString("ShipRegion"), rs.getString("ShipZipCode"), rs.getString("ShipCountry"));
		list.add(o);
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
    public int insertOrder(Orders o) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_Insert(?,?,?,?,?,?,?,?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //update order 
    public int updateOrder(Orders o) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_Update(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //delete order 
    public int deleteOrder(Orders o) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_Order_Delete(?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("OrderID", o.getOrderID());
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
