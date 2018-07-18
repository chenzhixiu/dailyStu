package com.abead.proxy;

import com.abead.dao.CustomerDAO;
import com.abead.dao.impl.CustomerDAOImpl;
import com.abead.entity.Customer;
import com.abead.util.JDBCHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:56
 */
public class CustomerDAOProxy implements CustomerDAO {
    Connection conn = null;
    CustomerDAOImpl impl=null;
    public CustomerDAOProxy(){
        try {
            this.conn= JDBCHelper.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.impl=new CustomerDAOImpl(this.conn);
    }
    public boolean doIns(Customer pojo) {
        boolean flag = this.impl.doIns(pojo);
        close();
        return flag;
    }
    public boolean doDel(String customerId) {
        boolean flag = this.impl.doDel(customerId);
        close();
        return flag;
    }
    public boolean doUpd(Customer pojo) {
        boolean flag = this.impl.doUpd(pojo);
        close();
        return flag;
    }
    public Customer findById(String cid) {
        Customer pojo = this.impl.findById(cid);
        close();
        return pojo;

    }
    public Customer findByName(String cname) {
        Customer pojo = this.impl.findByName(cname);
        close();
        return pojo;
    }
    public List<Customer> findAll(int pageSize, int pageCurrent) {
        List<Customer> list=this.impl.findAll(pageSize, pageCurrent);
        close();
        return list;
    }
    public int findAllCount() {
        int count=this.impl.findAllCount();
        close();
        return count;
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
