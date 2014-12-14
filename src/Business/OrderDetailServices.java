/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.OrderDetailController;
import DataHelp.OrderDetails;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class OrderDetailServices {
    OrderDetailController odc = new OrderDetailController();
    public List<OrderDetails> getOrderDetailAll(){
	return odc.getOrderDetailAll();
    }
    public List<OrderDetails> getOrderDetailByID(int id){
	return odc.getOrderDetailByID(id);
    }
    public int insertOrderDetail(OrderDetails od){
	return odc.insertOrderDetail(od);
    }
    public int updateOrderDetail(OrderDetails od){
	return odc.updateOrderDetail(od);
    }
    public int deleteOrderDetail(OrderDetails od){
	return odc.deleteOrderDetail(od);
    }
}
