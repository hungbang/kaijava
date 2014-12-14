/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.Categories;
import DataHelp.CategoriesController;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class CategoriesSevices {
    CategoriesController cc = new CategoriesController();
    public List<Categories> getCateAll(){
	return cc.getCateAll();
    }
    public List<Categories> getCateByID(int id){
	return cc.getCateByID(id);
    }
    public int insertCate(Categories c){
	return cc.insertCate(c);
    }
    public int updateCate(Categories c){
	return cc.updateCate(c);
    }
    public int deleteCate(Categories c){
	return cc.deleteCate(c);
    }
}
