import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.event.*;

public class teste extends JPanel {

	private JTextField[] txt = new JTextField[5];
	Partido[] partido = new Partido[10];
	Candidato[] c = new Candidato[20];
//    private JTextField txtat;
	private JButton bt01;
	private JButton bt02;
	private JMenuBar jbar;
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

	private int estagioVoto = 0;
	private int digito = 0;
	private boolean branco = false;
	private String Voto;
	private int numD = 4;
	private boolean fim = false;
	private boolean nulo;

	private String getPartido(int num) {
		String tx = null;
		for (int i = 0; i < partido.length; i++) {
			if (num == partido[i].codigo) {
				tx = partido[i].sigla + " - " + partido[i].nome;
			}
		}
		if (tx == null) {
			this.nulo = true;
		}
		return tx;
	}

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
						"Partido: " + getPartido(Integer.parseInt(txt[0].getText() + txt[1].getText())));
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
		for (int i = 0; i < 5; i++) {
			txt[i].setText("");
		}
		setD(0);
	}

	public boolean limpo() {
		int ok = 0;
		for (int i = 0; i < 5; i++) {
			if (txt[i].getText() != null && !txt[i].getText().isEmpty()) {
				ok++;
			}
		}
		if (ok != 0)
			return false;
		else
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
			JOptionPane.showMessageDialog(null, "Voto em branco !\nAperte CORRIGIR para corrigir seu voto", "Bloqueado",
					1);
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

	public teste() {

		// Construção dos partidos
		// PRONA
		partido[0] = new Partido();
		partido[0].codigo = 56;
		partido[0].nome = "Partido de reedificação da ordem nacional";
		partido[0].sigla = "PRONA";
		// PSDB
		partido[1] = new Partido();
		partido[1].codigo = 45;
		partido[1].nome = "Partido da Social Democracia Brasileira";
		partido[1].sigla = "PSDB";
		// PDT
		partido[2] = new Partido();
		partido[2].codigo = 12;
		partido[2].nome = "Partido Democratico Trabalhista";
		partido[2].sigla = "PDT";
		// NOVO
		partido[3] = new Partido();
		partido[3].codigo = 30;
		partido[3].nome = "Partido Novo";
		partido[3].sigla = "NOVO";
		// REDE

		// Construção dos candidatos

		// ENEAS - Presidente 5
		c[0] = new Candidato();
		c[0].setNome("Eneas");
		c[0].setRg("3231561552");
		c[0].setSexo('M');
		c[0].setCpf("27957251248");
		c[0].p = partido[0];
		c[0].cargo = 5;
		// Cabo Daciolo
		c[1] = new Candidato();
		c[1].setNome("Ciro Gomes");
		c[1].setRg("6841357565");
		c[1].setSexo('M');
		c[1].setCpf("45687512248");
		c[1].p = partido[2];
		c[1].cargo = 5;

		setBackground(new Color(255, 255, 224));
		// construct preComponents
		JMenu fileMenu = new JMenu("File");
		JMenuItem addcandidatoItem = new JMenuItem("addCandidato");
		fileMenu.add(addcandidatoItem);
		JMenu helpMenu = new JMenu("Help");

		for (int i = 0; i < 5; i++) {
			txt[i] = new JTextField(5);
		}

		jbar = new JMenuBar();
		jbar.add(fileMenu);
		jbar.add(helpMenu);

		bt01 = new JButton("1");
		bt01.setForeground(Color.WHITE);
		bt01.setBackground(Color.BLACK);

		bt02 = new JButton("2");
		bt02.setForeground(Color.WHITE);
		bt02.setBackground(Color.BLACK);

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
		btBra.setForeground(Color.BLACK);
		btBra.setBackground(Color.WHITE);

		btCon = new JButton("Confirmar");
		btCon.setForeground(Color.BLACK);
		btCon.setBackground(Color.GREEN);

		btCor = new JButton("Corrigir");
		btCor.setForeground(Color.BLACK);
		btCor.setBackground(Color.RED);

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
			txt[i].setEnabled(false);
			txt[i].setForeground(Color.BLACK);
			txt[i].setVisible(false);
		}
		
		// adjust size and set layout
		setPreferredSize(new Dimension(1048, 507));
		add(tela);
		tela.setLayout(null);
		tela.add(lblStatus);
		tela.add(lbl10);
		tela.add(lbl11);
		tela.add(lbl12);
		tela.add(lbl20);
		tela.add(lblErrado);
		tela.add(lblNull);
		tela.add(lblRodape);
		tela.add(lblrodape1);
		tela.add(lblrodape2);
		tela.add(lblrodape3);

		setLayout(null);
		for (int i = 0; i < 5; i++) {
			tela.add(txt[i]);
		}

		add(jbar);
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

		// set component bounds (only needed by Absolute Positioning)
		tela.setBounds(30, 55, 645, 420);
		lblStatus.setBounds(242, 91, 230, 15);
		lbl10.setBounds(12, 12, 137, 15);
		lbl11.setBounds(12, 154, 59, 15);
		lbl20.setBounds(12, 207, 380, 15);
		lbl12.setBounds(12, 261, 380, 15);
		lblErrado.setBounds(12, 234, 103, 15);
		lblNull.setBounds(294, 279, 190, 15);
		lblRodape.setVerticalAlignment(SwingConstants.TOP);
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
		jbar.setBounds(0, 0, 1045, 25);
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

		// função para o helpmenu <- mostrar os candidatos
		helpMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		// função para os botôes numéricos
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

		// Função para o botão Corrigir
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
				if (estagioVoto < 6) {
					String numero = "";
					for (int i = 0; i < numD; i++) {
						numero += txt[i].getText();
					}
					confirmar(numero);
					System.out.println(Voto);
				}
				setTela(0);
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("teste");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new teste());
		frame.pack();
		frame.setVisible(true);

	}
}
