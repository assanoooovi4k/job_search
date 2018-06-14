package by.prostrmk.controller;

import by.prostrmk.dao.UserDao;
import by.prostrmk.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        if (new UserDao().checkUser(username)){
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            resp.getWriter().write("No user!");
        }


    }
}
