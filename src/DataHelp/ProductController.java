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
 * @author bangquanhung
 */
public class ProductController {
    DataHelp db = new DataHelp();
    //get all product
   public List<Products> getProduct(){
       List<Products> list = new ArrayList<>();
       try{
           String strSql = "call{sp_Product_GetAll}";
	   Connection cn = db.getCon();
	   CallableStatement call = cn.prepareCall(strSql);
           ResultSet rs = call.executeQuery();
           while(rs.next()){
               Products p = new Products(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("SupplierID"), rs.getInt("CategoryID"), rs.getInt("Quantity"), rs.getDouble("UnitPrice"), rs.getString("Picture"), rs.getString("Color"), rs.getString("Size"), rs.getInt("OrderCount"), rs.getInt("ViewCount"), rs.getDate("ViewDate"), rs.getString("Description"));
	       list.add(p);
           }
       }
       catch(Exception ex){
           System.err.println(ex.getMessage());
       }
       return list;
   }
   //get product by id
   public List<Products> getProductByID(int id){
       List<Products> list = new ArrayList<>();
       try{
	   String strSql = "call{sp_Product_GetByID(?)}";
	   Connection cn = db.getCon();
	   CallableStatement call = cn.prepareCall(strSql);
	   call.setInt("ProductID", id);
	   ResultSet rs = call.executeQuery();
	   while(rs.next()){
	       Products p = new Products(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("SupplierID"), rs.getInt("CategoryID"), rs.getInt("Quantity"), rs.getDouble("UnitPrice"), rs.getString("Picture"), rs.getString("Color"), rs.getString("Size"), rs.getInt("OrderCount"), rs.getInt("ViewCount"), rs.getDate("ViewDate"), rs.getString("Description"));
	       list.add(p);
	   }
       }
       catch(Exception ex){
	   System.err.println(ex.getMessage());
       }
       return list;
   }
   //insert product 
   public int insertProduct(Products p){
       int row = 0;
       try{
	   String strSql = "call{sp_Product_Insert(?,?,?,?,?,?,?,?,?,?,?,?)}";
	   Connection cn = db.getCon();
	   CallableStatement call = cn.prepareCall(strSql);
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
       return row;
   }
   //update product
   public int updateProduct(Products p){
       int row = 0;
       try{
	   String strSql = "call{sp_Product_Update(?,?,?,?,?,?,?,?,?,?,?,?)}";
	   Connection cn = db.getCon();
	   CallableStatement call = cn.prepareCall(strSql);
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
       return row;
   }
   //delete product 
   public int deleteProduct(int id){
       int row = 0;
       try{
	   String strSql = "call{sp_Product_Delete(?)}";
	   Connection cn = db.getCon();
	   CallableStatement call = cn.prepareCall(strSql);
	   call.setInt("ProductID", id);
	   row = call.executeUpdate();
       }
       catch(Exception ex){
	   System.err.println(ex.getMessage());
       }
       return row;
   }
   
}
