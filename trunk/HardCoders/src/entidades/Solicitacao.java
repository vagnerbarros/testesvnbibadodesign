package entidades;


import interfaces.IEntidades;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Solicitacao implements IEntidades<Solicitacao>{

	private static String tabela = "Solicitacao";
	private Long id;
	private Long id_cliente;
	private Long id_servico;
	private Date data;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
		if(this.data != null){
			mapa.put("data", this.data);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}

	@Override
	public Solicitacao getCamposChave() {
		// TODO Auto-generated method stub
		return null;
	}
}
