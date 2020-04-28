package br.com.argentum.model;

import java.time.LocalDateTime;

public final class Negociacao {
	
	private final double preco;
	private final Integer quantidade;
	private final LocalDateTime data;
	
	
	public Negociacao(double preco, Integer quantidade, LocalDateTime data) {
		if(preco < 0) {
			throw new IllegalArgumentException("O preço deve ser maior que 0");
		}
		
		if(quantidade < 0) {
			throw new IllegalArgumentException("A quantidade não pode ser nula");
		}
		
		if(data == null) {
			throw new IllegalArgumentException("A data não pode ser nula");
		}
		
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
