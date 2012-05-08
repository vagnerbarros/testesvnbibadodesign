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
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import util.Constantes;
import util.Sessao;
import entidades.Cliente;
import entidades.Falha;
import entidades.Reclamacao;
import entidades.Servico;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import javax.swing.JButton;

public class TelaRegistrarReclamacao extends JPanel implements ActionListener, MouseListener, KeyListener{
	
	private JTextField txtCpfOrCnpj;
	private JTextField txtNome;
	private JTextField txtServico;
	private JTextField txtCodigo;
	private JLabel lupaCliente;
	private JLabel lupaReclamacao;
	private final JLabel lblCpfCnpj;
	private final JLabel lblNome;
	private JRadioButton rdbtnPessoaJurdica;
	private JRadioButton rdbtnPessoaFsica;
	private JList listaServico;
	private JList listaCliente;
	private JList listaReclamacao;
	private DefaultListModel modeloServico;
	private DefaultListModel modeloCliente;
	private DefaultListModel modeloReclamacao;
	private List<Cliente> clientes;
	private List<Servico> servicos;
	private List<Reclamacao> reclamacoes;
	private Cliente clienteSelecionado;
	private Servico servicoSelecionado;
	private Reclamacao reclamacaoSelecionada;
	private JButton btnConfirmar;
	
