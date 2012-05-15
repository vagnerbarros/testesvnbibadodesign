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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Sessao;

import com.toedter.calendar.JDateChooser;

import entidades.Cliente;
import entidades.Servico;
import entidades.Solicitacao;
import fachada.Fachada;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class TelaContratosVencer extends JPanel implements PropertyChangeListener, ActionListener, KeyListener, MouseListener{
	
	private JDateChooser txtDataInicial;
	private JDateChooser txtDataFinal;
	private JFormattedTextField txtNomeServico;
	private JTable table;
	private JButton btnDetalhar;
	private Map<Long, Cliente> clientes;
	private Map<Long, Servico> servicos;
	private TelaDetalhesDoContrato tdc;

	public TelaContratosVencer() {

		clientes = new Hashtable<Long, Cliente>();
		servicos = new Hashtable<Long, Servico>();
		carregarClientes();
		carregarServicos(new Servico());
		setBackground(Color.WHITE);

		// A partir daqui comandos para que o elemento JPanel redimensione o seu tamanho de acordo
		// com o tamanho do redimensionamento do frame

		JPanel jPanelSuperior = new JPanel();

		JLabel lblCadastroDeClientes = new JLabel("Contratos \u00E0 Vencer");
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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "Filtrar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.text);
		//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelSuperior, GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
				.addComponent(JPanelInferior, GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(906, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(JPanelInferior, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(null, "Per\u00EDodo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 22, 369, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataInicial.setBounds(10, 28, 65, 14);
		panel_1.add(lblDataInicial);

		txtDataInicial = new JDateChooser();
		txtDataInicial.getDateEditor().setEnabled(false);
		txtDataInicial.addPropertyChangeListener(this);
		txtDataInicial.setBounds(85, 26, 86, 20);
		panel_1.add(txtDataInicial);

		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataFinal.setBounds(198, 28, 65, 14);
		panel_1.add(lblDataFinal);

		txtDataFinal = new JDateChooser();
		txtDataFinal.setEnabled(false);
		txtDataFinal.addPropertyChangeListener(this);
		txtDataFinal.setBounds(273, 26, 86, 20);
		panel_1.add(txtDataFinal);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(393, 22, 369, 76);
		panel.add(panel_2);

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoServio.setBounds(10, 28, 97, 14);
		panel_2.add(lblNomeDoServio);

		txtNomeServico = new JFormattedTextField();
		MaskFormatter mascaraNome = criarMascara("****************************************************************************************************");
		mascaraNome.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?");
		mascaraNome.setPlaceholder("");
		txtNomeServico = new JFormattedTextField(mascaraNome);
		txtNomeServico.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtNomeServico.addKeyListener(this);
		txtNomeServico.setColumns(10);
		txtNomeServico.setBounds(117, 26, 242, 20);
		txtNomeServico.addMouseListener(this);
		txtNomeServico.setEditable(false);
		panel_2.add(txtNomeServico);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 752, 155);
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
				},
				new String[] {
						"Nome do Cliente", "Serviço", "Data Inicial", "Data Final"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(table);

		montaTabela(new Solicitacao());

		btnDetalhar = new JButton("Detalhar");
		btnDetalhar.addActionListener(this);
		btnDetalhar.setBounds(10, 275, 89, 23);
		panel.add(btnDetalhar);

		this.setLayout(layout);
	}

	private void carregarClientes(){

		Fachada fachada = Fachada.getInstancia();
		Cliente busca = new Cliente();
		busca.setId_empresa(Sessao.getEmpresa().getId());
		List<Cliente> listaClientes = fachada.buscarCliente(busca);
		for(Cliente c : listaClientes){
			clientes.put(c.getId_pessoa(), c);
		}
	}

	private void carregarServicos(Servico busca){

		servicos.clear();
		Fachada fachada = Fachada.getInstancia();
		busca.setId_empresa(Sessao.getEmpresa().getId());
		List<Servico> listaServicos = fachada.buscaLikeServico(busca);
		for(Servico s : listaServicos){
			servicos.put(s.getId(), s);
		}
	}

	private void montaTabela(Solicitacao s) {

		Fachada fachada = Fachada.getInstancia();
		s.setId_empresa(Sessao.getEmpresa().getId());
		List<Solicitacao> listaSolicitacoes = fachada.buscaIntervaloData(s);
		String colunas[] = { "Nome do Cliente", "Serviço", "Data Inicial", "Data Final"};
		Object linhas[][] = new Object[listaSolicitacoes.size()][colunas.length];

		if (listaSolicitacoes.isEmpty()) {
			table.setModel(new DefaultTableModel(null, colunas));
		} else {
			for (int i = 0; i < listaSolicitacoes.size(); i++) {

				linhas[i][0] = clientes.get(listaSolicitacoes.get(i).getId_cliente());
				linhas[i][1] = servicos.get(listaSolicitacoes.get(i).getId_servico());
				linhas[i][2] = listaSolicitacoes.get(i).getData_inicial();
				linhas[i][3] = listaSolicitacoes.get(i).getData_final();
			}
		}

		table.setModel(new DefaultTableModel(linhas, colunas) {
			Class[] types = new Class[] { Cliente.class, Servico.class, Date.class, Date.class};
			boolean[] canEdit = new boolean[] { false, false, false, false};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	public void propertyChange(PropertyChangeEvent evt) {

		Date dataInicial = txtDataInicial.getDate();
		Date dataFinal = txtDataFinal.getDate();
		JDateChooser data = (JDateChooser) evt.getSource();

		if(dataInicial != null && data.equals(txtDataInicial)){

			txtDataFinal.setMinSelectableDate(dataInicial);
			txtDataFinal.setEnabled(true);
			txtDataFinal.getDateEditor().setEnabled(false);
		}
		else if(dataFinal != null && data.equals(txtDataFinal)){
			txtNomeServico.setEditable(true);
			buscar();
		}
	}

	private void buscar(){

		Solicitacao s = new Solicitacao();
		s.setData_inicial(txtDataInicial.getCalendar().getTime());
		s.setData_final(txtDataFinal.getCalendar().getTime());
		montaTabela(s);
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(btnDetalhar)){
			int linha = table.getSelectedRow();
			if(linha != -1){
				
				Cliente c = (Cliente)table.getModel().getValueAt(linha, 0);
				Servico s = (Servico)table.getModel().getValueAt(linha, 1);
				if(c != null){
					if(s != null){
						tdc = new TelaDetalhesDoContrato(new javax.swing.JFrame(), true, c, s, this);
						tdc.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Serviço não informado");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Cliente não informado");
				}
			}
		}
	}
	
	protected void retornar(){
		
		buscar();
		tdc.setVisible(false);
		tdc = null;
		System.gc();
	}

	public void keyReleased(KeyEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(txtNomeServico)){
			Servico s = new Servico();
			s.setNome(txtNomeServico.getText().trim());
			carregarServicos(s);
			buscar();
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
