package com.abead.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 16:20
 */
@Alias("Location")
public class Location {
  private float LOCATION_ID;
  private String STREET_ADDRESS;
  private String POSTAL_CODE;
  private String CITY;
  private String STATE_PROVINCE;
  private String COUNTRY_ID;

    public float getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(float LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }

    public String getSTREET_ADDRESS() {
        return STREET_ADDRESS;
    }

    public void setSTREET_ADDRESS(String STREET_ADDRESS) {
        this.STREET_ADDRESS = STREET_ADDRESS;
    }

    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE_PROVINCE() {
        return STATE_PROVINCE;
    }

    public void setSTATE_PROVINCE(String STATE_PROVINCE) {
        this.STATE_PROVINCE = STATE_PROVINCE;
    }

    public String getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(String COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }
}
