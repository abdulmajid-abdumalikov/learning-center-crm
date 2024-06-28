package com.malikov.learningcentercrm.service;

import com.malikov.learningcentercrm.model.Course;
import com.malikov.learningcentercrm.repository.CourseRepository;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class CourseService extends BaseService<CourseRepository, Course>{

    @Getter
    private static final CourseService instance = new CourseService();

    public CourseService() {
        super(CourseRepository.getInstance());
    }

    @Override
    public void save(Course model) {
        super.save(model);
    }

    @Override
    public Course findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.deleteById(id);
    }

    @Override
    public Iterable<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Course update(String id, Course model) {
        return super.update(id, model);
    }

    public List<Course> getCourses() {
        return repository.getCourses();
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
