package com.abead.dao;

import com.abead.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:28
 */
public interface CustomerDAO {
    /**
     * @param pojo 客户类
     * @return 新增客户
     */
    public boolean doIns(Customer pojo);
    /**
     * @param customerId  客户id
     * @return 删除客户
     */
    public boolean doDel(String customerId);
    /**
     * @param pojo  客户类
     * @return 更新客户信息
     */
    public boolean doUpd(Customer pojo);
    /**
     * @param
     * @return 根据客户id，名称查询客户所有信息
     */
    public Customer findById(String cid);
    /**
     * @param
     * @return 根据客户名查询全部信息
     */
    public Customer findByName(String cname);
    /**
     * 列出所有客户
     */
    public List<Customer> findAll(int pageSize, int pageCurrent);

    /**
     *查询客户数量
     */
    public int findAllCount();
}
