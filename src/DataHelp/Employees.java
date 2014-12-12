/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHelp;

import java.sql.Date;

/**
 *
 * @author NguyenKhanh
 */
public class Employees {
    private int employeeID;
    private String lastname;
    private String firstName;
    private Date birthDay;
    private Date hireDay;
    private String address;
    private String city;
    private String region;
    private String zipcode;
    private String country;
    private String phone;
    private String email;
    private String photo;
    private String photoPath;
    private int reportTo;
    private String typeAccount;
    private boolean statusAccount;
    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return the hireDay
     */
    public Date getHireDay() {
        return hireDay;
    }

    /**
     * @param hireDay the hireDay to set
     */
    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the photoPath
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * @param photoPath the photoPath to set
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    /**
     * @return the reportTo
     */
    public int getReportTo() {
        return reportTo;
    }

    /**
     * @param reportTo the reportTo to set
     */
    public void setReportTo(int reportTo) {
        this.reportTo = reportTo;
    }

    /**
     * @return the typeAccount
     */
    public String getTypeAccount() {
        return typeAccount;
    }

    /**
     * @param typeAccount the typeAccount to set
     */
    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    /**
     * @return the statusAccount
     */
    public boolean isStatusAccount() {
        return statusAccount;
    }

    /**
     * @param statusAccount the statusAccount to set
     */
    public void setStatusAccount(boolean statusAccount) {
        this.statusAccount = statusAccount;
    }
}
