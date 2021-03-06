package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Jogo;

/**
 * Implementação da persistência dos jogos a serem registrados por meio de arquivo em disco.
 * Serializando um "ArrayList" contendo os jogos.
 * Optei por serializar para manter a simplicidade, mas pode ser fácilmente modificado para outra forma sem impactar no restante da aplicação.
 */
public final class SerializeJogosPersist extends JogosPersist {
	
	private ArrayList<Jogo> jogos;
	
	protected SerializeJogosPersist() {
		jogos = new ArrayList<>();
		
		load();
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		File file;
		ObjectInputStream in;
		
		try {
			
			file = new File("./jogos.ser");
			
			if (!file.exists()) {
				file.createNewFile();
				save();
			}
			
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
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			
			out.writeObject(jogos);
		
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public Jogo[] getTodosJogos() {
		Jogo[] temp = new Jogo[jogos.size()];
		
		jogos.toArray(temp);
		
		return temp;
	}
	
	@Override
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
	
	@Override
	public boolean removeJogo(Jogo jogo) {
		boolean removido;
		
		removido = jogos.remove(jogo);
				
		save();
		
		return removido;
	}
	
}
