package br.com.argentum.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Test;


public class CadlestickTest {

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

}
