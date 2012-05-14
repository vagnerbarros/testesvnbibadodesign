package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;

import util.Sessao;
import entidades.Empresa;
import entidades.Funcionario;
import fachada.Fachada;

public class TelaLogin extends JDialog implements ActionListener, KeyListener, MouseListener{
	
	private JFormattedTextField login_txt;
	private JPasswordField senha_txt;
	private List<Empresa> listaEmpresas;
	private JComboBox comboEmpresa;

	public TelaLogin() {

		this.listaEmpresas = Fachada.getInstancia().listarEmpresas(new Empresa());

		getContentPane().setBackground(Color.WHITE);

		setTitle("Sistelecom - Hardcoders 2012");

		getContentPane().setLayout(null);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-475)/2, (screenSize.height-340)/2, 475, 340);

		setResizable(false);

		{
			JButton okButton = new JButton("OK");
			okButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
			okButton.addActionListener(this);

						okButton.setBounds(263, 212, 66, 28);
						getContentPane().add(okButton);
						okButton.setActionCommand("OK");
						getRootPane().setDefaultButton(okButton);
		}

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblLogin.setBounds(117, 103, 34, 16);
		getContentPane().add(lblLogin);

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(70, 65, 107));
		panelSuperior.setBounds(0, 0, 469, 71);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);

		JLabel lblFormulrioDeLogin = new JLabel("Formul\u00E1rio de Login");
		lblFormulrioDeLogin.setFont(new Font("SansSerif", Font.PLAIN, 26));
		lblFormulrioDeLogin.setForeground(Color.WHITE);
		lblFormulrioDeLogin.setBounds(119, 19, 250, 34);
		panelSuperior.add(lblFormulrioDeLogin);
		{
			JPanel panelInferior = new JPanel();
			panelInferior.setBounds(0, 272, 469, 40);
			panelInferior.setBackground(new Color(167, 196, 210));
			getContentPane().add(panelInferior);
		}
		{
			JLabel lblSenha = new JLabel("Empresa:");
			lblSenha.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			lblSenha.setBounds(101, 181, 50, 16);
			getContentPane().add(lblSenha);
		}

		MaskFormatter mascaraLogin = criarMascara("********************");
		mascaraLogin.setPlaceholder("");
		mascaraLogin.setInvalidCharacters(" !@#$%¨&*()\"'+=-_[]{}|?");
		login_txt = new JFormattedTextField(mascaraLogin);
		login_txt.setFocusLostBehavior(JFormattedTextField.PERSIST);
		login_txt.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		login_txt.addActionListener(this);
		login_txt.addKeyListener(this);
		login_txt.addMouseListener(this);
		login_txt.setBounds(163, 97, 166, 28);
		getContentPane().add(login_txt);
		login_txt.setColumns(10);

		senha_txt = new JPasswordField();
		senha_txt.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		senha_txt.addKeyListener(this);
		senha_txt.setBounds(164, 136, 165, 28);
		getContentPane().add(senha_txt);

		JLabel label = new JLabel("Senha:");
		label.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		label.setBounds(115, 142, 36, 16);
		getContentPane().add(label);

		comboEmpresa = new JComboBox();
		comboEmpresa.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		comboEmpresa.setBounds(165, 177, 164, 24);
		carregarCombo(comboEmpresa);
		getContentPane().add(comboEmpresa);

	}

	public void carregarCombo(JComboBox combo){

		for(Empresa e : listaEmpresas){
			combo.addItem(e);
		}
	}

	public boolean ehPasswordCorreto(Funcionario f){

		boolean ehCorreto = true;
		char [] pw = f.getSenha().toCharArray();
		char [] input = senha_txt.getPassword();  

		if (input.length != pw.length) {
			ehCorreto = false;
		} else {
			ehCorreto = Arrays.equals (input, pw);
		}

		Arrays.fill(input,'0');

		return ehCorreto;
	}

	public void actionPerformed(ActionEvent evt) {
	
		String txtLogin = login_txt.getText();
		char [] txtSenha = senha_txt.getPassword();

		if(!txtLogin.equals("") && !(txtSenha.length == 0)){
			Fachada f = Fachada.getInstancia();
			Funcionario func = new Funcionario();
			func.setLogin(login_txt.getText());

			Empresa emp = (Empresa) comboEmpresa.getSelectedItem();
			func.setId_empresa(emp.getId());
			List<Funcionario> list = f.buscarFuncionario(func);

			if(!list.isEmpty()){
				if(!ehPasswordCorreto(list.get(0))){
					JOptionPane.showMessageDialog(null, "Login e Senha não conferem.");
				}
				else{
					dispose();
					Sessao.setFuncionario(list.get(0));
					Sessao.setEmpresa(emp);
					TelaPrincipal telaPrincipal = new TelaPrincipal();
					telaPrincipal.setVisible(true);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Login inexistente na empresa selecionada.");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Preencha os campos Login e Senha");
		}
	}

	public void keyPressed(KeyEvent evt) {
		
		int tecla = evt.getKeyCode();
		if(tecla == 10){
			senha_txt.grabFocus();
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

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}