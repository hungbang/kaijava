/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.OrderDetailController;
import DataHelp.OrderDetails;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class OrderDetailServices {
    OrderDetailController odc = new OrderDetailController();
    public List<OrderDetails> getOrderDetailAll() throws SQLException{
	return odc.getOrderDetailAll();
    }
    public List<OrderDetails> getOrderDetailByID(OrderDetails od) throws SQLException{
	return odc.getOrderDetailByID(od);
    }
    public int insertOrderDetail(OrderDetails od) throws SQLException{
	return odc.insertOrderDetail(od);
    }
    public int updateOrderDetail(OrderDetails od) throws SQLException{
	return odc.updateOrderDetail(od);
    }
    public int deleteOrderDetail(OrderDetails od) throws SQLException{
	return odc.deleteOrderDetail(od);
    }
}
