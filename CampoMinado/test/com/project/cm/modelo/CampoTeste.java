package com.project.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.cm.excecao.ExplosaoException;

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

	@Test
	void testeValorPadraoAtributoMarcado() {
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlteraMarcado() {
		
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlteraMarcado2chamadas() {
		
		campo.alterarMarcacao();
		campo.alterarMarcacao();
		assertFalse(campo.isMarcado());
		
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		
		campo.alterarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		
		campo.alterarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
		
			campo.abrir(); });
	}
	
	@Test
	void testeAbrirComVizinho1() {
		
		Campo campo22 = new Campo(2, 2);
		Campo campo11 = new Campo(1, 1);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinho2() {
		
		Campo campo22 = new Campo(2, 2);
		
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		Campo campo11 = new Campo(1, 1);
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isAberto());
	}

}
