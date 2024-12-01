package service;

import java.util.List;
import model.bo.Laboratorio;
import model.dao.LaboratorioDAO;

public class ServiceLaboratorio {
    
     public static void adicionar(Laboratorio objeto) {
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        laboratorioDAO.create(objeto);
    }

    public static List<Laboratorio> ler() {
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return laboratorioDAO.retrieve();
    }

    public static Laboratorio ler(int PK) {
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return laboratorioDAO.retrieve(PK);
    }

    public static List<Laboratorio> ler(String parametro, String atributo) {
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        return laboratorioDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Laboratorio objeto){
        LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        laboratorioDAO.update(objeto);
    }
}
