package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Servico implements IEntidades<Servico>{

	private static String tabela = "Servico";
	private Long id;
	private String nome;
	private Double valor;
	private Long id_empresa;
	private String ativo;
	
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Long getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
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
	public String toString(){
		return this.nome;
	}
	public boolean equals(Object obj){
		Servico s = (Servico) obj;
		if(this.id_empresa.compareTo(s.getId_empresa()) == 0 && this.nome.equalsIgnoreCase(s.getNome())){
			return true;
		}
		else{
			return false;
		}
	}
	public Servico getCamposChave() {
		Servico retorno = new Servico();
		retorno.setAtivo(this.ativo);
		retorno.setId_empresa(this.id_empresa);
		retorno.setNome(this.nome);
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
		if(this.valor != null){
			mapa.put("valor", this.valor);
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
