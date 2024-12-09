package service;

import java.util.List;
import model.bo.Fornecedor;
import model.dao.FornecedorDAO;

public class ServiceFornecedor {
    
     public static void adicionar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    public static List<Fornecedor> ler() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve();
    }

    public static Fornecedor ler(int PK) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(PK);
    }

    public static List<Fornecedor> ler(String parametro, String atributo) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Fornecedor objeto){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(objeto);
    } 
}
