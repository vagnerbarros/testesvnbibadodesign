package entidades;

import java.util.Hashtable;
import java.util.Map;

import interfaces.IEntidades;


public class Falha implements IEntidades<Falha>{

	private static String tabela = "Falha";
	private Long id;
	private Long id_cliente;
	private Long id_reclamacao;
	private Long id_servico;
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
		if(this.id_reclamacao != null){
			mapa.put("id_reclamacao", this.id_reclamacao);
		}
		if(this.id_servico != null){
			mapa.put("id_servico", this.id_servico);
		}
		if(this.ativo != null){
			mapa.put("ativo", this.ativo);
		}
		
		return mapa;
	}

	@Override
	public Falha getCamposChave() {
		// TODO Auto-generated method stub
		return null;
	}
}
