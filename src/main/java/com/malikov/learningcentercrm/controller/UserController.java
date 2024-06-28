package com.malikov.learningcentercrm.controller;

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

@WebServlet(value = {"/login"})
public class UserController extends HttpServlet {

    private final UserService userService = Beans.userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.login(username, password);

            if (user != null) {
                String redirectPage = determineRedirectPage(String.valueOf(user.getRole()));
                request.setAttribute("currentUser", user);
                request.getRequestDispatcher(redirectPage).forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private String determineRedirectPage(String role) {
        switch (role) {
            case "SUPER_ADMIN":
                return "sa-menu.jsp";
            case "ADMIN":
                return "a-menu.jsp";
            case "MENTOR":
                return "m-menu.jsp";
            default:
                return "error.jsp";
        }
    }
}
