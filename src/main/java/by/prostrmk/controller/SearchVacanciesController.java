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
        for (int i = 0; i < 10; i++) {
            System.out.println(searchKey);
        }
        VacancyDao vacancyDao = new VacancyDao();
        List searchVacancies = vacancyDao.search("title", "Vacancy", searchKey);
        for (Object searchVacancy : searchVacancies) {
            System.out.println(searchVacancy.toString());
        }
        req.getSession().setAttribute("searchList", searchVacancies);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);

    }
}
