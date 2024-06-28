package com.malikov.learningcentercrm.repository;

import com.malikov.learningcentercrm.model.Course;
import com.malikov.learningcentercrm.model.User;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.malikov.learningcentercrm.model.Course.map;

public class CourseRepository implements BaseRepository<Course> {
    @Getter
    private static final CourseRepository instance = new CourseRepository();

    @Override
    public void save(Course model) {
        String save = "insert into courses (name, description, price) values (?, ?, ?::double precision);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setString(3, String.valueOf(model.getPrice()));
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public Iterable<Course> findAll() {
        return null;
    }


    @Override
    public Course update(String id, Course model) {
        String update = "update courses set name = ?, description = ?, price = ?::double precision where id = ?::uuid returning *;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setString(3, String.valueOf(model.getPrice()));
            preparedStatement.setString(4, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Course.map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }


    public List<Course> getCourses() {
        PreparedStatement preparedStatement = null;
        List<Course> courses;
        try {
            preparedStatement = connection.prepareStatement("select * from courses;");
            ResultSet resultSet = preparedStatement.executeQuery();
            courses = new ArrayList<>();
            while (resultSet.next()) {
                Course course = Course.map(resultSet);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public void delete(String id) {
        String delete = "delete from courses where id =?::uuid;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
