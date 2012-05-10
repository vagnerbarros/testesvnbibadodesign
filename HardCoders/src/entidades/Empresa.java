package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Empresa implements IEntidades<Empresa>{

	private static String tabela = "Empresa";
	private Long id;
	private String nome;
	private String ativo;
	
	public Empresa(){
		
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
		Empresa e = (Empresa) obj;
		if(this.nome.equalsIgnoreCase(e.getNome())){
			return true;
		}
		else{
			return false;
		}
	}
	public Empresa getCamposChave() {
		Empresa retorno = new Empresa();
		return retorno;
	}
	public String toString(){
		return this.nome;
	}
	public Map<String, Object> getHashMap() {

		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id != null){
			mapa.put("id", this.id);
		}
		if(this.nome != null){
			mapa.put("nome", this.nome);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		return mapa;
	}
}
