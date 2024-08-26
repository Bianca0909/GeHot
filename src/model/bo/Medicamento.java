
package model.bo;


public class Medicamento {
    private Integer id;
    private String descricaoMedicamento;
    private String principioAtivo;
    private float qtdMinima;
    private String status;
    private Laboratorio laboratorio;
    private String codigoBarras;
    
    public Medicamento(){
        
    }

    public Medicamento(Integer id, String descricaoMedicamento, String principioAtivo, float qtdMinima, String status, Laboratorio laboratorio, String codigoBarras) {
        this.id = id;
        this.descricaoMedicamento = descricaoMedicamento;
        this.principioAtivo = principioAtivo;
        this.qtdMinima = qtdMinima;
        this.status = status;
        this.laboratorio = laboratorio;
        this.codigoBarras = codigoBarras;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}
