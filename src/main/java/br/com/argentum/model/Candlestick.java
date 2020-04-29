package br.com.argentum.model;

import java.time.LocalDateTime;

public final class Candlestick {
	
	private final Double abertura;
	private final Double fechamento;
	private final Double maximo;
	private final Double minimo;
	private final Double volume;
	private final LocalDateTime data;
	
	
	public Candlestick(Double abertura, Double fechamento, Double maximo, Double minimo, Double volume, LocalDateTime data) {
		if(maximo < minimo) {
			throw new IllegalArgumentException("O valor máximo não deve ser menor que o minimo");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}
	
	public boolean isAlta() {
		return this.fechamento >= this.abertura;
	}
	
	public boolean isBaixa() {
		return this.fechamento < this.abertura;
	}
	
	public Double getAbertura() {
		return abertura;
	}
	public Double getFechamento() {
		return fechamento;
	}
	public Double getMaximo() {
		return maximo;
	}
	public Double getMinimo() {
		return minimo;
	}
	public Double getVolume() {
		return volume;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	
	
}
