package model.bo;

public class Medico extends Pessoa {

    private String crm;
    private String senha;
    private String login;
    private String nomeSocial;

    public Medico() {
    }

    public Medico(Integer id, String nome, String fone1, String fone2, String email, String cpfCnpj,
            String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro,
            String logradouro, String complemento, String crm, String senha, String login, String nomeSocial) {
        super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro,
                logradouro, complemento);
        this.crm = crm;
        this.senha = senha;
        this.login = login;
        this.nomeSocial = nomeSocial;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", senha=" + senha + ", login=" + login + ", nomeSocial=" + nomeSocial + '}';
    }

    
}
