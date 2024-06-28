package com.malikov.learningcentercrm.repository;

import com.malikov.learningcentercrm.model.Student;
import lombok.Getter;

import java.util.UUID;

public class StudentRepository implements BaseRepository<Student>{
    @Getter
    private static final StudentRepository instance = new StudentRepository();
    @Override
    public void save(Student model) {

    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public Student update(String id, Student model) {
        return null;
    }
}
