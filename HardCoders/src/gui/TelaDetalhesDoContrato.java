package gui;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;

public class TelaDetalhesDoContrato extends javax.swing.JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

    public TelaDetalhesDoContrato(java.awt.Frame parent, boolean modal) {
    	super(parent, modal);
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
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(118, 24, 250, 20);
        panel_3.add(textField_5);
        
        JButton btnRenovar = new JButton("Renovar");
        
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
        
        textField_6 = new JTextField();
        textField_6.setBounds(118, 59, 86, 20);
        panel_3.add(textField_6);
        textField_6.setColumns(10);
        
        JLabel lblRenovaoDeContrato = new JLabel("Renova\u00E7\u00E3o de Contrato");
        lblRenovaoDeContrato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblRenovaoDeContrato.setBounds(22, 96, 142, 14);
        panel_3.add(lblRenovaoDeContrato);
        
        JLabel lblValor_1 = new JLabel("Novo valor:");
        lblValor_1.setBounds(22, 131, 86, 14);
        panel_3.add(lblValor_1);
        
        textField_7 = new JTextField();
        textField_7.setBounds(118, 128, 86, 20);
        panel_3.add(textField_7);
        textField_7.setColumns(10);
        
        JLabel lblPerodo = new JLabel("Per\u00EDodo:");
        lblPerodo.setBounds(229, 131, 46, 14);
        panel_3.add(lblPerodo);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
        comboBox_1.setBounds(285, 128, 46, 20);
        panel_3.add(comboBox_1);
        
        JLabel lblMeses = new JLabel("Meses");
        lblMeses.setBounds(341, 131, 46, 14);
        panel_3.add(lblMeses);
        panel_1.setLayout(null);
        
        JLabel lblNome = new JLabel("Nome do Cliente:");
        lblNome.setBounds(22, 27, 85, 14);
        panel_1.add(lblNome);
        
        textField = new JTextField();
        textField.setBounds(117, 24, 249, 20);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(389, 27, 38, 14);
        panel_1.add(lblCpf);
        
        textField_1 = new JTextField();
        textField_1.setBounds(437, 24, 161, 20);
        panel_1.add(textField_1);
        textField_1.setColumns(10);
        getContentPane().setLayout(layout);

    }
}
