package br.com.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeSerie {
	
	public static SerieTemporal criaSeria(double... valores) {
		List<Candlestick> candlesticks = new ArrayList<>();
		
		for (double d : valores) {
			candlesticks.add(new Candlestick(d, d, d, d, 1000.0, LocalDateTime.now()));
		}
		
		return new SerieTemporal(candlesticks);
	}
}
