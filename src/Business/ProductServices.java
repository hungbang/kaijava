/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.ProductController;
import DataHelp.Products;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class ProductServices {
    ProductController pc = new ProductController();
    public List<Products> getProduct(){
	return pc.getProduct();
    }
    public List<Products> getProductByID(int id){
	return pc.getProductByID(id);
    }
    public int insertProduct(Products p){
	return pc.insertProduct(p);
    }
    public int updateProduct(Products p){
	return pc.updateProduct(p);
    }
    public int deleteProduct(int id){
	return pc.deleteProduct(id);
    }
}
