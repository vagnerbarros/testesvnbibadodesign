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
import javax.swing.border.TitledBorder;

public class TelaCadastroReclamacoes extends JPanel implements ActionListener, KeyListener, ChangeListener, MouseListener{

	private JFormattedTextField txtCodigo;
	private JFormattedTextField txtTipo;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoCadastrar;
	private JComboBox comboBoxBusca;
	private JTabbedPane tabbedPane;
	private Border bordaPadrao;
	private JButton btnEditar;
	private JButton btnRemover;
	private Reclamacao reclamacaoEdicao;

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
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(671, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(240, 245, 247));
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(null, "Cadastrar Tipos de Reclama\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(544, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		panel_3.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 25, 48, 17);
		panel_3.add(lblCdigo);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		MaskFormatter mascaraCodigo = criarMascara("U####");
		mascaraCodigo.setPlaceholder("");
		txtCodigo = new JFormattedTextField(mascaraCodigo);
		txtCodigo.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(135, 24, 76, 20);
		txtCodigo.addMouseListener(this);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);


		MaskFormatter mascaraTipo = criarMascara("****************************************************************************************************");
		mascaraTipo.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraTipo.setPlaceholder("");
		txtTipo = new JFormattedTextField(mascaraTipo);
		txtTipo.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTipo.setBackground(Color.WHITE);
		txtTipo.setBounds(135, 55, 296, 20);
		txtTipo.addMouseListener(this);
		panel_3.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblTipoDeReclamao = new JLabel("Tipo de Reclama\u00E7\u00E3o:");
		lblTipoDeReclamao.setBounds(10, 56, 113, 17);
		panel_3.add(lblTipoDeReclamao);
		lblTipoDeReclamao.setFont(new Font("Tahoma", Font.PLAIN, 11));

		this.bordaPadrao = txtTipo.getBorder();

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		botaoCadastrar.setBounds(342, 81, 89, 23);
		panel_3.add(botaoCadastrar);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblTiposDeReclamao = new JLabel("Tipos de Reclama\u00E7\u00F5es Cadastradas");
		lblTiposDeReclamao.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.control);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTiposDeReclamao)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnRemover)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(375, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTiposDeReclamao)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar)
						.addComponent(btnRemover))
					.addGap(22))
		);

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
					.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(263, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		table.getTableHeader().setReorderingAllowed(false);

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
	
	private void atualizar(){
		
		Fachada fachada = Fachada.getInstancia();
		reclamacaoEdicao.setCodigo(txtCodigo.getText().trim());
		reclamacaoEdicao.setNome(txtTipo.getText().trim());
		try {
			fachada.atualizarReclamacao(reclamacaoEdicao);
			JOptionPane.showMessageDialog(null, "Tipo de reclamação atualizado com sucesso.");
			limparCadastro();
			tabbedPane.setSelectedIndex(1);
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Tipo de reclamação já existe.");
		}
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		normalizarCampos();

		if(elemento.equals(this.botaoCadastrar)){
			if(camposValidos()){
				if(botaoCadastrar.getText().equals("Cadastrar")){
					cadastrar();
				}
				else if(botaoCadastrar.getText().equals("Atualizar")){
					atualizar();
				}
			}
		}
		else if(elemento.equals(this.comboBoxBusca)){
			this.txtBusca.setText("");
			this.buscar();
		}
		else if(elemento.equals(this.btnEditar)){
			int linha = table.getSelectedRow();
			if(linha != -1){
				reclamacaoEdicao = (Reclamacao)table.getModel().getValueAt(linha, 0);
				carregarReclamacao();
			}
		}
		else if(elemento.equals(this.btnRemover)){
			removerReclamacao();
		}
	}
	
	private void carregarReclamacao(){
		
		tabbedPane.setSelectedIndex(0);
		botaoCadastrar.setText("Atualizar");
		txtCodigo.setText(reclamacaoEdicao.getCodigo());
		txtTipo.setText(reclamacaoEdicao.getNome());
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
			JOptionPane.showMessageDialog(null, "Tipo de reclamação cadastrada com sucesso.");
			limparCadastro();
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Tipo de reclamação já existe.");
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
		botaoCadastrar.setText("Cadastrar");
		reclamacaoEdicao = null;
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
			limparCadastro();
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
