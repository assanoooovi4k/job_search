package by.prostrmk.controller;

import by.prostrmk.dao.UserDao;
import by.prostrmk.model.entity.User;
import by.prostrmk.model.util.HibernateUtil;
import by.prostrmk.model.util.MailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("username"), req.getParameter("mail"), HibernateUtil.hashString(req.getParameter("password")));
        if (!new UserDao().checkUser(user.getUsername())){
            MailUtil mailUtil = new MailUtil("brinkpool@gmail.com", "Brinkpool1999");
            String token = mailUtil.token();
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("token", token);
            try {
                mailUtil.send("Welcome", "Please submit registration: localhost:8080/submit?tok=" + token, user.getMail());
            } catch (MessagingException e) {
                System.out.println(e.toString());
            }
        }

    }
}
