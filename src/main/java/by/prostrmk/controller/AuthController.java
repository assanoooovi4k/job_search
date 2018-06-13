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
        User user = new User(req.getParameter("username"), req.getParameter("password"));
        if (user.getUsername().length() < 4 || user.getPassword().equals("")){
            resp.getWriter().write("bad username");
        }else{
            new UserDao().saveEntity(user);
            resp.getWriter().write("ok,saved");
        }

    }
}
