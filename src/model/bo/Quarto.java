package model.bo;

public class Quarto {

	private Integer id;
	private String descricao;
	private String status;
	
	public Quarto(Integer id, String descricao, String status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
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
        
}
