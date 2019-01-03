package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Urna extends JPanel {

	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txtat;
	private JButton bt01;
	private JButton bt02;
	private JButton bt03;
	private JButton bt04;
	private JButton bt05;
	private JButton bt06;
	private JButton bt07;
	private JButton bt08;
	private JButton bt09;
	private JButton bt00;
	private JButton btBra;
	private JButton btCon;
	private JButton btCor;

	private int estagioVoto = 1;
	private int digito = 1;
	private boolean branco = false;

	public void limpar() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
	}

	public boolean limpo() {
		if (	(txt1.getText() != null && txt1.getText() != "") || 
				(txt2.getText() != null && txt2.getText() != "") || 
				(txt3.getText() != null && txt3.getText() != "") || 
				(txt4.getText() != null && txt4.getText() != "") || 
				(txt5.getText() != null && txt5.getText() != "")) {
			return false;
		} else
			return true;
	}

	private void proxE() {
		if (this.estagioVoto < 6)
			this.estagioVoto++;
		uptxt();
	}

	private void proxD() {
		if (this.digito < 5)
			this.digito++;
		uptxt();
	}

	private void uptxt() {
		switch (digito) {
		case 1:
			txtat = txt1;
			break;
		case 2:
			txtat = txt2;
			break;
		case 3:
			txtat = txt3;
			break;
		case 4:
			txtat = txt4;
			break;
		case 5:
			txtat = txt5;
			break;
		}
	}

	private void setD(int i) {
		if (i > 0 && i < 6)
			this.digito = i;
		uptxt();
	}

	private String rodape() {
		return "___________________________________________________________________________________________________________\n"
				+ "Aperte a tecla:\n   Confirmar para CONFIRMAR este voto\n      Corrigir para CORRIGIR este voto";
	}

	public void digita(String args0) {
		uptxt();
		if (txtat.getText() != null || txtat.getText() != "")
			txtat.setText(args0);
		proxD();
	}

	public String estagioVoto() {
		String estagio = "";
		switch (this.estagioVoto) {
		case 1:
			estagio = "Deputado Federal";
			break;
		case 2:
			estagio = "Deputado Estadual";
			break;
		case 3:
			estagio = "Senador - 1 vaga";
			break;
		case 4:
			estagio = "Senador - 2 vaga";
			break;
		case 5:
			estagio = "Governador";
			break;
		case 6:
			estagio = "Presidente";
			break;
		}
		return estagio;
	}

	public Urna() {
		setMinimumSize(new Dimension(1048, 507));
		setMaximumSize(new Dimension(1048, 507));
		setBackground(SystemColor.info);
		setForeground(Color.WHITE);
		txt3 = new JTextField(5);
		txt3.setEditable(false);
		bt01 = new JButton("1");
		bt01.setForeground(Color.WHITE);
		bt01.setBackground(Color.BLACK);
		bt02 = new JButton("2");
		bt02.setBackground(Color.BLACK);
		bt02.setForeground(Color.WHITE);
		bt03 = new JButton("3");
		bt03.setForeground(Color.WHITE);
		bt03.setBackground(Color.BLACK);
		bt04 = new JButton("4");
		bt04.setForeground(Color.WHITE);
		bt04.setBackground(Color.BLACK);
		bt05 = new JButton("5");
		bt05.setForeground(Color.WHITE);
		bt05.setBackground(Color.BLACK);
		bt06 = new JButton("6");
		bt06.setForeground(Color.WHITE);
		bt06.setBackground(Color.BLACK);
		bt07 = new JButton("7");
		bt07.setForeground(Color.WHITE);
		bt07.setBackground(Color.BLACK);
		bt08 = new JButton("8");
		bt08.setForeground(Color.WHITE);
		bt08.setBackground(Color.BLACK);
		bt09 = new JButton("9");
		bt09.setForeground(Color.WHITE);
		bt09.setBackground(Color.BLACK);
		bt00 = new JButton("0");
		bt00.setForeground(Color.WHITE);
		bt00.setBackground(Color.BLACK);
		btBra = new JButton("Branco");
		btBra.setBackground(Color.WHITE);
		btBra.setIcon(null);
		btCon = new JButton("Confirmar");
		btCon.setBackground(Color.GREEN);
		btCor = new JButton("Corrigir");
		btCor.setBackground(Color.RED);
//        txt1.setEnabled(false);
//        txt2.setEnabled(false);
//        txt3.setEnabled(false);
//        txt4.setEnabled(false);
//        txt5.setEnabled(false);

		// adjust size and set layout
		setPreferredSize(new Dimension(1048, 507));
		setLayout(null);
		add(txt3);
		add(bt01);
		add(bt02);
		add(bt03);
		add(bt04);
		add(bt05);
		add(bt06);
		add(bt07);
		add(bt08);
		add(bt09);
		add(bt00);
		add(btBra);
		add(btCon);
		add(btCor);
		txt3.setBounds(185, 200, 25, 35);
		bt01.setBounds(695, 75, 105, 70);
		bt02.setBounds(810, 75, 105, 70);
		bt03.setBounds(925, 75, 105, 70);
		bt04.setBounds(695, 155, 105, 70);
		bt05.setBounds(810, 155, 105, 70);
		bt06.setBounds(925, 155, 105, 70);
		bt07.setBounds(695, 235, 105, 70);
		bt08.setBounds(810, 235, 105, 70);
		bt09.setBounds(925, 235, 105, 70);
		bt00.setBounds(810, 315, 105, 70);
		btBra.setBounds(695, 425, 105, 50);
		btCon.setBounds(925, 425, 105, 50);
		btCor.setBounds(810, 425, 105, 50);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 44, 644, 431);
		add(panel);
				panel.setLayout(null);
		
				// construct components
				txt1 = new JTextField(5);
				txt1.setEditable(false);
				txt1.setBounds(103, 156, 25, 35);
				panel.add(txt1);
				txt2 = new JTextField(5);
				txt2.setEditable(false);
				txt2.setBounds(130, 156, 25, 35);
				panel.add(txt2);
				
				JLabel lblDeputadoFederal = new JLabel("DEPUTADO FEDERAL");
				lblDeputadoFederal.setBounds(210, 114, 243, 15);
				panel.add(lblDeputadoFederal);
				txt5 = new JTextField(5);
				txt5.setEditable(false);
				txt5.setBounds(210, 156, 25, 35);
				panel.add(txt5);
				txt4 = new JTextField(5);
				txt4.setEditable(false);
				txt4.setBounds(184, 156, 25, 35);
				panel.add(txt4);
				
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 1048, 21);
				add(menuBar);
        uptxt();

		bt01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt01.getText());
			}
		});
		bt02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt02.getText());
			}
		});
		bt03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt03.getText());
			}
		});
		bt04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt04.getText());
			}
		});
		bt05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt05.getText());
			}
		});
		bt06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt06.getText());
			}
		});
		bt07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt07.getText());
			}
		});
		bt08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt08.getText());
			}
		});
		bt09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt09.getText());
			}
		});
		bt00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digita(bt00.getText());
			}
		});

		btCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setD(1);
				limpar();
			}
		});
		btBra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limpo()) {

				} else
					JOptionPane.showMessageDialog(null, "Os campos precisam estar em branco, aperte CORRIGIR", "Erro", 1);

			}
		});

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Urna");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Urna());
		frame.pack();
		frame.setVisible(true);

	}
}
