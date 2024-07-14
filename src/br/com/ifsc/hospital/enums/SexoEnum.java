
package br.com.ifsc.hospital.enums;

public enum SexoEnum {
    FEMININO("Feminino"),
    MASCULINO("Masculino"),
    INTERSEXO("Intersexo");
    
    private String valor;
   
    SexoEnum(String valor) {
    this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
   
}
