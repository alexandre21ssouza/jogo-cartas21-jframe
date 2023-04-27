package cartas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaCartas extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblCartas;
	private JLabel lblCartasMao;
	private JLabel lblsomaCartas;
	private JLabel lblNypeCartas;
	private JButton btnPedirCarta;
	private JLabel lblMostrarAcao;
	private String pedir = "n";
	private String jogar = "n";
	private JLabel lblNomeJogo;
	private JLabel lblNewLabel_3;
	private JLabel lblSlogan21;
	private JLabel lblNomeInfo;
	private JLabel lblName;
	int soma = 0;
	String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCartas frame = new TelaCartas();
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
	public TelaCartas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Evento de clique e botão Iniciar
		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInicio.setBackground(new Color(255, 255, 255));
		btnInicio.setForeground(new Color(0, 0, 255));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				name = JOptionPane.showInputDialog(lblName, "Digite seu nome");

				if (name.isBlank()) {
					JOptionPane.showMessageDialog(btnInicio, "Digite seu Nome no campo proposto!");

				} else {
					lblName.setText(name);

					jogar = JOptionPane.showInputDialog(name + " Deseja iniciar? (s/n)");

					if ((jogar.equals("s") || jogar.equals("S")) && soma == 0) {

						pedir = JOptionPane.showInputDialog(btnPedirCarta, "pedir carta? (s/n)");

					} else if (jogar.equals("n") || jogar.equals("N")) {
						JOptionPane.showMessageDialog(btnInicio, "Obrigado por nos visitar!");
						JOptionPane.showMessageDialog(lblsomaCartas, "Para jogar novamente clique em Iniciar!");

					} else {
						JOptionPane.showMessageDialog(btnInicio, "Digite (s/n)! Confira o texto digitado. ");

					}
					;

				}
				if (pedir.equals("s") || pedir.equals("S")) {
					btnPedirCarta.setEnabled(true);
					lblMostrarAcao.setText("Clique em Pedir Carta!");

				} else {
					btnPedirCarta.setEnabled(false);
					lblMostrarAcao.setText("Até Breve!");
				}
			}
		});

		// Labels da tela
		JLabel lblInfoCartas = new JLabel("Cartas");
		lblInfoCartas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfoCartas.setForeground(new Color(0, 0, 255));
		lblInfoCartas.setBackground(new Color(255, 255, 255));

		JLabel lblInfoSomaCartas = new JLabel("Soma das Cartas");
		lblInfoSomaCartas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfoSomaCartas.setForeground(new Color(0, 0, 255));

		JLabel lblComandos = new JLabel("Comandos");
		lblComandos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComandos.setHorizontalAlignment(SwingConstants.CENTER);
		lblComandos.setForeground(new Color(0, 0, 255));

		lblCartasMao = new JLabel("0");
		lblCartasMao.setForeground(new Color(255, 0, 0));
		lblCartasMao.setHorizontalAlignment(SwingConstants.CENTER);

		lblsomaCartas = new JLabel("0");
		lblsomaCartas.setForeground(new Color(255, 0, 0));
		lblsomaCartas.setHorizontalAlignment(SwingConstants.CENTER);

		lblMostrarAcao = new JLabel("Bem-vindo!");
		lblMostrarAcao.setForeground(new Color(255, 0, 0));
		lblMostrarAcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarAcao.setVerticalAlignment(SwingConstants.TOP);

		lblNypeCartas = new JLabel();
		lblNypeCartas.setIcon(new ImageIcon("C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/001-cartas-de-poker.png"));
		lblNypeCartas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNypeCartas.setForeground(new Color(255, 0, 0));

		// botão pedir carta
		btnPedirCarta = new JButton("Pedir carta");
		btnPedirCarta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPedirCarta.setBackground(new Color(255, 255, 255));
		btnPedirCarta.setForeground(new Color(0, 0, 255));

		btnPedirCarta.setEnabled(false);// para deixar o botão Pedir carta desativado inicialmente
		btnPedirCarta.addActionListener(new ActionListener() {// Evento de clique botão Pedir carta
			public void actionPerformed(ActionEvent e) {

				// ArrayList para simular a mão do jogador, armazenando numeros de cartas
				// repetidas
				ArrayList<Integer> maoJogador = new ArrayList<>();

				while ((pedir.equals("s") || pedir.equals("S")) && (jogar.equals("s")) || jogar.equals("S")) {

					if (soma < 21 && (jogar.equals("s") || jogar.equals("S"))) {

						// sorteia o número que simula a carta do baralho
						double sorte = Math.random();
						int n = (int) (sorte * (10 - 1 + 1) + 1);
						maoJogador.add(n);

						// Switch para mostrar as imagens das cartas
						switch (n) {
						case 1:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/016-as-de-diamantes-1.png"));
							break;
						case 2:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/002-dois-de-diamantes.png"));
							break;
						case 3:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/012-tres-de-diamantes.png"));
							break;
						case 4:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/007-quatro-de-diamantes.png"));
							break;
						case 5:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/003-cinco-de-diamantes.png"));
							break;
						case 6:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/004-seis-de-diamantes.png"));
							break;
						case 7:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/014-sete-de-diamantes.png"));
							break;
						case 8:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/008-oito-de-diamantes.png"));
							break;
						case 9:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/005-nove-de-diamantes.png"));
							break;
						case 10:
							lblNypeCartas.setIcon(new ImageIcon(
									"C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/009-dez-de-diamantes.png"));
							break;
						}

						// Transformando inteiro em String para aparecer no campo da tela
						String maoJogadorString = "";
						for (int i = 0; i < maoJogador.size(); i++) {
							maoJogadorString = maoJogadorString + maoJogador.get(i).toString() + " - ";
						}

						// FOR para fazer a soma dos pontos
						lblCartasMao.setText(maoJogadorString);
						soma = 0;
						for (int i = 0; i < maoJogador.size(); i++) {
							soma = soma + maoJogador.get(i);
						}

						lblsomaCartas.setText(Integer.toString(soma));
						lblMostrarAcao.setText("Estou na torcida!");

						JOptionPane.showInternalMessageDialog(null, "confirme para pedir outra carta!");

					}

					else if (soma > 21) {
						// btnPedirCarta.setEnabled(false);
						JOptionPane.showMessageDialog(lblsomaCartas, "Não fez 21 pontos!");
						lblMostrarAcao.setText("Você PERDEU!!");
						maoJogador.clear();
						lblCartasMao.setText("0");
						lblNypeCartas.setIcon(
								new ImageIcon("C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/001-cartas-de-poker.png"));
						soma = 0;
						lblsomaCartas.setText(Integer.toString(soma));
						jogar = JOptionPane.showInputDialog("Deseja iniciar novamente? (s/n)");

					} else if (soma == 21) {
						btnPedirCarta.setEnabled(false);
						JOptionPane.showMessageDialog(lblsomaCartas, "Parabéns, fez 21 pontos!");
						lblMostrarAcao.setText("Você VENCEU!!");
						maoJogador.clear();
						lblNypeCartas.setIcon(
								new ImageIcon("C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/001-cartas-de-poker.png"));
						lblCartasMao.setText("0");
						soma = 0;
						lblsomaCartas.setText(Integer.toString(soma));
						jogar = JOptionPane.showInputDialog("Deseja iniciar novamente? (s/n)");

					}
				}

				if (jogar.equals("n") || jogar.equals("N")) {
					lblName.setText("Nome");
					btnPedirCarta.setEnabled(false);
					lblMostrarAcao.setText("Até Breve!");
					lblNypeCartas.setIcon(
							new ImageIcon("C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/001-cartas-de-poker.png"));
					JOptionPane.showMessageDialog(lblsomaCartas, "Obrigado por nos visitar!");
					JOptionPane.showMessageDialog(btnInicio, "Para jogar novamente clique em Iniciar!");

				} else {
					lblNypeCartas.setIcon(
							new ImageIcon("C:/Eclipse/ws-eclipse/Jogo21/src/cartas/image/001-cartas-de-poker.png"));
					JOptionPane.showMessageDialog(btnInicio, "Digite (s/n)! Confira e o texto digitado. ");
					jogar = JOptionPane.showInputDialog("Deseja iniciar novamente? (s/n)");
				}
			}
		});

		// Labels da tela
		lblNomeJogo = new JLabel("JOGO ");
		lblNomeJogo.setForeground(new Color(0, 128, 255));
		lblNomeJogo.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 15));

		lblNewLabel_3 = new JLabel("Carta Sorteada");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCartaAs = new JLabel("");
		lblCartaAs.setIcon(new ImageIcon("C:\\Eclipse\\ws-eclipse\\Jogo21\\src\\cartas\\image\\018-jogos-de-azar.png"));

		lblSlogan21 = new JLabel("");
		lblSlogan21.setHorizontalAlignment(SwingConstants.LEFT);
		lblSlogan21.setIcon(new ImageIcon("C:\\Eclipse\\ws-eclipse\\Jogo21\\src\\cartas\\image\\vinte-e-um (1).png"));

		lblNomeInfo = new JLabel("Jogador(a)");
		lblNomeInfo.setForeground(new Color(0, 0, 255));
		lblNomeInfo.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblName = new JLabel("Nome");
		lblName.setForeground(new Color(255, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(55)
								.addComponent(lblInfoCartas, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNomeJogo)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
														.addComponent(lblCartaAs)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblSlogan21, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addGap(32).addComponent(btnInicio)
										.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
										.addComponent(lblNomeInfo, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
										.addGap(23)))
						.addGroup(
								gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(lblsomaCartas, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addGap(49)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNypeCartas, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPedirCarta)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(8).addComponent(lblNewLabel_3,
								GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
				.addGap(34))
				.addGroup(
						gl_contentPane.createSequentialGroup().addGap(32)
								.addComponent(lblCartasMao, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addComponent(lblInfoSomaCartas, GroupLayout.PREFERRED_SIZE, 100,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(170, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(177)
						.addComponent(lblComandos, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(
						gl_contentPane.createSequentialGroup().addGap(137)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMostrarAcao, GroupLayout.PREFERRED_SIZE, 151,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(140, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNomeJogo)
												.addComponent(lblSlogan21, GroupLayout.DEFAULT_SIZE, 32,
														Short.MAX_VALUE))
										.addGap(35).addGroup(gl_contentPane
												.createParallelGroup(Alignment.BASELINE).addComponent(lblInfoCartas)
												.addComponent(lblNewLabel_3))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
												gl_contentPane.createSequentialGroup().addGap(4).addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNypeCartas)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblInfoSomaCartas)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblsomaCartas, GroupLayout.PREFERRED_SIZE,
																		20, GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblCartasMao))))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(24)
										.addComponent(lblCartaAs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(98)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblComandos)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblMostrarAcao)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnInicio)
								.addComponent(btnPedirCarta).addComponent(lblNomeInfo))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblName).addGap(19)));
		contentPane.setLayout(gl_contentPane);
	}
}
