package br.com.ifsc.hospital.model;

import java.time.LocalDate;

public class Jornada {

	private Integer id;
	private LocalDate dataInicial;
	private Integer cargaHoraria;
	private Medico medico;
	private Enfermeiro enfermeiro;
	private Farmaceutico farmaceutico;
	
	public Jornada(Integer id, LocalDate dataInicial, Integer cargaHoraria, Medico medico, Enfermeiro enfermeiro,
			Farmaceutico farmaceutico) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.cargaHoraria = cargaHoraria;
		this.medico = medico;
		this.enfermeiro = enfermeiro;
		this.farmaceutico = farmaceutico;
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
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}
	public void setEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiro = enfermeiro;
	}
	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}
	public void setFarmaceutico(Farmaceutico farmaceutico) {
		this.farmaceutico = farmaceutico;
	}
	
}
