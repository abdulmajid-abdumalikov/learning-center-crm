package com.malikov.learningcentercrm.service;

import com.malikov.learningcentercrm.model.BaseModel;
import com.malikov.learningcentercrm.repository.BaseRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public abstract class BaseService<R extends BaseRepository<T>, T extends BaseModel> {
    R repository;

    public void save(T model) {
        repository.save(model);
    }

    public T findById(Integer id) {
        return repository.findById(id);
    }

    public boolean deleteById(Integer id) {
        return repository.deleteById(id);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public T update(String id, T model) {
        return repository.update(id, model);
    }

}
