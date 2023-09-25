package com.project.cm;

import com.project.cm.modelo.Tabuleiro;
import com.project.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tab = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tab);
		
	}

}
