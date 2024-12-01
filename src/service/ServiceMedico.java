package service;

import java.util.List;
import model.bo.Medico;
import model.dao.MedicoDAO;

public class ServiceMedico {

    public static void adicionar(Medico objeto) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.create(objeto);
    }

    public static List<Medico> ler() {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve();
    }

    public static Medico ler(int PK) {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve(PK);
    }

    public static List<Medico> ler(String parametro, String atributo) {
        MedicoDAO medicoDAO = new MedicoDAO();
        return medicoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Medico objeto) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.update(objeto);
    }
}
