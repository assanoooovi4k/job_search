package by.prostrmk.controller;

import by.prostrmk.dao.UserDao;
import by.prostrmk.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/submit/*")
public class SubmitController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("tok");
        String sysToken = (String) req.getSession().getAttribute("token");
        if (token.equals(sysToken)) {
            User user = (User) req.getSession().getAttribute("user");
            new UserDao().saveEntity(user);
        }
    }
}
