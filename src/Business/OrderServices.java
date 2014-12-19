/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.OrderController;
import DataHelp.Orders;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class OrderServices {
    OrderController oc = new OrderController();
    public List<Orders> getOrderByAll() throws SQLException{
	return oc.getOrderByAll();
    }
    public List<Orders> getOrderByID(int id) throws SQLException{
	return oc.getOrderByID(id);
    }
    public int insertOrder(Orders o) throws SQLException{
	return oc.insertOrder(o);
    }
    public int updateOrder(Orders o) throws SQLException{
	return oc.updateOrder(o);
    }
    public int deleteOrder(Orders o) throws SQLException{
	return oc.deleteOrder(o);
    }
}
