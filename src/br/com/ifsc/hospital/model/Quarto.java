package br.com.ifsc.hospital.model;

public class Quarto {

	private Integer id;
	private String descricao;
	private String status;
	private Ala ala;
	
	public Quarto(Integer id, String descricao, String status, Ala ala) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.ala = ala;
	}
	
	public Quarto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Ala getAla() {
		return ala;
	}

	public void setAla(Ala ala) {
		this.ala = ala;
	}
	
}
