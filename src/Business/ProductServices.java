/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.ProductController;
import DataHelp.Products;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class ProductServices {
    ProductController pc = new ProductController();
    public List<Products> getProduct() throws SQLException{
	return pc.getProduct();
    }
    public List<Products> getProductByID(int id) throws SQLException{
	return pc.getProductByID(id);
    }
    public int insertProduct(Products p) throws SQLException{
	return pc.insertProduct(p);
    }
    public int updateProduct(Products p) throws SQLException{
	return pc.updateProduct(p);
    }
    public int deleteProduct(int id) throws SQLException{
	return pc.deleteProduct(id);
    }
}
