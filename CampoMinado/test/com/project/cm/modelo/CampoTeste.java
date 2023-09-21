package com.project.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach // pra todo teste executar isso primeiro
	void iniciarCampo() {
		
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoEsquerda() {
		
		Campo vizinhoEsq = new Campo(3, 2);
		boolean resul = campo.adicionarVizinho(vizinhoEsq);
		
		assertTrue(resul);
		
	}
	
	@Test
	void testeVizinhoDireita() {
		
		Campo vizinhoDir = new Campo(3, 4);
		boolean resul = campo.adicionarVizinho(vizinhoDir);
		
		assertTrue(resul);
		
	}
	
	@Test
	void testeVizinhoCima() {
		
		Campo vizinhoC = new Campo(2, 3);
		boolean resul = campo.adicionarVizinho(vizinhoC);
		
		assertTrue(resul);
		
	}
	
	@Test
	void testeVizinhoBaixo() {
		
		Campo vizinhoB = new Campo(4, 3);
		boolean resul = campo.adicionarVizinho(vizinhoB);
		
		assertTrue(resul);
		
	}
	
	@Test
	void testeVizinhoDiagonal() {
		
		Campo vizinhoDi = new Campo(2, 2);
		boolean resul = campo.adicionarVizinho(vizinhoDi);
		
		assertTrue(resul);
		
	}
	
	@Test
	void testeNaoVizinho() {
		
		Campo vizinhoN = new Campo(1, 1);
		boolean resul = campo.adicionarVizinho(vizinhoN);
		
		assertFalse(resul);
		
	}

}
