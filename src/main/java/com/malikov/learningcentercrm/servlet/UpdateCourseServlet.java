package com.malikov.learningcentercrm.servlet;

import com.malikov.learningcentercrm.model.Course;
import com.malikov.learningcentercrm.model.Role;
import com.malikov.learningcentercrm.model.User;
import com.malikov.learningcentercrm.service.CourseService;
import com.malikov.learningcentercrm.service.UserService;
import com.malikov.learningcentercrm.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/update-course")
public class UpdateCourseServlet extends HttpServlet {

    private final CourseService courseService = Beans.courseService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String id = req.getParameter("courseId");

        Course course = courseService.update(id, Course.builder()
                .name(name)
                .description(description)
                .price(Double.valueOf(price))
                .build());

        resp.sendRedirect("/courses");
    }
}
