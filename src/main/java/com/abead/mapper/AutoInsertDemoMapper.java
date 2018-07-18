package com.abead.mapper;

import com.abead.entity.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoInsertDemoMapper {
    public void autoInsertDemo(@Param("data")List<Demo> list);
}
