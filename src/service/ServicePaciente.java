
package service;

import java.util.List;
import model.bo.Paciente;
import model.dao.PacienteDAO;


public class ServicePaciente {
    
     public static void adicionar(Paciente objeto) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.create(objeto);
    }
     public static List<Paciente> ler() {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve();
    }

    public static Paciente ler(int PK) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve(PK);
    }

    public static List<Paciente> ler(String parametro, String atributo) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Paciente objeto){
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.update(objeto);
    }
    
}
