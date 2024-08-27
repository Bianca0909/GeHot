package model.bo;

public class Ala {

    private Integer id;
    private String descricao;
    private String status;

    public Ala(Integer id, String descricao, String status) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public Ala() {
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

    @Override
    public String toString() {
        return "Ala{" + "id=" + id + ", descricao=" + descricao + ", status=" + status + "}\n";
    }

}
