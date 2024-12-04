package model.bo;

import java.time.LocalDate;

public class Jornada {

    private Integer id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Integer cargaHoraria;
    private Integer profissionalId;

    public Jornada(Integer id, LocalDate dataInicial, LocalDate dataFinal, Integer cargaHoraria, Integer profissionalId) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargaHoraria = cargaHoraria;
        this.profissionalId = profissionalId;
    }

    public Jornada() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    
}
