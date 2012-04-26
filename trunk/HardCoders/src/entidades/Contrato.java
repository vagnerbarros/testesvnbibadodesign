package entidades;


import interfaces.IEntidades;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Contrato implements IEntidades<Contrato>{

	private static String tabela = "Contrato";
	private Long id;
	private Long id_servico;
	private String nome;
	private Date data_inicial;
	private Date data_final;
	private String ativo;

	public Contrato(){
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId_servico() {
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		if(this.nome != null){
			mapa.put("nome", this.nome);
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
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		return mapa;
	}

	@Override
	public Contrato getCamposChave() {
		// TODO Auto-generated method stub
		return null;
	}
}
