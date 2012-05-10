package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Reclamacao implements IEntidades<Reclamacao>{

	private static String tabela = "Reclamacao";
	private Long id;
	private String nome;
	private String codigo;
	private Long id_empresa;
	private String ativo;

	public Reclamacao(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public boolean equals(Object obj){
		Reclamacao r = (Reclamacao) obj;
		if(this.codigo.equalsIgnoreCase(r.getCodigo())){
			return true;
		}
		else{
			return false;
		}
	}
	public String toString(){
		return this.codigo;
	}
	public Reclamacao getCamposChave() {
		Reclamacao retorno = new Reclamacao();
		retorno.setCodigo(this.codigo);
		retorno.setAtivo(this.ativo);
		return retorno;
	}

	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id != null){
			mapa.put("id", this.id);
		}
		if(this.nome != null){
			mapa.put("nome", this.nome);
		}
		if(this.codigo != null){
			mapa.put("codigo", this.codigo);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}
}
