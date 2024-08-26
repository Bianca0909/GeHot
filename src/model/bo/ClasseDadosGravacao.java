package model.bo;

import java.util.ArrayList;

public class ClasseDadosGravacao {
    
   private static ClasseDadosGravacao uniqueinstance;
   public static ArrayList<Medicamento> listaMedicamento = new ArrayList<>();
   public static ArrayList<Laboratorio> listaLaboratorio = new ArrayList<>();
   public static ArrayList<Acompanhante> listaAcompanhante = new ArrayList<>();
   public static ArrayList<Ala> listaAla = new ArrayList<>();
   public static ArrayList<Leito> listaLeito = new ArrayList<>();
   public static ArrayList<Quarto> listaQuarto = new ArrayList<>();
   public static ArrayList<Paciente> listaPaciente = new ArrayList<>();
   public static ArrayList<Enfermeiro> listaEnfermeiro = new ArrayList<>();

    private ClasseDadosGravacao() {
    }

    public static synchronized ClasseDadosGravacao getInstance() {

        if (uniqueinstance == null) {
            uniqueinstance = new ClasseDadosGravacao();
        }

        return uniqueinstance;
    }
    
}
