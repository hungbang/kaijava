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
import java.util.Vector;

/**
 *
 * @author PHI LONG
 */
public class SupplierController {
    DataHelp db = new DataHelp();
    //get all supplier
    public List<Suppliers> getSupplier() throws SQLException{
        List<Suppliers> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_GetAll}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            rs = call.executeQuery();
            while(rs.next()){
                Suppliers s = new Suppliers(rs.getInt("SupplierID"),rs.getString("CompanyName"),rs.getString("ContactName"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("ZipCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Fax"),rs.getString("HomePage"));
                list.add(s);
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
            rs.close();
        }
        return list;
    }
    
    public Vector<Suppliers> getSupplierByVector() throws SQLException{
        Vector<Suppliers> list = new Vector<Suppliers>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_GetAll}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            rs = call.executeQuery();
            while(rs.next()){
                Suppliers s = new Suppliers(rs.getInt("SupplierID"),rs.getString("CompanyName"),rs.getString("ContactName"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("ZipCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Fax"),rs.getString("HomePage"));
                list.add(s);
            }
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
            rs.close();
        }
        return list;
    }
    //get Supplier by ID
    public List<Suppliers> getSupplierByID(int id) throws SQLException{
        List<Suppliers> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_GetID(?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            call.setInt("supplierID", id);
            rs = call.executeQuery();
            while(rs.next()){
                Suppliers s = new Suppliers(rs.getInt("SupplierID"),rs.getString("CompanyName"),rs.getString("ContactName"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("ZipCode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Fax"),rs.getString("HomePage"));
                list.add(s);
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
    //insert Supplier 
    public int insertSupllier(Suppliers s) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_Insert(?,?,?,?,?,?,?,?,?,?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
        return row;
    }
    //update supplier
    public int updateSupllier(Suppliers s) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_Update(?,?,?,?,?,?,?,?,?,?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
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
        finally{
            cn.close();
            call.close();
        }
        return row;
    }
    //delete supplier
    public int deleteSupplier(int id) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Supplier_Delete(?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            call.setInt("SupplierID", id);
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
