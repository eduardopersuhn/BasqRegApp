package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Jogo;
import utility.JogosUtility;

/**
 * Testes para a classe "JogosUtilityTest"
 * Para isso criei 3 listas diferentes para testar os casos
 *
 */
public class JogosUtilityTest {
	
	// Para testar uma lista de jogos vazia
	private ArrayList<Jogo> getListaCaso01() {
		ArrayList<Jogo> jogos = new ArrayList<>();
		
		return jogos;
	}
	
	// Para testar uma lista de jogos com os exemplos da questão prática
	private ArrayList<Jogo> getListaCaso02() {
		ArrayList<Jogo> jogos = new ArrayList<>();
		
		jogos.add(new Jogo(1, 12));
		jogos.add(new Jogo(2, 24));
		jogos.add(new Jogo(3, 10));
		jogos.add(new Jogo(4, 24));
		
		return jogos;
	}
	
	// Para testar uma lista de jogos com alguns jogos a mais
	private ArrayList<Jogo> getListaCaso03() {
		ArrayList<Jogo> jogos = new ArrayList<>();
		
		jogos.add(new Jogo(1, 12));
		jogos.add(new Jogo(2, 24));
		jogos.add(new Jogo(3, 10));
		jogos.add(new Jogo(4, 24));
		jogos.add(new Jogo(4, 25));
		jogos.add(new Jogo(4, 9));
		
		return jogos;
	}
	
	// Testando a função do placar mínimo da temporada
	@Test
	public void placarMin() {
		
		// Caso da lista vazia
		assertEquals(-1, JogosUtility.getPlacarMinTemporada(getListaCaso01()));
		// Minimo da temporada para esta lista de jogos deve ser o placar 10
		assertEquals(10, JogosUtility.getPlacarMinTemporada(getListaCaso02()));
		
	}
	
	// Testando a função do placar máximo da temporada
	@Test
	public void placarMax() {
		
		// Caso da lista vazia
		assertEquals(-1, JogosUtility.getPlacarMaxTemporada(getListaCaso01()));
		// Máximo da temporada para esta lista de jogos deve ser o placar 24
		assertEquals(24, JogosUtility.getPlacarMaxTemporada(getListaCaso02()));
		
	}
	
	// Testando a função das vezes do recorde mínimo ter sido quebrado
	@Test
	public void vezesRecordeMin() {
		
		assertEquals(0, JogosUtility.getVezesRecordeMin(getListaCaso01()));
		assertEquals(1, JogosUtility.getVezesRecordeMin(getListaCaso02()));
		assertEquals(2, JogosUtility.getVezesRecordeMin(getListaCaso03()));
		
	}
	
	// Testando a função das vezes do recorde máximo ter sido quebrado
	@Test
	public void vezesRecordeMax() {
		
		assertEquals(0, JogosUtility.getVezesRecordeMax(getListaCaso01()));
		assertEquals(1, JogosUtility.getVezesRecordeMax(getListaCaso02()));
		assertEquals(2, JogosUtility.getVezesRecordeMax(getListaCaso03()));
		
	}

}
