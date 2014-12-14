/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.Employees;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class EmployeeServices {
    EmployeeServices ec = new EmployeeServices();
    public List<Employees> getEmployee(){
	return ec.getEmployee();
    }
    public List<Employees> getSupplierByID(int id){
	return ec.getSupplierByID(id);
    }
    public int insertEmployee(Employees e){
	return ec.insertEmployee(e);
    }
    public int updateEmployee(Employees e){
	return ec.updateEmployee(e);
    }
    public int deleteEmployee(int id){
	return ec.deleteEmployee(id);
    }
}
