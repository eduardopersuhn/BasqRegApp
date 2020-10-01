package testes;


import org.junit.Test;

import model.Jogo;

/**
 * Testes para a classe "Jogo"
 * Objetivo é testar valores inválidos para os jogos
 * 
 * Caso um parâmetro inválido seja informado optei por lançar uma exceção ("IllegalArgumentException")
 */
public class JogoTest {
	
	// Em todos os casos "IllegalArgumentException" deve ser lançada
	
	// Testando o construtor com parâmetros inválidos
	@Test(expected = IllegalArgumentException.class)
	public void construtorNumInvalido() {
		
		new Jogo(-1, 10);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void construtorPlacarNegativoInvalido() {
		
		new Jogo(1, -1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void construtorPlacarInvalido() {
		
		new Jogo(1, 1000);
		
	}
	
	// Testando os setters com parâmetros inválidos
	@Test(expected = IllegalArgumentException.class)
	public void setNum() {
		
		new Jogo().setNum(-1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setPlacarNegativo() {
		
		new Jogo().setPlacar(-1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setPlacar() {
		
		new Jogo().setPlacar(1000);
		
	}

}
