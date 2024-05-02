
package br.com.ifsc.hospital.model;


public class ReceitaMedicamento {
    private Integer id;
    private String prescricao;
    private String status;
    private Receita receita;
    private Medicamento medicamento;
    
    
    public ReceitaMedicamento(){
        
    }

    public ReceitaMedicamento(Integer id, String prescricao, String status, Receita receita, Medicamento medicamento) {
        this.id = id;
        this.prescricao = prescricao;
        this.status = status;
        this.receita =  receita;
        this.medicamento = medicamento;
        
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
}
