package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Pessoa implements IEntidades<Pessoa>{

	private static String tabela = "Pessoa";
	private Long id;
	private String ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAtivo(){
		return this.ativo;
	}
	public void setAtivo(String ativo){
		this.ativo = ativo;
	}
	public String nomeTabela() {
		return tabela;
	}
	public boolean equals(Object obj){
		return false;
	}
	public Pessoa getCamposChave() {
		return new Pessoa();
	}
	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id != null){
			mapa.put("id", this.id);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}
}
