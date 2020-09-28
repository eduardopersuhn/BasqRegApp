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
import javax.swing.text.NumberFormatter;

import control.JogosController;
import model.Jogo;
import utility.JogosUtility;

import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

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
		
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setGroupingUsed(false);
		decimalFormat.setMinimumIntegerDigits(0);
		
		NumberFormatter formatterPlacar = new NumberFormatter(decimalFormat);
		formatterPlacar.setValueClass(Integer.class);
		formatterPlacar.setMinimum(0);
		formatterPlacar.setMaximum(1000);
		formatterPlacar.setAllowsInvalid(false);
		formatterPlacar.setCommitsOnValidEdit(true);
		
		NumberFormatter formatterNumJogo = new NumberFormatter(decimalFormat);
		formatterNumJogo.setValueClass(Integer.class);
		formatterNumJogo.setMinimum(0);
		formatterNumJogo.setMaximum(Integer.MAX_VALUE);
		formatterNumJogo.setAllowsInvalid(false);
		formatterNumJogo.setCommitsOnValidEdit(true);
		
		setMinimumSize(new Dimension(400, 200));
		
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
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_4);
		
		JLabel lblNumero = new JLabel("Numero");
		panel_4.add(lblNumero);
		
		campoNumAdd = new JFormattedTextField(formatterNumJogo);
		
		campoNumAdd.setColumns(5);
		campoNumAdd.setText("0");
		panel_4.add(campoNumAdd);
		
		JLabel lblPlacar = new JLabel("Placar");
		panel_4.add(lblPlacar);
		
		campoPlacarAdd = new JFormattedTextField(formatterPlacar);
		campoPlacarAdd.setColumns(5);
		panel_4.add(campoPlacarAdd);
		campoPlacarAdd.setText("0");
		
		JButton botaoAdd = new JButton("Adicionar");
		panel_4.add(botaoAdd);
		botaoAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addJogo();
			}
		});
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		JLabel lblNumero_1 = new JLabel("Numero");
		panel_5.add(lblNumero_1);
		
		campoNumRemover = new JFormattedTextField(formatterNumJogo);
		campoNumRemover.setColumns(10);
		panel_5.add(campoNumRemover);
		campoNumRemover.setText("0");
		
		JButton botaoRemover = new JButton("Remover");
		panel_5.add(botaoRemover);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_1);
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerJogo();
			}
		});
		
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
				"Jogo", "Placar", "M\u00EDnimo Temporada", "M\u00E1ximo Temporada", "Recorde M\u00EDnimo", "Recorde M\u00E1ximo"
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
		ArrayList<Jogo> aux = new ArrayList<>();
		
		jogos = controller.getTodosJogos();
		
		Arrays.sort(jogos);
		
		for (Jogo jogo : jogos) {
			aux.add(jogo);
			model.addRow(new Object[] { 
					jogo.getNum(), 
					jogo.getPlacar(), 
					JogosUtility.getPlacarMinTemporada(aux), 
					JogosUtility.getPlacarMaxTemporada(aux), 
					null, 
					null });
		}
		
		table.setModel(model);
		
		if (jogos.length > 0) {
			resetarCampos(jogos[jogos.length - 1].getNum());
			
		}
		else {
			resetarCampos();
			
		}
		
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
	
	private void resetarCampos(int numAdd) {
		campoNumAdd.setText((numAdd + 1) + "");
		campoPlacarAdd.setText("0");
		campoNumRemover.setText("0");
	}
	
	private void resetarCampos() {
		campoNumAdd.setText("1");
		campoPlacarAdd.setText("0");
		campoNumRemover.setText("0");
	}

}
