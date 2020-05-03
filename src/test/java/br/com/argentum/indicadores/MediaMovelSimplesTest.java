package br.com.argentum.indicadores;



import org.junit.Assert;
import org.junit.Test;

import br.com.argentum.model.GeradorDeSerie;
import br.com.argentum.model.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSeria(1, 2, 3, 4, 3, 4, 5);
		
		MediaMovelSimples mediaSimples = new MediaMovelSimples();
		
		Assert.assertEquals(2.0, mediaSimples.calcula(2, serie), 0.000001);
		Assert.assertEquals(3.0, mediaSimples.calcula(3, serie), 0.000001);
		Assert.assertEquals(10.0/3, mediaSimples.calcula(4, serie), 0.000001);
		Assert.assertEquals(11.0/3, mediaSimples.calcula(5, serie), 0.000001);
		Assert.assertEquals(4.0, mediaSimples.calcula(6, serie), 0.000001);
		
		
		
	}

}
