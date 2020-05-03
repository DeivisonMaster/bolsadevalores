package br.com.argentum.grafico;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.argentum.indicadores.MediaMovelSimples;
import br.com.argentum.model.SerieTemporal;

public class GeradorDeModeloGrafico {
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorDeModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
	}
	
	
	public void montaMediaMovelSimples() {
		LineChartSeries linha = new LineChartSeries();
		linha.setLabel("MMS - Fechamento");
		
		MediaMovelSimples indicador = new MediaMovelSimples();
		
		double valor = 0;
		
		for (int i = comeco; i <= fim; i++) {
			valor = indicador.calcula(i, serie);
			linha.set(i, valor);
		}
		
		this.modeloGrafico.addSeries(linha);
	}
	
	public LineChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
}
