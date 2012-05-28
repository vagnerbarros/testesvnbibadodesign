package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Reclamacao;
import fachada.Fachada;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class TelaSobre extends JDialog{


	private static final long serialVersionUID = 1L;
	private JPanel tela;
	
		public TelaSobre(java.awt.Frame parent, boolean modal) {
	
			super(parent, modal);
			getContentPane().setBackground(Color.WHITE);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(TelaSobre.class.getResource("/gui/imagens/fafica.png")));
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(TelaSobre.class.getResource("/gui/imagens/logohardsobre.png")));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(70, 65, 107));
			
			JLabel lblSistemaDesenvolvido = new JLabel("* Sistema desenvolvido como trabalho de conclus\u00E3o de Per\u00EDodo do");
			lblSistemaDesenvolvido.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JLabel lblDesenvolvedores = new JLabel("Desenvolvedores:");
			lblDesenvolvedores.setFont(new Font("Tahoma", Font.BOLD, 16));
			
			JLabel lblPlnioMos = new JLabel("Pl\u00EDnio Manoel Oliveira");
			lblPlnioMos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblVagnerBarros = new JLabel("Vagner Barros Pereira");
			lblVagnerBarros.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblWanessaChristineGomes = new JLabel("Wanessa Christine Gomes de Lima");
			lblWanessaChristineGomes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblNewLabel_3 = new JLabel("Projeto Interdisciplinar I.");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JLabel lblTipliniogmailcom = new JLabel("ti.plinio@gmail.com");
			lblTipliniogmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblVagnerbarrospereiragmailcom = new JLabel("vagnerbarrospereira@gmail.com");
			lblVagnerbarrospereiragmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblWanessaglimagmailcom = new JLabel("wanessaglima@gmail.com");
			lblWanessaglimagmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 982, Short.MAX_VALUE)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(49)
						.addComponent(lblNewLabel_1)
						.addGap(67)
						.addComponent(lblNewLabel)
						.addContainerGap(251, Short.MAX_VALUE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(62)
								.addComponent(lblSistemaDesenvolvido))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(272)
								.addComponent(lblNewLabel_3)))
						.addGap(271))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(153)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblPlnioMos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblVagnerBarros, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblWanessaChristineGomes, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
								.addGap(32)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblTipliniogmailcom, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblWanessaglimagmailcom, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVagnerbarrospereiragmailcom, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
							.addComponent(lblDesenvolvedores))
						.addContainerGap(349, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(41)
								.addComponent(lblNewLabel_1)
								.addGap(44))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap(54, Short.MAX_VALUE)
								.addComponent(lblNewLabel)
								.addGap(40)))
						.addComponent(lblSistemaDesenvolvido)
						.addGap(11)
						.addComponent(lblNewLabel_3)
						.addGap(55)
						.addComponent(lblDesenvolvedores, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPlnioMos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblVagnerBarros, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTipliniogmailcom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblVagnerbarrospereiragmailcom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblWanessaChristineGomes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWanessaglimagmailcom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGap(80)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			);
			
			JLabel lblNewLabel_2 = new JLabel("Equipe HardCoders FAFICA \u00A9 2012 - Todos os direitos reservados.");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setForeground(Color.WHITE);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(222)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(238))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			getContentPane().setLayout(groupLayout);
			setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarCliente.class.getResource("/gui/imagens/icone.png")));
			setTitle("Sobre a Equipe HardCoders .:.");
		    IniciarJDialog();
		}
		
		public void IniciarJDialog(){
			setBounds(100, 100, 800, 600);
		}
}		
