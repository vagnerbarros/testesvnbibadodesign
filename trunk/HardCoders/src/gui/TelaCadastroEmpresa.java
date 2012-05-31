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
import entidades.Empresa;
import entidades.Funcionario;
import entidades.Pessoa;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import javax.swing.border.TitledBorder;

public class TelaCadastroEmpresa extends JPanel implements ActionListener, KeyListener, ChangeListener, MouseListener{
	
	private JFormattedTextField txtNomeEmpresa;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoCadastrar;
	private JTabbedPane tabbedPane;
	private JButton btnEditar;
	private JButton btnRemover;
	private Border bordaPadrao;
	private Empresa empresaEditada;

	public TelaCadastroEmpresa() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Empresas");
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
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(706, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Cadastrar Nova Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa:");
		lblNomeDaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 11));

		MaskFormatter mascaraEmpresa = criarMascara("****************************************************************************************************");
		mascaraEmpresa.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraEmpresa.setPlaceholder("");
		txtNomeEmpresa = new JFormattedTextField(mascaraEmpresa);
		txtNomeEmpresa.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNomeEmpresa.setColumns(10);
		txtNomeEmpresa.setBackground(Color.WHITE);
		txtNomeEmpresa.addMouseListener(this);

		this.bordaPadrao = txtNomeEmpresa.getBorder();

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(botaoCadastrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNomeDaEmpresa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNomeEmpresa, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDaEmpresa)
						.addComponent(txtNomeEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botaoCadastrar)
					.addGap(78))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(524, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.menu);

		JLabel lblNome = new JLabel("Nome:");

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		txtBusca.addMouseListener(this);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);

		JScrollPane scrollPane = new JScrollPane();

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		
		JLabel lblEmpresasCadastrados = new JLabel("Empresas Cadastradas");
		lblEmpresasCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEmpresasCadastrados, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnRemover)
							.addGap(8)
							.addComponent(btnEditar)))
					.addContainerGap(599, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmpresasCadastrados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnRemover))
					.addContainerGap(59, Short.MAX_VALUE))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nome da Empresa"}
				) {
			Class[] types = new Class [] {Empresa.class};
			boolean[] canEdit = new boolean [] {false};

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
		this.montaTabela(new Empresa());

		this.setLayout(layout);

	}

	public void keyReleased(KeyEvent evt) {

		Empresa e = new Empresa();
		e.setNome(txtBusca.getText().trim());
		montaTabela(e);
	}
	
	private void atualizar(){
		
		empresaEditada.setNome(txtNomeEmpresa.getText().trim());
		
		Fachada fachada = Fachada.getInstancia();
		try {
			fachada.atualizarEmpresa(empresaEditada);
			JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso.");
			limparCadastro();
			tabbedPane.setSelectedIndex(1);
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Este nome de empresa já existe.");
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
		else if(elemento.equals(this.btnEditar)){

			int linha = table.getSelectedRow();
			if(linha != -1){
				empresaEditada = (Empresa)table.getModel().getValueAt(linha, 0);
				editarSelecionado();
			}
		}
		else if(elemento.equals(this.btnRemover)){

			removerSelecionado();
		}
	}

	private void removerSelecionado(){

		int linha = this.table.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Empresa e =	(Empresa) table.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstancia();
				fachada.removerEmpresa(e);
				montaTabela(new Empresa());
			}
		}
	}

	private void editarSelecionado(){

		tabbedPane.setSelectedIndex(0);
		txtNomeEmpresa.setText(empresaEditada.getNome());
		botaoCadastrar.setText("Atualizar");
	}

	private void montaTabela(Empresa e) {

		Fachada fachada = Fachada.getInstancia();
		List<Empresa> listaEmpresas = fachada.buscaLikeEmpresa(e);
		String colunas[] = { "Nome"};
		Object linhas[][] = new Object[listaEmpresas.size()][colunas.length];

		if (listaEmpresas.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaEmpresas.size(); i++) {

				linhas[i][0] = listaEmpresas.get(i);
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { java.lang.String.class};
			boolean[] canEdit = new boolean[] { false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	private void cadastrar(){

		Empresa e = new Empresa();
		e.setNome(txtNomeEmpresa.getText().trim());
		e.setAtivo(Constantes.ATIVO);
		Fachada fachada = Fachada.getInstancia();
		try {
			fachada.cadastrarEmpresa(e);
			Long id_empresa = fachada.ultimoIdEmpresa(new Empresa());
			
			Pessoa p = new Pessoa();
			p.setAtivo(Constantes.ATIVO);
			fachada.cadastrarPessoa(p);
			Long id_pessoa = fachada.ultimoIdPessoa(new Pessoa());
			
			Funcionario f = Sessao.getFuncionario();
			f.setId_pessoa(id_pessoa);
			f.setId_empresa(id_empresa);
			fachada.cadastrarFuncionario(f);
			
			JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso.");
			limparCadastro();
		} catch (EntidadeJaExisteException e1) {
			JOptionPane.showMessageDialog(null, "A Empresa já existe.");
		}
	}

	private void limparCadastro(){

		txtNomeEmpresa.setText(null);
		empresaEditada = null;
		botaoCadastrar.setText("Cadastrar");
		txtNomeEmpresa.grabFocus();
	}

	private boolean camposValidos(){

		boolean valido = true;

		if(txtNomeEmpresa.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtNomeEmpresa);
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
		txtNomeEmpresa.setBorder(bordaPadrao);
	}

	public void stateChanged(ChangeEvent e) {

		if(this.tabbedPane.getSelectedIndex() == 1){
			this.montaTabela(new Empresa());
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

	public void keyPressed(KeyEvent evt) {}
	public void keyTyped(KeyEvent evt) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
