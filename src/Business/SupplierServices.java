/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import DataHelp.SupplierController;
import DataHelp.Suppliers;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author bangquanhung
 */
public class SupplierServices {
    SupplierController sc = new SupplierController();
    public List<Suppliers> getSupplier() throws SQLException{
	return sc.getSupplier();
    }
    public Vector<Suppliers> getSupplierByVector() throws SQLException{
        return sc.getSupplierByVector();
    }
    public List<Suppliers> getSupplierByID(int id) throws SQLException{
	return sc.getSupplierByID(id);
    }
    public int insertSupllier(Suppliers s) throws SQLException{
	return sc.insertSupllier(s);
    }
    public int updateSupllier(Suppliers s) throws SQLException{
	return sc.updateSupllier(s);
    }
    public int deleteSupplier(int id) throws SQLException{
	return sc.deleteSupplier(id);
    }
}
