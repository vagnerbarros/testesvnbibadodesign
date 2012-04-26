package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Telefone implements IEntidades<Telefone>{

	private static String tabela = "Telefone";
	private Long id_pessoa;
	private String rotulo;
	private String numero;
	private String ativo;

	public Telefone(){
		
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
		Telefone t = (Telefone) obj;
		if(this.id_pessoa.compareTo(t.getId_pessoa()) == 0 && this.rotulo.equals(t.getRotulo())){
			return true;
		}
		else{
			return false;
		}
	}
	public Telefone getCamposChave() {
		Telefone retorno = new Telefone();
		retorno.setAtivo(this.ativo);
		retorno.setId_pessoa(this.id_pessoa);
		retorno.setRotulo(this.rotulo);
		return retorno;
	}

	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id_pessoa != null){
			mapa.put("id_pessoa", this.id_pessoa);
		}
		if(this.rotulo != null){
			mapa.put("rotulo", this.rotulo);
		}
		if(this.numero != null){
			mapa.put("numero", this.numero);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}
}
