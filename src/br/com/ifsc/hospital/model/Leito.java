package br.com.ifsc.hospital.model;

public class Leito {

	private Integer id;
	private String descricao;
	private String status;
	private Quarto quarto;
	
	public Leito(Integer id, String descricao, String status, Quarto quarto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.quarto = quarto;
	}
	
	public Leito() {
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

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
}
