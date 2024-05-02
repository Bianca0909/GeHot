
package br.com.ifsc.hospital.model;

import java.time.LocalDateTime;


public class Receita {
    private Integer id;
    private LocalDateTime dataHoraReceita;
    private String observacao;
    private String status;
    
    public Receita(){
        
    }

    public Receita(Integer id, LocalDateTime dataHoraReceita, String observacao, String status) {
        this.id = id;
        this.dataHoraReceita = dataHoraReceita;
        this.observacao = observacao;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraReceita() {
        return dataHoraReceita;
    }

    public void setDataHoraReceita(LocalDateTime dataHoraReceita) {
        this.dataHoraReceita = dataHoraReceita;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
       
}
