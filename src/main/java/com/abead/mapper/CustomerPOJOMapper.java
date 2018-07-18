package com.abead.mapper;


import com.abead.entity.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/28 13:35
 */
public interface CustomerPOJOMapper {
    public Customer selectBlog(long id);
    public long insertCustomer(@Param("customer") Customer customer);

    public long selectMaxId();
    public long selectCount();
}
