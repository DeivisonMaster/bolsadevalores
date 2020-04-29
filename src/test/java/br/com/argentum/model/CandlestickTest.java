package br.com.argentum.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Test;

import junit.framework.Assert;


public class CandlestickTest {

	@Test
	public void test() {
		CandleBuilder builder = new CandleBuilder();
		
		builder
			.comAbertura(10.0)
			.comFechamento(20.0)
			.comMaximo(100.0)
			.comMinimo(10.0)
			.comVolume(100.0)
			.comData(LocalDateTime.now())
			.geraCandlestick();
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorQueMinimo() {
		CandleBuilder builder = new CandleBuilder();
		builder
			.comAbertura(10.0)
			.comFechamento(30.0)
			.comMinimo(25.0)
			.comMaximo(15.0)
			.comVolume(200.0)
			.comData(LocalDateTime.now())
			.geraCandlestick();
	}
	
	@Test
	public void ehAltaSeFechamentoForIgualAbertura() {
		CandleBuilder builder = new CandleBuilder();
		
		Candlestick candlestick = builder
			.comAbertura(30.0)
			.comFechamento(30.0)
			.comMinimo(10.0)
			.comMaximo(50.0)
			.comVolume(200.0)
			.comData(LocalDateTime.now())
			.geraCandlestick();
		
		Assert.assertTrue(candlestick.isAlta()); 
	}

}
