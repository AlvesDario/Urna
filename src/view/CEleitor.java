package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CEleitor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CEleitor frame = new CEleitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CEleitor() {
		setResizable(false);
		setTitle("Candidato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPessoa = new JLabel("Cadastro de Pessoa");
		lblPessoa.setBackground(Color.WHITE);
		lblPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPessoa.setBounds(0, 12, 446, 15);
		contentPane.add(lblPessoa);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(12, 163, 66, 15);
		contentPane.add(lblNumero);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 50, 49, 15);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 78, 37, 15);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(275, 78, 29, 15);
		contentPane.add(lblRg);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 109, 44, 15);
		contentPane.add(lblSexo);
		
		JLabel lblCadastroDeEleitor = new JLabel("Cadastro de Eleitor");
		lblCadastroDeEleitor.setBackground(Color.WHITE);
		lblCadastroDeEleitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeEleitor.setBounds(0, 136, 446, 15);
		contentPane.add(lblCadastroDeEleitor);
		
		JLabel lblZonaEleitoral = new JLabel("Zona Eleitoral:");
		lblZonaEleitoral.setBounds(12, 203, 99, 15);
		contentPane.add(lblZonaEleitoral);
		
		textField = new JTextField();
		textField.setBounds(60, 48, 374, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 77, 124, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(310, 76, 124, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(60, 104, 44, 24);
		contentPane.add(comboBox);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(320, 232, 114, 25);
		contentPane.add(btnCadastrar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 161, 124, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(116, 201, 124, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
