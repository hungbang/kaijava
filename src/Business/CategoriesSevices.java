/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataHelp.Categories;
import DataHelp.CategoriesController;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author bangquanhung
 */
public class CategoriesSevices {
    CategoriesController cc = new CategoriesController();
    public Vector<Categories> getCateAllByVector() throws SQLException{
        return cc.getCateAllByVector();
    }
    public List<Categories> getCateAll() throws SQLException{
	return cc.getCateAll();
    }
    public List<Categories> getCateByID(int id) throws SQLException{
	return cc.getCateByID(id);
    }
    public int insertCate(Categories c) throws SQLException{
	return cc.insertCate(c);
    }
    public int updateCate(Categories c) throws SQLException{
	return cc.updateCate(c);
    }
    public int deleteCate(Categories c) throws SQLException{
	return cc.deleteCate(c);
    }
}
