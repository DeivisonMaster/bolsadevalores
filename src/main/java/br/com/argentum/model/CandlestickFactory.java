package br.com.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandlestickFactory {
	
	/**
	 * @description 
	 * */
	public Candlestick geraCandleParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		double volume = 0;
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();  // 
			
			if(negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}
			else if(negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data); 
	}

	public List<Candlestick> constroiCandlesticks(List<Negociacao> negociacoes) {
		List<Candlestick> candlestick = new ArrayList<>();
		List<Negociacao> negociacoesDia = new ArrayList<>();
		LocalDateTime dataAtual = negociacoes.get(0).getData();
		
		for (Negociacao negociacao : negociacoes) {
			if(negociacao.isMesmoDia(dataAtual)) {
				negociacoesDia.add(negociacao);
				
			}else {
				Candlestick candle = geraCandleParaData(negociacoesDia, dataAtual);
				candlestick.add(candle);
				
				negociacoesDia = new ArrayList<>();
				dataAtual = negociacao.getData();
			}
			
		}
		
		Candlestick candle = geraCandleParaData(negociacoesDia, dataAtual);
		candlestick.add(candle);
		
		return candlestick;
	}
}

