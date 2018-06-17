package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;
import by.prostrmk.model.entity.User;
import by.prostrmk.model.entity.Vacancy;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/me/removeVacancy/*")
public class RemoveVacancyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long id = Long.valueOf(req.getParameter("id"));
        if (user != null && req.getParameter("id")!=null) {
            Vacancy vacancy = (Vacancy) new VacancyDao().getById(id, Vacancy.class);
            new VacancyDao().deleteEntity(vacancy);
        }
    }
}
