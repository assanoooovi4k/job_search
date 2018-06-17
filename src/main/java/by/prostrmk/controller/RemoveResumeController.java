package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;
import by.prostrmk.model.entity.Resume;
import by.prostrmk.model.entity.User;
import by.prostrmk.model.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/me/removeResume/*")
public class RemoveResumeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && req.getParameter("id")!=null) {
            Resume resume = (Resume) new VacancyDao().getById(Long.valueOf(req.getParameter("id")), Resume.class);
            new VacancyDao().deleteEntity(resume);
        }
    }
}
