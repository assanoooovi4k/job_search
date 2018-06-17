package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/searchResumes")
public class SearchResumesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKey = req.getParameter("search");
        VacancyDao vacancyDao = new VacancyDao();
        List searchResumes = vacancyDao.search("title", "Resume", searchKey);
        req.getSession().setAttribute("searchList", searchResumes);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);

    }
}
