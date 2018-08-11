package com.lingh.test.db.dao;

import com.lingh.test.db.entity.TResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TResource record);

    TResource selectByPrimaryKey(Integer id);

    List<TResource> selectAll();

    int updateByPrimaryKey(TResource record);

    List<TResource> getByUserId(@Param("userId") Integer userId);
}