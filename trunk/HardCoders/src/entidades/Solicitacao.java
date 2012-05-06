package entidades;


import interfaces.IEntidades;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import util.Constantes;

public class Solicitacao implements IEntidades<Solicitacao>{

	private static String tabela = "Solicitacao";
	private Long id;
	private Long id_cliente;
	private Long id_servico;
	private Date data_inicial;
	private Date data_final;
	private Long id_empresa;
	private String ativo;
	
	public Solicitacao(){
		
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
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public String nomeTabela() {
		return tabela;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
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
	public Solicitacao getCamposChave() {
		Solicitacao retorno = new Solicitacao();
		retorno.setAtivo(Constantes.ATIVO);
		retorno.setId_cliente(this.id_cliente);
		retorno.setId_servico(this.id_servico);
		retorno.setId_empresa(this.id_empresa);
		return retorno;
	}
	
	public boolean equals(Object obj){
		Solicitacao s = (Solicitacao) obj;
		if(this.id_cliente.equals(s.getId_cliente()) && this.id_servico.equals(s.getId_servico()) && this.id_empresa.equals(s.getId_empresa())){
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
		if(this.id_servico != null){
			mapa.put("id_servico", this.id_servico);
		}
		if(this.data_inicial != null){
			mapa.put("data_inicial", this.data_inicial);
		}
		if(this.data_final != null){
			mapa.put("data_final", this.data_final);
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
