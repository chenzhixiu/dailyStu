package com.abead.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:32
 */
@Alias("Customer")
public class Customer implements Serializable {
    private long id;
    private String customerId;
    private String customerName;
    private String password;
    private int customerSex;
    private String customerTel;
    private String customerAdress;
    private String customerProId;
    private int isDelete;
    private int roleMark;

    public Customer(){}
    public Customer(String customerId, String string, String string1, int anInt, String string2, String string3, String bigDecimal, int anInt1, int anInt2) {
         this.customerId =customerId;
         customerName = string;
         password = string1;
         customerSex = anInt;
         customerTel = string2;
         customerAdress = string3;
         customerProId = bigDecimal;
         isDelete = anInt1;
         roleMark = anInt2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer(String cname, int csex, String ctel, String cadress, String cpid) {
        customerName = cname;
        customerSex = csex;
        customerTel = ctel;
        customerAdress = cadress;
        customerProId = cpid;
    }

    public void setCustomerSex(int customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerSex() {
        return customerSex;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getRoleMark() {
        return roleMark;
    }

    public void setRoleMark(int roleMark) {
        this.roleMark = roleMark;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerProId() {
        return customerProId;
    }

    public void setCustomerProId(String customerProId) {
        this.customerProId = customerProId;
    }
}
