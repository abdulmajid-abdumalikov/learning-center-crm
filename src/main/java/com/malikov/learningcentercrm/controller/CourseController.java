package com.malikov.learningcentercrm.controller;

import com.malikov.learningcentercrm.model.Course;
import com.malikov.learningcentercrm.service.CourseService;
import com.malikov.learningcentercrm.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/courses")
public class CourseController extends HttpServlet {
    private final CourseService courseService = Beans.courseService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("courses", courseService.getCourses());
        req.getRequestDispatcher("courses.jsp").forward(req, resp);
    }
}
