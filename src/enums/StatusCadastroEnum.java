package enums;

public enum StatusCadastroEnum {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");   

     private String valor;
   
    StatusCadastroEnum(String valor) {
    this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }

    
}
