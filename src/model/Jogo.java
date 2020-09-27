package model;

import java.io.Serializable;

public class Jogo implements Serializable, Comparable<Jogo> {
	
	private static final long serialVersionUID = 2617956552686531110L;
	private int num;
	private int placar;
	
	public Jogo() {
		num = 0;
		placar = 0;
	}
	
	public Jogo(int num, int placar) {
		this.num = num;
		this.placar = placar;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
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
