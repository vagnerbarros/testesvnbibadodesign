package gui;

import java.awt.BorderLayout;
import java.awt.Container;

public class ControladorGui {

	private Container contentPane;
	
	private TelaCadastroCliente telaCadCliente;
	private TelaCadastroReclamacoes telaCadReclam;
	private TelaCadastroFuncionarios telaCadFunc;
	private TelaCadastroServicos telaCadServ;
	private TelaCadastroEmpresa telaCadEmpresa;
	
	private TelaContratosVencer telaContVencer;
	
	private TelaRealizarVenda telaVenda;
	
	
	public ControladorGui(Container p){
		contentPane = p;
	}

	public void abrirTelaRealVenda(){

		fecharTodas();

		if(telaVenda == null){
			telaVenda = new TelaRealizarVenda();
			contentPane.add(telaVenda, BorderLayout.CENTER);
		}
		
		contentPane.setComponentZOrder(telaVenda, 0);
		telaVenda.setVisible(true);
	}
	
	public void abrirTelaCadCliente(){

		fecharTodas();

		if(telaCadCliente == null){
			telaCadCliente = new TelaCadastroCliente();
			contentPane.add(telaCadCliente, BorderLayout.CENTER);
		}
		
		contentPane.setComponentZOrder(telaCadCliente, 0);
		telaCadCliente.setVisible(true);
	}

	public void abrirTelaCadReclam(){

		fecharTodas();
		
		if(telaCadReclam == null){
			telaCadReclam = new TelaCadastroReclamacoes();
			contentPane.add(telaCadReclam, BorderLayout.CENTER);
		}

		contentPane.setComponentZOrder(telaCadReclam, 0);
		telaCadReclam.setVisible(true);
		
	}
	
	public void abrirTelaCadFuncionarios(){

		fecharTodas();
		
		if(telaCadFunc == null){
			telaCadFunc = new TelaCadastroFuncionarios();
			contentPane.add(telaCadFunc, BorderLayout.CENTER);
		}

		contentPane.setComponentZOrder(telaCadFunc, 0);
		telaCadFunc.setVisible(true);
		
	}
	
	public void abrirTelaCadServicos(){

		fecharTodas();
		
		if(telaCadServ == null){
			telaCadServ = new TelaCadastroServicos();
			contentPane.add(telaCadServ, BorderLayout.CENTER);
		}

		contentPane.setComponentZOrder(telaCadServ, 0);
		telaCadServ.setVisible(true);
		
	}
	
	public void abrirTelaCadEmpresas(){

		fecharTodas();
		
		if(telaCadEmpresa == null){
			telaCadEmpresa = new TelaCadastroEmpresa();
			contentPane.add(telaCadEmpresa, BorderLayout.CENTER);
		}

		contentPane.setComponentZOrder(telaCadEmpresa, 0);
		telaCadEmpresa.setVisible(true);
		
	}


	public void abrirTelaContVencer(){

		fecharTodas();
		
		if(telaContVencer == null){
			telaContVencer = new TelaContratosVencer();
			contentPane.add(telaContVencer, BorderLayout.CENTER);
		}

		contentPane.setComponentZOrder(telaContVencer, 0);
		telaContVencer.setVisible(true);
		
	}

	
	public void fecharTodas(){

		if(telaCadCliente != null) {
			telaCadCliente.setVisible(false);
			contentPane.remove(telaCadCliente);
			telaCadCliente = null;
		}

		if(telaCadReclam != null) {
			telaCadReclam.setVisible(false);
			contentPane.remove(telaCadReclam);
			telaCadReclam = null;
		}
		
		if(telaCadFunc != null) {
			telaCadFunc.setVisible(false);
			contentPane.remove(telaCadFunc);
			telaCadFunc = null;
		}
		
		if(telaCadServ != null) {
			telaCadServ.setVisible(false);
			contentPane.remove(telaCadServ);
			telaCadServ = null;
		}
		
		if(telaCadEmpresa != null) {
			telaCadEmpresa.setVisible(false);
			contentPane.remove(telaCadEmpresa);
			telaCadEmpresa = null;
		}
		
		if(telaContVencer != null) {
			telaContVencer.setVisible(false);
			contentPane.remove(telaContVencer);
			telaContVencer = null;
		}
		
		if(telaVenda != null) {
			telaVenda.setVisible(false);
			contentPane.remove(telaVenda);
			telaVenda = null;
		}
		
		System.gc();

	}

}
