package br.com.argentum.model;

import java.util.List;

public class SerieTemporal {
	
	private final List<Candlestick> candlesticks;
	
	public SerieTemporal(List<Candlestick> candles) {
		this.candlesticks = candles;
	}
	
	public Candlestick getCandlestick(int posicao) {
		return this.candlesticks.get(posicao);
	}
	
	public int getUltimaPosicao() {
		return this.candlesticks.size() - 1;
	}
}
