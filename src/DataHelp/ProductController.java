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

/**
 *
 * @author bangquanhung
 */
public class ProductController {
    DataHelp db = new DataHelp();
    //get all product
   public List<Products> getProduct() throws SQLException{
       List<Products> list = new ArrayList<>();
       CallableStatement call = null;
       ResultSet rs = null;
       Connection cn = null;
       try{
           String strSql = "{call sp_Product_GetAll}";
	   cn = db.getCon();
	   call = cn.prepareCall(strSql);
           rs = call.executeQuery();
           while(rs.next()){
               Products p = new Products(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("SupplierID"), rs.getInt("CategoryID"), rs.getInt("Quantity"), rs.getDouble("UnitPrice"), rs.getString("Picture"), rs.getString("Color"), rs.getString("Size"), rs.getInt("OrderCount"), rs.getInt("ViewCount"), rs.getDate("ViewDate"), rs.getString("Description"));
	       list.add(p);
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
   //get product by id
   public List<Products> getProductByID(int id) throws SQLException{
       List<Products> list = new ArrayList<>();
       CallableStatement call = null;
       ResultSet rs = null;
       Connection cn = null;
       try{
	   String strSql = "{call sp_Product_GetByID(?)}";
	   cn = db.getCon();
	   call = cn.prepareCall(strSql);
	   call.setInt("ProductID", id);
	   rs = call.executeQuery();
	   while(rs.next()){
	       Products p = new Products(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("SupplierID"), rs.getInt("CategoryID"), rs.getInt("Quantity"), rs.getDouble("UnitPrice"), rs.getString("Picture"), rs.getString("Color"), rs.getString("Size"), rs.getInt("OrderCount"), rs.getInt("ViewCount"), rs.getDate("ViewDate"), rs.getString("Description"));
	       list.add(p);
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
   //insert product 
   public int insertProduct(Products p) throws SQLException{
       int row = 0;
       CallableStatement call = null;
       Connection cn = null;
       try{
	   String strSql = "{call sp_Product_Insert(?,?,?,?,?,?,?,?,?,?,?,?)}";
	   cn = db.getCon();
	   call = cn.prepareCall(strSql);
	   call.setString("ProductName", p.getProductName());
	   call.setInt("SupplierID", p.getSupplierID());
	   call.setInt("CategoryID", p.getCategoryID());
	   call.setInt("Quantity", p.getQuantity());
	   call.setDouble("UnitPrice", p.getUnitPrice());
	   call.setString("Picture", p.getPicture());
	   call.setString("Color", p.getColor());
	   call.setString("Size", p.getSize());
	   call.setInt("OrderCount", p.getOrderCount());
	   call.setInt("ViewCount", p.getViewCount());
	   call.setDate("ViewDate", p.getViewDate());
	   call.setString("Description", p.getDescription());
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
   //update product
   public int updateProduct(Products p) throws SQLException{
       int row = 0;
       CallableStatement call = null;
       Connection cn = null;
       try{
	   String strSql = "{call sp_Product_Update(?,?,?,?,?,?,?,?,?,?,?,?)}";
	   cn = db.getCon();
	   call = cn.prepareCall(strSql);
	   call.setInt("ProductID", p.getProductID());
	   call.setString("ProductName", p.getProductName());
	   call.setInt("SupplierID", p.getSupplierID());
	   call.setInt("CategoryID", p.getCategoryID());
	   call.setInt("Quantity", p.getQuantity());
	   call.setDouble("UnitPrice", p.getUnitPrice());
	   call.setString("Picture", p.getPicture());
	   call.setString("Color", p.getColor());
	   call.setString("Size", p.getSize());
	   call.setInt("OrderCount", p.getOrderCount());
	   call.setInt("ViewCount", p.getViewCount());
	   call.setDate("ViewDate", p.getViewDate());
	   call.setString("Description", p.getDescription());
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
   //delete product 
   public int deleteProduct(int id) throws SQLException{
       int row = 0;
       CallableStatement call = null;
       Connection cn = null;
       try{
	   String strSql = "{call sp_Product_Delete(?)}";
	   cn = db.getCon();
	   call = cn.prepareCall(strSql);
	   call.setInt("ProductID", id);
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
