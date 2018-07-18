package com.abead.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 16:17
 */
@Alias("Employee")
public class Employee {
  private float EMPLOYEE_ID;
  private String FIRST_NAME;
  private String LAST_NAME;
  private String EMAIL;
  private String PHONE_NUMBER;
  private Date HIRE_DATE;
  private String JOB_ID;
  private float SALARY;
  private float COMMISSION_PCT;
  private float MANAGER_ID;
  private float DEPARTMENT_ID;

    public float getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public void setEMPLOYEE_ID(float EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public Date getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(Date HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public String getJOB_ID() {
        return JOB_ID;
    }

    public void setJOB_ID(String JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public float getSALARY() {
        return SALARY;
    }

    public void setSALARY(float SALARY) {
        this.SALARY = SALARY;
    }

    public float getCOMMISSION_PCT() {
        return COMMISSION_PCT;
    }

    public void setCOMMISSION_PCT(float COMMISSION_PCT) {
        this.COMMISSION_PCT = COMMISSION_PCT;
    }

    public float getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(float MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public float getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(float DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }
}
