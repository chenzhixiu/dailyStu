package com.abead.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 16:13
 */
@Alias("Department")
public class Department {
    private float DEPARTMENT_ID;
    private String DEPARTMENT_NAME;
    private float MANAGER_ID;
    private float LOCATION_ID;

    public float getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(float DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }

    public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public float getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(float MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public float getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(float LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }
}
