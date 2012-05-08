package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.NivelAcesso;
import util.Sessao;
import entidades.Reclamacao;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroReclamacoes extends JPanel implements ActionListener, KeyListener, ChangeListener, MouseListener{

	private JFormattedTextField txtCodigo;
	private JFormattedTextField txtTipo;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoLimpar;
	private JButton botaoCadastrar;
	private JComboBox comboBoxBusca;
	private JTabbedPane tabbedPane;
	private Border bordaPadrao;
	private JButton btnVisualizar;
	private JButton btnRemover;

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
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(273, Short.MAX_VALUE))
		);
		panel_3.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 12, 48, 17);
		panel_3.add(lblCdigo);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		MaskFormatter mascaraCodigo = criarMascara("U####");
		mascaraCodigo.setPlaceholder("");
		txtCodigo = new JFormattedTextField(mascaraCodigo);
		txtCodigo.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(147, 11, 76, 20);
		txtCodigo.addMouseListener(this);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);


		MaskFormatter mascaraTipo = criarMascara("****************************************************************************************************");
		mascaraTipo.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraTipo.setPlaceholder("");
		txtTipo = new JFormattedTextField(mascaraTipo);
		txtTipo.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTipo.setBackground(Color.WHITE);
		txtTipo.setBounds(147, 39, 296, 20);
		txtTipo.addMouseListener(this);
		panel_3.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblTipoDeReclamao = new JLabel("Tipo de Reclama\u00E7\u00E3o:");
		lblTipoDeReclamao.setBounds(10, 40, 127, 17);
		panel_3.add(lblTipoDeReclamao);
		lblTipoDeReclamao.setFont(new Font("Tahoma", Font.PLAIN, 12));

		this.bordaPadrao = txtTipo.getBorder();

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(this);
		botaoLimpar.setBounds(255, 70, 89, 23);
		panel_3.add(botaoLimpar);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		botaoCadastrar.setBounds(354, 69, 89, 23);
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

		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(this);

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTiposDeReclamao)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnVisualizar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRemover))
							.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(355, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTiposDeReclamao)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVisualizar)
						.addComponent(btnRemover))
					.addContainerGap())
		);

		JLabel lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxBusca = new JComboBox();
		iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addKeyListener(this);
		txtBusca.addMouseListener(this);
	
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
			Class[] types = new Class [] {Reclamacao.class, java.lang.String.class};
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

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

				linhas[i][0] = listaReclamacao.get(i);
				linhas[i][1] = listaReclamacao.get(i).getNome();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Reclamacao.class, java.lang.String.class};
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
		normalizarCampos();

		if(elemento.equals(this.botaoCadastrar)){
			if(camposValidos()){
				cadastrar();
			}
		}
		else if(elemento.equals(this.botaoLimpar)){
			limparCadastro();
		}
		else if(elemento.equals(this.comboBoxBusca)){
			this.txtBusca.setText("");
			this.buscar();
		}
		else if(elemento.equals(this.btnVisualizar)){

		}
		else if(elemento.equals(this.btnRemover)){
			removerReclamacao();
		}
	}
	
	private void removerReclamacao(){

		int linha = table.getSelectedRow();

		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Reclamacao r = (Reclamacao) table.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstancia();
				fachada.removerReclamacao(r);
				montaTabela(new Reclamacao());
			}
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
			JOptionPane.showMessageDialog(null, "Reclamação já existe.");
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

		boolean valido = true;

		if(txtCodigo.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtCodigo);
		}
		if(txtTipo.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtTipo);
		}
		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
		}
		return valido;
	}

	private void pintarBorda(JFormattedTextField campo){
		campo.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
	}

	private void normalizarCampos(){
		txtCodigo.setBorder(bordaPadrao);
		txtTipo.setBorder(bordaPadrao);
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
	
	public void mousePressed(MouseEvent evt) {
		ajudarCursor((JFormattedTextField)evt.getSource());
	}
	
	private void ajudarCursor(JFormattedTextField campo){
		campo.setCaretPosition(campo.getText().trim().length());
	}

	public void mouseClicked(MouseEvent evt) {}
	public void mouseReleased(MouseEvent evt) {}
	public void keyTyped(KeyEvent arg0) {}
	public void keyPressed(KeyEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
}
