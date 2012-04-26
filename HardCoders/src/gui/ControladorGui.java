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
	
	public ControladorGui(Container p){
		contentPane = p;
	}

	public void abrirTelaCadCliente(){

		//fecha as outras
		fecharTodas();

		//instancia
		if(telaCadCliente == null){
			//instancia
			telaCadCliente = new TelaCadastroCliente();
			contentPane.add(telaCadCliente, BorderLayout.CENTER);
		}
		
		//mostra essa
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
		
		System.gc();

	}

}
