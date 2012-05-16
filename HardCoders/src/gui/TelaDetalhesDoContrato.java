package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import util.Sessao;
import entidades.Cliente;
import entidades.Servico;
import entidades.Solicitacao;
import exception.EntidadeJaExisteException;
import fachada.Fachada;

public class TelaDetalhesDoContrato extends javax.swing.JDialog implements ActionListener{
	private JTextField txtNomeCliente;
	private JTextField txtCpf;
	private JTextField txtNomeServico;
	private JTextField txtValor;
	private JComboBox comboBoxMeses;
	private JButton btnRenovar;
	private Cliente cliente;
	private Servico servico;
	private TelaContratosVencer telaContratosVencer;

    public TelaDetalhesDoContrato(java.awt.Frame parent, boolean modal, Cliente c, Servico s, TelaContratosVencer tela) {
    	super(parent, modal);
    	this.cliente = c;
    	this.servico = s;
    	this.telaContratosVencer = tela;
    	getContentPane().setBackground(Color.WHITE);
    	setTitle("Detalhes do Contrato .:.");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDetalhesDoContrato.class.getResource("/gui/imagens/icone.png")));
    	initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        setBounds(0, 0, 722, 426);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(70, 65, 107));
        
        JLabel lblDetalharContrato = new JLabel("Detalhar Contrato");
        lblDetalharContrato.setForeground(Color.WHITE);
        lblDetalharContrato.setFont(new Font("Tahoma", Font.PLAIN, 28));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblDetalharContrato)
        			.addContainerGap(406, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
        			.addContainerGap(29, Short.MAX_VALUE)
        			.addComponent(lblDetalharContrato, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel.setLayout(gl_panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setOpaque(false);
        panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o:");
        lblNomeDoServio.setBounds(22, 27, 102, 14);
        panel_3.add(lblNomeDoServio);
        
        txtNomeServico = new JTextField();
        txtNomeServico.setEditable(false);
        txtNomeServico.setColumns(10);
        txtNomeServico.setBounds(118, 24, 250, 20);
        panel_3.add(txtNomeServico);
        
        btnRenovar = new JButton("Renovar");
        btnRenovar.addActionListener(this);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        			.addGap(0))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(14))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        			.addGap(14))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnRenovar)
        			.addContainerGap(607, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnRenovar)
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        
        JLabel lblValor = new JLabel("Valor atual:");
        lblValor.setBounds(22, 62, 86, 14);
        panel_3.add(lblValor);
        
        txtValor = new JTextField();
        txtValor.setEditable(false);
        txtValor.setBounds(118, 59, 86, 20);
        panel_3.add(txtValor);
        txtValor.setColumns(10);
        
        JLabel lblRenovaoDeContrato = new JLabel("Renova\u00E7\u00E3o de Contrato");
        lblRenovaoDeContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblRenovaoDeContrato.setBounds(22, 106, 142, 14);
        panel_3.add(lblRenovaoDeContrato);
        
        JLabel lblPerodo = new JLabel("Per\u00EDodo:");
        lblPerodo.setBounds(22, 131, 46, 14);
        panel_3.add(lblPerodo);
        
        comboBoxMeses = new JComboBox();
        inicializarComboBox();
        comboBoxMeses.setBounds(78, 128, 46, 20);
        panel_3.add(comboBoxMeses);
        
        JLabel lblMeses = new JLabel("Meses");
        lblMeses.setBounds(134, 131, 46, 14);
        panel_3.add(lblMeses);
        panel_1.setLayout(null);
        
        JLabel lblNome = new JLabel("Nome do Cliente:");
        lblNome.setBounds(22, 27, 85, 14);
        panel_1.add(lblNome);
        
        txtNomeCliente = new JTextField();
        txtNomeCliente.setEditable(false);
        txtNomeCliente.setBounds(117, 24, 249, 20);
        panel_1.add(txtNomeCliente);
        txtNomeCliente.setColumns(10);
        
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(389, 27, 38, 14);
        panel_1.add(lblCpf);
        
        txtCpf = new JTextField();
        txtCpf.setEditable(false);
        txtCpf.setBounds(437, 24, 161, 20);
        panel_1.add(txtCpf);
        txtCpf.setColumns(10);
        getContentPane().setLayout(layout);
        
        carregarCliente();
        carregarServico();

    }
    
    private void carregarCliente(){
    	
    	if(this.cliente != null){
    		txtNomeCliente.setText(cliente.getNome());
    		txtCpf.setText(cliente.getCpfOrCnpj());
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Cliente não informado");
    		setVisible(false);
    	}
    }
    
    private void carregarServico(){
    	
    	if(this.servico != null){
    		txtNomeServico.setText(servico.getNome());
    		txtValor.setText(servico.getValor().toString());
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Serviço não informado");
    		setVisible(false);
    	}
    }
    
    private void inicializarComboBox(){
    	for(int i = 1; i <= 36; i++){
    		comboBoxMeses.addItem(i);
    	}
    }

	public void actionPerformed(ActionEvent evt) {
		
		JComponent elemento = (JComponent) evt.getSource();
		
		if(elemento.equals(btnRenovar)){
			if(servico != null && cliente != null){
				Solicitacao solicitacao = new Solicitacao();
				solicitacao.setId_cliente(cliente.getId());
				solicitacao.setId_empresa(Sessao.getEmpresa().getId());
				solicitacao.setId_servico(servico.getId());
				Fachada fachada = Fachada.getInstancia();
				List<Solicitacao> lista = fachada.buscarSolicitacao(solicitacao);
				if(!lista.isEmpty()){
					Solicitacao result = lista.get(0);
					
					result.setData_inicial(result.getData_final());
					
					Calendar calend = Calendar.getInstance();
					calend.setTime(result.getData_final());
					calend.set(Calendar.MONTH, calend.get(Calendar.MONTH) + (Integer)comboBoxMeses.getSelectedItem());
					result.setData_final(calend.getTime());
					
					try {
						fachada.atualizarSolicitacao(result);
						JOptionPane.showMessageDialog(null, "Contrato renovado com sucesso.");
						this.telaContratosVencer.retornar();
					} catch (EntidadeJaExisteException e) {
						JOptionPane.showMessageDialog(null, "Erro ao tentar renovar contrato.");
					}
				}
			}
		}
	}
}
