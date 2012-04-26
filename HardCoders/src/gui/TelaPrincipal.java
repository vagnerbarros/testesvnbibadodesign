package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Chamar o estilo do Frame INICIO
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("Windows".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					// Chamar o estilo do Frame FIM

					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/gui/imagens/icone.png")));

		final ControladorGui controladorGui = new ControladorGui(getContentPane());

		controladorGui.abrirTelaCadCliente();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setExtendedState(MAXIMIZED_BOTH);

		setTitle("Gerenciamento de Servi\u00E7os em Telecomunica\u00E7\u00F5es - Hardcoders \u00A9 FAFICA 2012");

		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(new BorderLayout(0, 0));

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);

		final JPanel pnlFundo = new JPanel();

		pnlFundo.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 65, 107));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 100, Short.MAX_VALUE)
				);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(167, 196, 210));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/LogotipoHard.png")));
		GroupLayout gl_pnlFundo = new GroupLayout(pnlFundo);
		gl_pnlFundo.setHorizontalGroup(
				gl_pnlFundo.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_pnlFundo.createSequentialGroup()
						.addContainerGap(449, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_pnlFundo.setVerticalGroup(
				gl_pnlFundo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFundo.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				);
		pnlFundo.setLayout(gl_pnlFundo);
		getContentPane().add(pnlFundo);

		JMenuBar BarraMenu = new JMenuBar();
		setJMenuBar(BarraMenu);

		JMenu MenuCadastro = new JMenu("Cadastro");
		MenuCadastro.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		BarraMenu.add(MenuCadastro);

		JMenuItem menuCadClientes = new JMenuItem("    Clientes   ");
		menuCadClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorGui.abrirTelaCadCliente();
			}
		});


		menuCadClientes.setBackground(Color.WHITE);
		menuCadClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/clienteIco.png")));
		menuCadClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
		menuCadClientes.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		MenuCadastro.add(menuCadClientes);

		JMenuItem menuCadFuncionarios = new JMenuItem("    Funcion\u00E1rios   ");
		menuCadFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorGui.abrirTelaCadFuncionarios();
			}
		});
		menuCadFuncionarios.setBackground(Color.WHITE);
		menuCadFuncionarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/FuncionariosIco.png")));
		menuCadFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
		menuCadFuncionarios.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		MenuCadastro.add(menuCadFuncionarios);

		JSeparator separator = new JSeparator();
		MenuCadastro.add(separator);

		JMenuItem menuCadServicos = new JMenuItem("    Servi\u00E7os   ");
		menuCadServicos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/servicosIco.png")));
		menuCadServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorGui.abrirTelaCadServicos();
			}
		});
		menuCadServicos.setBackground(Color.WHITE);
		menuCadServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		menuCadServicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
		MenuCadastro.add(menuCadServicos);

		JMenuItem menuCadEmpresas = new JMenuItem("    Empresas   ");
		menuCadEmpresas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/empresasIco.png")));
		menuCadEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorGui.abrirTelaCadEmpresas();
			}
		});
		menuCadEmpresas.setBackground(Color.WHITE);
		menuCadEmpresas.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		menuCadEmpresas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
		MenuCadastro.add(menuCadEmpresas);

		JSeparator separator_1 = new JSeparator();
		MenuCadastro.add(separator_1);

		JMenuItem menuCadReclamacoes = new JMenuItem("    Reclama\u00E7\u00F5es   ");
		menuCadReclamacoes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/reclamacaoIco.png")));
		menuCadReclamacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorGui.abrirTelaCadReclam();
			}
		});
		menuCadReclamacoes.setBackground(Color.WHITE);
		menuCadReclamacoes.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		menuCadReclamacoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
		MenuCadastro.add(menuCadReclamacoes);

		JMenu mnContratos = new JMenu("Contratos");
		mnContratos.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		BarraMenu.add(mnContratos);

		JMenuItem mntmContratosVencer = new JMenuItem("       Contratos \u00E0 Vencer   ");
		mntmContratosVencer.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/contratoIco.png")));
		mntmContratosVencer.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		mnContratos.add(mntmContratosVencer);

		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		BarraMenu.add(mnVendas);

		JMenuItem mntmRealizarVenda = new JMenuItem("       Realizar Venda   ");
		mntmRealizarVenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/dinheiroIco.png")));
		mntmRealizarVenda.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		mnVendas.add(mntmRealizarVenda);

		JMenu mnReclamaes = new JMenu("Reclama\u00E7\u00F5es");
		mnReclamaes.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		BarraMenu.add(mnReclamaes);

		JMenuItem mntmRegistrarReclamao = new JMenuItem("       Registrar Reclama\u00E7\u00E3o   ");
		mntmRegistrarReclamao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/gui/imagens/reclamacaoIco.png")));
		mntmRegistrarReclamao.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		mnReclamaes.add(mntmRegistrarReclamao);
	}
}
