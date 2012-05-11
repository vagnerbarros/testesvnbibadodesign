package gui;


import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaVisualizarCliente extends JDialog {


	private static final long serialVersionUID = 1L;
	private JPanel tela;
	
		public TelaVisualizarCliente(java.awt.Frame parent, boolean modal, JPanel tela) {
	
			super(parent, modal);
			getContentPane().setBackground(Color.WHITE);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(78, 74, 110));
			
			JLabel label = new JLabel("");
			
			JLabel lblLocalizarTipoDe = new JLabel("Visualizar Cliente");
			lblLocalizarTipoDe.setForeground(Color.WHITE);
			lblLocalizarTipoDe.setFont(new Font("Tahoma", Font.PLAIN, 28));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(705)
								.addComponent(label))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblLocalizarTipoDe, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(16, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(11)
						.addComponent(label)
						.addGap(19)
						.addComponent(lblLocalizarTipoDe)
						.addContainerGap())
			);
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(338))
			);
			getContentPane().setLayout(groupLayout);
			this.tela = tela;
			setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarCliente.class.getResource("/gui/imagens/icone.png")));
			setTitle("Visualizar Cliente .:.");
		    IniciarJDialog();
		}
		
		public void IniciarJDialog(){
		
			setBounds(100, 100, 729, 457);
	}
}
