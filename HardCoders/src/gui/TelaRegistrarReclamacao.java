package gui;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class TelaRegistrarReclamacao extends JPanel {
	private JTextField textField;
	private JTextField txtNome;
	private JTextField txtServico;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TelaRegistrarReclamacao() {
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 65, 107));
		
		JLabel lblRegistrarReclamao = new JLabel("Registrar Reclama\u00E7\u00E3o");
		lblRegistrarReclamao.setForeground(Color.WHITE);
		lblRegistrarReclamao.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1293, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblRegistrarReclamao, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(928, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblRegistrarReclamao, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoServio.setBounds(21, 36, 97, 14);
		panel_2.add(lblNomeDoServio);
		
		txtServico = new JTextField();
		txtServico.setColumns(10);
		txtServico.setBounds(128, 34, 142, 20);
		panel_2.add(txtServico);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(251, 64, 30, 25);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Reclama\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setBounds(21, 36, 97, 14);
		panel_3.add(lblCdigo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 34, 142, 20);
		panel_3.add(textField_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(251, 64, 30, 25);
		panel_3.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(280, 26, 30, 25);
		panel_3.add(label_4);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		
		JList listaServico = new JList();
		listaServico.setBackground(SystemColor.menu);
		listaServico.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		listaServico.setBounds(128, 53, 142, 26);
		panel_2.add(listaServico);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRegistrarReclamacao.class.getResource("/gui/imagens/lupaS.png")));
		lblNewLabel_1.setBounds(280, 26, 30, 25);
		panel_3.add(lblNewLabel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnPessoaJurdica = new JRadioButton("Pessoa Jur\u00EDdica");
		
		rdbtnPessoaJurdica.setOpaque(false);
		rdbtnPessoaJurdica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPessoaJurdica.setBounds(21, 30, 109, 23);
		panel_1.add(rdbtnPessoaJurdica);
		
		JRadioButton rdbtnPessoaFsica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFsica.setOpaque(false);
		rdbtnPessoaFsica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPessoaFsica.setBounds(132, 30, 109, 23);
		panel_1.add(rdbtnPessoaFsica);
		
		final JLabel lblCpfCnpj = new JLabel("CNPJ:");
		lblCpfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfCnpj.setBounds(21, 74, 46, 14);
		panel_1.add(lblCpfCnpj);
		setLayout(groupLayout);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPessoaFsica);
		bg.add(rdbtnPessoaJurdica);
		
		textField = new JTextField();
		textField.setBounds(132, 72, 151, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		final JLabel lblNome = new JLabel("Raz\u00E3o Social:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(21, 112, 69, 14);
		panel_1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(132, 110, 315, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaRegistrarReclamacao.class.getResource("/gui/imagens/lupaS.png")));
		label.setBounds(293, 67, 30, 25);
		panel_1.add(label);
		
		rdbtnPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCpfCnpj.setText("CNPJ:");
				lblNome.setText("Razão Social:");
			}
		});
		
		rdbtnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCpfCnpj.setText("CPF:");
				lblNome.setText("Nome:");
			}
		});
		
		rdbtnPessoaJurdica.doClick();
		
	}
}
