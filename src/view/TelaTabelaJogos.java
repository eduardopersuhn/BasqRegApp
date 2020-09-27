package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import control.JogosController;
import model.Jogo;

import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaTabelaJogos extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField campoNumAdd;
	private JFormattedTextField campoPlacarAdd;
	private JFormattedTextField campoNumRemover;
	
	
	private JogosController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTabelaJogos frame = new TelaTabelaJogos(null);
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
	public TelaTabelaJogos(JFrame frame) {
		super(frame);
		controller = new JogosController();
		
		setMinimumSize(new Dimension(300, 200));
		
		setType(Type.NORMAL);
		setTitle("BasqRegApp");
		
		// LookAndFeel.set();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Gerenciar Jogos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		campoNumAdd = new JFormattedTextField();
		
		campoNumAdd.setColumns(5);
		campoNumAdd.setText("Numero");
		panel_4.add(campoNumAdd);
		
		campoPlacarAdd = new JFormattedTextField();
		campoPlacarAdd.setColumns(5);
		panel_4.add(campoPlacarAdd);
		campoPlacarAdd.setText("Placar");
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		campoNumRemover = new JFormattedTextField();
		campoNumRemover.setColumns(10);
		panel_5.add(campoNumRemover);
		campoNumRemover.setText("Numero");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JButton botaoAdd = new JButton("Adicionar");
		botaoAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addJogo();
				resetarCampos();
			}
		});
		panel_2.add(botaoAdd);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_2.add(rigidArea_1);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerJogo();
				resetarCampos();
			}
		});
		panel_2.add(botaoRemover);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Lista de Jogos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(getTableModel());
		scrollPane.setViewportView(table);
		
		atualizarTabela();
	}
	
	private DefaultTableModel getTableModel() {
		return new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Jogo", "Placar", "M\u00E1ximo Temporada", "M\u00EDnimo Temporada", "Recorde M\u00EDnimo", "Recorde M\u00E1ximo"
			}
		) {
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
			
		};
	}
	
	private void atualizarTabela() {
		DefaultTableModel model = getTableModel();
		Jogo[] jogos;
		
		jogos = controller.getTodosJogos();
		
		Arrays.sort(jogos);
		
		for (Jogo jogo : jogos) {
			model.addRow(new Object[] { jogo.getNum(), jogo.getPlacar(), null, null, null, null });
		}
		
		table.setModel(model);
	}
	
	private void removerJogo() {
		Jogo jogo = new Jogo(Integer.parseInt(campoNumRemover.getText()), 0);
		
		boolean removido = controller.removeJogo(jogo);
		
		if (removido) {
			atualizarTabela();
			
		} else {
			JOptionPane.showMessageDialog(this, "Numero " + jogo.getNum() + " não foi encontrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void addJogo() {
		Jogo jogo = new Jogo(Integer.parseInt(campoNumAdd.getText()), Integer.parseInt(campoPlacarAdd.getText()));
		
		boolean adicionado = controller.addJogo(jogo);
		
		if (adicionado) {
			atualizarTabela();
			
		} else {
			JOptionPane.showMessageDialog(this, "Numero " + jogo.getNum() + " ja cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void resetarCampos() {
		campoNumAdd.setText("Numero");
		campoPlacarAdd.setText("Placar");
		campoNumRemover.setText("Numero");
	}

}
