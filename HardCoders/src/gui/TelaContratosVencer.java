package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaContratosVencer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	public TelaContratosVencer() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Contratos \u00E0 Vencer");
		lblCadastroDeClientes.setForeground(Color.WHITE);
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 28));

		javax.swing.GroupLayout gl_jPanelSuperior = new javax.swing.GroupLayout(jPanelSuperior);
		gl_jPanelSuperior.setHorizontalGroup(
				gl_jPanelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelSuperior.createSequentialGroup()
						.addGap(24)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(395, Short.MAX_VALUE))
				);
		gl_jPanelSuperior.setVerticalGroup(
				gl_jPanelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanelSuperior.createSequentialGroup()
						.addGap(35)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE))
				);
		jPanelSuperior.setLayout(gl_jPanelSuperior);

		JPanel JPanelInferior = new JPanel();
		JPanelInferior.setBackground(new java.awt.Color(167, 196, 210));
		jPanelSuperior.setBackground(new java.awt.Color(70, 65, 107));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/gui/imagens/LogotipoHard.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(906, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(null);
		
		JLabel lblFiltar = new JLabel("Filtrar");
		lblFiltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiltar.setBounds(28, 11, 58, 14);
		panel.add(lblFiltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 53, 369, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataInicial.setBounds(10, 28, 65, 14);
		panel_1.add(lblDataInicial);
		
		textField = new JTextField();
		textField.setBounds(85, 26, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataFinal.setBounds(198, 28, 65, 14);
		panel_1.add(lblDataFinal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 26, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPerodo.setBounds(28, 36, 46, 14);
		panel.add(lblPerodo);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblServio.setBounds(422, 36, 46, 14);
		panel.add(lblServio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(422, 53, 369, 76);
		panel.add(panel_2);
		
		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoServio.setBounds(10, 28, 97, 14);
		panel_2.add(lblNomeDoServio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 26, 242, 20);
		panel_2.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 140, 763, 155);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome do Cliente", "Servi\u00E7o", "Data Inicial", "Data Final"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		JButton btnDetalhar = new JButton("Detalhar");
		btnDetalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetalharContrato.main(null);
			}
		});
		btnDetalhar.setBounds(28, 306, 89, 23);
		panel.add(btnDetalhar);

		this.setLayout(layout);
	}

	public void mouseClicked(MouseEvent evt) {}
	public void mouseReleased(MouseEvent evt) {}
	public void keyTyped(KeyEvent arg0) {}
	public void keyPressed(KeyEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
}
