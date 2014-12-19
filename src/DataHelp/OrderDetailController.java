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
public class OrderDetailController {
    DataHelp db = new DataHelp();
    //get all order detail 
    public List<OrderDetails> getOrderDetailAll() throws SQLException{
	List<OrderDetails> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_OrderDetail_GetByAll}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    rs = call.executeQuery();
	    while(rs.next()){
		OrderDetails od = new OrderDetails(rs.getInt("OrderID"), rs.getInt("ProductID"), rs.getDouble("UnitPrice"), rs.getInt("Quantiry"), rs.getFloat("Discount"));
		list.add(od);
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
    //get order detail by id
    public List<OrderDetails> getOrderDetailByID(OrderDetails o) throws SQLException{
	List<OrderDetails> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_OrderDetail_GetByID(?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("OrderID", o.getOrderID());
            call.setInt("ProductID", o.getProductID());
	    rs = call.executeQuery();
	    while(rs.next()){
		OrderDetails od = new OrderDetails(rs.getInt("OrderID"), rs.getInt("ProductID"), rs.getDouble("UnitPrice"), rs.getInt("Quantiry"), rs.getFloat("Discount"));
		list.add(od);
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
    //insert into order detail
    public int insertOrderDetail(OrderDetails od) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_OrderDetail_Insert(?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //update order detail
    public int updateOrderDetail(OrderDetails od) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_OrderDetail_Update(?,?,?,?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
	return row;
    }
    //delete order detail
    public int deleteOrderDetail(OrderDetails od) throws SQLException{
	int row = 0;
        CallableStatement call = null;
        Connection cn = null;
	try{
	    String strSql = "{call sp_OrderDetail_Delete(?,?)}";
	    cn = db.getCon();
	    call = cn.prepareCall(strSql);
	    call.setInt("OrderID", od.getOrderID());
	    call.setInt("ProductID", od.getProductID());
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
