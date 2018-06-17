package by.prostrmk.controller;

import by.prostrmk.dao.Dao;
import by.prostrmk.dao.VacancyDao;
import by.prostrmk.model.entity.Resume;
import by.prostrmk.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/createResume")
public class CreateResumeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("newResume.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            resp.sendRedirect("/auth.jsp");
        }else{
            Resume resume = new Resume(user.getMail(),user.getUsername(), req.getParameter("university"), req.getParameter("title"), req.getParameter("content"));
            Dao dao = new VacancyDao();
            dao.saveEntity(resume);
        }
    }
}
