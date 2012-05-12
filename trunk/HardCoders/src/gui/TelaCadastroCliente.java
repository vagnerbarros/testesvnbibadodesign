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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
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
import util.Validacao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Pessoa;
import entidades.Telefone;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class TelaCadastroCliente extends JPanel implements ActionListener, MouseListener, ChangeListener, KeyListener{

	private JTable table;
	private JFormattedTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtRazaoSocial;
	private JFormattedTextField txtCnpj;
	private JFormattedTextField txtRua;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtBairro;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCidade;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtEmail;
	private JFormattedTextField txtComplemento;
	private JFormattedTextField txtBusca;
	private final JComboBox comboBoxTelefone;
	private final JComboBox comboBoxEndereco;
	private final JComboBox comboBoxEstado;
	private final JComboBox comboBoxBusca;
	private JRadioButton rbtnJurica;
	private JRadioButton rbtnFisica;
	private final JLabel lblCpf;
	private final JLabel lblCnpj;
	private final JLabel lblNome;
	private final JLabel lblRazoSocial;
	private final JButton botaoCadastrar;
	private Map<String, String[]> enderecos;
	private Map<String, String[]> telefones;
	private int comboEnderecoAtual;
	private int comboTelefoneAtual;
	private Border bordaPadrao;
	private JTabbedPane tabbedPane;
	private JButton btnRemover;
	private JButton btnEditar;
	private JButton btnLimpar;
	private JLabel lblClientesCadastrados;
	private JPanel panel_4;
	private Long idPessoaAtualizar;

	public TelaCadastroCliente() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setForeground(Color.WHITE);
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 28));

		javax.swing.GroupLayout gl_jPanelSuperior = new javax.swing.GroupLayout(jPanelSuperior);
		gl_jPanelSuperior.setHorizontalGroup(
				gl_jPanelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanelSuperior.createSequentialGroup()
						.addGap(25)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(899, Short.MAX_VALUE))
				);
		gl_jPanelSuperior.setVerticalGroup(
				gl_jPanelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanelSuperior.createSequentialGroup()
						.addGap(32)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE))
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
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(606, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		ButtonGroup group = new ButtonGroup();

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		mascaraNome.setPlaceholder("");
		mascaraNome.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?><");

		MaskFormatter mascaraCpf = criarMascara("###.###.###-##");
		mascaraCpf.setPlaceholder("");

		MaskFormatter mascaraRazaoSocial = criarMascara("****************************************************************************************************");
		mascaraRazaoSocial.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraRazaoSocial.setPlaceholder("");

		MaskFormatter mascaraCnpj = criarMascara("##.###.###/####-##");
		mascaraCnpj.setPlaceholder("");

		MaskFormatter mascaraTelefone = criarMascara("(##)####-####");
		mascaraTelefone.setPlaceholder("");

		MaskFormatter mascaraEmail = criarMascara("****************************************************************************************************");
		mascaraEmail.setInvalidCharacters(" !\"#$%&'()*,/:;<>=?[]\\^`ABCDEFGHIJLMNOPQRSTUVXZKY|{}´-°");
		mascaraEmail.setPlaceholder("");

		MaskFormatter mascaraRua = criarMascara("****************************************************************************************************");
		mascaraRua.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraRua.setPlaceholder("");

		MaskFormatter mascaraNumero = criarMascara("#####");
		mascaraNumero.setPlaceholder("");

		MaskFormatter mascaraBairro = criarMascara("**************************************************");
		mascaraBairro.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraBairro.setPlaceholder("");

		MaskFormatter mascaraCep = criarMascara("##.###-###");
		mascaraCep.setPlaceholder("");

		MaskFormatter mascaraCidade = criarMascara("**************************************************");
		mascaraCidade.setInvalidCharacters("1234567890!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraCidade.setPlaceholder("");

		this.enderecos = new Hashtable<String, String[]>();
		this.telefones = new Hashtable<String, String[]>();
		this.comboEnderecoAtual = 0;
		this.comboTelefoneAtual = 0;

		MaskFormatter mascaraComplemento = criarMascara("**************************************************");
		mascaraComplemento.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?<>");
		mascaraComplemento.setPlaceholder("");

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		rbtnFisica = new JRadioButton("Pessoa F\u00EDsica");
		rbtnFisica.addActionListener(this);
		rbtnFisica.setBackground(Color.WHITE);

		rbtnJurica = new JRadioButton("Pessoa Jur\u00EDdica");
		rbtnJurica.addActionListener(this);
		rbtnJurica.setBackground(Color.WHITE);
		group.add(rbtnJurica);
		group.add(rbtnFisica);

		rbtnFisica.setSelected(true);

		lblNome = new JLabel("Nome:");

		lblCpf = new JLabel("CPF:");
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCpf.setColumns(10);

		lblCnpj = new JLabel("CNPJ:");

		lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		txtRazaoSocial = new JFormattedTextField(mascaraRazaoSocial);
		txtRazaoSocial.addMouseListener(this);
		txtRazaoSocial.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtRazaoSocial.setColumns(10);
		txtCnpj = new JFormattedTextField(mascaraCnpj);
		txtCnpj.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCnpj.setColumns(10);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.addMouseListener(this);
		txtNome.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNome.setColumns(10);

		this.bordaPadrao = txtNome.getBorder();

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(20)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(rbtnFisica)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(rbtnJurica))
														.addGroup(gl_panel.createSequentialGroup()
																.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblRazoSocial, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNome))
																		.addGap(3)
																		.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(txtNome, 188, 188, 188)
																						.addPreferredGap(ComponentPlacement.UNRELATED)
																						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
																						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
																								.addComponent(txtRazaoSocial, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
																								.addGap(10)
																								.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(ComponentPlacement.RELATED)
																								.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))))
																								.addGroup(gl_panel.createSequentialGroup()
																										.addContainerGap()
																										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
																										.addGroup(gl_panel.createSequentialGroup()
																												.addContainerGap()
																												.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																												.addGap(424))
																												.addGroup(gl_panel.createSequentialGroup()
																														.addContainerGap()
																														.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(ComponentPlacement.RELATED)
																														.addComponent(botaoCadastrar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
																														.addContainerGap(746, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(17)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(rbtnFisica)
												.addComponent(rbtnJurica))
												.addGap(8)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addGap(5)
																.addComponent(lblRazoSocial))
																.addGroup(gl_panel.createSequentialGroup()
																		.addGap(2)
																		.addComponent(txtRazaoSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(3)
																				.addComponent(lblCnpj))))
																				.addGroup(gl_panel.createSequentialGroup()
																						.addGap(48)
																						.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																												.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addComponent(lblNome))
																												.addComponent(lblCpf))
																												.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																														.addComponent(btnLimpar)
																														.addComponent(botaoCadastrar))
																														.addGap(40))
				);
		panel_4.setLayout(null);

		comboBoxTelefone = new JComboBox();
		comboBoxTelefone.setBounds(82, 22, 83, 20);
		panel_4.add(comboBoxTelefone);
		carregarCombo(comboBoxTelefone);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setBounds(175, 22, 118, 20);
		panel_4.add(txtTelefone);
		txtTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTelefone.setColumns(10);

		final JLabel lbl_tel_fisica = new JLabel("Telefone:");
		lbl_tel_fisica.setBounds(10, 25, 46, 14);
		panel_4.add(lbl_tel_fisica);

		final JLabel lbl_email_fisica = new JLabel("E-mail:");
		lbl_email_fisica.setBounds(306, 25, 32, 14);
		panel_4.add(lbl_email_fisica);
		txtEmail = new JFormattedTextField(mascaraEmail);
		txtEmail.setBounds(348, 22, 144, 20);
		panel_4.add(txtEmail);
		txtEmail.addMouseListener(this);
		txtEmail.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtEmail.setColumns(10);
		comboBoxTelefone.addActionListener(this);
		panel_3.setLayout(null);

		final JLabel lbl_rua_end = new JLabel("Rua:");
		lbl_rua_end.setBounds(19, 51, 46, 14);
		panel_3.add(lbl_rua_end);
		txtRua = new JFormattedTextField(mascaraRua);
		txtRua.setBounds(80, 48, 210, 20);
		panel_3.add(txtRua);
		txtRua.addMouseListener(this);
		txtRua.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtRua.setColumns(10);

		final JLabel lbl_numero_end = new JLabel("N\u00BA:");
		lbl_numero_end.setBounds(300, 51, 46, 14);
		panel_3.add(lbl_numero_end);
		txtNumero = new JFormattedTextField(mascaraNumero);
		txtNumero.setBounds(379, 48, 49, 20);
		panel_3.add(txtNumero);
		txtNumero.addMouseListener(this);
		txtNumero.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNumero.setColumns(10);
		txtComplemento = new JFormattedTextField(mascaraComplemento);
		txtComplemento.setBounds(379, 76, 98, 20);
		panel_3.add(txtComplemento);
		txtComplemento.addMouseListener(this);
		txtComplemento.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtComplemento.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(300, 79, 69, 14);
		panel_3.add(lblComplemento);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(379, 107, 49, 20);
		panel_3.add(comboBoxEstado);
		carregarCombo(comboBoxEstado);

		final JLabel lbl_estado_end = new JLabel("Estado:");
		lbl_estado_end.setBounds(300, 106, 46, 14);
		panel_3.add(lbl_estado_end);

		comboBoxEndereco = new JComboBox();
		comboBoxEndereco.setBounds(80, 23, 98, 20);
		panel_3.add(comboBoxEndereco);
		carregarCombo(comboBoxEndereco);

		final JLabel lbl_cep_end = new JLabel("CEP:");
		lbl_cep_end.setBounds(19, 137, 46, 14);
		panel_3.add(lbl_cep_end);
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(80, 131, 98, 20);
		panel_3.add(txtCep);
		txtCep.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCep.setColumns(10);

		final JLabel lbl_cidade_end = new JLabel("Cidade:");
		lbl_cidade_end.setBounds(19, 106, 46, 14);
		panel_3.add(lbl_cidade_end);
		txtCidade = new JFormattedTextField(mascaraCidade);
		txtCidade.setBounds(80, 103, 210, 20);
		panel_3.add(txtCidade);
		txtCidade.addMouseListener(this);
		txtCidade.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCidade.setColumns(10);

		final JLabel lbl_bairro_end = new JLabel("Bairro:");
		lbl_bairro_end.setBounds(19, 79, 46, 14);
		panel_3.add(lbl_bairro_end);
		txtBairro = new JFormattedTextField(mascaraBairro);
		txtBairro.setBounds(80, 76, 210, 20);
		panel_3.add(txtBairro);
		txtBairro.addMouseListener(this);
		txtBairro.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBairro.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(19, 26, 46, 14);
		panel_3.add(lblTipo);
		this.comboBoxEndereco.addActionListener(this);
		panel.setLayout(gl_panel);

		lblCnpj.setVisible(false);
		txtCnpj.setVisible(false);
		lblRazoSocial.setVisible(false);
		txtRazaoSocial.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nome/Razão Social", "CPF/CNPJ", "Tipo"}
				) {
			Class[] types = new Class [] {Cliente.class, java.lang.String.class, java.lang.String.class};
			boolean[] canEdit = new boolean [] {false, false, false};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.montaTabelaCliente(new Cliente());

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.menu);

		comboBoxBusca = new JComboBox();
		carregarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addMouseListener(this);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(208, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(16, Short.MAX_VALUE))
				);
		panel_2.setLayout(gl_panel_2);

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);

		lblClientesCadastrados = new JLabel("Clientes Cadastrados");
		lblClientesCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
												.addComponent(btnRemover)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
												.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
												.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblClientesCadastrados, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
												.addContainerGap(325, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblClientesCadastrados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemover)
								.addComponent(btnEditar))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);

		this.setLayout(layout);
		tabbedPane.addTab("Cadastros", null, panel, null);
		tabbedPane.addTab("Listagem", null, panel_1, null);
	}

	private void montaTabelaCliente(Cliente c) {

		Fachada fachada = Fachada.getInstancia();
		c.setId_empresa(Sessao.getEmpresa().getId());
		List<Cliente> listaClientes = fachada.buscaLikeCliente(c);
		String colunas[] = { "Nome/Razão Social", "CPF/CNPJ", "Tipo"};
		Object linhas[][] = new Object[listaClientes.size()][colunas.length];

		if (listaClientes.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaClientes.size(); i++) {

				linhas[i][0] = listaClientes.get(i);
				linhas[i][1] = listaClientes.get(i).getCpfOrCnpj();
				linhas[i][2] = listaClientes.get(i).getTipo();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Cliente.class, java.lang.String.class, java.lang.String.class};
			boolean[] canEdit = new boolean[] { false, false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	private void montaTabelaEndereco(Endereco e) {

		Fachada fachada = Fachada.getInstancia();
		e.setId_empresa(Sessao.getEmpresa().getId());
		List<Endereco> listaEnderecos = fachada.buscaLikeEndereco(e);
		String colunas[] = { "Rua", "Rótulo"};
		Object linhas[][] = new Object[listaEnderecos.size()][colunas.length];

		if (listaEnderecos.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaEnderecos.size(); i++) {

				linhas[i][0] = listaEnderecos.get(i);
				linhas[i][1] = listaEnderecos.get(i).getRotulo();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Endereco.class, java.lang.String.class};
			boolean[] canEdit = new boolean[] { false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	private void montaTabelaTelefone(Telefone t) {

		Fachada fachada = Fachada.getInstancia();
		t.setId_empresa(Sessao.getEmpresa().getId());
		List<Telefone> listaTelefones = fachada.buscaLikeTelefone(t);
		String colunas[] = { "Telefone", "Rótulo"};
		Object linhas[][] = new Object[listaTelefones.size()][colunas.length];

		if (listaTelefones.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaTelefones.size(); i++) {

				linhas[i][0] = listaTelefones.get(i);
				linhas[i][1] = listaTelefones.get(i).getRotulo();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Telefone.class, java.lang.String.class};
			boolean[] canEdit = new boolean[] { false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	private void limparEndereco(){
		txtRua.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtCep.setText("");
		txtComplemento.setText("");
		comboBoxEstado.setSelectedIndex(0);
	}

	private void carregarCombo(JComboBox combo){

		if(combo.equals(this.comboBoxTelefone)){
			String [] rotulos = Constantes.getRotuloTelefoneCliente();
			for(String rotulo : rotulos){
				this.comboBoxTelefone.addItem(rotulo);
			}
		}
		else if(combo.equals(this.comboBoxEndereco)){
			String [] rotulos = Constantes.getRotuloEndereco();
			for(String rotulo : rotulos){
				this.comboBoxEndereco.addItem(rotulo);
			}
		}
		else if(combo.equals(this.comboBoxEstado)){
			String [] estados = Constantes.listaEstados;
			for(String estado : estados){
				this.comboBoxEstado.addItem(estado);
			}
		}
		else if(combo.equals(this.comboBoxBusca)){
			String [] rotulos = Constantes.getBuscaCliente();
			for(String rotulo : rotulos){
				comboBoxBusca.addItem(rotulo);
			}
		}
	}

	private void ativarCamposPF(){

		lblCpf.setVisible(true);
		txtCpf.setVisible(true);
		lblNome.setVisible(true);
		txtNome.setVisible(true);

		lblCnpj.setVisible(false);
		txtCnpj.setVisible(false);
		lblRazoSocial.setVisible(false);
		txtRazaoSocial.setVisible(false);
	}

	private void ativarCamposPJ(){

		lblCpf.setVisible(false);
		txtCpf.setVisible(false);
		lblNome.setVisible(false);
		txtNome.setVisible(false);

		lblCnpj.setVisible(true);
		txtCnpj.setVisible(true);
		lblRazoSocial.setVisible(true);
		txtRazaoSocial.setVisible(true);
	}

	private void atualizar(){

		Fachada fachada = Fachada.getInstancia();

		Cliente editado = new Cliente();
		editado.setId_pessoa(idPessoaAtualizar);
		List<Cliente> retorno = fachada.buscarCliente(editado);
		editado = retorno.get(0);

		boolean podeAtualizar = false;
		String cpfOrCnpj = "";
		String tipoCliente = editado.getTipo();
		String nome = "";
		// pessoa fisica
		if(editado.getTipo().equals(Constantes.PF)){
			podeAtualizar = camposPFPreenchidos() && cpfValido();
			nome = this.txtNome.getText().trim();
			cpfOrCnpj = this.txtCpf.getText().trim();
		}
		//pessoa juridica
		else if(editado.getTipo().equals(Constantes.PJ)){
			podeAtualizar = camposPJPreenchidos() && cnpjValido();
			nome = this.txtRazaoSocial.getText().trim();
			cpfOrCnpj = this.txtCnpj.getText().trim();
		}

		if(podeAtualizar){

			String email = this.txtEmail.getText().trim();

			Cliente c = new Cliente();
			c.setId_pessoa(idPessoaAtualizar);
			c.setNome(nome);
			c.setTipo(tipoCliente);
			c.setId_empresa(Sessao.getEmpresa().getId());
			c.setEmail(email);
			c.setCpfOrCnpj(cpfOrCnpj);
			c.setAtivo(Constantes.ATIVO);

			fachada.atualizarCliente(c);
			atualizarEnderecos();
			atualizarTelefones();

			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
			limparCadastro();
			idPessoaAtualizar = null;
		}
	}

	private void atualizarTelefones() {

		//dados de telefone
		Fachada fachada = Fachada.getInstancia();
		salvarCampos((String)comboBoxTelefone.getSelectedItem(), 2);
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
					fachada.atualizarTelefone(t);
				}
				else{
					try {
						fachada.cadastrarTelefone(t);
					} catch (EntidadeJaExisteException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void atualizarEnderecos() {

		salvarCampos((String)comboBoxEndereco.getSelectedItem(), 1);
		Set<String> rotulos = enderecos.keySet();
		Fachada fachada = Fachada.getInstancia();
		Long id_empresa = Sessao.getEmpresa().getId();

		for(String rotulo : rotulos){
			String [] campos = enderecos.get(rotulo);

			String rua = campos[0];
			String numero = campos[1];
			String bairro = campos[2];
			String cidade = campos[3];
			String cep = campos[4];
			String estado = (String)comboBoxEstado.getItemAt(Integer.parseInt(campos[5]));
			String complemento = campos[6];

			if(rua.length() > 0 || numero.length() > 0 || bairro.length() > 0 || cidade.length() > 0 || cep.replace(" ", "").length() > 2 || complemento.length() > 0){

				Endereco e = new Endereco();
				
				Endereco busca = new Endereco();
				busca.setId_pessoa(idPessoaAtualizar);
				busca.setRotulo(rotulo);
				busca.setId_empresa(id_empresa);
				List<Endereco> ends = fachada.buscarEndereco(busca);
				if(!ends.isEmpty()){
					e = ends.get(0);
				}
				else{
					e.setId_pessoa(idPessoaAtualizar);
					e.setRotulo(rotulo);
					e.setId_empresa(id_empresa);
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
					fachada.atualizarEndereco(e);
				}
				else{
					try {
						fachada.cadastrarEndereco(e);
					} catch (EntidadeJaExisteException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private void cadastrar(int tipo){

		Fachada fachada = Fachada.getInstancia();

		// dados de cliente
		Pessoa p = new Pessoa();
		p.setAtivo(Constantes.ATIVO);
		try {
			fachada.cadastrarPessoa(p);


			Long id_pessoa = fachada.ultimoIdPessoa(new Pessoa());

			String cpfOrCnpj = "";
			String tipoCliente = "";
			String nome = "";
			// pessoa fisica
			if(tipo == 1){
				nome = this.txtNome.getText().trim();
				cpfOrCnpj = this.txtCpf.getText().trim();
				tipoCliente = Constantes.PF;
			}
			//pessoa juridica
			else if(tipo == 2){
				nome = this.txtRazaoSocial.getText().trim();
				cpfOrCnpj = this.txtCnpj.getText().trim();
				tipoCliente = Constantes.PJ;
			}

			String email = this.txtEmail.getText().trim();

			Cliente c = new Cliente();
			c.setId_pessoa(id_pessoa);
			c.setNome(nome);
			c.setTipo(tipoCliente);
			c.setId_empresa(Sessao.getEmpresa().getId());
			c.setEmail(email);
			c.setCpfOrCnpj(cpfOrCnpj);
			c.setAtivo(Constantes.ATIVO);

			fachada.cadastrarCliente(c);
			cadastrarEnderecos(id_pessoa);
			cadastrarTelefones(id_pessoa);

			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
			limparCadastro();

		} catch (EntidadeJaExisteException e1) {
			JOptionPane.showMessageDialog(null, "O Cliente já existe.");
		}
	}

	private void limparCadastro(){
		limparEndereco();
		limparTelefone();
		txtCpf.setText("");
		txtCnpj.setText("");
		txtNome.setText("");
		txtRazaoSocial.setText("");
		txtEmail.setText("");
		this.enderecos.clear();
		this.telefones.clear();
		comboBoxEndereco.setSelectedIndex(0);
		comboBoxEstado.setSelectedIndex(0);
		comboBoxTelefone.setSelectedIndex(0);
		comboEnderecoAtual = 0;
		comboTelefoneAtual = 0;
		habilitarRadioButtons();
	}

	private void cadastrarTelefones(Long id_pessoa) throws EntidadeJaExisteException{

		//dados de telefone
		Fachada fachada = Fachada.getInstancia();
		salvarCampos((String)comboBoxTelefone.getSelectedItem(), 2);
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

				fachada.cadastrarTelefone(t);
			}
		}
	}

	private void cadastrarEnderecos(Long id_pessoa) throws EntidadeJaExisteException{

		salvarCampos((String)comboBoxEndereco.getSelectedItem(), 1);
		Set<String> rotulos = enderecos.keySet();
		Fachada fachada = Fachada.getInstancia();
		Long id_empresa = Sessao.getEmpresa().getId();

		for(String rotulo : rotulos){
			String [] campos = enderecos.get(rotulo);

			String rua = campos[0];
			String numero = campos[1];
			String bairro = campos[2];
			String cidade = campos[3];
			String cep = campos[4];
			String estado = (String)comboBoxEstado.getItemAt(Integer.parseInt(campos[5]));
			String complemento = campos[6];

			if(rua.length() > 0 || numero.length() > 0 || bairro.length() > 0 || cidade.length() > 0 || cep.replace(" ", "").length() > 2 || complemento.length() > 0){

				Endereco e = new Endereco();
				e.setId_pessoa(id_pessoa);
				e.setRotulo(rotulo);
				e.setRua(rua);
				e.setNumero(numero);
				e.setComplemento(complemento);
				e.setBairro(bairro);
				e.setCidade(cidade);
				e.setCep(cep);
				e.setEstado(estado);
				e.setId_empresa(id_empresa);
				e.setAtivo(Constantes.ATIVO);
				fachada.cadastrarEndereco(e);
			}
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

	private boolean camposPFPreenchidos(){

		boolean valido = true;

		if(!(txtCpf.getText().trim().length() == 14)){
			valido = false;
			pintarBorda(txtCpf);
		}
		if(txtNome.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtNome);
		}

		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
		}
		return valido;
	}

	private boolean camposPJPreenchidos(){

		boolean valido = true;

		if(!(txtCnpj.getText().trim().length() == 18)){
			valido = false;
			pintarBorda(txtCnpj);
		}
		if(txtRazaoSocial.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtRazaoSocial);
		}

		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
		}
		return valido;
	}

	private boolean cpfValido(){
		boolean valido = true;
		if(!Validacao.cpfValido(txtCpf.getText())){
			valido = false;
			JOptionPane.showMessageDialog(null, "CPJ inválido");
		}
		return valido;
	}

	private boolean cnpjValido(){
		boolean valido = true;
		if(!Validacao.cnpjValido(txtCnpj.getText())){
			valido = false;
			JOptionPane.showMessageDialog(null, "CNPJ inválido");
		}
		return valido;
	}

	private void pintarBorda(JFormattedTextField campo){
		campo.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
	}

	private void normalizarCampos(){
		txtCpf.setBorder(bordaPadrao);
		txtCnpj.setBorder(bordaPadrao);
		txtNome.setBorder(bordaPadrao);
		txtRazaoSocial.setBorder(bordaPadrao);
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		normalizarCampos();

		if(elemento.equals(this.rbtnFisica)){
			this.ativarCamposPF();
			limparCadastro();

		}
		else if(elemento.equals(this.rbtnJurica)){
			this.ativarCamposPJ();
			limparCadastro();
		}
		else if(elemento.equals(this.botaoCadastrar)){
			if(botaoCadastrar.getText().equals("Cadastrar")){
				if(this.rbtnFisica.isSelected()){
					if(camposPFPreenchidos() && cpfValido()){
						cadastrar(1);
					}
				}
				else if(this.rbtnJurica.isSelected()){
					if(camposPJPreenchidos() && cnpjValido()){
						cadastrar(2);
					}
				}
			}
			else if(botaoCadastrar.getText().equals("Atualizar")){
				atualizar();
			}
		}
		else if(elemento.equals(this.btnRemover)){
			verificarTipoRemocao();
		}
		else if(elemento.equals(this.btnEditar)){
			int linha = table.getSelectedRow();
			if(linha != -1){
				tabbedPane.setSelectedIndex(0);
				botaoCadastrar.setText("Atualizar");
				verificarTipoEdicao(linha);
				desabilitarRadioButtons();
			}
		}
		else if(elemento.equals(this.btnLimpar)){
			this.limparCadastro();
		}
		else if(elemento.equals(this.comboBoxEndereco)){
			this.atualizarCampos("Salvar", 1);
			this.atualizarCampos("Restaurar", 1);
		}
		else if(elemento.equals(this.comboBoxTelefone)){
			this.atualizarCampos("Salvar", 2);
			this.atualizarCampos("Restaurar", 2);
		}
		else if(elemento.equals(this.comboBoxBusca)){
			txtBusca.setText("");
			buscar();
		}
	}

	private void verificarTipoEdicao(int linha){

		if(comboBoxBusca.getSelectedItem().equals(Constantes.NOMERAZAO)){
			idPessoaAtualizar = ((Cliente) table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.TELEFONE)){
			idPessoaAtualizar = ((Telefone) table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.ENDERECO)){
			idPessoaAtualizar = ((Endereco) table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.CPFCNPJ)){
			idPessoaAtualizar = ((Cliente) table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		carregarInformacoesCliente();
		carregarInformacoesEndereco();
		carregarInformacoesTelefone();
	}

	private void desabilitarRadioButtons(){
		rbtnFisica.setEnabled(false);
		rbtnJurica.setEnabled(false);
	}

	private void habilitarRadioButtons(){
		rbtnFisica.setEnabled(true);
		rbtnJurica.setEnabled(true);
	}

	private void carregarInformacoesEndereco(){

		Fachada fachada = Fachada.getInstancia();
		Endereco busca = new Endereco();
		busca.setId_pessoa(idPessoaAtualizar);
		List<Endereco> lista = fachada.buscarEndereco(busca);
		for(Endereco e : lista){
			String [] campos = new String[7];
			campos[0] = e.getRua();
			campos[1] = e.getNumero();
			campos[2] = e.getBairro();
			campos[3] = e.getCidade();
			campos[4] = e.getCep();
			campos[5] = Constantes.getPosicaoEstado(e.getEstado()) + "";
			campos[6] = e.getComplemento();
			enderecos.put(e.getRotulo(), campos);
		}
		restaurarCampos((String)comboBoxEndereco.getSelectedItem(), 1);
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
		restaurarCampos((String)comboBoxTelefone.getSelectedItem(), 2);
	}

	private void carregarInformacoesCliente(){

		Fachada fachada = Fachada.getInstancia();
		Cliente busca = new Cliente();
		busca.setId_pessoa(idPessoaAtualizar);
		List<Cliente> lista = fachada.buscarCliente(busca);
		Cliente c = lista.get(0);

		if(c.getTipo().equals(Constantes.PF)){
			ativarCamposPF();
			txtNome.setText(c.getNome());
			txtCpf.setText(c.getCpfOrCnpj());
			rbtnFisica.setSelected(true);
		}
		else if(c.getTipo().equals(Constantes.PJ)){
			ativarCamposPJ();
			txtRazaoSocial.setText(c.getNome());
			txtCnpj.setText(c.getCpfOrCnpj());
			rbtnJurica.setSelected(true);
		}
		txtEmail.setText(c.getEmail());
	}

	private void verificarTipoRemocao(){

		if(comboBoxBusca.getSelectedItem().equals(Constantes.NOMERAZAO)){
			removerCliente();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.TELEFONE)){
			removerTelefone();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.ENDERECO)){
			removerEndereco();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.CPFCNPJ)){
			removerCliente();
		}
	}

	private void removerCliente(){

		int linha = table.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Fachada fachada = Fachada.getInstancia();
				Cliente c = (Cliente) table.getModel().getValueAt(linha, 0);

				Pessoa p = new Pessoa();
				p.setId(c.getId_pessoa());
				fachada.removerPessoa(p);

				Endereco e = new Endereco();
				e.setId_pessoa(c.getId_pessoa());
				List<Endereco> listaEnd = fachada.buscarEndereco(e);
				for(Endereco elem : listaEnd){
					fachada.removerEndereco(elem);
				}

				Telefone t = new Telefone();
				t.setId_pessoa(c.getId_pessoa());
				List<Telefone> listaTel = fachada.buscarTelefone(t);
				for(Telefone tel : listaTel){
					fachada.removerTelefone(tel);
				}

				fachada.removerCliente(c);
				montaTabelaCliente(new Cliente());
			}
		}
	}

	private void removerTelefone(){

		int linha = this.table.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Fachada fachada = Fachada.getInstancia();
				Telefone t = (Telefone) this.table.getModel().getValueAt(linha, 0);
				fachada.removerTelefone(t);
				montaTabelaTelefone(new Telefone());
			}
		}
	}

	private void removerEndereco(){

		int linha = this.table.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Fachada fachada = Fachada.getInstancia();
				Endereco e = (Endereco) this.table.getModel().getValueAt(linha, 0);
				fachada.removerEndereco(e);
				montaTabelaEndereco(new Endereco());
			}
		}
	}

	private void buscar(){

		if(this.comboBoxBusca.getSelectedItem().equals(Constantes.NOMERAZAO)){
			Cliente c = new Cliente();
			c.setNome(txtBusca.getText().trim());
			this.montaTabelaCliente(c);
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.ENDERECO)){
			Endereco e = new Endereco();
			e.setRua(txtBusca.getText().trim());
			this.montaTabelaEndereco(e);
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.TELEFONE)){
			Telefone t = new Telefone();
			t.setNumero(txtBusca.getText().trim());
			this.montaTabelaTelefone(t);
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.CPFCNPJ)){
			Cliente c = new Cliente();
			c.setCpfOrCnpj(txtBusca.getText().trim());
			this.montaTabelaCliente(c);
		}
	}

	private void atualizarCampos(String operacao, int tipo){

		if(tipo == 1){
			String rotulo = (String)this.comboBoxEndereco.getItemAt(this.comboEnderecoAtual);
			if(operacao.equals("Salvar")){
				salvarCampos(rotulo, tipo);
			}
			else if(operacao.equals("Restaurar")){
				restaurarCampos(rotulo, tipo);
			}
		}
		else if(tipo == 2){
			String rotulo = (String) this.comboBoxTelefone.getItemAt(this.comboTelefoneAtual);
			if(operacao.equals("Salvar")){
				salvarCampos(rotulo, tipo);
			}
			else if(operacao.equals("Restaurar")){
				restaurarCampos(rotulo, tipo);
			}
		}
	}
	private void restaurarCampos(String chave, int tipo){

		String [] campos;
		if(tipo == 1){
			campos = enderecos.get(chave);
			if(campos != null){
				txtRua.setText(campos[0]);
				txtNumero.setText(campos[1]);
				txtBairro.setText(campos[2]);
				txtCidade.setText(campos[3]);
				txtCep.setText(campos[4]);
				comboBoxEstado.setSelectedIndex(Integer.parseInt(campos[5]));
				txtComplemento.setText(campos[6]);
			}
		}
		else if(tipo == 2){
			campos = telefones.get(chave);
			if(campos != null){
				txtTelefone.setText(campos[0]);
			}
		}
	}
	private void salvarCampos(String chave, int tipo){
		if(tipo == 1){
			String [] campos = new String[7];
			campos[0] = txtRua.getText().trim();
			campos[1] = txtNumero.getText().trim();
			campos[2] = txtBairro.getText().trim();
			campos[3] = txtCidade.getText().trim();
			campos[4] = txtCep.getText().trim();
			campos[5] = comboBoxEstado.getSelectedIndex() + "";
			campos[6] = txtComplemento.getText().trim();
			enderecos.put(chave, campos);
			comboEnderecoAtual = comboBoxEndereco.getSelectedIndex();
			limparEndereco();
		}
		else if(tipo == 2){
			String [] campos = new String[1];
			campos[0] = txtTelefone.getText().trim();
			telefones.put(chave, campos);
			comboTelefoneAtual = comboBoxTelefone.getSelectedIndex();
			limparTelefone();
		}
	}
	private void limparTelefone(){
		txtTelefone.setText("");
	}
	public void mousePressed(MouseEvent evt) {
		ajudarCursor((JFormattedTextField)evt.getSource());
	}
	private void ajudarCursor(JFormattedTextField campo){
		campo.setCaretPosition(campo.getText().trim().length());
	}
	public void stateChanged(ChangeEvent evt) {
		if(tabbedPane.getSelectedIndex() == 1){
			comboBoxBusca.setSelectedIndex(0);
			montaTabelaCliente(new Cliente());
		}
		else if(tabbedPane.getSelectedIndex() == 0){
			limparCadastro();
			botaoCadastrar.setText("Cadastrar");
		}
	}
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() != 10){
			buscar();
		}
	}

	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
