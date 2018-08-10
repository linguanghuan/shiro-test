package com.lingh.test.db.dao;

import com.lingh.test.db.entity.TRoleResource;
import java.util.List;

public interface TRoleResourceMapper {
    int insert(TRoleResource record);

    List<TRoleResource> selectAll();
}