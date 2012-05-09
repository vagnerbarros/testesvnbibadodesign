package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaBuscarReclamacao extends JDialog {


	private static final long serialVersionUID = 1L;
	private JPanel tela;
	private JTextField textField;
	private JTable table;
	
		public TelaBuscarReclamacao(java.awt.Frame parent, boolean modal, JPanel tela) {
	
			super(parent, modal);
			getContentPane().setBackground(Color.WHITE);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(78, 74, 110));
			
			JLabel label = new JLabel("");
			
			JLabel lblLocalizarTipoDe = new JLabel("Localizar Tipo de Reclama\u00E7\u00E3o");
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
			
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setLayout(null);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Tipo"}));
			comboBox.setBounds(21, 35, 76, 20);
			panel_1.add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(107, 35, 341, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"C\u00F3digo", "Tipo"
				}
			));
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("Confirmar");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(398)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(btnNewButton))
			);
			getContentPane().setLayout(groupLayout);
			this.tela = tela;
			setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarCliente.class.getResource("/gui/imagens/icone.png")));
			setTitle("Localizar Tipo de Reclama\u00E7\u00E3o .:.");
		    IniciarJDialog();
		}
		
		public void IniciarJDialog(){
		
		
			setBounds(100, 100, 729, 457);
	}
}
