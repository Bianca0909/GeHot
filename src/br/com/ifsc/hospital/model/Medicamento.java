
package br.com.ifsc.hospital.model;


public class Medicamento {
    private Integer id;
    private String descricaoMedicamento;
    private String principioAtivo;
    private float qtdMinima;
    private String status;
    
    public Medicamento(){
        
    }

    public Medicamento(Integer id, String descricaoMedicamento, String principioAtivo, float qtdMinima, String status) {
        this.id = id;
        this.descricaoMedicamento = descricaoMedicamento;
        this.principioAtivo = principioAtivo;
        this.qtdMinima = qtdMinima;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricaoMedicamento() {
        return descricaoMedicamento;
    }

    public void setDescricaoMedicamento(String descricaoMedicamento) {
        this.descricaoMedicamento = descricaoMedicamento;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public float getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(float qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
}
