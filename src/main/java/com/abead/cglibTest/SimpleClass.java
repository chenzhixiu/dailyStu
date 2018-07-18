package com.abead.cglibTest;

import java.util.Collections;
import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 14:32
 */
public final class SimpleClass {
    //static final long serialVersionUID = 3905348978240129619L;
    public  void sort(List<String> list){
        Collections.sort(list);
    }
    public void g(){
        System.out.println("g");
    }
}
