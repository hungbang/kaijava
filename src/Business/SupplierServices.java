/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import DataHelp.SupplierController;
import DataHelp.Suppliers;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class SupplierServices {
    SupplierController sc = new SupplierController();
    public List<Suppliers> getSupplier(){
	return sc.getSupplier();
    }
    public List<Suppliers> getSupplierByID(int id){
	return sc.getSupplierByID(id);
    }
    public int insertSupllier(Suppliers s){
	return sc.insertSupllier(s);
    }
    public int updateSupllier(Suppliers s){
	return sc.updateSupllier(s);
    }
    public int deleteSupplier(int id){
	return sc.deleteSupplier(id);
    }
}
