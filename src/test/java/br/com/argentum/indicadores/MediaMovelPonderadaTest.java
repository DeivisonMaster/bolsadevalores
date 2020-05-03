package br.com.argentum.indicadores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.argentum.model.GeradorDeSerie;
import br.com.argentum.model.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSeria(1, 2, 3, 4, 5, 6);
		
		MediaMovelPonderada mediaSimples = new MediaMovelPonderada();
		
		Assert.assertEquals(14.0/6, mediaSimples.calcula(2, serie), 0.00001);
		Assert.assertEquals(20.0/6, mediaSimples.calcula(3, serie), 0.00001);
		Assert.assertEquals(26.0/6, mediaSimples.calcula(4, serie), 0.00001);
		Assert.assertEquals(32.0/6, mediaSimples.calcula(5, serie), 0.00001);
	}

}
