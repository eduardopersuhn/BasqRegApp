package utility;

import java.util.ArrayList;

import model.Jogo;

/**
 * Funções de utilidade para manipular os jogos registrados.
 *
 */
public class JogosUtility {
	
	public static int getPlacarMinTemporada(ArrayList<Jogo> jogos) {
		int min = -1;
		
		if (!jogos.isEmpty()) {
			min = jogos.get(0).getPlacar();
			
			for (Jogo jogo : jogos) {
				
				if (jogo.getPlacar() < min)
					min = jogo.getPlacar();
			}
			
		}
		
		return min;
	}
	
	public static int getPlacarMaxTemporada(ArrayList<Jogo> jogos) {
		int max = -1;
		
		if (!jogos.isEmpty()) {
			max = jogos.get(0).getPlacar();
			
			for (Jogo jogo : jogos) {
				
				if (jogo.getPlacar() > max)
					max = jogo.getPlacar();
			}
		}
		
		return max;
	}
	
	public static int getVezesRecordeMax(ArrayList<Jogo> jogos) {
		int vezes = 0;
		Jogo recorde;
		
		if (!jogos.isEmpty()) {
			recorde = jogos.get(0);
			
			for (Jogo jogo : jogos) {
				
				if (jogo.getPlacar() > recorde.getPlacar()) {
					vezes++;
					recorde = jogo;
				}
			}
		}
		
		return vezes;
	}
	
	public static int getVezesRecordeMin(ArrayList<Jogo> jogos) {
		int vezes = 0;
		Jogo recorde;
		
		if (!jogos.isEmpty()) {
			recorde = jogos.get(0);
			
			for (Jogo jogo : jogos) {
				
				if (jogo.getPlacar() < recorde.getPlacar()) {
					vezes++;
					recorde = jogo;
				}
			}
		}
		
		return vezes;
	}
	
}
