package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Reclamacao;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroReclamacoes extends JPanel implements ActionListener, KeyListener, ChangeListener{
	
	private JFormattedTextField txtCodigo;
	private JFormattedTextField txtTipo;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoLimpar;
	private JButton botaoCadastrar;
	private JComboBox comboBoxBusca;
	private JTabbedPane tabbedPane;

	public TelaCadastroReclamacoes() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Reclama\u00E7\u00F5es");
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
				layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(425, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(240, 245, 247));
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(178, Short.MAX_VALUE))
				);
		panel_3.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(89, 11, 48, 17);
		panel_3.add(lblCdigo);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		MaskFormatter mascaraCodigo = criarMascara("U####");
		txtCodigo = new JFormattedTextField(mascaraCodigo);
		txtCodigo.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(147, 11, 104, 20);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblTipoDeReclamao = new JLabel("Tipo de Reclama\u00E7\u00E3o:");
		lblTipoDeReclamao.setBounds(10, 55, 127, 17);
		panel_3.add(lblTipoDeReclamao);
		lblTipoDeReclamao.setFont(new Font("Tahoma", Font.PLAIN, 14));

		MaskFormatter mascaraTipo = criarMascara("****************************************************************************************************");
		txtTipo = new JFormattedTextField(mascaraTipo);
		txtTipo.setBackground(Color.WHITE);
		txtTipo.setBounds(147, 55, 296, 20);
		panel_3.add(txtTipo);
		txtTipo.setColumns(10);

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(this);
		botaoLimpar.setBounds(255, 96, 89, 23);
		panel_3.add(botaoLimpar);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		botaoCadastrar.setBounds(354, 96, 89, 23);
		panel_3.add(botaoCadastrar);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblTiposDeReclamao = new JLabel("Tipos de Reclama\u00E7\u00E3o Cadastradas");
		lblTiposDeReclamao.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(SystemColor.control);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
								.addComponent(lblTiposDeReclamao, Alignment.LEADING))
								.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
						.addGap(19)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTiposDeReclamao)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addGap(15))
				);

		JLabel lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxBusca = new JComboBox();
		iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblFiltrar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(315, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addGap(13)
										.addComponent(lblFiltrar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(15)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel_2.setLayout(gl_panel_2);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Código", "Tipo de Reclamação"}
				) {
			Class[] types = new Class [] {java.lang.String.class, java.lang.String.class};
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

		this.montaTabela(new Reclamacao());

		this.setLayout(layout);
	}

	private void montaTabela(Reclamacao r) {

		Fachada fachada = Fachada.getInstancia();
		r.setId_empresa(Sessao.getEmpresa().getId());
		List<Reclamacao> listaReclamacao = fachada.buscaLikeReclamacao(r);
		String colunas[] = { "Código", "Tipo de Reclamação"};
		Object linhas[][] = new Object[listaReclamacao.size()][colunas.length];

		if (listaReclamacao.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaReclamacao.size(); i++) {

				linhas[i][0] = listaReclamacao.get(i).getCodigo();
				linhas[i][1] = listaReclamacao.get(i).getNome();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class};
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

		Reclamacao r = new Reclamacao();
		r.setCodigo(txtCodigo.getText().trim());
		r.setNome(txtTipo.getText().trim());
		r.setId_empresa(Sessao.getEmpresa().getId());
		r.setAtivo(Constantes.ATIVO);
		Fachada fachada = Fachada.getInstancia();
		try {
			fachada.cadastrarReclamacao(r);
			JOptionPane.showMessageDialog(null, "Reclamação cadastrada com sucesso.");
			limparCadastro();
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void iniciarCombo(JComboBox combo){

		if(combo.equals(this.comboBoxBusca)){
			String [] reclamacoes = Constantes.getBuscaReclamacao();
			for(String reclamacao : reclamacoes){
				combo.addItem(reclamacao);
			}
		}
	}

	private void buscar(){

		Reclamacao r = new Reclamacao();
		if(this.comboBoxBusca.getSelectedItem().equals(Constantes.CODIGO)){
			r.setCodigo(txtBusca.getText().trim());
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.TIPO)){
			r.setNome(txtBusca.getText().trim());
		}
		this.montaTabela(r);
	}

	private boolean camposValidos(){
		//aqui deve ser validado todos os campos
		return true;
	}

	private void limparCadastro(){

		txtCodigo.setText(null);
		txtTipo.setText(null);
		txtCodigo.grabFocus();
	}

	public void keyReleased(KeyEvent evt) {
		if(evt.getKeyCode() != 10){
			buscar();
		}
	}

	public void stateChanged(ChangeEvent e) {
		if(this.tabbedPane.getSelectedIndex() == 1){
			this.montaTabela(new Reclamacao());
		}
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

	public void keyTyped(KeyEvent arg0) {}
	public void keyPressed(KeyEvent arg0) {}
}
