/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DataHelp.ConfigConnect;
import java.sql.Connection;

/**
 *
 * @author bangquanhung
 */
public class TestPro {
    public static void main(String[] args) {
        ConfigConnect cc = new ConfigConnect();
        Connection cn = cc.getCon();
        if(cn!= null){
            System.out.println("Connect success!");
        }
        else
            System.out.println("fail");
    }
}
