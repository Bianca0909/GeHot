package service;

import model.bo.Jornada;
import model.dao.JornadaDAO;

public class ServiceJornada {

    public static void adicionar(Jornada objeto) {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.create(objeto);
    }

    public static void atualizar(Jornada objeto) {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.update(objeto);
    }

    public static void deletar(Jornada objeto) {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.delete(objeto);
    }
}
