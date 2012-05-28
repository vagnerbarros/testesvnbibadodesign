package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Telefone;
import fachada.Fachada;

public class TelaBuscarCliente extends JDialog implements ActionListener, KeyListener, MouseListener{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JFormattedTextField txtBusca;
	private JPanel panel_1;
	private JComboBox comboBoxBusca;
	private JButton btnConfirmar;
	private JPanel tela;

	public TelaBuscarCliente(java.awt.Frame parent, boolean modal, JPanel tela){
		super(parent, modal);
		this.tela = tela;
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarCliente.class.getResource("/gui/imagens/icone.png")));
		setTitle("Localizar Cliente .:.");
	    IniciarJDialog();
	}
	
	private void IniciarJDialog() {
		
		setBounds(100, 100, 733, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(78, 74, 110));
			JLabel lblLocalizarCliente = new JLabel("Localizar Cliente");
			lblLocalizarCliente.setForeground(Color.WHITE);
			lblLocalizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			JLabel label_1 = new JLabel("");
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(705)
						.addComponent(label_1))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(10)
						.addComponent(lblLocalizarCliente, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(11)
						.addComponent(label_1)
						.addGap(19)
						.addComponent(lblLocalizarCliente))
			);
			panel_1.setLayout(gl_panel_1);
		}
		
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
		
		JPanel panel = new JPanel();
		
		MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
		mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
		mascaraBusca.setPlaceholder("");
		txtBusca = new JFormattedTextField(mascaraBusca);
		txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtBusca.addMouseListener(this);
		txtBusca.addKeyListener(this);
		txtBusca.setColumns(10);
		
		comboBoxBusca = new JComboBox();
		carregarCombo(comboBoxBusca);
		comboBoxBusca.addActionListener(this);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(616)
					.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(btnConfirmar))
		);
		contentPanel.setLayout(gl_contentPanel);

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
	
	private void carregarCombo(JComboBox combo){
		if(combo.equals(this.comboBoxBusca)){
			String [] rotulos = Constantes.getBuscaCliente();
			for(String rotulo : rotulos){
				comboBoxBusca.addItem(rotulo);
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
	
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() != 10){
			buscar();
		}
	}
	
	public void mousePressed(MouseEvent evt) {
		ajudarCursor((JFormattedTextField)evt.getSource());
	}
	private void ajudarCursor(JFormattedTextField campo){
		campo.setCaretPosition(campo.getText().trim().length());
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(this.comboBoxBusca)){
			txtBusca.setText("");
			buscar();
		}
		else if(elemento.equals(btnConfirmar)){
			int linha = table.getSelectedRow();
			if(linha != -1){
				Long id_cliente = idClienteSelecionado(linha);
				if(this.tela instanceof TelaRealizarVenda){
					((TelaRealizarVenda)tela).retornarResultadoCliente(id_cliente);
				}
				else if(this.tela instanceof TelaRegistrarReclamacao){
					((TelaRegistrarReclamacao)tela).retornarResultadoCliente(id_cliente);
				}
				this.setVisible(false);
			}
		}
		
	}
	
	private Long idClienteSelecionado(int linha){
		Long retorno = null;
		if(comboBoxBusca.getSelectedItem().equals(Constantes.NOMERAZAO)){
			retorno = ((Cliente)table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.TELEFONE)){
			retorno = ((Telefone)table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.ENDERECO)){
			retorno = ((Endereco)table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		else if(comboBoxBusca.getSelectedItem().equals(Constantes.CPFCNPJ)){
			retorno = ((Cliente)table.getModel().getValueAt(linha, 0)).getId_pessoa();
		}
		return retorno;
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

	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
