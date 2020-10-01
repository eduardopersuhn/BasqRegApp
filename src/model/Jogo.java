package model;

import java.io.Serializable;

/**
 * Classe que representa o registro de um jogo que será utilizado pela aplicação.
 * 
 */
public class Jogo implements Serializable, Comparable<Jogo> {
	
	private static final long serialVersionUID = 2617956552686531110L;
	private int num;
	private int placar;
	
	public Jogo() {
		num = 0;
		placar = 0;
	}
	
	public Jogo(int num, int placar) {
		setNum(num);
		setPlacar(placar);
	}
	
	public Jogo(Jogo jogo) {
		this.replaceValues(jogo);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) throws IllegalArgumentException {
		
		if (num < 0) {
			throw new IllegalArgumentException();
		}
		this.num = num;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) throws IllegalArgumentException  {
		
		// Segundo descrito na questão prática o placar tem que ser positivo e menor que 1000
		if (placar < 0 || placar >= 1000) {
			throw new IllegalArgumentException();
		}
		
		this.placar = placar;
	}
	
	public void replaceValues(Jogo jogo) {
		setNum(jogo.getNum());
		setPlacar(jogo.getPlacar());
	}
	
	@Override
	public String toString() {
		return "Jogo numero: " + num + " placar: " + placar;
	}

	@Override
	public int compareTo(Jogo jogo) {
		return Integer.compare(this.getNum(), jogo.getNum());
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getNum() == ((Jogo) obj).getNum();
	}
	
}
