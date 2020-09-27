package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Jogo;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Jogo> jogos = new ArrayList<>();
		
		jogos.add(new Jogo(1, 20));
		jogos.add(new Jogo(2, 11));
		jogos.add(new Jogo(3, 4));
		jogos.add(new Jogo(4, 7));
		jogos.add(new Jogo(5, 21));
		
		try {
			File file = new File("./jogos.ser");
			
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			
			out.writeObject(jogos);
		
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		try {
			File file = new File("./jogos.ser");
			
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			
			jogos = (ArrayList<Jogo>) in.readObject();
		
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Jogo jogo : jogos) {
			System.out.println(jogo);
		}
		
	}

}
