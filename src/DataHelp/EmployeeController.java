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
public class EmployeeController {
    DataHelp db = new DataHelp();
    //get all employee
    public List<Employees> getEmployee(){
        List<Employees> list = new ArrayList<>();
        try{
            String strSql = "call{sp_Employee_GetAll}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Employees e = new Employees(rs.getInt("employeeID"),rs.getString("lastname"),rs.getString("firstName"),rs.getDate("birthDay"),rs.getDate("hireDay"),rs.getString("address"),rs.getString("city"),rs.getString("region"),rs.getString("zipcode"),rs.getString("country"),rs.getString("phone"),rs.getString("email"),rs.getString("photo"),rs.getString("photoPath"),rs.getInt("reportTo"),rs.getString("typeAccount"),rs.getBoolean("statusAccount"));
                list.add(e);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
    //get Employee by ID
    public List<Employees> getSupplierByID(int id){
        List<Employees> list = new ArrayList<>();
        try{
            String strSql = "call{sp_Employee_GetID(?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setInt("EmployeeID", id);
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Employees e = new Employees(rs.getInt("employeeID"),rs.getString("lastname"),rs.getString("firstName"),rs.getDate("birthDay"),rs.getDate("hireDay"),rs.getString("address"),rs.getString("city"),rs.getString("region"),rs.getString("zipcode"),rs.getString("country"),rs.getString("phone"),rs.getString("email"),rs.getString("photo"),rs.getString("photoPath"),rs.getInt("reportTo"),rs.getString("typeAccount"),rs.getBoolean("statusAccount"));
                list.add(e);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
    //insert Employee
    public int insertEmployee(Employees e){
        int row = 0;
        try{
            String strSql = "call{sp_Employee_Insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setString("lastname", e.getLastname());
            call.setString("firstName", e.getFirstName());
            call.setDate("birthDay", e.getBirthDay());
            call.setDate("hireDay", e.getHireDay());
            call.setString("address", e.getAddress());
            call.setString("city", e.getCity());
            call.setString("region", e.getRegion());
            call.setString("zipcode", e.getZipcode());
            call.setString("country", e.getCountry());
            call.setString("phone", e.getPhone());
            call.setString("email", e.getEmail());
            call.setString("photo", e.getPhoto());
            call.setString("photoPath", e.getPhotoPath());
            call.setInt("reportTo", e.getReportTo());
            call.setString("typeAccount", e.getTypeAccount());
            call.setBoolean("statusAccount", e.isStatusAccount());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
    //update Employee
    public int updateEmployee(Employees e){
        int row = 0;
        try{
            String strSql = "call{sp_Employee_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setString("lastname", e.getLastname());
            call.setString("firstName", e.getFirstName());
            call.setDate("birthDay", e.getBirthDay());
            call.setDate("hireDay", e.getHireDay());
            call.setString("address", e.getAddress());
            call.setString("city", e.getCity());
            call.setString("region", e.getRegion());
            call.setString("zipcode", e.getZipcode());
            call.setString("country", e.getCountry());
            call.setString("phone", e.getPhone());
            call.setString("email", e.getEmail());
            call.setString("photo", e.getPhoto());
            call.setString("photoPath", e.getPhotoPath());
            call.setInt("reportTo", e.getReportTo());
            call.setString("typeAccount", e.getTypeAccount());
            call.setBoolean("statusAccount", e.isStatusAccount());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
    //delete Employee
    public int deleteEmployee(int id){
        int row = 0;
        try{
            String strSql = "call{sp_Employee_Delete(?)}";
            Connection cn = db.getCon();
            CallableStatement call = cn.prepareCall(strSql);
            call.setInt("EmployeeID", id);
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return row;
    }
}
