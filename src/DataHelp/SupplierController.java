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
 * @author PHI LONG
 */
public class SupplierController {
    DataHelp db = new DataHelp();
    //get all supplier
    public List<Suppliers> getSupplier(){
        List<Suppliers> list = new ArrayList<>();
        try{
            String strSql = "{call sp_Supplier_GetAll}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Suppliers s = new Suppliers(rs.getInt("SupplierID"),rs.getString("CompanyName"),rs.getString("ContactName"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("ZipCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Fax"),rs.getString("HomePage"));
                list.add(s);
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    //get Supplier by ID
    public List<Suppliers> getSupplierByID(int id){
        List<Suppliers> list = new ArrayList<>();
        try{
            String strSql = "{call sp_Supplier_GetID(?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setInt("supplierID", id);
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Suppliers s = new Suppliers(rs.getInt("SupplierID"),rs.getString("CompanyName"),rs.getString("ContactName"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("ZipCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Fax"),rs.getString("HomePage"));
                list.add(s);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
    //insert Supplier 
    public int insertSupllier(Suppliers s){
        int row = 0;
        try{
            String strSql = "{call sp_Supplier_Insert(?,?,?,?,?,?,?,?,?,?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setString("CompanyName",s.getCompanyName());
            call.setString("ContactName",s.getContactName());
            call.setString("Address",s.getAddress());
            call.setString("City",s.getCity());
            call.setString("Region",s.getRegion());
            call.setString("ZipCode",s.getZipCode());
            call.setString("Country",s.getCountry());
            call.setString("Phone",s.getPhone());
            call.setString("Fax",s.getFax());
            call.setString("HomePage",s.getHomePage());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
    //update supplier
    public int updateSupllier(Suppliers s){
        int row = 0;
        try{
            String strSql = "{call sp_Supplier_Update(?,?,?,?,?,?,?,?,?,?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
	    call.setInt("SupplierID", s.getSupplierID());
            call.setString("CompanyName",s.getCompanyName());
            call.setString("ContactName",s.getContactName());
            call.setString("Address",s.getAddress());
            call.setString("City",s.getCity());
            call.setString("Region",s.getRegion());
            call.setString("ZipCode",s.getZipCode());
            call.setString("Country",s.getCountry());
            call.setString("Phone",s.getPhone());
            call.setString("Fax",s.getFax());
            call.setString("HomePage",s.getHomePage());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
    //delete supplier
    public int deleteSupplier(int id){
        int row = 0;
        try{
            String strSql = "{call sp_Supplier_Delete(?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setInt("SupplierID", id);
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
}
