package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;
import by.prostrmk.model.entity.User;
import by.prostrmk.model.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/createVacancy")
public class CreateVacancyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/auth.jsp").forward(req, resp);

        }
        req.getRequestDispatcher("/newVacancy.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        Vacancy vacancy = new Vacancy(user.getMail(), user.getUsername(), req.getParameter("title"), new Date().toString(), req.getParameter("salary"), req.getParameter("content"));
        VacancyDao vacancyDao = new VacancyDao();
        vacancyDao.saveEntity(vacancy);
    }
}
