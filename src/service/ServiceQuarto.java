
package service;

import java.util.List;
import model.bo.Quarto;
import model.dao.QuartoDAO;



public class ServiceQuarto {
    
    public static void adicionar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.create(objeto);
    }
     public static List<Quarto> ler() {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve();
    }

    public static Quarto ler(int PK) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(PK);
    }

    public static List<Quarto> ler(String parametro, String atributo) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Quarto objeto){
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.update(objeto);
    }
    
}
