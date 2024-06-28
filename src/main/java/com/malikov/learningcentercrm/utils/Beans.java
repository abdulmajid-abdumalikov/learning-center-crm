package com.malikov.learningcentercrm.utils;

import com.malikov.learningcentercrm.service.CourseService;
import com.malikov.learningcentercrm.service.GroupService;
import com.malikov.learningcentercrm.service.StudentService;
import com.malikov.learningcentercrm.service.UserService;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Beans {

    public static final UserService userService = UserService.getInstance();
    public static final StudentService studentService = StudentService.getInstance();
    public static final CourseService courseService = CourseService.getInstance();
    public static final GroupService groupService = GroupService.getInstance();


    @Getter
    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/learning-center-crm",
                    "postgres",
                    "0800"
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
