package com.project.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.project.cm.excecao.ExplosaoException;
import com.project.cm.excecao.SairException;
import com.project.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tab;
	private Scanner in = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tab) {
		
		this.tab = tab;
		
		executarJogo();
		
	}

	private void executarJogo() {
		
		try {
			
			boolean continuar = true;
			
			while(continuar) {
				
				cicloJogo();
				
				System.out.println("Outra partida? (s/n) ");
				String resposta = in.nextLine();
				
				if("n".equalsIgnoreCase(resposta)) {
					
					continuar = false;
				} 
				else {
					
					tab.reiniciar();
					
				}
				
			}
			
		} catch (SairException e) {
			
			System.out.println("Saindo do Jogo");
			
		} finally {
			
			in.close();
		}
		
	}

	private void cicloJogo() {
		
		try {
			
			System.out.println("Para fechar o jogo digite 'sair'\n");
			
			while(!tab.objetivoAlcancado()) {
				
				System.out.println(tab);
				
				String digitado = capturarValor("Digite (x,y): ");
				
				Iterator<Integer> xy =  Arrays.stream(digitado.split(","))
					  .map(e -> Integer.parseInt(e.trim()))
					  .iterator();
				
				digitado = capturarValor("1 - Abrir ou 2 - (Des)Marcar: ");
				
				if("1".equals(digitado)) {
					
					tab.abrir(xy.next(), xy.next());
					
				} else if("2".equals(digitado)) {
					
					tab.marcar(xy.next(), xy.next());
				}
				
				System.out.println("\n");
			}
			
			System.out.println("\n");
			System.out.println(tab);
			System.out.println("\n");
			System.out.println("Voce Ganhou");
			System.out.println("\n");
			
		} catch (ExplosaoException e) {
			
			System.out.println("\n");
			System.out.println(tab);
			System.out.println("Voce perdeu");
		}
		
	}
	
	private String capturarValor(String texto) {
		
		System.out.print(texto);
		
		String digitado = in.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			
			throw new SairException();
		}
		
		return digitado;
		
	}


}
