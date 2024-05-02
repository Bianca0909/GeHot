package br.com.ifsc.hospital.model;

public class Paciente extends Pessoa {
 
	private String tipoSanguineo;
	private String sexo;
	private String nomeSocial;
	
	public Paciente(String id, String nome, String fone1, String fone2, String email, String cpfCnpj,
			String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro,
			String logradouro, String complemento, String tipoSanguineo, String sexo, String nomeSocial) {
		super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro,
				logradouro, complemento);
		this.tipoSanguineo = tipoSanguineo;
		this.sexo = sexo;
		this.nomeSocial = nomeSocial;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	
}
