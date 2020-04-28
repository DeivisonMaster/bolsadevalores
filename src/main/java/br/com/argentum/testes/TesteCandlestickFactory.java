package br.com.argentum.testes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.argentum.model.Candlestick;
import br.com.argentum.model.CandlestickFactory;
import br.com.argentum.model.Negociacao;

public class TesteCandlestickFactory {
	public static void main(String[] args) {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao n1 = new Negociacao(40.0, 100, hoje);
		Negociacao n2 = new Negociacao(35.0, 100, hoje);
		Negociacao n3 = new Negociacao(45.0, 100, hoje);
		Negociacao n4 = new Negociacao(20.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
		
		CandlestickFactory factory = new CandlestickFactory(); 
		Candlestick candlestick = factory.geraCandleParaData(negociacoes, hoje);
		
		System.out.println(candlestick.getAbertura());
		System.out.println(candlestick.getFechamento());
		System.out.println(candlestick.getMaximo());
		System.out.println(candlestick.getMinimo());
		System.out.println(candlestick.getVolume());
	}
}
