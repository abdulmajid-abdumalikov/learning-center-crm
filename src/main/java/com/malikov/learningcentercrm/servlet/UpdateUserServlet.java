package com.malikov.learningcentercrm.servlet;

import com.malikov.learningcentercrm.model.Role;
import com.malikov.learningcentercrm.model.User;
import com.malikov.learningcentercrm.service.UserService;
import com.malikov.learningcentercrm.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/update-user")
public class UpdateUserServlet extends HttpServlet {

    private final UserService userService = Beans.userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String id = req.getParameter("userId");

        User user = userService.update(id, User.builder()
                .name(name)
                .username(username)
                .password(password)
                .role(Role.valueOf(role))
                .build());

        resp.sendRedirect("/users");

    }

}
