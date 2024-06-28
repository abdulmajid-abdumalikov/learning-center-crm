package com.malikov.learningcentercrm.servlet;

import com.malikov.learningcentercrm.service.CourseService;
import com.malikov.learningcentercrm.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete-course")
public class DeleteCourseServlet extends HttpServlet {

    private final CourseService courseService = Beans.courseService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("courseId");
        courseService.delete(id);
        resp.sendRedirect("/courses");
    }
}
