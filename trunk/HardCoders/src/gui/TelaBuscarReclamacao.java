package gui;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Constantes;
import util.Sessao;
import entidades.Reclamacao;
import fachada.Fachada;

public class TelaBuscarReclamacao extends JDialog implements ActionListener, MouseListener, KeyListener{


	private static final long serialVersionUID = 1L;
	private JPanel tela;
	private JFormattedTextField txtBusca;
	private JTable table;
	private JComboBox comboBoxBusca;
	private JButton btnConfirmar;
	private TelaRegistrarReclamacao telaRegistrarReclamacao;
	
		public TelaBuscarReclamacao(java.awt.Frame parent, boolean modal, TelaRegistrarReclamacao telaRegistrarReclamacao) {
	
			super(parent, modal);
			getContentPane().setBackground(Color.WHITE);
			
			this.telaRegistrarReclamacao = telaRegistrarReclamacao;
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(78, 74, 110));
			
			JLabel label = new JLabel("");
			
			JLabel lblLocalizarTipoDe = new JLabel("Localizar Tipo de Reclama\u00E7\u00E3o");
			lblLocalizarTipoDe.setForeground(Color.WHITE);
			lblLocalizarTipoDe.setFont(new Font("Tahoma", Font.PLAIN, 28));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(705)
								.addComponent(label))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblLocalizarTipoDe, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(16, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(11)
						.addComponent(label)
						.addGap(19)
						.addComponent(lblLocalizarTipoDe)
						.addContainerGap())
			);
			panel.setLayout(gl_panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.setBorder(new TitledBorder(null, "Filtrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setLayout(null);
			
			comboBoxBusca = new JComboBox();
			iniciarComboBox(comboBoxBusca);
			comboBoxBusca.addActionListener(this);
			comboBoxBusca.setBounds(21, 35, 76, 20);
			panel_1.add(comboBoxBusca);
			
			MaskFormatter mascaraBusca = criarMascara("****************************************************************************************************");
			mascaraBusca.setInvalidCharacters("!@#$%¨&*()\"'+=-_[]{}|?><");
			mascaraBusca.setPlaceholder("");
			txtBusca = new JFormattedTextField(mascaraBusca);
			txtBusca.setFocusLostBehavior(JFormattedTextField.PERSIST);
			txtBusca.addMouseListener(this);
			txtBusca.addKeyListener(this);
			txtBusca.setBounds(107, 35, 341, 20);
			panel_1.add(txtBusca);
			txtBusca.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object [][] {}, new String [] {"Código", "Tipo"}
					) {
				Class[] types = new Class [] {Reclamacao.class, java.lang.String.class};
				boolean[] canEdit = new boolean [] {false, false};

				public Class getColumnClass(int columnIndex) {
					return types [columnIndex];
				}

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit [columnIndex];
				}
			});
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			scrollPane.setViewportView(table);
			
			this.montaTabela(new Reclamacao());
			
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(this);
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(398)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(btnConfirmar))
			);
			getContentPane().setLayout(groupLayout);
			this.tela = tela;
			setIconImage(Toolkit.getDefaultToolkit().getImage(TelaBuscarCliente.class.getResource("/gui/imagens/icone.png")));
			setTitle("Localizar Tipo de Reclama\u00E7\u00E3o .:.");
		    IniciarJDialog();
		}
		
		public void IniciarJDialog(){
		
		
			setBounds(100, 100, 729, 457);
		}
		
		private void montaTabela(Reclamacao r) {

			Fachada fachada = Fachada.getInstancia();
			r.setId_empresa(Sessao.getEmpresa().getId());
			List<Reclamacao> listaReclamacao = fachada.buscaLikeReclamacao(r);
			String colunas[] = { "Código", "Tipo"};
			Object linhas[][] = new Object[listaReclamacao.size()][colunas.length];

			if (listaReclamacao.isEmpty()) {
				table.setModel(new DefaultTableModel(null, colunas));
			} else {
				for (int i = 0; i < listaReclamacao.size(); i++) {

					linhas[i][0] = listaReclamacao.get(i);
					linhas[i][1] = listaReclamacao.get(i).getNome();
				}
			}

			table.setModel(new DefaultTableModel(linhas, colunas) {
				Class[] types = new Class[] { Reclamacao.class, java.lang.String.class};
				boolean[] canEdit = new boolean[] { false, false};

				public Class getColumnClass(int columnIndex) {
					return types[columnIndex];
				}

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit[columnIndex];
				}
			});
		}
		
		private void iniciarComboBox(JComboBox combo){
			if(combo.equals(comboBoxBusca)){
				String [] rotulos = Constantes.getBuscaReclamacao();
				for(String rotulo : rotulos){
					comboBoxBusca.addItem(rotulo);
				}
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
		
		public void keyReleased(KeyEvent evt){
			if(evt.getKeyCode() != 10){
				buscar();
			}
		}
		
		private void buscar(){

			if(this.comboBoxBusca.getSelectedItem().equals(Constantes.CODIGO)){
				Reclamacao r = new Reclamacao();
				r.setCodigo(txtBusca.getText().trim());
				this.montaTabela(r);
			}
			else if(this.comboBoxBusca.getSelectedItem().equals(Constantes.TIPO)){
				Reclamacao r = new Reclamacao();
				r.setNome(txtBusca.getText().trim());
				this.montaTabela(r);
			}
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
					Reclamacao r = ((Reclamacao)table.getModel().getValueAt(linha, 0));
					telaRegistrarReclamacao.retornarResultadoReclamacao(r);
					this.setVisible(false);
				}
			}
		}

		public void keyPressed(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
}		
