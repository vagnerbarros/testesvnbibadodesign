package util;

import javax.swing.JButton;

public abstract class NivelAcesso {

	
	public static void inicializarBotao(JButton botao, String cargo){
		if(cargo.equals(Constantes.GERENTE)){
			botao.setEnabled(true);
		}
		else if(cargo.equals(Constantes.FUNCIONARIO)){
			botao.setEnabled(false);
		}
	}
}
