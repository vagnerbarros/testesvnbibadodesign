package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout.CaretPolicy;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.text.MaskFormatter;
import util.Constantes;
import util.NivelAcesso;
import util.Sessao;
import entidades.Servico;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaCadastroServicos extends JPanel implements ActionListener, ChangeListener, KeyListener, MouseListener{

	private JFormattedTextField txtNome;
	private JFormattedTextField txtValor;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JButton botaoCadastrar;
	private JButton btnVisualizar;
	private JButton btnRemover;
	private JTabbedPane tabbedPane;
	private JComboBox comboBoxBusca;
	private Border bordaPadrao;

	public TelaCadastroServicos() {

		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Servi\u00E7os");
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
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(958, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoServio.setBounds(10, 41, 89, 17);
		panel_2.add(lblNomeDoServio);

		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		mascaraNome.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?");
		mascaraNome.setPlaceholder("");
		txtNome = new JFormattedTextField(mascaraNome);
		txtNome.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNome.setColumns(10);
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(99, 39, 296, 20);
		txtNome.addMouseListener(this);
		panel_2.add(txtNome);

		JLabel lblValorPadro = new JLabel("Valor Padr\u00E3o:");
		lblValorPadro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorPadro.setBounds(10, 70, 66, 17);
		panel_2.add(lblValorPadro);

		MaskFormatter mascaraValor = criarMascara("********");
		mascaraValor.setValidCharacters("1234567890");
		mascaraValor.setPlaceholder("");
		txtValor = new JFormattedTextField(mascaraValor);
		txtValor.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtValor.setColumns(10);
		txtValor.setBackground(Color.WHITE);
		txtValor.setBounds(99, 68, 89, 20);
		txtValor.addMouseListener(this);
		txtValor.addKeyListener(this);
		panel_2.add(txtValor);

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);
		botaoCadastrar.setBounds(306, 67, 89, 23);
		panel_2.add(botaoCadastrar);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(840, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(270, Short.MAX_VALUE))
				);

		JLabel lblEx = new JLabel("Ex.: 00.00");
		lblEx.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblEx.setBounds(198, 70, 66, 14);
		panel_2.add(lblEx);

		JLabel lblCadastrarNovoServio = new JLabel("Cadastrar Novo Servi\u00E7o");
		lblCadastrarNovoServio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastrarNovoServio.setBounds(10, 11, 142, 17);
		panel_2.add(lblCadastrarNovoServio);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Listagem", null, panel_1, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(SystemColor.menu);

		JLabel label_1 = new JLabel("Filtrar:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxBusca = new JComboBox();
		iniciarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);

		MaskFormatter mascaraBusca = criarMascara("*********************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		txtBusca.setBackground(Color.WHITE);
		txtBusca.addMouseListener(this);

		this.bordaPadrao = txtBusca.getBorder();

		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(69, Short.MAX_VALUE))
				);
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
										.addGap(13)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_3.createSequentialGroup()
												.addGap(15)
												.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
														.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
														.addContainerGap(33, Short.MAX_VALUE))
				);
		panel_3.setLayout(gl_panel_3);

		JLabel lblServiosCadastrados = new JLabel("Servi\u00E7os Cadastrados");
		lblServiosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();

		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(this);

		btnRemover = new JButton("Remover");
		NivelAcesso.inicializarBotao(btnRemover, Sessao.getFuncionario().getCargo());
		btnRemover.addActionListener(this);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
						.addGap(14)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(btnVisualizar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnRemover)
										.addContainerGap())
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
														.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
														.addComponent(lblServiosCadastrados, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
														.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
														.addGap(555))))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblServiosCadastrados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnVisualizar)
								.addComponent(btnRemover))
								.addContainerGap())
				);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Nome", "Valor"}
				) {
			Class[] types = new Class [] {Servico.class, java.lang.String.class};
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

		this.montaTabela(new Servico());

		this.setLayout(layout);

	}

	private void montaTabela(Servico s) {

		Fachada fachada = Fachada.getInstancia();
		s.setId_empresa(Sessao.getEmpresa().getId());
		List<Servico> listaServicos = fachada.buscaLikeServico(s);
		String colunas[] = { "Nome", "Valor"};
		Object linhas[][] = new Object[listaServicos.size()][colunas.length];

		if (listaServicos.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaServicos.size(); i++) {

				linhas[i][0] = listaServicos.get(i);
				linhas[i][1] = listaServicos.get(i).getValor().toString();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Servico.class, java.lang.String.class};
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
		else if(elemento.equals(this.comboBoxBusca)){
			this.txtBusca.setText("");
			this.buscar();
		}
		else if(elemento.equals(this.btnRemover)){
			removerServico();
		}
		else if(elemento.equals(this.btnVisualizar)){

		}
	}

	private void removerServico(){

		int linha = table.getSelectedRow();

		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Servico s = (Servico) table.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstancia();
				fachada.removerServico(s);
				montaTabela(new Servico());
			}
		}
	}

	private void cadastrar(){

		String nome = this.txtNome.getText().trim();
		Double valor = Double.parseDouble(this.txtValor.getText().trim());

		Servico s = new Servico();
		s.setNome(nome);
		s.setValor(valor);
		s.setId_empresa(Sessao.getEmpresa().getId());
		s.setAtivo(Constantes.ATIVO);
		Fachada fachada = Fachada.getInstancia();
		try {
			fachada.cadastrarServico(s);
			JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
			limparCadastro();
		} catch (EntidadeJaExisteException e) {
			JOptionPane.showMessageDialog(null, "Serviço já existe.");
		}
	}

	private void limparCadastro(){
		txtNome.setText(null);
		txtValor.setText(null);
		txtNome.grabFocus();
	}

	private boolean camposValidos(){

		boolean valido = true;

		if(txtNome.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtNome);
		}
		if(txtValor.getText().trim().equals("")){
			valido = false;
			pintarBorda(txtValor);
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
		txtNome.setBorder(bordaPadrao);
		txtValor.setBorder(bordaPadrao);
	}

	public void stateChanged(ChangeEvent evt) {

		if(this.tabbedPane.getSelectedIndex() == 1){
			this.montaTabela(new Servico());
		}
	}

	private void iniciarCombo(JComboBox combo){
		if(combo.equals(this.comboBoxBusca)){
			String [] parametros = Constantes.getBuscaServico();
			for(String parametro : parametros){
				combo.addItem(parametro);
			}
		}
	}

	public void keyReleased(KeyEvent evt) {
		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(txtBusca)){
			if(evt.getKeyCode() != 10){
				buscar();
			}
		}
		else if(elemento.equals(txtValor)){
			String text = txtValor.getText().trim();
			
		}
	}

	private void buscar(){

		Servico s = new Servico();
		if(this.comboBoxBusca.getSelectedItem().equals(Constantes.NOME)){
			s.setNome(txtBusca.getText().trim());
		}
		else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.VALOR)){
			String valor = txtBusca.getText().trim();
			if(!valor.equals("")){
				try{
					double v = Double.parseDouble(valor);
					s.setValor(v);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "A busca por valor deve conter números");
					txtBusca.setText("");
				}
			}
		}
		this.montaTabela(s);
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

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void keyPressed(KeyEvent evt) {}
	public void keyTyped(KeyEvent evt) {}
}
