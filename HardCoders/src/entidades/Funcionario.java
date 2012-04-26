package entidades;

import interfaces.IEntidades;

import java.util.Hashtable;
import java.util.Map;

public class Funcionario implements IEntidades<Funcionario>{

	private static String tabela = "Funcionario";
	private Long id_pessoa;
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private String cargo;
	private Long id_empresa;
	private String ativo;
	
	public Funcionario(){
		
	}
	
	public Long getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String nomeTabela() {
		return tabela;
	}
	public Long getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}
	public boolean equals(Object obj){
		Funcionario f = (Funcionario) obj;
		if(this.login.equals(f.getLogin()) && this.id_empresa.compareTo(f.getId_empresa()) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public Funcionario getCamposChave(){
		Funcionario retorno =  new Funcionario();
		retorno.setAtivo(this.ativo);
		retorno.setLogin(this.login);
		retorno.setId_empresa(this.id_empresa);
		return retorno;
	}
	
	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id_pessoa != null){
			mapa.put("id_pessoa", this.id_pessoa);
		}
		if(this.cpf != null){
			mapa.put("cpf", this.cpf);
		}
		if(this.nome != null){
			mapa.put("nome", this.nome);
		}
		if(this.login != null){
			mapa.put("login", this.login);
		}
		if(this.senha != null){
			mapa.put("senha", this.senha);
		}
		if(this.cargo != null){
			mapa.put("cargo", this.cargo);
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
