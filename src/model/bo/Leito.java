package model.bo;

public class Leito {

	private Integer id;
	private String descricao;
	private String status;
	private Integer quarto_id;
        
	public Leito(Integer id, String descricao, String status, Integer quarto_id) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
                this.quarto_id = quarto_id;
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

         public Integer getQuarto_id() {
            return quarto_id;
        }

        public void setQuarto_id(Integer quarto_id) {
            this.quarto_id = quarto_id;
        }

        @Override
        public String toString() {
            return "Leito{" + "id=" + id + ", descricao=" + descricao + ", status=" + status + '}';
        }
}
