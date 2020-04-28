package br.com.argentum.model;

import java.time.LocalDateTime;

public final class Negociacao {
	
	private final double preco;
	private final Integer quantidade;
	private final LocalDateTime data;
	
	
	public Negociacao(double preco, Integer quantidade, LocalDateTime data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getPreco() {
		return preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public double getVolume() {
		return this.preco * this.quantidade;
	}
	
	
}
