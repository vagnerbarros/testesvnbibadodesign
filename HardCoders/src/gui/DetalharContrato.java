package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class DetalharContrato extends JDialog {

	public static void main(String[] args) {
		try {
			DetalharContrato dialog = new DetalharContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DetalharContrato() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetalharContrato.class.getResource("/gui/imagens/icone.png")));
		setTitle("Detalhar Contrato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
	}

}
