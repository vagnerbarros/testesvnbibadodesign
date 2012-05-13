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
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.NivelAcesso;
import util.Sessao;
import util.Validacao;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Telefone;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import javax.swing.border.TitledBorder;

public class TelaCadastroFuncionarios extends JPanel implements ActionListener, KeyListener, ChangeListener, MouseListener{

	private JFormattedTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtBairro;
	private JFormattedTextField txtLogin;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtEndereco;
	private JFormattedTextField txtComplemento;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtCidade;
	private JFormattedTextField txtBusca;
	private JPasswordField txtSenha;
	private JPasswordField txtConfSenha;
	private JTable table;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxTelefone;
	private JComboBox comboBoxCargo;
	private JComboBox comboBoxBusca;
	private JButton btnLimpar;
	private JButton btnCadastro;
	private JButton btnRemover;
	private JButton btnEditar;
	private JTabbedPane tabbedPane;
	private Border bordaPadrao;
	private int comboTelefoneAtual;
	private Map<String, String[]> telefones;
	private Long idPessoaAtualizar;

	public TelaCadastroFuncionarios() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Funcionários");
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
		
		//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
				.addComponent(tabbedPane)
				.addComponent(JPanelInferior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(574, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(229, 23, 43, 14);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 23, 24, 15);
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));

		this.comboTelefoneAtual = 0;
		this.telefones = new Hashtable<String, String[]>();

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		mascaraNome.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraNome.setPlaceholder("");
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.setBounds(278, 21, 335, 20);
		txtNome.addMouseListener(this);
		txtNome.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNome.setColumns(10);

		MaskFormatter mascaraCep = criarMascara("##.###-###");
		mascaraCep.setPlaceholder("");

		MaskFormatter mascaraNumero = criarMascara("#####");
		mascaraNumero.setPlaceholder("");
		panel.setLayout(null);

		MaskFormatter mascaraCpf = criarMascara("###.###.###-##");
		mascaraCpf.setPlaceholder("");
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(81, 21, 138, 20);
		txtCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCpf.setColumns(10);

		MaskFormatter mascaraBairro = criarMascara("**************************************************");
		mascaraBairro.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraBairro.setPlaceholder("");

		MaskFormatter mascaraLogin = criarMascara("********************");
		mascaraLogin.setInvalidCharacters(" !@#$%¨&*()\"'+=-_[]{}|?<>");

		MaskFormatter mascaraSenha = criarMascara("********************");
		mascaraSenha.setInvalidCharacters(" !@#$%¨&*()\"'+=-_[]{}|?<>");

		MaskFormatter mascaraTelefone = criarMascara("(##)####-####");
		mascaraTelefone.setPlaceholder("");

		MaskFormatter mascaraEndereco = criarMascara("****************************************************************************************************");
		mascaraEndereco.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraEndereco.setPlaceholder("");

		MaskFormatter mascaraCidade = criarMascara("**************************************************");
		mascaraCidade.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraCidade.setPlaceholder("");

		MaskFormatter mascaraComplemento = criarMascara("**************************************************");
		mascaraComplemento.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraComplemento.setPlaceholder("");

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addMouseListener(this);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(10, 297, 78, 23);
		btnLimpar.addActionListener(this);

		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(93, 297, 98, 23);
		btnCadastro.addActionListener(this);
		panel.add(btnLimpar);
		panel.add(btnCadastro);
		panel.add(lblNome);
		panel.add(lblCpf);
		panel.add(txtNome);
		panel.add(txtCpf);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 49, 604, 150);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblBairro = new JLabel("CEP:");
		lblBairro.setBounds(10, 120, 25, 15);
		panel_3.add(lblBairro);
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(64, 117, 187, 20);
		panel_3.add(txtCep);
		txtCep.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCep.setColumns(10);
		txtEndereco = new JFormattedTextField(mascaraEndereco);
		txtEndereco.setBounds(64, 25, 187, 20);
		panel_3.add(txtEndereco);
		txtEndereco.addMouseListener(this);
		txtEndereco.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtEndereco.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00B0:");
		lblNumero.setBounds(271, 28, 25, 15);
		panel_3.add(lblNumero);
		lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNumero = new JFormattedTextField(mascaraNumero);
		txtNumero.setBounds(346, 25, 49, 20);
		panel_3.add(txtNumero);
		txtNumero.addMouseListener(this);
		txtNumero.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNumero.setColumns(10);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.LEFT);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRua.setBounds(10, 28, 25, 15);
		panel_3.add(lblRua);


		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(10, 59, 34, 15);
		panel_3.add(lblBairro_1);
		lblBairro_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 89, 40, 15);
		panel_3.add(lblCidade);
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCidade = new JFormattedTextField(mascaraCidade);
		txtCidade.setBounds(64, 86, 187, 20);
		panel_3.add(txtCidade);
		txtCidade.addMouseListener(this);
		txtCidade.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCidade.setColumns(10);
		txtComplemento = new JFormattedTextField(mascaraComplemento);
		txtComplemento.setBounds(345, 56, 249, 20);
		panel_3.add(txtComplemento);
		txtComplemento.addMouseListener(this);
		txtComplemento.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtComplemento.setColumns(10);

		JLabel lblEstado = new JLabel("UF:");
		lblEstado.setBounds(271, 89, 18, 15);
		panel_3.add(lblEstado);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(345, 86, 50, 20);
		panel_3.add(comboBoxEstado);
		iniciarCombo(comboBoxEstado);
		txtBairro = new JFormattedTextField(mascaraBairro);
		txtBairro.setBounds(64, 56, 187, 20);
		panel_3.add(txtBairro);
		txtBairro.addMouseListener(this);
		txtBairro.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBairro.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(271, 120, 53, 15);
		panel_3.add(lblTelefone);
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));

		comboBoxTelefone = new JComboBox();
		comboBoxTelefone.setBounds(346, 117, 99, 20);
		panel_3.add(comboBoxTelefone);
		iniciarCombo(comboBoxTelefone);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setBounds(455, 117, 139, 20);
		panel_3.add(txtTelefone);
		txtTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTelefone.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(271, 59, 69, 15);
		panel_3.add(lblComplemento);
		lblComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxTelefone.addActionListener(this);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(null, "Acesso ao Sistema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 205, 603, 88);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 24, 29, 15);
		panel_4.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtLogin = new JFormattedTextField(mascaraLogin);
		txtLogin.setBounds(68, 21, 180, 20);
		panel_4.add(txtLogin);
		txtLogin.addMouseListener(this);
		txtLogin.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 55, 53, 15);
		panel_4.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSenha = new JPasswordField();
		txtSenha.setBounds(68, 52, 180, 20);
		panel_4.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(274, 24, 33, 15);
		panel_4.add(lblCargo);
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 11));

		comboBoxCargo = new JComboBox();
		comboBoxCargo.setBounds(342, 21, 99, 20);
		panel_4.add(comboBoxCargo);
		iniciarCombo(comboBoxCargo);

		JLabel lblConfSenha = new JLabel("Conf. Senha:");
		lblConfSenha.setBounds(274, 55, 69, 14);
		panel_4.add(lblConfSenha);

		txtConfSenha = new JPasswordField();
		txtConfSenha.setColumns(10);
		txtConfSenha.setBounds(342, 52, 180, 20);
		panel_4.add(txtConfSenha);

		this.bordaPadrao = txtCidade.getBorder();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.menu);

		comboBoxBusca = new JComboBox();
		this.iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(286, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGap(15)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(33, Short.MAX_VALUE))
				);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);

		JLabel lblFuncionriosCadastrados = new JLabel("Funcion\u00E1rios Cadastrados");
		lblFuncionriosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(btnRemover)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblFuncionriosCadastrados)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
										.addComponent(scrollPane))
										.addContainerGap(410, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblFuncionriosCadastrados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemover)
								.addComponent(btnEditar))
								.addContainerGap())
				);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null},
				},
				new String[] {
						"Nome", "CPF", "Cargo"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.montaTabela(new Funcionario());

		this.setLayout(layout);

		tabbedPane.addChangeListener(this);
	}

	private void montaTabela(Funcionario f) {

		Fachada fachada = Fachada.getInstancia();
		f.setId_empresa(Sessao.getEmpresa().getId());
		List<Funcionario> listaFuncionarios = fachada.buscaLikeFuncionario(f);
		String colunas[] = { "Nome", "CPF", "Cargo"};
		Object linhas[][] = new Object[listaFuncionarios.size()][colunas.length];

		if (listaFuncionarios.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaFuncionarios.size(); i++) {

				linhas[i][0] = listaFuncionarios.get(i);
				linhas[i][1] = listaFuncionarios.get(i).getCpf();
				linhas[i][2] = listaFuncionarios.get(i).getCargo();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Funcionario.class, java.lang.String.class,
					java.lang.String.class};
			boolean[] canEdit = new boolean[] { false, false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	private void iniciarCombo(JComboBox combo){

		if(combo.equals(this.comboBoxEstado)){
			String [] estados = Constantes.listaEstados;
			for(String estado : estados){
				combo.addItem(estado);
			}
		}
		else if(combo.equals(this.comboBoxTelefone)){
			String [] rotulos = Constantes.getRotuloTelefone();
			for(String rotulo : rotulos){
				combo.addItem(rotulo);
			}
		}
		else if(combo.equals(this.comboBoxCargo)){
			String [] cargos = Constantes.getCargos();
			for(String cargo : cargos){
				combo.addItem(cargo);
			}
		}
		else if(combo.equals(this.comboBoxBusca)){
			String [] parametros = Constantes.getBuscaFuncionario();
			for(String parametro : parametros){
				combo.addItem(parametro);
			}
		}
	}

	private void limparCadastro(){

		txtBairro.setText(null);
		txtCep.setText(null);
		txtCpf.setText(null);
		txtEndereco.setText(null);
		txtLogin.setText(null);
		txtNome.setText(null);
		txtSenha.setText(null);
		txtConfSenha.setText(null);
		txtTelefone.setText(null);
		txtComplemento.setText(null);
		txtNumero.setText(null);
		txtCidade.setText(null);
		telefones.clear();
		comboBoxTelefone.setSelectedIndex(0);
		comboTelefoneAtual = 0;
		comboBoxCargo.setSelectedIndex(0);
		comboBoxEstado.setSelectedIndex(0);
	}

	private void cadastrar(){

		String login = txtLogin.getText().trim();
		String nome = txtNome.getText().trim();
		String senha = new String(txtSenha.getPassword());
		String cpf = txtCpf.getText();
		String cargo = (String) comboBoxCargo.getSelectedItem();
		String bairro = txtBairro.getText().trim();
		String cidade = txtCidade.getText().trim();
		String cep = txtCep.getText();
		String rua = txtEndereco.getText().trim();
		String numero = txtNumero.getText().trim();
		String complemento = txtComplemento.getText().trim();
		String estado = (String) comboBoxEstado.getSelectedItem();
		Fachada fachada = Fachada.getInstancia();

		try {

			// inserir pessoa
			Pessoa p = new Pessoa();
			p.setAtivo(Constantes.ATIVO);
			fachada.cadastrarPessoa(p);
			Long id_pessoa = fachada.ultimoIdPessoa(p);	

			// dados de funcionario
			Funcionario novo = new Funcionario();
			novo.setId_pessoa(id_pessoa);
			novo.setCargo(cargo);
			novo.setId_empresa(Sessao.getEmpresa().getId());
			novo.setLogin(login);
			novo.setSenha(senha);
			novo.setNome(nome);
			novo.setCpf(cpf);
			novo.setAtivo(Constantes.ATIVO);
			fachada.cadastrarFuncionario(novo);

			// dados de endereço
			Endereco end = new Endereco();
			end.setRotulo(Constantes.RESIDENCIAL);
			end.setRua(rua);
			end.setNumero(numero);
			end.setCep(cep);
			end.setBairro(bairro);
			end.setComplemento(complemento);
			end.setCidade(cidade);
			end.setEstado(estado);
			end.setId_pessoa(id_pessoa);
			end.setId_empresa(Sessao.getEmpresa().getId());
			end.setAtivo(Constantes.ATIVO);
			fachada.cadastrarEndereco(end);

			cadastrarTelefones(id_pessoa);

			this.limparCadastro();
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Este Login ou CPF já existe.");
		}
	}

	private void cadastrarTelefones(Long id_pessoa){

		//dados de telefone
		Fachada fachada = Fachada.getInstancia();
		salvarCampos((String)comboBoxTelefone.getSelectedItem());
		Set<String> rotulos = telefones.keySet();
		Long id_empresa = Sessao.getEmpresa().getId();

		for(String rotulo : rotulos){
			String numeroTelefone = telefones.get(rotulo)[0];
			if(numeroTelefone.replace(" ", "").length() > 3){

				Telefone t = new Telefone();
				t.setId_pessoa(id_pessoa);
				t.setNumero(numeroTelefone);
				t.setRotulo(rotulo);
				t.setId_empresa(id_empresa);
				t.setAtivo(Constantes.ATIVO);

				try {
					fachada.cadastrarTelefone(t);
				} catch (EntidadeJaExisteException e) {
					JOptionPane.showMessageDialog(null, "O Telefone já existe.");
				}
			}
		}
	}

	private void atualizar(){

		Fachada fachada = Fachada.getInstancia();

		Funcionario editado = new Funcionario();
		editado.setId_pessoa(idPessoaAtualizar);
		List<Funcionario> retorno = fachada.buscarFuncionario(editado);
		editado = retorno.get(0);

		String nome = this.txtNome.getText().trim();
		String cpf = this.txtCpf.getText().trim();
		String cargo = (String)this.comboBoxCargo.getSelectedItem();

		editado.setNome(nome);
		editado.setCpf(cpf);
		editado.setCargo(cargo);

		try {
			fachada.atualizarFuncionario(editado);
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "CPF pertence a outro funcionário.");
		}
		atualizarEnderecos();
		atualizarTelefones();

		JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso.");
		limparCadastro();
		idPessoaAtualizar = null;
	}

	private void atualizarTelefones() {

		//dados de telefone
		Fachada fachada = Fachada.getInstancia();
		salvarCampos((String)comboBoxTelefone.getSelectedItem());
		Set<String> rotulos = telefones.keySet();
		Long id_empresa = Sessao.getEmpresa().getId();

		for(String rotulo : rotulos){
			String numeroTelefone = telefones.get(rotulo)[0];
			if(numeroTelefone.replace(" ", "").length() > 3){

				Telefone t = new Telefone();

				Telefone busca = new Telefone();
				busca.setId_empresa(id_empresa);
				busca.setRotulo(rotulo);
				busca.setId_pessoa(idPessoaAtualizar);
				List<Telefone> tels = fachada.buscarTelefone(busca);
				if(!tels.isEmpty()){
					t = tels.get(0);
				}
				else{
					t.setId_empresa(id_empresa);
					t.setRotulo(rotulo);
					t.setId_pessoa(idPessoaAtualizar);
					t.setAtivo(Constantes.ATIVO);
				}

				t.setNumero(numeroTelefone);

				if(t.getId() != null){
					try {
						fachada.atualizarTelefone(t);
					} catch (EntidadeJaExisteException e) {
						JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar telefone.");
					}
				}
				else{
					try {
						fachada.cadastrarTelefone(t);
					} catch (EntidadeJaExisteException e) {
						JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar telefone.");
					}
				}
			}
		}
	}

	private void atualizarEnderecos() {

		Fachada fachada = Fachada.getInstancia();

		String rua = txtEndereco.getText().trim();
		String numero = txtNumero.getText().trim();
		String bairro = txtBairro.getText().trim();
		String cidade = txtCidade.getText().trim();
		String cep = txtCep.getText().trim();
		String estado = (String)comboBoxEstado.getSelectedItem();
		String complemento = txtComplemento.getText().trim();

		if(rua.length() > 0 || numero.length() > 0 || bairro.length() > 0 || cidade.length() > 0 || cep.replace(" ", "").length() > 2 || complemento.length() > 0){

			Endereco e = new Endereco();

			Endereco busca = new Endereco();
			busca.setId_pessoa(idPessoaAtualizar);
			List<Endereco> ends = fachada.buscarEndereco(busca);
			if(!ends.isEmpty()){
				e = ends.get(0);
			}
			else{
				e.setId_pessoa(idPessoaAtualizar);
				e.setId_empresa(Sessao.getEmpresa().getId());
				e.setAtivo(Constantes.ATIVO);
			}

			e.setRua(rua);
			e.setNumero(numero);
			e.setComplemento(complemento);
			e.setBairro(bairro);
			e.setCidade(cidade);
			e.setCep(cep);
			e.setEstado(estado);

			if(e.getId() != null){
				try {
					fachada.atualizarEndereco(e);
				} catch (EntidadeJaExisteException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar endereço.");
				}
			}
			else{
				try {
					fachada.cadastrarEndereco(e);
				} catch (EntidadeJaExisteException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar endereço.");
				}
			}
		}
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		normalizarCampos();

		if(elemento.equals(this.btnLimpar)){
			this.limparCadastro();
		}
		else if(elemento.equals(this.btnCadastro)){
			if(btnCadastro.getText().equals("Cadastrar")){
				if(camposPreenchidos() && camposValidos() && senhaConfirmacaoIguais()){
					this.cadastrar();
				}
			}
			else if(btnCadastro.getText().equals("Atualizar")){
				if(camposPreenchidos() && camposValidos()){
					atualizar();
				}
			}
		}
		else if(elemento.equals(this.comboBoxBusca)){
			this.txtBusca.setText("");
			this.buscar();
		}
		else if(elemento.equals(this.comboBoxTelefone)){
			this.atualizarCampos("Salvar");
			this.atualizarCampos("Restaurar");
		}
		else if(elemento.equals(btnRemover)){
			removerFuncionario();
		}
		else if(elemento.equals(btnEditar)){
			int linha = table.getSelectedRow();
			if(linha != -1){
				tabbedPane.setSelectedIndex(0);
				btnCadastro.setText("Atualizar");
				idPessoaAtualizar = ((Funcionario)table.getModel().getValueAt(linha, 0)).getId_pessoa();
				carregarInformacoesFuncionario();
				carregarInformacoesEndereco();
			}
		}
	}

	private void carregarInformacoesEndereco(){

		Fachada fachada = Fachada.getInstancia();
		Endereco busca = new Endereco();
		busca.setId_pessoa(idPessoaAtualizar);
		List<Endereco> lista = fachada.buscarEndereco(busca);
		Endereco e = lista.get(0);
		txtEndereco.setText(e.getRua());
		txtNumero.setText(e.getNumero());
		txtBairro.setText(e.getBairro());
		txtCidade.setText(e.getCidade());
		txtCep.setText(e.getCep());
		comboBoxEstado.setSelectedIndex(Constantes.getPosicaoEstado(e.getEstado()));
		txtComplemento.setText(e.getComplemento());
	}

	private void carregarInformacoesTelefone(){

		Fachada fachada = Fachada.getInstancia();
		Telefone busca = new Telefone();
		busca.setId_pessoa(idPessoaAtualizar);
		List<Telefone> lista = fachada.buscarTelefone(busca);

		for(Telefone t : lista){
			String [] campos = new String[1];
			campos[0] = t.getNumero();
			telefones.put(t.getRotulo(), campos);
		}
		restaurarCampos((String)comboBoxTelefone.getSelectedItem());
	}

	private void carregarInformacoesFuncionario(){

		Fachada fachada = Fachada.getInstancia();
		Funcionario busca = new Funcionario();
		busca.setId_pessoa(idPessoaAtualizar);
		List<Funcionario> lista = fachada.buscarFuncionario(busca);
		Funcionario f = lista.get(0);

		txtNome.setText(f.getNome());
		txtCpf.setText(f.getCpf());
	}

	private boolean senhaConfirmacaoIguais(){
		boolean iguais = true;
		char [] pw = txtSenha.getPassword();
		char [] conf = txtConfSenha.getPassword();

		if (conf.length != pw.length) {
			iguais = false;
			JOptionPane.showMessageDialog(null, "Senha e Confirmação não conferem");
		} else {
			if(Arrays.equals(conf, pw)){
				iguais = true;
			}
			else{
				iguais = false;
				JOptionPane.showMessageDialog(null, "Senha e Confirmação não conferem");
			}
		}
		return iguais;
	}

	private void removerFuncionario(){

		int linha = table.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Fachada fachada = Fachada.getInstancia();
				Funcionario f = (Funcionario) table.getModel().getValueAt(linha, 0);

				Pessoa p = new Pessoa();
				p.setId(f.getId_pessoa());
				fachada.removerPessoa(p);

				Endereco e = new Endereco();
				e.setId_pessoa(f.getId_pessoa());
				List<Endereco> listaEnd = fachada.buscarEndereco(e);
				for(Endereco elem : listaEnd){
					fachada.removerEndereco(elem);
				}

				Telefone t = new Telefone();
				t.setId_pessoa(f.getId_pessoa());
				List<Telefone> listaTel = fachada.buscarTelefone(t);
				for(Telefone tel : listaTel){
					fachada.removerTelefone(tel);
				}

				fachada.removerFuncionario(f);
				montaTabela(new Funcionario());
			}
		}
	}

	private void atualizarCampos(String operacao){

		String rotulo = (String) this.comboBoxTelefone.getItemAt(this.comboTelefoneAtual);
		if(operacao.equals("Salvar")){
			salvarCampos(rotulo);
		}
		else if(operacao.equals("Restaurar")){
			restaurarCampos(rotulo);
		}
	}

	private void salvarCampos(String chave){

		String [] campos = new String[1];
		campos[0] = txtTelefone.getText().trim();
		telefones.put(chave, campos);
		comboTelefoneAtual = comboBoxTelefone.getSelectedIndex();
		txtTelefone.setText("");
	}

	private void restaurarCampos(String chave){

		String [] campos;
		campos = telefones.get(chave);
		if(campos != null){
			txtTelefone.setText(campos[0]);
		}
	}

	private void normalizarCampos(){
		txtCpf.setBorder(bordaPadrao);
		txtLogin.setBorder(bordaPadrao);
		txtNome.setBorder(bordaPadrao);
		txtSenha.setBorder(bordaPadrao);
		txtConfSenha.setBorder(bordaPadrao);
	}

	private boolean camposPreenchidos(){

		boolean valido = true;

		if(!(txtCpf.getText().trim().length() == 14)){
			valido = false;
			pintarBorda(txtCpf);
		}
		if(txtLogin.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtLogin);
		}
		if(txtNome.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtNome);
		}
		if(txtSenha.getPassword().length == 0){
			valido = false;
			pintarBorda(txtSenha);
		}
		if(txtConfSenha.getPassword().length == 0){
			valido = false;
			pintarBorda(txtConfSenha);
		}

		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
		}
		return valido;
	}

	private boolean camposValidos(){
		boolean valido = true;
		if(!Validacao.cpfValido(txtCpf.getText())){
			valido = false;
			JOptionPane.showMessageDialog(null, "CPJ inválido");
		}
		return valido;
	}

	private void pintarBorda(JTextField campo){
		campo.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
	}

	public void keyReleased(KeyEvent evt) {

		if(evt.getKeyCode() != 10){
			buscar();
		}
	}

	private void buscar(){

		Funcionario f = new Funcionario();
		if(this.comboBoxBusca.getSelectedItem().equals(Constantes.NOME)){

			f.setNome(txtBusca.getText().trim());
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.CPF)){

			f.setCpf(txtBusca.getText().trim());
		}
		this.montaTabela(f);
	}

	// evento do tabbetPane
	public void stateChanged(ChangeEvent evt) {

		if(this.tabbedPane.getSelectedIndex() == 1){
			this.montaTabela(new Funcionario());
		}
		else if(this.tabbedPane.getSelectedIndex() == 0){
			limparCadastro();
			btnCadastro.setText("Cadastrar");
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
