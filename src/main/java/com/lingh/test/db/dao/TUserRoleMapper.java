package com.lingh.test.db.dao;

import com.lingh.test.db.entity.TUserRole;
import java.util.List;

public interface TUserRoleMapper {
    int insert(TUserRole record);

    List<TUserRole> selectAll();
}