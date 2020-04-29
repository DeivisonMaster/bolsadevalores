package br.com.argentum.model;

import java.time.LocalDateTime;

public class CandleBuilder {
	
	private Double abertura;
	private Double fechamento;
	private Double maximo;
	private Double minimo;
	private Double volume;
	private LocalDateTime data;
	
	
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}
	
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}
	
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}
	
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}
	
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}
	
	public CandleBuilder comData(LocalDateTime data) {
		this.data = data;
		return this;
	}
	
	public Candlestick geraCandlestick() {
		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
