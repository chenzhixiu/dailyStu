package com.abead.dao.impl;

import com.abead.dao.CustomerDAO;
import com.abead.entity.Customer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:29
 */
public class CustomerDAOImpl implements CustomerDAO {
    Connection conn;
    public CustomerDAOImpl(Connection conn){
        this.conn = conn;
    }
    public boolean doIns(Customer pojo) {
        boolean flag=false;
        PreparedStatement pstate = null;
        try {
            this.conn.setAutoCommit(false);
            String sql="insert into customer(customer_id,customer_name,customer_sex,customer_tel,customer_adress,customer_pro_id)values(DH1.nextval,?,?,?,?,?)";
            pstate = this.conn.prepareStatement(sql);
            pstate.setString(1,pojo.getCustomerName());
            pstate.setInt(2,pojo.getCustomerSex());
            pstate.setString(3,pojo.getCustomerTel());
            pstate.setString(4,pojo.getCustomerAdress());
            pstate.setString(5,pojo.getCustomerProId());
            pstate.execute();
            this.conn.commit();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            try {
                pstate.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean doDel(String customerId) {//伪删除，使信息不可见，方便误删找回
        boolean flag = false;
        PreparedStatement pstate = null;
        try {
            this.conn.setAutoCommit(false);
            String sql = "update customer set is_delete=0 wherecustomer_id = ?";
            pstate = this.conn.prepareStatement(sql);
            pstate.setString(1, customerId);
            pstate.execute();
            this.conn.commit();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.conn.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally{
            try {
                pstate.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return flag;
    }

    public boolean doUpd(Customer pojo) {
        boolean flag = false;
        PreparedStatement pstate = null;
        try {
            this.conn.setAutoCommit(false);
            String sql = "update customer setcustomer_name=?,password=?,customer_sex=?,customer_tel=?,customer_adress=?,customer_pro_id=?,is_delete=?,role_mark=?where customer_id=?";
            pstate = this.conn.prepareStatement(sql);
            pstate.setString(1,pojo.getCustomerId());
            pstate.setString(2,pojo.getCustomerName());
            pstate.setString(3,pojo.getPassword());
            pstate.setInt(4,pojo.getCustomerSex());
            pstate.setString(5,pojo.getCustomerTel());
            pstate.setString(6, pojo.getCustomerAdress());
            pstate.setString(7,pojo.getCustomerProId());
            pstate.setInt(8, pojo.getIsDelete());
            pstate.setInt(9, pojo.getRoleMark());
            pstate.execute();
            this.conn.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                this.conn.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally{
            try {
                pstate.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return flag;
    }

    public Customer findById(String customerId) {
        Customer pojo = null;
        PreparedStatement pstate = null;
        ResultSet res = null;
        String sql = "select customer_name, password,customer_sex, customer_tel, customer_adress, customer_pro_id, is_delete, role_mark from customer where customer_id = ? and is_delete=1";
        try {
            pstate = this.conn.prepareStatement(sql);
            pstate.setString(1, customerId);
            res = pstate.executeQuery();
            while(res.next()){
                pojo=new Customer(customerId,res.getString(1),res.getString(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
           close(res,pstate);
        }
        return pojo;
    }

    public Customer findByName(String customerName) {
        Customer pojo = null;
        PreparedStatement pstate = null;
        ResultSet res = null;
        String sql = "select customer_id, password,customer_sex, customer_tel, customer_adress, customer_pro_id, is_delete,role_mark from customer where customer_name = ? and is_delete=1";
        try {
            pstate = this.conn.prepareStatement(sql);
            pstate.setString(1, customerName);
            res = pstate.executeQuery();
            while(res.next()){
                pojo=new Customer(res.getString(1),customerName,res.getString(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getInt(8));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(res,pstate);
        }
        return pojo;
    }

    public void close(ResultSet res,PreparedStatement pstate){
        try {
            res.close();
            pstate.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    public List<Customer> findAll(int pageSize, int pageCurrent) {
        List<Customer> list = new ArrayList<Customer>();
        PreparedStatement pstate = null;
        ResultSet res = null;
        String sql = "select customer_id, customer_name,password, customer_sex, customer_tel, customer_adress, customer_pro_id,is_delete, role_mark  from customer limit ?,?" ;
        try {
            pstate = this.conn.prepareStatement(sql);
            pstate.setInt(1,(pageCurrent-1) * pageSize);
            pstate.setInt(2, pageSize);
            res = pstate.executeQuery();
            while(res.next()){
                Customer pojo=new Customer(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getString(6),res.getString(7),res.getInt(8),res.getInt(9));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
           close(res,pstate);
        }
        return list;
    }
    public int findAllCount() {
        int count = 0;
        PreparedStatement pstate = null;
        ResultSet res = null;
        String sql = "select count(customer_id) from customer" ;
        try {
            pstate = this.conn.prepareStatement(sql);
            res = pstate.executeQuery();
            while(res.next()){
                count = res.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            close(res,pstate);
        }
        return count;
    }
}
