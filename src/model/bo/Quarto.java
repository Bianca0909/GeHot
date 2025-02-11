package model.bo;

public class Quarto {

    private Integer id;
    private String descricao;
    private String status;
    private Integer ala_id;

    public Quarto(Integer id, String descricao, String status, Integer ala_id) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.ala_id = ala_id;
    }

    public Quarto() {

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

    public Integer getAla_id() {
        return ala_id;
    }

    public void setAla_id(Integer ala_id) {
        this.ala_id = ala_id;
    }

    @Override
    public String toString() {
        return "Quarto{" + "id=" + id + ", descricao=" + descricao + ", status=" + status + '}';
    }

}
