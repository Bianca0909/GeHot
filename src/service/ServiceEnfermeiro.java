package service;

import java.util.List;
import model.bo.Enfermeiro;
import model.dao.EnfermeiroDAO;

public class ServiceEnfermeiro {

    public static void adicionar(Enfermeiro objeto) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        enfermeiroDAO.create(objeto);
    }

    public static List<Enfermeiro> ler() {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve();
    }

    public static Enfermeiro ler(int PK) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve(PK);
    }

    public static List<Enfermeiro> ler(String parametro, String atributo) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Enfermeiro objeto) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        enfermeiroDAO.update(objeto);
    }
}
