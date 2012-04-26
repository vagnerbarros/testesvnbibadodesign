package entidades;

import interfaces.IEntidades;

import java.util.Hashtable;
import java.util.Map;

public class Cliente implements IEntidades<Cliente>{

	private static String tabela = "Cliente";
	private Long id_pessoa;
	private String nome;
	private String email;
	private Long id_empresa;
	private String cpfOrCnpj;
	private String tipo;
	private String ativo;
	
	public Cliente(){
		
	}
	
	public Long getId_pessoa(){
		return this.id_pessoa;
	}
	public void setId_pessoa(Long id_pessoa){
		this.id_pessoa = id_pessoa;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getCpfOrCnpj(){
		return this.cpfOrCnpj;
	}
	public void setCpfOrCnpj(String cpfOrCnpj){
		this.cpfOrCnpj = cpfOrCnpj;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String nomeTabela() {
		return tabela;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public boolean equals(Object obj){
		Cliente c = (Cliente) obj;
		if(this.cpfOrCnpj.equals(c.getCpfOrCnpj()) && this.id_empresa.compareTo(c.getId_empresa()) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public Cliente getCamposChave() {
		Cliente retorno = new Cliente();
		retorno.setAtivo(this.ativo);
		retorno.setCpfOrCnpj(this.cpfOrCnpj);
		retorno.setId_empresa(this.id_empresa);
		return retorno;
	}
	
	public Map<String, Object> getHashMap(){
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id_pessoa != null){
			mapa.put("id_pessoa", this.id_pessoa);
		}
		if(this.nome != null){
			mapa.put("nome", this.nome);
		}
		if(this.email != null){
			mapa.put("email", this.email);
		}
		if(this.cpfOrCnpj != null){
			mapa.put("cpfOrCnpj", this.cpfOrCnpj);
		}
		if(this.tipo != null){
			mapa.put("tipo", this.tipo);
		}
		if(this.id_empresa != null){
			mapa.put("id_empresa", this.id_empresa);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		return mapa;
	}
}
