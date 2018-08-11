package com.lingh.test.service;

import com.lingh.test.db.dao.TResourceMapper;
import com.lingh.test.db.entity.TResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceService {

    @Resource
    TResourceMapper resourceMapper;

    public List<TResource> getAll() {
        return resourceMapper.selectAll();
    }

    public List<TResource> getByUserId(Integer userId) {
        return resourceMapper.getByUserId(userId);
    }
}
