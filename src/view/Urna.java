package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Urna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField[] txt = new JTextField[5];
	private JMenuBar menuBar;
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
	
	// tela e conteudo
	private JPanel tela;
	private JLabel lblStatus;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl20;
	private JLabel lbl12;
	private JLabel lblErrado;
	private JLabel lblNull;
	private JLabel lblRodape;
	private JLabel lblrodape1;
	private JLabel lblrodape2;
	private JLabel lblrodape3;
	
	// menu bar
	private JMenu mnAdd;
	private JMenuItem mntmCandidato;
	private JMenuItem mntmEleitor;
	private JMenu mnHelp;
	private JMenuItem mntmVotos;
	private JMenuItem mntmInfo = new JMenuItem("Info");
	
	private int estagioVoto = 0;
	private int digito = 0;
	private boolean branco = false;
	private String Voto;
	private int numD = 4;
	private boolean fim = false;
	private boolean nulo;

//	private String getPartido(int num) {
//		String tx = null;
//		for (int i = 0; i < partido.length; i++) {
//			if (num == partido[i].codigo) {
//				tx = partido[i].sigla + " - " + partido[i].nome;
//			}
//		}
//		if (tx == null) {
//			this.nulo = true;
//		}
//		return tx;
//	}

	private void setTela(int i) {
		{
			lblStatus.setVisible(false);
			lbl10.setVisible(false);
			lbl11.setVisible(false);
			lbl12.setVisible(false);
			lbl20.setVisible(false);
			lblErrado.setVisible(false);
			lblNull.setVisible(false);
			lblRodape.setVisible(false);
			lblrodape1.setVisible(false);
			lblrodape2.setVisible(false);
			lblrodape3.setVisible(false);
			for (int x = 0; x < 5; x++) {
				txt[x].setVisible(false);
			}
			try {
				lbl12.setText(
						"Partido: " /*+ getPartido(Integer.parseInt(txt[0].getText() + txt[1].getText()))*/);
			} catch (Exception erro) {
				lbl12.setText("Partido: ");
			}
		}

		if (!fim) {
			for (int x = 0; x < numD; x++) {
				txt[x].setVisible(true);
			}
		}

		if (i == 0) {
			lblStatus.setVisible(true);
			lblStatus.setText(estagioVoto());
			for (int x = 0; x < numD; x++) {
				txt[x].setVisible(true);
			}
		}

		else {
			setRodape(true);
		}

		if (i == 1) {
			lblStatus.setVisible(true);
			lbl10.setVisible(true);
			lbl11.setVisible(true);
			lbl12.setVisible(true);
			if(nulo) {
				lblErrado.setVisible(nulo);
				lblNull.setVisible(nulo);
			}
			if (branco) {
				lblNull.setText("VOTO EM BRANCO");
				lblNull.setVisible(branco);
			}

		}

		if (i == 99) {
			lblStatus.setText("FIM");
			lblStatus.setVisible(true);
			txt[0].setVisible(false);
			txt[1].setVisible(false);
		}
	}

	public void setRodape(boolean a) {
		lblRodape.setVisible(a);
		lblrodape1.setVisible(a);
		lblrodape2.setVisible(a);
		lblrodape3.setVisible(a);
	}

	public void confirmar(String numero) {
		this.Voto = estagioVoto() + ": " + numero + "\n";
		proxE();
	}

	public void limpar() {
		for (int i = 0; i < 5; i++)
			txt[i].setText("");
		setD(0);
	}

	public boolean limpo() {
		for (int i = 0; i < 5; i++) {
			if (!txt[i].getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private void proxE() {
		if (this.estagioVoto < 6)
			this.estagioVoto++;
		else
			setTela(99);
		limpar();
		setTela(0);
	}

	private void proxD() {
		if (this.digito < numD - 1)
			this.digito++;
		if (this.digito > 1) {
			setTela(1);
		}
	}
	
	private void setD(int i) {
		if (i >= 0 && i < numD)
			this.digito = i;
	}

	public void digita(String arg0) {
		if (!branco) {
			if (!fim) {
				if (txt[this.digito].getText() == null || txt[this.digito].getText().isEmpty()) {
					txt[this.digito].setText(arg0);
					proxD();
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Voto em branco !\nAperte CORRIGIR para corrigir seu voto", "Bloqueado", 1);
	}

	public String estagioVoto() {
		String estagio = "";
		switch (this.estagioVoto) {
		case 0:
			estagio = "Deputado Federal";
			numD = 4;
			break;
		case 1:
			estagio = "Deputado Estadual";
			numD = 5;
			break;
		case 2:
			estagio = "Senador - 1 vaga";
			numD = 3;
			break;
		case 3:
			estagio = "Senador - 2 vaga";
			numD = 3;
			break;
		case 4:
			estagio = "Governador";
			numD = 2;
			break;
		case 5:
			estagio = "Presidente";
			numD = 2;
			break;
		default:
			estagio = "FIM";
			this.fim = true;
		}
		return estagio;
	}

	public Urna() {
		getContentPane().setBackground(SystemColor.info);
		setTitle("Urna");
		setSize(new Dimension(1048, 520));
		setMinimumSize(new Dimension(1048, 510));
		setBackground(SystemColor.info);
		setForeground(Color.WHITE);
		setBackground(SystemColor.text);
		setForeground(Color.WHITE);
		setResizable(false);

		//Construcao de botoes
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

		btCon = new JButton("Confirmar");
		btCon.setBackground(Color.GREEN);

		btCor = new JButton("Corrigir");
		btCor.setBackground(Color.RED);

		menuBar = new JMenuBar();
		mnAdd = new JMenu("Add");
		mntmCandidato = new JMenuItem("Candidato");
		mntmEleitor = new JMenuItem("Eleitor");
		mnHelp = new JMenu("Help");
		mntmVotos = new JMenuItem("Votos");
		mntmInfo = new JMenuItem("Info");

		//Tela e componentes
		tela = new JPanel();
		tela.setBackground(Color.WHITE);
		lblStatus = new JLabel("Deputado Federal");
		lbl10 = new JLabel("SEU VOTO VAI PARA");
		lbl11 = new JLabel("Número:");
		lbl20 = new JLabel("Nome:");
		lbl12 = new JLabel("Partido:");
		lblErrado = new JLabel("Número errado");
		lblNull = new JLabel("VOTO NULO");
		lblRodape = new JLabel(
				"__________________________________________________________________________________________________________");
		lblrodape1 = new JLabel("Aperte a tecla:");
		lblrodape2 = new JLabel("CONFIRMApara CONFIRMAR  este voto");
		lblrodape3 = new JLabel("CORRIGE para REINICIAR este voto");

		for (int i = 0; i < 5; i++) {
			txt[i] = new JTextField(5);
		}

		for (int i = 0; i < 5; i++) {
			txt[i].setEditable(false);
			txt[i].setForeground(Color.BLACK);
			txt[i].setVisible(false);
		}

		// adjust size and set layout
		setPreferredSize(new Dimension(1048, 510));
		getContentPane().setLayout(null);
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

		// set component bounds (only needed by Absolute Positioning)
		tela.setBounds(30, 55, 645, 420);
		lblStatus.setBounds(242, 91, 230, 15);
		lbl10.setBounds(12, 12, 137, 15);
		lbl11.setBounds(12, 154, 59, 15);
		lbl20.setBounds(12, 207, 380, 15);
		lbl12.setBounds(12, 261, 380, 15);
		lblErrado.setBounds(12, 234, 103, 15);
		lblNull.setBounds(294, 279, 190, 15);
//		lblRodape.setVerticalAlignment(SwingConstants.TOP);
		lblRodape.setBounds(0, 343, 645, 15);
		lblrodape1.setBounds(12, 360, 113, 15);
		lblrodape2.setBounds(32, 375, 261, 15);
		lblrodape3.setBounds(42, 390, 237, 15);

		setTela(0);
		txt[0].setBounds(105, 145, 25, 35);
		txt[1].setBounds(130, 145, 25, 35);
		txt[2].setBounds(155, 145, 25, 35);
		txt[3].setBounds(180, 145, 25, 35);
		txt[4].setBounds(205, 145, 25, 35);

		getContentPane().add(bt01);
		getContentPane().add(bt02);
		getContentPane().add(bt03);
		getContentPane().add(bt04);
		getContentPane().add(bt05);
		getContentPane().add(bt06);
		getContentPane().add(bt07);
		getContentPane().add(bt08);
		getContentPane().add(bt09);
		getContentPane().add(bt00);
		getContentPane().add(btBra);
		getContentPane().add(btCon);
		getContentPane().add(btCor);
		getContentPane().add(menuBar);

		//Menu Bar
		menuBar.setBounds(0, 0, 1044, 21);
		menuBar.add(mnAdd);
		mnAdd.add(mntmCandidato);
		mnAdd.add(mntmEleitor);
		menuBar.add(mnHelp);
		mnHelp.add(mntmVotos);
		mnHelp.add(mntmInfo);
		mntmInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Help().setVisible(true);
			}
		});

		tela.setBounds(28, 44, 644, 431);
		getContentPane().add(tela);
				tela.setLayout(null);

				// construct components
				lblStatus = new JLabel("DEPUTADO FEDERAL");
				lblStatus.setBounds(210, 114, 243, 15);
				tela.add(lblStatus);
				tela.add(lbl10);
				tela.add(lbl11);
				tela.add(lbl20);
				tela.add(lbl12);
				tela.add(lblErrado);
				tela.add(lblNull);
				tela.add(lblRodape);
				tela.add(lblrodape1);
				tela.add(lblrodape2);
				tela.add(lblrodape3);

				setTela(0);
				txt[0].setBounds(105, 145, 25, 35);
				txt[1].setBounds(130, 145, 25, 35);
				txt[2].setBounds(155, 145, 25, 35);
				txt[3].setBounds(180, 145, 25, 35);
				txt[4].setBounds(205, 145, 25, 35);
				for (int i = 0; i < 5; i++) {
					tela.add(txt[i]);
				}

//        uptxt();

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

		// Função para o botão Correcao
		btCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				if (branco)
					branco = false;
				setTela(0);
			}
		});

		// Função para o botão Branco
		btBra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (limpo()) {
					branco = true;
					setTela(1);
				} else
					JOptionPane.showMessageDialog(null, "Os campos precisam estar em branco, aperte CORRIGIR", "Erro",
							1);
			}
		});

		// Função para o botão Confirmar
		btCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!fim) {
					String numero = "";
					for (int i = 0; i < numD; i++)
						numero += txt[i].getText();
					confirmar(numero);
					System.out.println(Voto);
				}
				setTela(0);
			}
		});

	}

	public static void main(String[] args) {
		Urna frame = new Urna();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
