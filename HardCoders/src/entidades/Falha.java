package entidades;

import java.util.Hashtable;
import java.util.Map;

import util.Constantes;

import interfaces.IEntidades;


public class Falha implements IEntidades<Falha>{

	private static String tabela = "Falha";
	private Long id;
	private Long id_cliente;
	private Long id_reclamacao;
	private Long id_servico;
	private Long id_empresa;
	private String ativo;
	
	public Falha(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Long getId_reclamacao() {
		return id_reclamacao;
	}
	public void setId_reclamacao(Long id_reclamacao) {
		this.id_reclamacao = id_reclamacao;
	}
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
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
		Falha f = (Falha) obj;
		if(this.id_cliente.equals(f.getId_cliente()) && this.id_empresa.equals(f.getId_empresa()) && this.id_reclamacao.equals(f.getId_reclamacao()) && this.id_servico.equals(f.getId_servico())){
			return true;
		}
		else{
			return false;
		}
	}

	public Map<String, Object> getHashMap() {
		
		Map<String, Object> mapa = new Hashtable<String, Object>();
		
		if(this.id != null){
			mapa.put("id", this.id);
		}
		if(this.id_cliente != null){
			mapa.put("id_cliente", this.id_cliente);
		}
		if(this.id_reclamacao != null){
			mapa.put("id_reclamacao", this.id_reclamacao);
		}
		if(this.id_servico != null){
			mapa.put("id_servico", this.id_servico);
		}
		if(this.id_empresa != null){
			mapa.put("id_empresa", this.id_empresa);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}

	public Falha getCamposChave() {
		Falha retorno = new Falha();
		retorno.setAtivo(Constantes.ATIVO);
		retorno.setId_cliente(this.id_cliente);
		retorno.setId_empresa(this.id_empresa);
		retorno.setId_reclamacao(this.id_reclamacao);
		retorno.setId_servico(this.id_servico);
		return retorno;
	}
}
