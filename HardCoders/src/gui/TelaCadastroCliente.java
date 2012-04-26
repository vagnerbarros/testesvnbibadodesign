package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;

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
	private final JComboBox comboBoxTelPF;
	private final JComboBox comboBoxTelPJ;
	private final JComboBox comboBoxEndereco;
	private final JComboBox comboBoxEstado;
	private JRadioButton rbtnJurica;
	private JRadioButton rbtnFisica;
	private final JLabel lblCpf;
	private final JLabel lblCnpj;
	private final JLabel lblNome;
	private final JLabel lblRazoSocial;
	private final JButton botaoCadastrar;
	private Map<String, String[]> enderecosPF;
	private Map<String, String[]> enderecosPJ;

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
	    
	    comboBoxTelPF = new JComboBox();
	    carregarCombo(comboBoxTelPF);
	    
	    comboBoxTelPJ = new JComboBox();
	    carregarCombo(comboBoxTelPJ);
	    
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
	    
		this.enderecosPF = new Hashtable<String, String[]>();
		this.enderecosPJ = new Hashtable<String, String[]>();
	    
	    comboBoxEstado = new JComboBox();
	    carregarCombo(comboBoxEstado);
	    
	    GroupLayout gl_panel_end_Fisica = new GroupLayout(panel_end_Fisica);
	    gl_panel_end_Fisica.setHorizontalGroup(
	    	gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    			.addGap(10)
	    			.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addComponent(lbl_end)
	    					.addGap(10)
	    					.addComponent(comboBoxEndereco, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addComponent(lbl_rua_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(13)
	    					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(lbl_numero_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addComponent(lbl_bairro_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(13)
	    					.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(lbl_cidade_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addComponent(lbl_cep_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(13)
	    					.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(lbl_estado_end, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	    					.addGap(10)
	    					.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
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
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lbl_rua_end))
	    				.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lbl_numero_end))
	    				.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(11)
	    			.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(4)
	    					.addComponent(lbl_bairro_end))
	    				.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(4)
	    					.addComponent(lbl_cidade_end))
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(10)
	    			.addGroup(gl_panel_end_Fisica.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lbl_cep_end))
	    				.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(gl_panel_end_Fisica.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lbl_estado_end))
	    				.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
	    					.addComponent(panel_end_Fisica, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_panel.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(botaoCadastrar))
	    				.addGroup(gl_panel.createSequentialGroup()
	    					.addGap(10)
	    					.addComponent(lbl_tel_fisica)
	    					.addGap(18)
	    					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	    						.addComponent(comboBoxTelPJ, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(gl_panel.createSequentialGroup()
	    							.addComponent(comboBoxTelPF, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	    							.addPreferredGap(ComponentPlacement.RELATED)
	    							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
	    							.addGap(64)
	    							.addComponent(lbl_email_fisica)
	    							.addGap(18)
	    							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))))
	    			.addContainerGap(682, Short.MAX_VALUE))
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
	    			.addComponent(panel_end_Fisica, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
	    			.addGap(19)
	    			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_panel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lbl_tel_fisica))
	    				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	    					.addComponent(comboBoxTelPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	    					.addComponent(lbl_email_fisica)
	    					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(comboBoxTelPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
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
		comboBoxTelPJ.setVisible(false);
		
		this.setLayout(layout);
	}
	
	private void carregarCombo(JComboBox combo){
		
		if(combo.equals(this.comboBoxTelPF)){
			String [] rotulos = Constantes.getRotuloTelefonePF();
			for(String rotulo : rotulos){
				this.comboBoxTelPF.addItem(rotulo);
			}
		}
		else if(combo.equals(this.comboBoxTelPJ)){
			String [] rotulos = Constantes.getRotuloTelefonePJ();
			for(String rotulo : rotulos){
				this.comboBoxTelPJ.addItem(rotulo);
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
		comboBoxTelPF.setVisible(true);
		
		lblCnpj.setVisible(false);
		txtCnpj.setVisible(false);
		lblRazoSocial.setVisible(false);
		txtRazaoSocial.setVisible(false);
		comboBoxTelPJ.setVisible(false);
	}
	
	private void ativarCamposPJ(){
		
		lblCpf.setVisible(false);
		txtCpf.setVisible(false);
		lblNome.setVisible(false);
		txtNome.setVisible(false);
		comboBoxTelPF.setVisible(false);
		
		lblCnpj.setVisible(true);
		txtCnpj.setVisible(true);
		lblRazoSocial.setVisible(true);
		txtRazaoSocial.setVisible(true);
		comboBoxTelPJ.setVisible(true);
	}
	
	private void cadastrarPessoaFisica(){
		
		// dados de cliente
		String tipo = Constantes.PF;
		String cpf = this.txtCpf.getText().trim();
		String nome = this.txtNome.getText().trim();
		String email = this.txtEmail.getText().trim();
		
		// dados de endereço
		String rotuloEndereco = (String) this.comboBoxEndereco.getSelectedItem();
		String rua = this.txtRua.getText().trim();
		String numero = this.txtNumero.getText().trim();
		String bairro = this.txtBairro.getText().trim();
		String cidade = this.txtCidade.getText().trim();
		String cep = this.txtCep.getText().trim();
		String estado = (String) this.comboBoxEstado.getSelectedItem();
		
		//dados de telefone
		String rotuloTelefone = (String) this.comboBoxTelPF.getSelectedItem();
		String numeroTelefone = this.txtTelefone.getText().trim();
	}
	
	private void cadastrarPessoaJuridica(){
		
		
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

	public void actionPerformed(ActionEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		
		if(elemento.equals(this.rbtnFisica)){
			this.ativarCamposPF();
		}
		else if(elemento.equals(this.rbtnJurica)){
			this.ativarCamposPJ();
		}
		else if(elemento.equals(this.botaoCadastrar)){
			if(this.rbtnFisica.isSelected()){
				cadastrarPessoaFisica();
			}
			else if(this.rbtnJurica.isSelected()){
				cadastrarPessoaJuridica();
			}
		}
		else if(elemento.equals(this.comboBoxEndereco)){
//			this.salvarCampos();
		}
	}
}
