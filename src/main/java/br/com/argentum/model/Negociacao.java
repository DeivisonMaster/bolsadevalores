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
	
	public boolean isMesmoDia(LocalDateTime outraData) {
		return this.data.getDayOfMonth() == outraData.getDayOfMonth() &&
				this.data.getMonth() == outraData.getMonth() &&
						this.data.getYear() == outraData.getYear();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negociacao other = (Negociacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}
	
	
}
