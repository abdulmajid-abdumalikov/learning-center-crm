package com.malikov.learningcentercrm.repository;

import com.malikov.learningcentercrm.model.BaseModel;
import com.malikov.learningcentercrm.utils.Beans;

import java.sql.Connection;
import java.util.UUID;

public interface BaseRepository<T extends BaseModel> {

    Connection connection = Beans.getConnection();


    void save(T model);
    T findById(Integer id);
    boolean deleteById(Integer id);
    Iterable<T> findAll();
    T update(String id, T model);
}
