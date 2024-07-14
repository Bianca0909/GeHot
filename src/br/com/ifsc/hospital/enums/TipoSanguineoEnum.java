package br.com.ifsc.hospital.enums;

public enum TipoSanguineoEnum {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_NEGATIVO("B-"),
    B_POSITIVO("B+"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_NEGATIVO("O-"),
    O_POSITIVO("O+");
    
    private String valor;
   
    TipoSanguineoEnum(String valor) {
    this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
    
    
    
}
