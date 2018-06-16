package by.prostrmk.controller;

import by.prostrmk.dao.VacancyDao;
import by.prostrmk.model.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/vacancy/*")
public class VacancyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = req.getRequestURI().split("/");
        String id = params[params.length - 1];
        req.setAttribute("o", new VacancyDao().getById(Long.valueOf(id), Vacancy.class));
        req.getRequestDispatcher("/uservacancy.jsp").forward(req, resp);

    }
}
