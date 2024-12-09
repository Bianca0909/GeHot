
package service;

import java.util.List;
import model.bo.Leito;
import model.dao.LeitoDAO;


public class ServiceLeito {
    
     public static void adicionar(Leito objeto) {
        LeitoDAO leitoDAO = new LeitoDAO();
        leitoDAO.create(objeto);
    }
     public static List<Leito> ler() {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve();
    }

    public static Leito ler(int PK) {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve(PK);
    }

    public static List<Leito> ler(String parametro, String atributo) {
        LeitoDAO leitoDAO = new LeitoDAO();
        return leitoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Leito objeto){
        LeitoDAO leitoDAO = new LeitoDAO();
        leitoDAO.update(objeto);
    }
     
    
}
