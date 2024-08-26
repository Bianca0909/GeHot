package model.bo;

import java.util.ArrayList;

public class ClasseDadosGravacao {
    
   private static ClasseDadosGravacao uniqueinstance;
    public static ArrayList<Medicamento> listaMedicamento = new ArrayList<>();
    public static ArrayList<Laboratorio> listaLaboratorio = new ArrayList<>();

    private ClasseDadosGravacao() {
    }

    public static synchronized ClasseDadosGravacao getInstance() {

        if (uniqueinstance == null) {
            uniqueinstance = new ClasseDadosGravacao();
        }

        return uniqueinstance;
    }
    
}
