package control;

import model.Jogo;

/**
 * Classe criada com objetivo de prover uma interface para persistir os dados dos jogos de alguma forma.
 * Fiz desta forma para o restante da aplicação ser independente da forma como os dados são armazenados de forma persistente.
 * Por exemplo uma classe deve extender esta para realizar, de fato, o armazenamente em disco ou em um banco de dados.
 */
public abstract class JogosPersist {
	
	// Utilizando o padrão Singleton.
	// Única diferença é que não utilizei o construtor privado por não ser possivel instanciar uma subclasse de "JogosPersist" dessa forma.
	// Independente disso o restante da aplicação não "enxerga" o conteúdo do pacote "control".
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
