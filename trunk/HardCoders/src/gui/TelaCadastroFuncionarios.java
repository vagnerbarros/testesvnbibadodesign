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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Telefone;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroFuncionarios extends JPanel implements ActionListener, KeyListener, ChangeListener{

	private JFormattedTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtBairro;
	private JFormattedTextField txtLogin;
	private JFormattedTextField txtSenha;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtEndereco;
	private JFormattedTextField txtComplemento;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtCidade;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxTelefone;
	private JComboBox comboBoxCargo;
	private JButton btnLimpar;
	private JButton btnCadastro;
	private JComboBox comboBoxBusca;
	private JTabbedPane tabbedPane;
	private Border bordaPadrao;

	public TelaCadastroFuncionarios() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Funcion�rios");
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
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(356, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 671, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 333, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(17, 54, 53, 14);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(17, 23, 24, 15);
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(278, 89, 56, 15);
		lblEndereo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblBairro = new JLabel("CEP:");
		lblBairro.setBounds(17, 89, 25, 15);
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		mascaraNome.setInvalidCharacters("1234567890!@#$%�&*()\"'+=-_[]{}|?><");
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.setBounds(81, 52, 532, 20);
		txtNome.setColumns(10);

		MaskFormatter mascaraCep = criarMascara("##.###-###");
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCep.setBounds(81, 87, 187, 20);
		txtCep.setColumns(10);

		MaskFormatter mascaraNumero = criarMascara("#####");
		txtNumero = new JFormattedTextField(mascaraNumero);
		txtNumero.setColumns(10);
		txtNumero.setBounds(564, 87, 49, 20);
		panel.add(txtNumero);

		MaskFormatter mascaraCpf = criarMascara("###.###.###-##");
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtCpf.setBounds(81, 21, 187, 20);
		txtCpf.setColumns(10);


		MaskFormatter mascaraBairro = criarMascara("**************************************************");
		mascaraBairro.setInvalidCharacters("1234567890!@#$%�&*()\"'+=-_[]{}|?<>");
		txtBairro = new JFormattedTextField(mascaraBairro);
		txtBairro.setBounds(81, 118, 187, 20);
		txtBairro.setColumns(10);

		MaskFormatter mascaraLogin = criarMascara("********************");
		mascaraLogin.setInvalidCharacters(" !@#$%�&*()\"'+=-_[]{}|?<>");
		txtLogin = new JFormattedTextField(mascaraLogin);
		txtLogin.setBounds(81, 177, 187, 20);
		txtLogin.setColumns(10);

		MaskFormatter mascaraSenha = criarMascara("********************");
		mascaraSenha.setInvalidCharacters(" !@#$%�&*()\"'+=-_[]{}|?<>");
		txtSenha = new JFormattedTextField(mascaraSenha);
		txtSenha.setBounds(81, 208, 187, 20);
		txtSenha.setColumns(10);

		MaskFormatter mascaraTelefone = criarMascara("(##)####-####");
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtTelefone.setBounds(182, 149, 86, 20);
		txtTelefone.setColumns(10);

		MaskFormatter mascaraEndereco = criarMascara("****************************************************************************************************");
		mascaraEndereco.setInvalidCharacters("1234567890!@#$%�&*()\"'+=-_[]{}|?<>");
		txtEndereco = new JFormattedTextField(mascaraEndereco);
		txtEndereco.setBounds(368, 87, 157, 20);
		txtEndereco.setColumns(10);

		MaskFormatter mascaraCidade = criarMascara("**************************************************");
		mascaraCidade.setInvalidCharacters("1234567890!@#$%�&*()\"'+=-_[]{}|?<>");
		txtCidade = new JFormattedTextField(mascaraCidade);
		txtCidade.setColumns(10);
		txtCidade.setBounds(368, 149, 157, 20);
		panel.add(txtCidade);

		this.bordaPadrao = txtCidade.getBorder();
		
		MaskFormatter mascaraComplemento = criarMascara("**************************************************");
		mascaraComplemento.setInvalidCharacters("!@#$%�&*()\"'+=-_[]{}|?<>");
		txtComplemento = new JFormattedTextField(mascaraComplemento);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(368, 118, 245, 20);
		panel.add(txtComplemento);

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);


		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(17, 120, 34, 15);
		lblBairro_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		comboBoxTelefone = new JComboBox();
		comboBoxTelefone.setBounds(80, 149, 91, 20);
		iniciarCombo(comboBoxTelefone);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(17, 151, 53, 15);
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(17, 179, 53, 15);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(17, 210, 53, 15);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(17, 248, 78, 23);
		btnLimpar.addActionListener(this);

		btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(101, 248, 78, 23);
		btnCadastro.addActionListener(this);

		JLabel lblEstado = new JLabel("UF:");
		lblEstado.setBounds(535, 151, 18, 15);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(563, 149, 50, 20);
		iniciarCombo(comboBoxEstado);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(278, 179, 53, 15);
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		comboBoxCargo = new JComboBox();
		comboBoxCargo.setBounds(368, 177, 99, 20);
		iniciarCombo(comboBoxCargo);
		panel.setLayout(null);
		panel.add(btnLimpar);
		panel.add(btnCadastro);
		panel.add(lblSenha);
		panel.add(lblLogin);
		panel.add(lblBairro_1);
		panel.add(lblTelefone);
		panel.add(lblBairro);
		panel.add(lblNome);
		panel.add(lblCpf);
		panel.add(txtNome);
		panel.add(txtCep);
		panel.add(lblEndereo);
		panel.add(txtLogin);
		panel.add(lblCargo);
		panel.add(txtSenha);
		panel.add(txtBairro);
		panel.add(lblEstado);
		panel.add(comboBoxTelefone);
		panel.add(txtTelefone);
		panel.add(comboBoxCargo);
		panel.add(txtEndereco);
		panel.add(comboBoxEstado);
		panel.add(txtCpf);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComplemento.setBounds(278, 120, 90, 15);
		panel.add(lblComplemento);

		JLabel lblNumero = new JLabel("N\u00B0:");
		lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(535, 90, 25, 15);
		panel.add(lblNumero);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(278, 151, 56, 15);
		panel.add(lblCidade);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(SystemColor.menu);

		JLabel label_1 = new JLabel("Filtrar:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxBusca = new JComboBox();
		this.iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(356, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addGap(13)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(15)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGap(34)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addGap(10))
				);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nome", "CPF", "Cargo"}
				) {
			Class[] types = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class};
			boolean[] canEdit = new boolean [] {false, false, false};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		this.montaTabela(new Funcionario());

		this.setLayout(layout);

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

				linhas[i][0] = listaFuncionarios.get(i).getNome();
				linhas[i][1] = listaFuncionarios.get(i).getCpf();
				linhas[i][2] = listaFuncionarios.get(i).getCargo();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class,
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
		txtTelefone.setText(null);
		txtComplemento.setText(null);
		txtNumero.setText(null);
		txtCidade.setText(null);
	}

	private void cadastrar(){

		String login = txtLogin.getText().trim();
		String nome = txtNome.getText().trim();
		String senha = txtSenha.getText().trim();
		String cpf = txtCpf.getText();
		String cargo = (String) comboBoxCargo.getSelectedItem();
		String bairro = txtBairro.getText().trim();
		String cidade = txtCidade.getText().trim();
		String cep = txtCep.getText();
		String rua = txtEndereco.getText().trim();
		String numero = txtNumero.getText().trim();
		String complemento = txtComplemento.getText().trim();
		String telefone = txtTelefone.getText();
		String estado = (String) comboBoxEstado.getSelectedItem();
		String rotuloTel = (String) comboBoxTelefone.getSelectedItem();

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

			// dados de endere�o
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
			end.setAtivo(Constantes.ATIVO);
			fachada.cadastrarEndereco(end);

			// dados de telefone
			Telefone tel = new Telefone();
			tel.setAtivo(Constantes.ATIVO);
			tel.setId_pessoa(id_pessoa);
			tel.setNumero(telefone);
			tel.setRotulo(rotuloTel);
			fachada.cadastrarTelefone(tel);

			this.limparCadastro();
			JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!");
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Este Login j� existe.");
		}
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		normalizarCampos();
		
		if(elemento.equals(this.btnLimpar)){
			this.limparCadastro();
		}
		else if(elemento.equals(this.btnCadastro)){
			if(camposValidos()){
				this.cadastrar();
			}
		}
		else if(elemento.equals(this.comboBoxBusca)){
			this.buscar();
		}
	}
	
	private void normalizarCampos(){
		txtCpf.setBorder(bordaPadrao);
		txtLogin.setBorder(bordaPadrao);
		txtNome.setBorder(bordaPadrao);
		txtSenha.setBorder(bordaPadrao);
	}

	private boolean camposValidos(){

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
		if(txtSenha.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtSenha);
		}

		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos Obrigat�riaos n�o preenchidos");
		}
		return valido;
	}
	
	private void pintarBorda(JFormattedTextField campo){
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
