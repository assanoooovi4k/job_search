package by.prostrmk.dao;

import by.prostrmk.model.entity.Vacancy;
import by.prostrmk.model.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class VacancyDao extends AbstractDao{

    public List getAllVacancies(){
        return super.getAll("username", Vacancy.class);
    }

    public List getVacanciesByUsername(String username){
        return super.getByStringParamList("username", username, Vacancy.class);
    }

}
