package com.malikov.learningcentercrm.service;

import com.malikov.learningcentercrm.model.Student;
import com.malikov.learningcentercrm.repository.StudentRepository;
import lombok.Getter;

import java.util.UUID;

public class StudentService extends BaseService<StudentRepository, Student> {

    @Getter
    private static final StudentService instance = new StudentService();

    public StudentService() {
        super(StudentRepository.getInstance());
    }

    @Override
    public void save(Student model) {
         super.save(model);
    }

    @Override
    public Student findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.deleteById(id);
    }

    @Override
    public Iterable<Student> findAll() {
        return super.findAll();
    }

    @Override
    public Student update(String id, Student model) {
        return super.update(id, model);
    }
}
