package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextLayout.CaretPolicy;
import java.text.ParseException;
import java.util.Hashtable;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Pessoa;
import entidades.Telefone;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroCliente extends JPanel implements ActionListener{

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
	private final JComboBox comboBoxTelefone;
	private final JComboBox comboBoxEndereco;
	private final JComboBox comboBoxEstado;
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
				gl_jPanelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelSuperior.createSequentialGroup()
						.addGap(24)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(511, Short.MAX_VALUE))
				);
		gl_jPanelSuperior.setVerticalGroup(
				gl_jPanelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanelSuperior.createSequentialGroup()
						.addContainerGap(35, Short.MAX_VALUE)
						.addComponent(lblCadastroDeClientes, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGap(31))
				);
		jPanelSuperior.setLayout(gl_jPanelSuperior);

		JPanel JPanelInferior = new JPanel();
		JPanelInferior.setBackground(new java.awt.Color(167, 196, 210));
		jPanelSuperior.setBackground(new java.awt.Color(70, 65, 107));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/gui/imagens/LogotipoHard.png")));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(840, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastros", null, panel, null);

		rbtnFisica = new JRadioButton("Pessoa F\u00EDsica");
		rbtnFisica.addActionListener(this);
		rbtnFisica.setBackground(Color.WHITE);

		rbtnJurica = new JRadioButton("Pessoa Jur\u00EDdica");
		rbtnJurica.addActionListener(this);
		rbtnJurica.setBackground(Color.WHITE);

		ButtonGroup group = new ButtonGroup();
		group.add(rbtnJurica);
		group.add(rbtnFisica);

		rbtnFisica.setSelected(true);

		lblNome = new JLabel("Nome:");

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.setColumns(10);
		
		this.bordaPadrao = txtNome.getBorder();

		lblCpf = new JLabel("CPF:");

		MaskFormatter mascaraCpf = criarMascara("###.###.###-##");
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCpf.setColumns(10);

		lblCnpj = new JLabel("CNPJ:");

		lblRazoSocial = new JLabel("Raz\u00E3o Social:");

		MaskFormatter mascaraRazaoSocial = criarMascara("****************************************************************************************************");
		txtRazaoSocial = new JFormattedTextField(mascaraRazaoSocial);
		txtRazaoSocial.setColumns(10);

		MaskFormatter mascaraCnpj = criarMascara("##.###.###/####-##");
		txtCnpj = new JFormattedTextField(mascaraCnpj);
		txtCnpj.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCnpj.setColumns(10);

		final JPanel panel_end_Fisica = new JPanel();

		final JLabel lbl_tel_fisica = new JLabel("Telefone:");

		MaskFormatter mascaraTelefone = criarMascara("(##)####-####");
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTelefone.setColumns(10);

		final JLabel lbl_email_fisica = new JLabel("E-mail:");

		MaskFormatter mascararEmail = criarMascara("****************************************************************************************************");
		txtEmail = new JFormattedTextField(mascararEmail);
		txtEmail.setColumns(10);

		comboBoxTelefone = new JComboBox();
		carregarCombo(comboBoxTelefone);
		comboBoxTelefone.addActionListener(this);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);

		JLabel lbl_end = new JLabel("Endere\u00E7o:");

		comboBoxEndereco = new JComboBox();
		carregarCombo(comboBoxEndereco);
		this.comboBoxEndereco.addActionListener(this);

		final JLabel lbl_rua_end = new JLabel("Rua:");

		MaskFormatter mascaraRua = criarMascara("****************************************************************************************************");
		txtRua = new JFormattedTextField(mascaraRua);
		txtRua.setColumns(10);

		final JLabel lbl_numero_end = new JLabel("N\u00BA:");

		MaskFormatter mascaraNumero = criarMascara("*****");
		txtNumero = new JFormattedTextField(mascaraNumero);
		txtNumero.setColumns(10);

		final JLabel lbl_bairro_end = new JLabel("Bairro:");

		final JLabel lbl_cep_end = new JLabel("CEP:");

		MaskFormatter mascaraBairro = criarMascara("**************************************************");
		txtBairro = new JFormattedTextField(mascaraBairro);
		txtBairro.setColumns(10);

		MaskFormatter mascaraCep = criarMascara("##.###-###");
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCep.setColumns(10);

		MaskFormatter mascaraCidade = criarMascara("**************************************************");
		txtCidade = new JFormattedTextField(mascaraCidade);
		txtCidade.setColumns(10);

		final JLabel lbl_cidade_end = new JLabel("Cidade:");

		final JLabel lbl_estado_end = new JLabel("Estado:");

		this.enderecos = new Hashtable<String, String[]>();
		this.telefones = new Hashtable<String, String[]>();
		this.comboEnderecoAtual = 0;
		this.comboTelefoneAtual = 0;

		comboBoxEstado = new JComboBox();
		carregarCombo(comboBoxEstado);

		JLabel lblComplemento = new JLabel("Complemento:");

		MaskFormatter mascaraComplemento = criarMascara("**************************************************");
		txtComplemento = new JFormattedTextField(mascaraComplemento);
		txtComplemento.setColumns(10);

		GroupLayout gl_panel_end_Fisica = new GroupLayout(panel_end_Fisica);
		gl_panel_end_Fisica.setHorizontalGroup(
			gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_end_Fisica.createSequentialGroup()
									.addComponent(lbl_end)
									.addGap(10)
									.addComponent(comboBoxEndereco, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_end_Fisica.createSequentialGroup()
									.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_bairro_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_cep_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_rua_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addGap(33)
									.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtComplemento, Alignment.LEADING)
										.addComponent(txtCep)
										.addComponent(txtBairro, Alignment.LEADING)
										.addComponent(txtRua, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
									.addGap(65)
									.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_end_Fisica.createSequentialGroup()
												.addComponent(lbl_numero_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel_end_Fisica.createSequentialGroup()
												.addComponent(lbl_cidade_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(txtCidade, 0, 0, Short.MAX_VALUE)))
										.addGroup(Alignment.TRAILING, gl_panel_end_Fisica.createSequentialGroup()
											.addComponent(lbl_estado_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
							.addGap(41))
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblComplemento)))
					.addGap(9))
		);
		gl_panel_end_Fisica.setVerticalGroup(
			gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_end))
						.addComponent(comboBoxEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_rua_end))
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_numero_end))
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_end_Fisica.createSequentialGroup()
									.addGap(11)
									.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_end_Fisica.createSequentialGroup()
											.addGap(4)
											.addComponent(lbl_bairro_end))
										.addGroup(gl_panel_end_Fisica.createSequentialGroup()
											.addGap(4)
											.addComponent(lbl_cidade_end))))
								.addGroup(gl_panel_end_Fisica.createSequentialGroup()
									.addGap(12)
									.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(11)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_cep_end))
						.addGroup(gl_panel_end_Fisica.createSequentialGroup()
							.addGap(3)
							.addComponent(lbl_estado_end))
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComplemento)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_end_Fisica.setLayout(gl_panel_end_Fisica);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(46)
							.addComponent(rbtnFisica)
							.addComponent(rbtnJurica))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNome)
							.addGap(40)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblRazoSocial, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtRazaoSocial, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(botaoCadastrar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lbl_tel_fisica)
							.addGap(33)
							.addComponent(comboBoxTelefone, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(lbl_email_fisica)
							.addGap(18)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_end_Fisica, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rbtnFisica)
						.addComponent(rbtnJurica))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCnpj))
						.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRazoSocial))
						.addComponent(txtRazaoSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCpf))
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_end_Fisica, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_email_fisica)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_tel_fisica))
					.addGap(44)
					.addComponent(botaoCadastrar)
					.addGap(85))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
				},
				new String[] {
						"C\u00F3digo", "Tipo de Reclama\u00E7\u00E3o", "Data do Cadastro", "A\u00E7\u00F5es"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(10)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
						.addGap(10))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(47)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addGap(11))
				);
		panel_1.setLayout(gl_panel_1);

		lblCnpj.setVisible(false);
		txtCnpj.setVisible(false);
		lblRazoSocial.setVisible(false);
		txtRazaoSocial.setVisible(false);

		this.setLayout(layout);
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
			JOptionPane.showMessageDialog(null, e1.getMessage());
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
	}
	
	private void cadastrarTelefones(Long id_pessoa) throws EntidadeJaExisteException{
		
		//dados de telefone
		Fachada fachada = Fachada.getInstancia();
		salvarCampos((String)comboBoxTelefone.getSelectedItem(), 2);
		Set<String> rotulos = telefones.keySet();
		for(String rotulo : rotulos){
			String numeroTelefone = telefones.get(rotulo)[0];
			Telefone t = new Telefone();
			t.setId_pessoa(id_pessoa);
			t.setNumero(numeroTelefone);
			t.setRotulo(rotulo);
			t.setAtivo(Constantes.ATIVO);
			
			fachada.cadastrarTelefone(t);
		}
	}

	private void cadastrarEnderecos(Long id_pessoa) throws EntidadeJaExisteException{

		salvarCampos((String)comboBoxEndereco.getSelectedItem(), 1);
		Set<String> rotulos = enderecos.keySet();
		Fachada fachada = Fachada.getInstancia();
		for(String rotulo : rotulos){
			String [] campos = enderecos.get(rotulo);

			String rua = campos[0];
			String numero = campos[1];
			String bairro = campos[2];
			String cidade = campos[3];
			String cep = campos[4];
			String estado = (String)comboBoxEstado.getItemAt(Integer.parseInt(campos[5]));
			String complemento = campos[6];

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
			e.setAtivo(Constantes.ATIVO);
			fachada.cadastrarEndereco(e);
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
	
	private boolean camposPFValidos(){
		
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
			JOptionPane.showMessageDialog(null, "Campos Obrigatóriaos não preenchidos");
		}
		return valido;
	}
	
	private boolean camposPJValidos(){
		
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
			JOptionPane.showMessageDialog(null, "Campos Obrigatóriaos não preenchidos");
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
			if(this.rbtnFisica.isSelected()){
				if(camposPFValidos()){
					cadastrar(1);
				}
			}
			else if(this.rbtnJurica.isSelected()){
				if(camposPJValidos()){
					cadastrar(2);
				}
			}
		}
		else if(elemento.equals(this.comboBoxEndereco)){
			this.atualizarCampos("Salvar", 1);
			this.atualizarCampos("Restaurar", 1);
		}
		else if(elemento.equals(this.comboBoxTelefone)){
			this.atualizarCampos("Salvar", 2);
			this.atualizarCampos("Restaurar", 2);
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
}
