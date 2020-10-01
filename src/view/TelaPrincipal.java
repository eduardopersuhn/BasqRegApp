package view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Tela principal. Parcialmente gerado pelo plugin "Window builder" do eclipse.
 */
@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		
		LookAndFeel.set();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Arquivo");
		menuBar.add(mnMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnMenu.add(mntmSair);
		
		JMenu mnJogos = new JMenu("Jogos");
		menuBar.add(mnJogos);
		
		JMenuItem mntmTabelaJogos = new JMenuItem("Tabela de Jogos");
		mntmTabelaJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exibirTelaConsulta();
			}
		});
		mnJogos.add(mntmTabelaJogos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void exibirTelaConsulta() {
		JDialog telaConsulta = new TelaTabelaJogos(this);
		telaConsulta.setModalityType(ModalityType.DOCUMENT_MODAL);
		telaConsulta.setVisible(true);
	}

}
