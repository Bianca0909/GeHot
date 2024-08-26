
package model.bo;


public class Laboratorio {
    private Integer id;
    private String nomeFantasia;
    private String contato;
    private String status;
    
    public Laboratorio(){
        
    }

    public Laboratorio(Integer id, String nomeFantasia, String contato, String status) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.contato = contato;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id + ", nomeFantasia=" + nomeFantasia + ", contato=" + contato + ", status=" + status + "}\n";
    }
     
    
}
