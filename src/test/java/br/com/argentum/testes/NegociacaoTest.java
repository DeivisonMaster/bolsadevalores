package br.com.argentum.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Test;

import br.com.argentum.model.Negociacao;

public class NegociacaoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-20.0, 3, LocalDateTime.now());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10.0, 5, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeComPrecoNegativo() {
		new Negociacao(10.0, -5, LocalDateTime.now());
	}
}
