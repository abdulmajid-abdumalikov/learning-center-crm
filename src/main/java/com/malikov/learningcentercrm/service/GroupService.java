package com.malikov.learningcentercrm.service;

import com.malikov.learningcentercrm.model.Group;
import com.malikov.learningcentercrm.repository.GroupRepository;
import lombok.Getter;

import java.util.UUID;

public class GroupService extends BaseService<GroupRepository, Group>{

    @Getter
    private static final GroupService instance = new GroupService();

    public GroupService( ) {
        super(GroupRepository.getInstance());
    }

    @Override
    public void save(Group model) {
         super.save(model);
    }

    @Override
    public Group findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.deleteById(id);
    }

    @Override
    public Iterable<Group> findAll() {
        return super.findAll();
    }

    @Override
    public Group update(String id, Group model) {
        return super.update(id, model);
    }
}
