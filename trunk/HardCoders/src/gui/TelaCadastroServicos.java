package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import util.Constantes;
import util.Sessao;
import entidades.Servico;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import java.awt.TextField;

public class TelaCadastroServicos extends JPanel implements ActionListener, ChangeListener, KeyListener{

	private JFormattedTextField txtNome;
	private JFormattedTextField txtValor;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoLimpar;
	private JButton botaoCadastrar;
	private JTabbedPane tabbedPane;
	private JComboBox comboBoxBusca;

	public TelaCadastroServicos() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Servi\u00E7os");
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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(433, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoServio.setBounds(27, 11, 110, 17);
		panel_2.add(lblNomeDoServio);

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.setColumns(10);
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(147, 11, 296, 20);
		panel_2.add(txtNome);

		JLabel lblValorPadro = new JLabel("Valor Padr\u00E3o:");
		lblValorPadro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorPadro.setBounds(27, 42, 110, 17);
		panel_2.add(lblValorPadro);

		MaskFormatter mascaraValor = criarMascara("********");
		mascaraValor.setValidCharacters("1234567890.");
		txtValor = new JFormattedTextField(mascaraValor);
		txtValor.setFocusLostBehavior(JFormattedTextField.COMMIT);
		txtValor.setColumns(10);
		txtValor.setBackground(Color.WHITE);
		txtValor.setBounds(147, 42, 89, 20);
		panel_2.add(txtValor);

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(this);
		botaoLimpar.setBounds(255, 42, 89, 23);
		panel_2.add(botaoLimpar);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		botaoCadastrar.setBounds(354, 42, 89, 23);
		panel_2.add(botaoCadastrar);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(227, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(SystemColor.menu);

		JLabel label_1 = new JLabel("Filtrar:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxBusca = new JComboBox();
		iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);
		
		MaskFormatter mascaraBusca = criarMascara("*********************************************************************************");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		txtBusca.setBackground(Color.WHITE);

		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(13)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);

		JLabel lblServiosCadastrados = new JLabel("Servi\u00E7os Cadastrados");
		lblServiosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addGap(14)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
								.addComponent(lblServiosCadastrados, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
								.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(lblServiosCadastrados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addGap(26))
				);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nome", "Valor"}
				) {
			Class[] types = new Class [] {java.lang.String.class, java.lang.Double.class};
			boolean[] canEdit = new boolean [] {false, false};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		this.montaTabela(new Servico());

		this.setLayout(layout);

	}

	private void montaTabela(Servico s) {

		Fachada fachada = Fachada.getInstancia();
		s.setId_empresa(Sessao.getEmpresa().getId());
		List<Servico> listaServicos = fachada.buscaLikeServico(s);
		String colunas[] = { "Nome", "Valor"};
		Object linhas[][] = new Object[listaServicos.size()][colunas.length];

		if (listaServicos.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaServicos.size(); i++) {

				linhas[i][0] = listaServicos.get(i).getNome();
				linhas[i][1] = listaServicos.get(i).getValor();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.Double.class};
			boolean[] canEdit = new boolean[] { false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();

		if(elemento.equals(this.botaoCadastrar)){
			if(camposValidos()){
				cadastrar();
			}
		}
		else if(elemento.equals(this.botaoLimpar)){
			limparCadastro();
		}
		else if(elemento.equals(this.comboBoxBusca)){
			this.txtBusca.setText(null);
			this.buscar();
		}
	}

	private void cadastrar(){

		String nome = this.txtNome.getText().trim();
		Double valor = Double.parseDouble(this.txtValor.getText().trim());

		Servico s = new Servico();
		s.setNome(nome);
		s.setValor(valor);
		s.setId_empresa(Sessao.getEmpresa().getId());
		s.setAtivo(Constantes.ATIVO);
		Fachada fachada = Fachada.getInstancia();
		try {
			fachada.cadastrarServico(s);
			JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
			limparCadastro();
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void limparCadastro(){
		txtNome.setText(null);
		txtValor.setText(null);
		txtNome.grabFocus();
	}

	private boolean camposValidos(){
		//aqui deve ser feita todo tipo de validação
		return true;
	}

	public void stateChanged(ChangeEvent evt) {

		if(this.tabbedPane.getSelectedIndex() == 1){
			this.montaTabela(new Servico());
		}
	}

	private void iniciarCombo(JComboBox combo){
		if(combo.equals(this.comboBoxBusca)){
			String [] parametros = Constantes.getBuscaServico();
			for(String parametro : parametros){
				combo.addItem(parametro);
			}
		}
	}

	public void keyReleased(KeyEvent evt) {
		if(evt.getKeyCode() != 10){
			buscar();
		}
	}
	
	private void buscar(){

		Servico s = new Servico();
		if(this.comboBoxBusca.getSelectedItem().equals(Constantes.NOME)){
			s.setNome(txtBusca.getText().trim());
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.VALOR)){
			String valor = txtBusca.getText().trim();
			if(!valor.equals("")){
				s.setValor(Double.parseDouble(valor));
				System.out.println(s.getValor());
			}
		}
		this.montaTabela(s);
	}
	
	private MaskFormatter criarMascara(String formato){
		
		try {
			MaskFormatter mascara = new MaskFormatter(formato);
			return mascara;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void keyPressed(KeyEvent evt) {}
	public void keyTyped(KeyEvent evt) {}
}
