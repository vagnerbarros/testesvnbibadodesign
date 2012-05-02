package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DetalharContrato extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public DetalharContrato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        IniciarJDialog();
    }
	
	private void IniciarJDialog() {	
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-900)/2, (screenSize.height-650)/2, 900, 650);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetalharContrato.class.getResource("/gui/imagens/icone.png")));
		setTitle("Detalhar Contrato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cliente", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Serviço", null, panel_1, null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
