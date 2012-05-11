package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import util.Constantes;
import util.Sessao;
import entidades.Cliente;
import entidades.Servico;
import entidades.Solicitacao;
import exception.EntidadeJaExisteException;
import fachada.Fachada;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class TelaRealizarVenda extends JPanel implements ActionListener, KeyListener, MouseListener{

	private JTextField txtCpfOrCnpj;
	private JTextField txtNome;
	private JTextField txtServico;
	private JTextField txtValor;
	private JLabel lupaCliente;
	private final JLabel lblNome;
	private JRadioButton rdbtnCpf;
	private JRadioButton rdbtnCnpj;
	private JList listaCpfOrCnpj;
	private JList listaServico;
	private DefaultListModel modeloCpfOrCnpj;
	private DefaultListModel modeloServico;
	private List<Cliente> listaClientes;
	private List<Servico> servicos;
	private JButton btnConfirmar;
	private Servico servicoSelecionado = null;
	private Cliente clienteSelecionado = null;
	private JComboBox comboBoxMeses;

	public TelaRealizarVenda() {
		setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(78, 74, 110));

		JLabel lblRealizarVenda = new JLabel("Realizar Venda");
		lblRealizarVenda.setForeground(Color.WHITE);
		lblRealizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(579, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 196, 210));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(153, 180, 209), 1, true), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		modeloServico = new DefaultListModel();

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(null, "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		listaServico = new JList(this.modeloServico);
		listaServico.setBackground(SystemColor.menu);
		listaServico.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		listaServico.addMouseListener(this);
		listaServico.addKeyListener(this);
		listaServico.setVisible(false);
		listaServico.setVisibleRowCount(3);
		listaServico.setLayoutOrientation(JList.VERTICAL);
		listaServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaServico.setBounds(122, 41, 182, 41);
		panel_3.add(listaServico);

		modeloCpfOrCnpj = new DefaultListModel();

		txtServico = new JTextField();
		txtServico.addKeyListener(this);
		txtServico.addMouseListener(this);
		txtServico.setColumns(10);
		txtServico.setBounds(122, 20, 182, 20);
		panel_3.add(txtServico);

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setBounds(10, 23, 84, 14);
		panel_3.add(lblNomeDoServio);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(202, 51, 30, 31);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(null, "Contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(null);

		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		txtValor.setBounds(10, 48, 133, 20);
		panel_4.add(txtValor);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 23, 30, 14);
		panel_4.add(lblValor);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/LogotipoHard.png")));

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(544, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConfirmar)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))
					.addContainerGap(386, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConfirmar)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);

		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setBounds(153, 23, 40, 14);
		panel_4.add(lblPerodo);

		JLabel lblMeses = new JLabel("Meses");
		lblMeses.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMeses.setBounds(203, 51, 63, 14);
		panel_4.add(lblMeses);
		
		comboBoxMeses = new JComboBox();
		iniciarCombo(comboBoxMeses);
		comboBoxMeses.setBounds(153, 48, 40, 20);
		panel_4.add(comboBoxMeses);

		panel_2.setLayout(null);
		listaCpfOrCnpj = new JList(this.modeloCpfOrCnpj);
		listaCpfOrCnpj.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaCpfOrCnpj.setBackground(SystemColor.menu);
		listaCpfOrCnpj.addMouseListener(this);
		listaCpfOrCnpj.addKeyListener(this);
		listaCpfOrCnpj.setVisible(false);
		listaCpfOrCnpj.setVisibleRowCount(3);
		listaCpfOrCnpj.setLayoutOrientation(JList.VERTICAL);
		listaCpfOrCnpj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaCpfOrCnpj.setBounds(123, 53, 180, 44);
		panel_2.add(this.listaCpfOrCnpj);

		lblNome = new JLabel("Nome do Cliente:");
		lblNome.setBounds(20, 67, 93, 14);
		panel_2.add(lblNome);

		rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.setOpaque(false);
		rdbtnCpf.addActionListener(this);
		rdbtnCpf.setBounds(14, 32, 46, 23);
		panel_2.add(rdbtnCpf);

		rdbtnCnpj = new JRadioButton("CNPJ");
		rdbtnCnpj.setOpaque(false);
		rdbtnCnpj.addActionListener(this);
		rdbtnCnpj.setBounds(62, 32, 51, 23);
		panel_2.add(rdbtnCnpj);

		txtCpfOrCnpj = new JTextField();
		txtCpfOrCnpj.addKeyListener(this);
		txtCpfOrCnpj.addMouseListener(this);
		txtCpfOrCnpj.setBounds(121, 33, 182, 20);
		panel_2.add(txtCpfOrCnpj);
		txtCpfOrCnpj.setColumns(10);
		setLayout(groupLayout);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCnpj);
		bg.add(rdbtnCpf);

		txtNome = new JTextField();
		txtNome.setOpaque(false);
		txtNome.setEditable(false);
		txtNome.setBounds(121, 64, 301, 20);
		panel_2.add(txtNome);
		txtNome.setColumns(10);

		lupaCliente = new JLabel("");
		lupaCliente.addMouseListener(this);
		lupaCliente.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/lupaS.png")));
		lupaCliente.setBounds(312, 24, 30, 31);
		panel_2.add(lupaCliente);

		rdbtnCpf.setSelected(true);
	}

	public void actionPerformed(ActionEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();

		if(elemento.equals(rdbtnCnpj)){
			limparCliente();
			listaServico.setVisible(false);
			lblNome.setText("Razão Social:");
		}
		else if(elemento.equals(rdbtnCpf)){
			limparCliente();
			listaServico.setVisible(false);
			lblNome.setText("Nome do Cliente:");
		}
		else if(elemento.equals(btnConfirmar)){
			if(camposPreenchidos()){
				Fachada fachada = Fachada.getInstancia();
				Solicitacao s = new Solicitacao();
				s.setAtivo(Constantes.ATIVO);
				s.setId_servico(servicoSelecionado.getId());
				s.setId_cliente(clienteSelecionado.getId_pessoa());
				s.setId_empresa(Sessao.getEmpresa().getId());
				Calendar calend = Calendar.getInstance();
				s.setData_inicial(calend.getTime());
				calend.set(Calendar.MONTH, calend.get(Calendar.MONTH) + (Integer)comboBoxMeses.getSelectedItem());
				s.setData_final(calend.getTime());
				try {
					fachada.cadastrarSolicitacao(s);
					JOptionPane.showMessageDialog(null, "Venda realizada com sucesso.");
					limparCliente();
					limparServico();
				} catch (EntidadeJaExisteException e) {
					JOptionPane.showMessageDialog(null, "Este Cliente já possui solicitação deste servico");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos");
			}
		}
	}
	
	private void limparCliente(){
		clienteSelecionado = null;
		txtNome.setText("");
		txtCpfOrCnpj.setText("");
		txtCpfOrCnpj.setEditable(true);
		listaCpfOrCnpj.setVisible(false);
	}
	
	private void limparServico(){
		servicoSelecionado = null;
		txtServico.setText("");
		txtValor.setText("");
		txtServico.setEditable(true);
		listaServico.setVisible(false);
	}

	public boolean camposPreenchidos(){
		if(!txtCpfOrCnpj.isEditable() && !txtServico.isEditable() && servicoSelecionado != null && clienteSelecionado != null){
			return true;
		}
		else{
			return false;
		}
	}

	public void keyReleased(KeyEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(this.txtCpfOrCnpj)){
			if(evt.getKeyCode() == 40){
				listaCpfOrCnpj.grabFocus();
				listaCpfOrCnpj.setSelectedIndex(0);
			}
			else{
				txtNome.setText("");
				String texto = this.txtCpfOrCnpj.getText();
				if(!texto.equals("")){
					String tipo = "";
					if(this.rdbtnCnpj.isSelected()){
						tipo = Constantes.PJ;
					}
					else if(this.rdbtnCpf.isSelected()){
						tipo = Constantes.PF;
					}
					Cliente c = new Cliente();
					c.setCpfOrCnpj(texto);
					c.setTipo(tipo);
					c.setId_empresa(Sessao.getEmpresa().getId());
					buscaCpfOrCnpj(c);
				}
				else{
					this.listaCpfOrCnpj.setVisible(false);
				}
			}
		}
		else if(elemento.equals(this.txtServico)){
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
		else if(elemento.equals(listaCpfOrCnpj)){
			if(evt.getKeyCode() == 38 && listaCpfOrCnpj.isVisible() && listaCpfOrCnpj.getSelectedIndex() == 0){
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
			}
		}
	}

	private void acaoSelecionarCpfCnpj(){
		clienteSelecionado = listaClientes.get(listaCpfOrCnpj.getSelectedIndex());
		listaCpfOrCnpj.setVisible(false);
		txtCpfOrCnpj.setEditable(false);
		txtCpfOrCnpj.setText(clienteSelecionado.getCpfOrCnpj());
		txtNome.setText(clienteSelecionado.getNome());
	}

	private void acaoSelecionarServico(){
		servicoSelecionado = servicos.get(listaServico.getSelectedIndex());
		listaServico.setVisible(false);
		txtServico.setEditable(false);
		txtServico.setText(servicoSelecionado.getNome());
		txtValor.setText(servicoSelecionado.getValor().toString());
	}

	public void mouseClicked(MouseEvent evt) {

		JComponent elemento = (JComponent) evt.getSource();
		if(elemento.equals(this.lupaCliente)){
			TelaBuscarCliente tbc = new TelaBuscarCliente(new javax.swing.JFrame(), true, this);
			tbc.setVisible(true);
		}
		else if(elemento.equals(this.listaCpfOrCnpj)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				acaoSelecionarCpfCnpj();
			}
		}
		else if(elemento.equals(this.listaServico)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				acaoSelecionarServico();
			}
		}
		else if(elemento.equals(this.txtCpfOrCnpj)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				limparCliente();
			}
		}
		else if(elemento.equals(this.txtServico)){
			if(evt.getClickCount() == Constantes.QUANT_CLICKS){
				limparServico();
			}
		}
	}
	
	protected void retornarResultadoCliente(Long id_cliente){
		Cliente c = new Cliente();
		c.setId_pessoa(id_cliente);
		Fachada fachada = Fachada.getInstancia();
		List<Cliente> lista = fachada.buscarCliente(c);
		clienteSelecionado = lista.get(0);
		if(clienteSelecionado.getTipo().equals(Constantes.PF)){
			rdbtnCpf.setSelected(true);
			rdbtnCnpj.setSelected(false);
			lblNome.setText("Nome do Cliente:");
		}
		else if(clienteSelecionado.getTipo().equals(Constantes.PJ)){
			rdbtnCpf.setSelected(false);
			rdbtnCnpj.setSelected(true);
			lblNome.setText("Razão Social:");
		}
		txtCpfOrCnpj.setText(clienteSelecionado.getCpfOrCnpj());
		txtCpfOrCnpj.setEditable(false);
		txtNome.setText(clienteSelecionado.getNome());
	}

	private void buscaCpfOrCnpj(Cliente c){

		Fachada fachada = Fachada.getInstancia();
		listaClientes = fachada.buscaLikeCliente(c);
		if(!listaClientes.isEmpty()){
			modeloCpfOrCnpj.removeAllElements();
			for(int i = 0; i < listaClientes.size(); i++){
				modeloCpfOrCnpj.add(i, listaClientes.get(i).getCpfOrCnpj());
			}
			listaCpfOrCnpj.setVisible(true);
		}
		else{
			listaCpfOrCnpj.setVisible(false);
		}
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
	
	private void iniciarCombo(JComboBox combo){
		for(int i = 1; i <= 36; i++){
			combo.addItem(i);
		}
	}

	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
