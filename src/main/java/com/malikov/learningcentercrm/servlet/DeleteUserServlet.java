package com.malikov.learningcentercrm.servlet;

import com.malikov.learningcentercrm.service.UserService;
import com.malikov.learningcentercrm.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete-user")
public class DeleteUserServlet extends HttpServlet {

    private final UserService userService = Beans.userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        userService.delete(id);
        resp.sendRedirect("/users");
    }
}
