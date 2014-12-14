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
public class OrderDetailController {
    DataHelp db = new DataHelp();
    //get all order detail 
    public List<OrderDetails> getOrderDetailAll(){
	List<OrderDetails> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_OrderDetail_GetByAll}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    ResultSet rs = call.executeQuery();
	    while(rs.next()){
		OrderDetails od = new OrderDetails(rs.getInt("OrderID"), rs.getInt("ProductID"), rs.getDouble("UnitPrice"), rs.getInt("Quantiry"), rs.getFloat("Discount"));
		list.add(od);
	    }
	    
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //get order detail by id
    public List<OrderDetails> getOrderDetailByID(int id){
	List<OrderDetails> list = new ArrayList<>();
	try{
	    String strSql = "call{sp_OrderDetail_GetByID(?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", id);
	    ResultSet rs = call.executeQuery();
	    while(rs.next()){
		OrderDetails od = new OrderDetails(rs.getInt("OrderID"), rs.getInt("ProductID"), rs.getDouble("UnitPrice"), rs.getInt("Quantiry"), rs.getFloat("Discount"));
		list.add(od);
	    }
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return list;
    }
    //insert into order detail
    public int insertOrderDetail(OrderDetails od){
	int row = 0;
	try{
	    String strSql = "call{sp_OrderDetail_Insert(?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", od.getOrderID());
	    call.setInt("ProductID", od.getProductID());
	    call.setDouble("UnitPrice", od.getUnitPrice());
	    call.setInt("Quantity", od.getQuantity());
	    call.setFloat("Discount", od.getDiscount());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //update order detail
    public int updateOrderDetail(OrderDetails od){
	int row = 0;
	try{
	    String strSql = "call{sp_OrderDetail_Update(?,?,?,?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", od.getOrderID());
	    call.setInt("ProductID", od.getProductID());
	    call.setDouble("UnitPrice", od.getUnitPrice());
	    call.setInt("Quantity", od.getQuantity());
	    call.setFloat("Discount", od.getDiscount());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
    //delete order detail
    public int deleteOrderDetail(OrderDetails od){
	int row = 0;
	try{
	    String strSql = "call{sp_OrderDetail_Delete(?,?)}";
	    Connection cn = db.getCon();
	    CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("OrderID", od.getOrderID());
	    call.setInt("ProductID", od.getProductID());
	    row = call.executeUpdate();
	}
	catch(Exception ex){
	    System.err.println(ex.getMessage());
	}
	return row;
    }
}
