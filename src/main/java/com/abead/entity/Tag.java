package com.abead.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 15:38
 */
@Alias("Tag")
public class Tag {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
