package com.abead.cglibTest;

import java.beans.PropertyChangeListener;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 14:24
 */
public abstract class Bean implements java.io.Serializable{

    String sampleProperty;

    abstract public void addPropertyChangeListener(PropertyChangeListener listener);

    abstract public void removePropertyChangeListener(PropertyChangeListener listener);

    public String getSampleProperty(){
        return sampleProperty;
    }

    public void setSampleProperty(String value){
        this.sampleProperty = value;
    }

    public String toString(){
        return "sampleProperty is " + sampleProperty;
    }

}
