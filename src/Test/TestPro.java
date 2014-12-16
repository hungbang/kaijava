/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Business.CategoriesSevices;
import Business.CustomerServices;
import DataHelp.Categories;
import DataHelp.ConfigConnect;
import DataHelp.Customers;
import DataHelp.DataHelp;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author bangquanhung
 */
public class TestPro {
    public static void main(String[] args) {
        
        DataHelp db = new DataHelp();
        Connection cn = db.getCon();
        if(cn!= null){
            System.out.println("Connect success!\n" + cn);
            loadData();
        }
        else
            System.out.println("fail");
    }
    public static void loadData(){
        try{
            CategoriesSevices cs = new CategoriesSevices();
            List<Categories> list = cs.getCateAll();
            CustomerServices cus = new CustomerServices();
            List<Customers> listCus = cus.getCusByAll();
            for(Categories c : list){
                System.out.println("Cus: " + c.getCategoryName());
            }
            
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}

