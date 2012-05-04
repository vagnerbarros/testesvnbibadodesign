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
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
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
	private JSpinner spinner;
	private Servico servicoSelecionado = null;
	private Cliente clienteSelecionado = null;

	public TelaRealizarVenda() {
		setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(78, 74, 110));

		JLabel lblRealizarVenda = new JLabel("Realizar Venda");
		lblRealizarVenda.setForeground(Color.WHITE);
		lblRealizarVenda.setFont(new Font("Tahoma", Font.PLAIN, 28));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/logoSup.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2)
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel_2))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(43)
												.addComponent(lblRealizarVenda, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 196, 210));

		JPanel panel_2 = new JPanel();

		modeloServico = new DefaultListModel();

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		listaServico = new JList(this.modeloServico);
		listaServico.addMouseListener(this);
		listaServico.addKeyListener(this);
		listaServico.setVisible(false);
		listaServico.setVisibleRowCount(3);
		listaServico.setLayoutOrientation(JList.VERTICAL);
		listaServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaServico.setBounds(122, 54, 182, 47);
		panel_3.add(listaServico);

		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServio.setBounds(10, 11, 46, 14);
		panel_3.add(lblServio);

		modeloCpfOrCnpj = new DefaultListModel();

		txtServico = new JTextField();
		txtServico.addKeyListener(this);
		txtServico.addMouseListener(this);
		txtServico.setColumns(10);
		txtServico.setBounds(122, 34, 182, 20);
		panel_3.add(txtServico);

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
		lblNomeDoServio.setBounds(10, 37, 84, 14);
		panel_3.add(lblNomeDoServio);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(202, 51, 30, 31);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);

		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrato.setBounds(10, 11, 84, 14);
		panel_4.add(lblContrato);

		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		txtValor.setBounds(10, 61, 109, 20);
		panel_4.add(txtValor);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 36, 30, 14);
		panel_4.add(lblValor);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(314, 23, 30, 31);
		panel_4.add(label_5);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRealizarVenda.class.getResource("/gui/imagens/LogotipoHard.png")));

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
										.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
										.addComponent(btnConfirmar)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConfirmar)
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);

		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setBounds(202, 36, 40, 14);
		panel_4.add(lblPerodo);

		JLabel lblMeses = new JLabel("Meses");
		lblMeses.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMeses.setBounds(252, 64, 63, 14);
		panel_4.add(lblMeses);

		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 72, 1);
		spinner = new JSpinner(model);
		JSpinner.DefaultEditor editor = ((DefaultEditor) spinner.getEditor());
		editor.getTextField().setEditable(false);
		editor.getTextField().setEnabled(true);
		spinner.setBounds(202, 61, 40, 20);
		panel_4.add(spinner);
		panel_2.setLayout(null);
		listaCpfOrCnpj = new JList(this.modeloCpfOrCnpj);
		listaCpfOrCnpj.addMouseListener(this);
		listaCpfOrCnpj.addKeyListener(this);
		listaCpfOrCnpj.setVisible(false);
		listaCpfOrCnpj.setVisibleRowCount(3);
		listaCpfOrCnpj.setLayoutOrientation(JList.VERTICAL);
		listaCpfOrCnpj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaCpfOrCnpj.setBounds(123, 53, 180, 44);
		panel_2.add(this.listaCpfOrCnpj);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(14, 11, 46, 14);
		panel_2.add(lblCliente);

		lblNome = new JLabel("Nome do Cliente:");
		lblNome.setBounds(20, 67, 93, 14);
		panel_2.add(lblNome);

		rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.addActionListener(this);
		rdbtnCpf.setBounds(14, 32, 46, 23);
		panel_2.add(rdbtnCpf);

		rdbtnCnpj = new JRadioButton("CNPJ");
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
				Calendar calend = Calendar.getInstance();
				s.setData_inicial(calend.getTime());
				calend.set(Calendar.MONTH, calend.get(Calendar.MONTH) + (Integer)spinner.getModel().getValue());
				s.setData_final(calend.getTime());
				try {
					fachada.cadastrarSolicitacao(s);
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
			TelaBuscarCliente tbc = new TelaBuscarCliente(new javax.swing.JFrame(), true);
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

	public void keyPressed(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
