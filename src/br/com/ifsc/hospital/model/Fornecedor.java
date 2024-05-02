package br.com.ifsc.hospital.model;

public class Fornecedor extends Pessoa{

	private Integer nomeFantasia;
	private Integer contato;
	
	public Fornecedor(String id, String nome, String fone1, String fone2, String email, String cpfCnpj,
			String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, String bairro,
			String logradouro, String complemento, Integer nomeFantasia, Integer contato) {
		super(id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro,
				logradouro, complemento);
		this.nomeFantasia = nomeFantasia;
		this.contato = contato;
	}

	public Integer getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(Integer nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Integer getContato() {
		return contato;
	}

	public void setContato(Integer contato) {
		this.contato = contato;
	}
	
}
