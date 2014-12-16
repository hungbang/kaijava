/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.CustomerController;
import DataHelp.Customers;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class CustomerServices {
    CustomerController cc = new CustomerController();
    public List<Customers> getCusByAll() throws SQLException{
	return cc.getCusByAll();
    }
    public List<Customers> getOrderByID(int id){
	return cc.getOrderByID(id);
    }
    public int insertCustomer(Customers p){
	return cc.insertCustomer(p);
    }
    public int updateOrder(Customers p){
	return cc.updateOrder(p);
    }
    public int deleteOrder(Customers p){
	return cc.deleteOrder(p);
    }
}
