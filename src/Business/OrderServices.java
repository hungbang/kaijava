/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.OrderController;
import DataHelp.Orders;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class OrderServices {
    OrderController oc = new OrderController();
    public List<Orders> getOrderByAll(){
	return oc.getOrderByAll();
    }
    public List<Orders> getOrderByID(int id){
	return oc.getOrderByID(id);
    }
    public int insertOrder(Orders o){
	return oc.insertOrder(o);
    }
    public int updateOrder(Orders o){
	return oc.updateOrder(o);
    }
    public int deleteOrder(Orders o){
	return oc.deleteOrder(o);
    }
}
