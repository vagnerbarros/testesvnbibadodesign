package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Endereco implements IEntidades<Endereco>{

	private static String tabela = "Endereco";
	private Long id;
	private Long id_pessoa;
	private String rotulo;
	private String rua;
	private String numero;
	private String bairro;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	private String ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
		Endereco e = (Endereco) obj;
		if(this.id_pessoa.compareTo(e.getId_pessoa()) == 0 && this.rotulo.equals(e.getRotulo())){
			return true;
		}
		else{
			return false;
		}
	}
	public Endereco getCamposChave() {
		Endereco retorno = new Endereco();
		retorno.setAtivo(this.ativo);
		retorno.setId_pessoa(this.id_pessoa);
		retorno.setRotulo(this.rotulo);
		return retorno;
	}
	
	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id != null){
			mapa.put("id", this.id);
		}
		if(this.id_pessoa != null){
			mapa.put("id_pessoa", this.id_pessoa);
		}
		if(this.rotulo != null){
			mapa.put("rotulo", this.rotulo);
		}
		if(this.rua != null){
			mapa.put("rua", this.rua);
		}
		if(this.numero != null){
			mapa.put("numero", this.numero);
		}
		if(this.bairro != null){
			mapa.put("bairro", this.bairro);
		}
		if(this.complemento != null){
			mapa.put("complemento", this.complemento);
		}
		if(this.cep != null){
			mapa.put("cep", this.cep);
		}
		if(this.cidade != null){
			mapa.put("cidade", this.cidade);
		}
		if(this.estado != null){
			mapa.put("estado", this.estado);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}
}
