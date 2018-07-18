package com.abead.proxy;

import com.abead.dao.CustomerDAO;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:59
 */
public class CustomerDAOFactory {
    public static CustomerDAO getDAOInstance(){
        return new CustomerDAOProxy();
    }
}
