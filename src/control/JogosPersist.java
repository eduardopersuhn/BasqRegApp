package control;

import model.Jogo;

public abstract class JogosPersist {
	
	private static JogosPersist _instance;
	
	protected JogosPersist() { }
	
	public static JogosPersist getInstance() {
		
		if (_instance == null) {
			_instance = new SerializeJogosPersist();
		}
		
		return _instance;
	}
	
	public abstract boolean addJogo(Jogo jogo);
	
	public abstract Jogo[] getTodosJogos();
	
	public abstract boolean removeJogo(Jogo jogo);
	
}
