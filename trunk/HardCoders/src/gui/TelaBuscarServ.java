package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class TelaBuscarServ extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPanel panel_1;
	private JTable table;

	public TelaBuscarServ(java.awt.Frame parent, boolean modal){
		super(parent, modal);
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarServ.class.getResource("/gui/imagens/icone.png")));
		setTitle("Localizar Cliente .:.");
	    IniciarJDialog();
	}
	
	private void IniciarJDialog() {
		
		setBounds(100, 100, 733, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(78, 74, 110));
			JLabel lblLocalizarCliente = new JLabel("Localizar Servi\u00E7os");
			lblLocalizarCliente.setForeground(Color.WHITE);
			lblLocalizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			JLabel label_1 = new JLabel("");
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(705)
						.addComponent(label_1))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(10)
						.addComponent(lblLocalizarCliente, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(11)
						.addComponent(label_1)
						.addGap(19)
						.addComponent(lblLocalizarCliente))
			);
			panel_1.setLayout(gl_panel_1);
		}
		
		JPanel panel = new JPanel();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Valor"}));
		
		ButtonGroup bg = new ButtonGroup();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConfirmar = new JButton("Confirmar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnCadastrarNovo = new JButton("Cadastrar Novo");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCadastrarNovo))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnCancelar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnConfirmar))
							.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarNovo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnCancelar))
					.addGap(42))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Nome", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);

	}
}
