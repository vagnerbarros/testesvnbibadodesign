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
import util.Sessao;
import entidades.Empresa;
import entidades.Funcionario;
import entidades.Pessoa;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroEmpresa extends JPanel implements ActionListener, KeyListener, ChangeListener, MouseListener{
	private JFormattedTextField txtNomeEmpresa;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoCadastrar;
	private JTabbedPane tabbedPane;
	private JButton btnEditar;
	private JButton btnRemover;
	private Border bordaPadrao;

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
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(618, Short.MAX_VALUE)
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
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa:");
		lblNomeDaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		MaskFormatter mascaraEmpresa = criarMascara("****************************************************************************************************");
		mascaraEmpresa.setInvalidCharacters("!@#$%�&*()\"'+=-_[]{}|?><");
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
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGap(8)
						.addComponent(lblNomeDaEmpresa, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(txtNomeEmpresa, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(352)
								.addComponent(botaoCadastrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGap(26)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeDaEmpresa)
								.addComponent(txtNomeEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addComponent(botaoCadastrar))
				);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
						.addGap(10))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(11)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(SystemColor.menu);

		JLabel lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNome = new JLabel("Nome:");

		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%�&*()\"'+=-_[]{}|?><");
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
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome, Alignment.TRAILING)
								.addComponent(lblFiltrar, Alignment.TRAILING))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addGap(427))
				);
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGap(13)
						.addComponent(lblFiltrar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);
		panel_3.setLayout(gl_panel_3);

		JScrollPane scrollPane = new JScrollPane();

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(this);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane, Alignment.LEADING)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 652, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemover)))
					.addContainerGap(353, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemover)
						.addComponent(btnEditar)))
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
		this.montaTabela(new Empresa());

		this.setLayout(layout);

	}

	public void keyReleased(KeyEvent evt) {

		Empresa e = new Empresa();
		e.setNome(txtBusca.getText().trim());
		montaTabela(e);
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		normalizarCampos();

		if(elemento.equals(this.botaoCadastrar)){
			if(camposValidos()){
				cadastrar();
			}
		}
		else if(elemento.equals(this.btnEditar)){

			editarSelecionado();
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
			JOptionPane.showMessageDialog(null, "A Empresa j� existe.");
		}
	}

	private void limparCadastro(){

		txtNomeEmpresa.setText(null);
		txtNomeEmpresa.grabFocus();
	}

	private boolean camposValidos(){

		boolean valido = true;

		if(txtNomeEmpresa.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtNomeEmpresa);
		}
		if(!valido){
			JOptionPane.showMessageDialog(null, "Campos Obrigat�riaos n�o preenchidos");
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
