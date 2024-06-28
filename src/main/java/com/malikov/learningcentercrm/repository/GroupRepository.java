package com.malikov.learningcentercrm.repository;

import com.malikov.learningcentercrm.model.Group;
import lombok.Getter;

import java.util.UUID;

public class GroupRepository implements BaseRepository<Group>{
    @Getter
    private static final GroupRepository instance = new GroupRepository();
    @Override
    public void save(Group model) {

    }

    @Override
    public Group findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public Iterable<Group> findAll() {
        return null;
    }

    @Override
    public Group update(String id, Group model) {
        return null;
    }
}
