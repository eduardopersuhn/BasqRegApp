package utility;

import java.util.ArrayList;

import model.Jogo;

public class JogosUtility {
	
	public static int getPlacarMinTemporada(ArrayList<Jogo> jogos) {
		int min = -1;
		
		if (jogos.size() > 0) {
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
		
		if (jogos.size() > 0) {
			max = jogos.get(0).getPlacar();
			
			for (Jogo jogo : jogos) {
				
				if (jogo.getPlacar() > max)
					max = jogo.getPlacar();
			}
		}
		
		return max;
	}
	
	
	
}
