package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Jogo;

public class JogosController {
	
	private ArrayList<Jogo> jogos;
	
	public JogosController() {
		jogos = new ArrayList<>();
		
		load();
	}
	
	private void load() {
		File file;
		ObjectInputStream in;
		
		try {
			file = new File("./jogos.ser");
			in   = new ObjectInputStream(new FileInputStream(file));
			
			jogos = (ArrayList<Jogo>) in.readObject();
		
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void save() {
		try {
			File file = new File("./jogos.ser");
			
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			
			out.writeObject(jogos);
		
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Jogo[] getTodosJogos() {
		Jogo[] temp = new Jogo[jogos.size()];
		
		jogos.toArray(temp);
		
		return temp;
	}
	
	public boolean addJogo(Jogo jogo) {
		boolean adicionado;
		
		if (jogos.contains(jogo)) {
			adicionado = false;
			
		} else {
			adicionado = true;
			jogos.add(jogo);
		}
		
		save();
		
		return adicionado;
	}
	
	public boolean removeJogo(Jogo jogo) {
		boolean removido;
		
		removido = jogos.remove(jogo);
				
		save();
		
		return removido;
	}
	
}