	/**
	 * Create the panel.
	 */
	public TelaRegistrarReclamacao() {
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 65, 107));
		
		JLabel lblRegistrarReclamao = new JLabel("Registrar Reclama\u00E7\u00E3o");
		lblRegistrarReclamao.setForeground(Color.WHITE);
		lblRegistrarReclamao.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1293, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblRegistrarReclamao, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(928, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblRegistrarReclamao, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoServio.setBounds(21, 36, 97, 14);
		panel_2.add(lblNomeDoServio);
		
		txtServico = new JTextField();
		txtServico.addKeyListener(this);
		txtServico.addMouseListener(this);
		txtServico.setColumns(10);
		txtServico.setBounds(128, 34, 142, 20);
		panel_2.add(txtServico);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Reclama\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setBounds(21, 36, 97, 14);
		panel_3.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.addMouseListener(this);
		txtCodigo.addKeyListener(this);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(128, 34, 142, 20);
		panel_3.add(txtCodigo);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(379, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConfirmar)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(379, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConfirmar)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		
		txtCpfOrCnpj = new JTextField();
		txtCpfOrCnpj.addKeyListener(this);
		txtCpfOrCnpj.addMouseListener(this);
		txtCpfOrCnpj.setBounds(132, 72, 151, 20);
		panel_1.add(txtCpfOrCnpj);
		txtCpfOrCnpj.setColumns(10);
		
		modeloServico = new DefaultListModel();
		listaServico = new JList(modeloServico);
		listaServico.addKeyListener(this);
		listaServico.addMouseListener(this);
		listaServico.setBounds(128, 53, 142, 26);
		inicializarListas(listaServico);
		panel_2.add(listaServico);
		
		modeloCliente = new DefaultListModel();
		listaCliente = new JList(modeloCliente);
		listaCliente.addKeyListener(this);
		listaCliente.addMouseListener(this);
		listaCliente.setBounds(txtCpfOrCnpj.getX(), txtCpfOrCnpj.getY() + txtCpfOrCnpj.getHeight(), txtCpfOrCnpj.getWidth(), 50);
		inicializarListas(listaCliente);
		panel_1.add(listaCliente);
		
		modeloReclamacao = new DefaultListModel();
		listaReclamacao = new JList(modeloReclamacao);
		listaReclamacao.addKeyListener(this);
		listaReclamacao.addMouseListener(this);
		listaReclamacao.setBounds(txtCodigo.getX(), txtCodigo.getY() + txtCodigo.getHeight(), txtCodigo.getWidth(), 50);
		inicializarListas(listaReclamacao);
		panel_3.add(listaReclamacao);
		
		lupaReclamacao = new JLabel("");
		lupaReclamacao.addMouseListener(this);
		lupaReclamacao.setIcon(new ImageIcon(TelaRegistrarReclamacao.class.getResource("/gui/imagens/lupaS.png")));
		lupaReclamacao.setBounds(280, 26, 30, 25);
		panel_3.add(lupaReclamacao);
		panel_1.setLayout(null);
		
		rdbtnPessoaJurdica = new JRadioButton("Pessoa Jur\u00EDdica");
		
		rdbtnPessoaJurdica.setOpaque(false);
		rdbtnPessoaJurdica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPessoaJurdica.setBounds(21, 30, 109, 23);
		panel_1.add(rdbtnPessoaJurdica);
		
		rdbtnPessoaFsica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFsica.setOpaque(false);
		rdbtnPessoaFsica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPessoaFsica.setBounds(132, 30, 109, 23);
		panel_1.add(rdbtnPessoaFsica);
		
		lblCpfCnpj = new JLabel("CNPJ:");
		lblCpfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfCnpj.setBounds(21, 74, 46, 14);
		panel_1.add(lblCpfCnpj);
		setLayout(groupLayout);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPessoaFsica);
		bg.add(rdbtnPessoaJurdica);
		
		lblNome = new JLabel("Raz\u00E3o Social:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(21, 112, 69, 14);
		panel_1.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(132, 110, 315, 20);
		txtNome.setEditable(false);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		lupaCliente = new JLabel("");
		lupaCliente.addMouseListener(this);
		lupaCliente.setIcon(new ImageIcon(TelaRegistrarReclamacao.class.getResource("/gui/imagens/lupaS.png")));
		lupaCliente.setBounds(293, 67, 30, 25);
		panel_1.add(lupaCliente);
		
		rdbtnPessoaJurdica.addActionListener(this);
		rdbtnPessoaFsica.addActionListener(this);
		rdbtnPessoaJurdica.doClick();
		
	}
	
	private void inicializarListas(JList lista){
		
		lista.setVisible(false);
		lista.setBackground(SystemColor.menu);
		lista.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setVisibleRowCount(3);
	}

	public void actionPerformed(ActionEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(rdbtnPessoaFsica)){
			lblCpfCnpj.setText("CPF:");
			limparCliente();
			listaServico.setVisible(false);
			lblNome.setText("Nome:");
		}
		else if(elemento.equals(rdbtnPessoaJurdica)){
			lblCpfCnpj.setText("CNPJ:");
			limparCliente();
			listaServico.setVisible(false);
			lblNome.setText("Razão Social:");
		}
		else if(elemento.equals(btnConfirmar)){
			if(camposPreenchidos()){
				Fachada fachada = Fachada.getInstancia();
				Falha f = new Falha();
				f.setAtivo(Constantes.ATIVO);
				f.setId_servico(servicoSelecionado.getId());
				f.setId_cliente(clienteSelecionado.getId_pessoa());
				f.setId_reclamacao(reclamacaoSelecionada.getId());
				f.setId_empresa(Sessao.getEmpresa().getId());
				try {
					fachada.cadastrarFalha(f);
					JOptionPane.showMessageDialog(null, "Problema registrado com sucesso.");
					limparCliente();
					limparServico();
					limparReclamacao();
				} catch (EntidadeJaExisteException e) {
					JOptionPane.showMessageDialog(null, "Este Cliente já realizou reclamação deste servico");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos");
			}
		}
	}
	
	public boolean camposPreenchidos(){
		if(!txtCpfOrCnpj.isEditable() && !txtServico.isEditable() && !txtCodigo.isEditable() && servicoSelecionado != null && clienteSelecionado != null && reclamacaoSelecionada != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void limparCliente(){
		clienteSelecionado = null;
		txtNome.setText("");
		txtCpfOrCnpj.setText("");
		txtCpfOrCnpj.setEditable(true);
		listaCliente.setVisible(false);
	}
	
	private void limparServico(){
		servicoSelecionado = null;
		txtServico.setText("");
		txtServico.setEditable(true);
		listaServico.setVisible(false);
	}
	
	private void limparReclamacao(){
		reclamacaoSelecionada = null;
		txtCodigo.setText("");
		txtCodigo.setEditable(true);
		listaReclamacao.setVisible(false);
	}

	public void mouseClicked(MouseEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(lupaCliente)){
			TelaBuscarCliente tbc = new TelaBuscarCliente(new javax.swing.JFrame(), true, this);
			tbc.setVisible(true);
		}
		else if(elemento.equals(lupaReclamacao)){
			//chamar a tela de buscar reclamacao
		}
		else if(elemento.equals(txtServico)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				limparServico();
			}
		}
		else if(elemento.equals(txtCpfOrCnpj)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				limparCliente();
			}
		}
		else if(elemento.equals(txtCodigo)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				limparReclamacao();
			}
		}
		else if(elemento.equals(this.listaCliente)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				acaoSelecionarCpfCnpj();
			}
		}
		else if(elemento.equals(this.listaServico)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				acaoSelecionarServico();
			}
		}
		else if(elemento.equals(this.listaReclamacao)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				acaoSelecionarReclamacao();
			}
		}
	}
	
	public void keyReleased(KeyEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(txtCpfOrCnpj)){
			if(evt.getKeyCode() == 40){
				listaCliente.grabFocus();
				listaCliente.setSelectedIndex(0);
			}
			else{
				txtNome.setText("");
				String texto = this.txtCpfOrCnpj.getText();
				if(!texto.equals("")){
					String tipo = "";
					if(this.rdbtnPessoaJurdica.isSelected()){
						tipo = Constantes.PJ;
					}
					else if(this.rdbtnPessoaFsica.isSelected()){
						tipo = Constantes.PF;
					}
					Cliente c = new Cliente();
					c.setCpfOrCnpj(texto);
					c.setTipo(tipo);
					c.setId_empresa(Sessao.getEmpresa().getId());
					buscaCpfOrCnpj(c);
				}
				else{
					this.listaCliente.setVisible(false);
				}
			}
		}
		else if(elemento.equals(txtCodigo)){
			if(evt.getKeyCode() == 40){
				listaReclamacao.grabFocus();
				listaReclamacao.setSelectedIndex(0);
			}
			else{
				String texto = txtCodigo.getText();
				if(!texto.equals("")){
					Reclamacao r = new Reclamacao();
					r.setCodigo(texto);
					r.setId_empresa(Sessao.getEmpresa().getId());
					buscaReclamacao(r);
				}
			}
		}
		else if(elemento.equals(txtServico)){
			if(evt.getKeyCode() == 40){
				listaServico.grabFocus();
				listaServico.setSelectedIndex(0);
			}
			else{
				String texto = this.txtServico.getText();
				if(!texto.equals("")){
					Servico s = new Servico();
					s.setNome(texto);
					s.setId_empresa(Sessao.getEmpresa().getId());
					buscaServico(s);
				}
				else{
					listaServico.setVisible(false);
				}
			}
		}
		else if(elemento.equals(listaCliente)){
			if(evt.getKeyCode() == 38 && listaCliente.isVisible() && listaCliente.getSelectedIndex() == 0){
				txtCpfOrCnpj.grabFocus();
			}
			else if(evt.getKeyCode() == 10){
				acaoSelecionarCpfCnpj();
				txtServico.grabFocus();
			}
		}
		else if(elemento.equals(listaServico)){
			if(evt.getKeyCode() == 38 && listaServico.isVisible() && listaServico.getSelectedIndex() == 0){
				txtServico.grabFocus();
			}
			else if(evt.getKeyCode() == 10){
				acaoSelecionarServico();
				txtCodigo.grabFocus();
			}
		}
		else if(elemento.equals(listaReclamacao)){
			if(evt.getKeyCode() == 38 && listaReclamacao.isVisible() && listaReclamacao.getSelectedIndex() == 0){
				txtCodigo.grabFocus();
			}
			else if(evt.getKeyCode() == 10){
				acaoSelecionarReclamacao();
			}
		}
	}
	
	private void acaoSelecionarCpfCnpj(){
		clienteSelecionado = clientes.get(listaCliente.getSelectedIndex());
		listaCliente.setVisible(false);
		txtCpfOrCnpj.setEditable(false);
		txtCpfOrCnpj.setText(clienteSelecionado.getCpfOrCnpj());
		txtNome.setText(clienteSelecionado.getNome());
	}

	private void acaoSelecionarServico(){
		servicoSelecionado = servicos.get(listaServico.getSelectedIndex());
		listaServico.setVisible(false);
		txtServico.setEditable(false);
		txtServico.setText(servicoSelecionado.getNome());
	}
	
	private void acaoSelecionarReclamacao(){
		reclamacaoSelecionada = reclamacoes.get(listaReclamacao.getSelectedIndex());
		listaReclamacao.setVisible(false);
		txtCodigo.setEditable(false);
		txtCodigo.setText(reclamacaoSelecionada.getCodigo());
	}
	
	protected void retornarResultadoCliente(Long id_cliente){
		Cliente c = new Cliente();
		c.setId_pessoa(id_cliente);
		Fachada fachada = Fachada.getInstancia();
		List<Cliente> lista = fachada.buscarCliente(c);
		clienteSelecionado = lista.get(0);
		if(clienteSelecionado.getTipo().equals(Constantes.PF)){
			rdbtnPessoaFsica.setSelected(true);
			rdbtnPessoaJurdica.setSelected(false);
			lblCpfCnpj.setText("CPF:");
			lblNome.setText("Nome:");
		}
		else if(clienteSelecionado.getTipo().equals(Constantes.PJ)){
			rdbtnPessoaFsica.setSelected(false);
			rdbtnPessoaJurdica.setSelected(true);
			lblCpfCnpj.setText("CNPJ:");
			lblNome.setText("Razão Social:");
		}
		txtCpfOrCnpj.setText(clienteSelecionado.getCpfOrCnpj());
		txtCpfOrCnpj.setEditable(false);
		txtNome.setText(clienteSelecionado.getNome());
	}
	
	private void buscaServico(Servico s){

		Fachada fachada = Fachada.getInstancia();
		servicos = fachada.buscaLikeServico(s);
		if(!servicos.isEmpty()){
			modeloServico.removeAllElements();
			for(int i = 0; i < servicos.size(); i++){
				modeloServico.add(i, servicos.get(i).getNome());
			}
			listaServico.setVisible(true);
		}
		else{
			listaServico.setVisible(false);
		}
	}
	
	private void buscaCpfOrCnpj(Cliente c){

		Fachada fachada = Fachada.getInstancia();
		clientes = fachada.buscaLikeCliente(c);
		if(!clientes.isEmpty()){
			modeloCliente.removeAllElements();
			for(int i = 0; i < clientes.size(); i++){
				modeloCliente.add(i, clientes.get(i).getCpfOrCnpj());
			}
			listaCliente.setVisible(true);
		}
		else{
			listaCliente.setVisible(false);
		}
	}
	
	private void buscaReclamacao(Reclamacao r){
		
		Fachada fachada = Fachada.getInstancia();
		reclamacoes = fachada.buscaLikeReclamacao(r);
		if(!reclamacoes.isEmpty()){
			modeloReclamacao.removeAllElements();
			for(int i = 0; i < reclamacoes.size(); i++){
				modeloReclamacao.add(i, reclamacoes.get(i).getCodigo());
			}
			listaReclamacao.setVisible(true);
		}
		else{
			listaReclamacao.setVisible(false);
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
