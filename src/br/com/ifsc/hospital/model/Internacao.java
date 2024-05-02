package br.com.ifsc.hospital.model;

import java.time.LocalDateTime;

public class Internacao {

	private Integer id;
	private LocalDateTime dataHoraInternacao;
	private LocalDateTime dataHoraAlta;
	private String observacao;
	private String status;
	private Consulta consulta;
	
	public Internacao(Integer id, LocalDateTime dataHoraInternacao, LocalDateTime dataHoraAlta, String observacao,
			String status, Consulta consulta) {
		super();
		this.id = id;
		this.dataHoraInternacao = dataHoraInternacao;
		this.dataHoraAlta = dataHoraAlta;
		this.observacao = observacao;
		this.status = status;
		this.consulta = consulta;
	}
	
	public Internacao() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataHoraInternacao() {
		return dataHoraInternacao;
	}
	public void setDataHoraInternacao(LocalDateTime dataHoraInternacao) {
		this.dataHoraInternacao = dataHoraInternacao;
	}
	public LocalDateTime getDataHoraAlta() {
		return dataHoraAlta;
	}
	public void setDataHoraAlta(LocalDateTime dataHoraAlta) {
		this.dataHoraAlta = dataHoraAlta;
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
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
}
