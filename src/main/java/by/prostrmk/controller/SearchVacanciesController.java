package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/searchVacancies/*")
public class SearchVacanciesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKey = req.getParameter("search");
        VacancyDao vacancyDao = new VacancyDao();
        List searchVacancies = vacancyDao.search("title", "Vacancy", searchKey);
        req.getSession().setAttribute("searchList", searchVacancies);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);

    }
}
