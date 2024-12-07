package service;

import java.util.List;
import model.bo.Farmaceutico;
import model.dao.FarmaceuticoDAO;

public class ServiceFarmaceutico {
         public static void adicionar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.create(objeto);
    }

    public static List<Farmaceutico> ler() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve();
    }

    public static Farmaceutico ler(int PK) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(PK);
    }

    public static List<Farmaceutico> ler(String parametro, String atributo) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Farmaceutico objeto){
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.update(objeto);
    } 
}
