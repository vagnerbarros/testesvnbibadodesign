package gui;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaRealizarVenda extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNomeServico;
	private JTextField textField_2;

	public TelaRealizarVenda() {
		setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(78, 74, 110));
		
		JLabel lblRealizarVenda = new JLabel("Realizar Venda");
		lblRealizarVenda.setForeground(Color.WHITE);
		lblRealizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/logoSup.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(43)
							.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 196, 210));
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServio.setBounds(10, 11, 46, 14);
		panel_3.add(lblServio);
		
		txtNomeServico = new JTextField();
		txtNomeServico.setColumns(10);
		txtNomeServico.setBounds(122, 34, 182, 20);
		panel_3.add(txtNomeServico);
		
		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setBounds(10, 37, 84, 14);
		panel_3.add(lblNomeDoServio);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(202, 51, 30, 31);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrato.setBounds(10, 11, 84, 14);
		panel_4.add(lblContrato);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 61, 109, 20);
		panel_4.add(textField_2);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 36, 30, 14);
		panel_4.add(lblValor);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(202, 51, 30, 31);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(314, 23, 30, 31);
		panel_4.add(label_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/LogotipoHard.png")));
		
		JButton btnConfirmar = new JButton("Confirmar");
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnConfirmar))))
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(20)))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConfirmar)
								.addComponent(btnCancelar))
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblEx = new JLabel("EX: 00,00");
		lblEx.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEx.setBounds(129, 65, 63, 14);
		panel_4.add(lblEx);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setBounds(202, 36, 40, 14);
		panel_4.add(lblPerodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "24"}));
		comboBox.setBounds(202, 61, 40, 20);
		panel_4.add(comboBox);
		
		JLabel lblMeses = new JLabel("Meses");
		lblMeses.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMeses.setBounds(252, 64, 63, 14);
		panel_4.add(lblMeses);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/lupaS.png")));
		label.setBounds(314, 23, 30, 31);
		panel_3.add(label);
		panel_2.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(14, 11, 46, 14);
		panel_2.add(lblCliente);
		
		final JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setBounds(20, 67, 93, 14);
		panel_2.add(lblNome);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNome.setText("Nome do Cliente:");
			}
		});
		rdbtnCpf.setBounds(14, 32, 46, 23);
		panel_2.add(rdbtnCpf);
		
		JRadioButton rdbtnCnpj = new JRadioButton("CNPJ");
		rdbtnCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNome.setText("Razão Social:");
			}
		});
		rdbtnCnpj.setBounds(62, 32, 51, 23);
		panel_2.add(rdbtnCnpj);
		
		textField = new JTextField();
		textField.setBounds(121, 33, 182, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		setLayout(groupLayout);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCnpj);
		bg.add(rdbtnCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 64, 301, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaBuscarCliente tbc = new TelaBuscarCliente(new javax.swing.JFrame(), true);
				tbc.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/lupaS.png")));
		lblNewLabel.setBounds(312, 24, 30, 31);
		panel_2.add(lblNewLabel);
		
		rdbtnCpf.setSelected(true);

	}
}
