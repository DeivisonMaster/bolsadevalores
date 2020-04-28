package br.com.argentum.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void geraSequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao n1 = new Negociacao(40.0, 100, hoje); // abertura
		Negociacao n2 = new Negociacao(35.0, 100, hoje); // minimo
		Negociacao n3 = new Negociacao(45.0, 100, hoje); // maximo
		Negociacao n4 = new Negociacao(20.0, 100, hoje); // fechamento
		
		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
		
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candlestick = factory.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(20.0, candlestick.getMinimo(), 0.000001);
		Assert.assertEquals(45.0, candlestick.getMaximo(), 0.000001);
		Assert.assertEquals(40.0, candlestick.getAbertura(), 0.000001);
		Assert.assertEquals(20.0, candlestick.getFechamento(), 0.000001);
		Assert.assertEquals(14000.0, candlestick.getVolume(), 0.000001);
	}

	@Test
	public void geraCandlestickComApenasUmaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao n1 = new Negociacao(40.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(n1);
		
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candlestick = factory.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(40.0, candlestick.getMinimo(), 0.000001);
		Assert.assertEquals(40.0, candlestick.getMaximo(), 0.000001);
		Assert.assertEquals(40.0, candlestick.getAbertura(), 0.000001);
		Assert.assertEquals(40.0, candlestick.getFechamento(), 0.000001);
		Assert.assertEquals(4000.0, candlestick.getVolume(), 0.000001);
	}
	
	@Test
	public void geraCandlestickComZeroEmCasoDeNenhumaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();
		
		List<Negociacao> negociacoes = new ArrayList<>();
		
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candlestick = factory.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(0.0, candlestick.getMinimo(), 0.000001);
		Assert.assertEquals(0.0, candlestick.getMaximo(), 0.000001);
		Assert.assertEquals(0.0, candlestick.getAbertura(), 0.000001);
		Assert.assertEquals(0.0, candlestick.getFechamento(), 0.000001);
		Assert.assertEquals(0.0, candlestick.getVolume(), 0.000001);
	}
}
