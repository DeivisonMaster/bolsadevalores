package br.com.argentum.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.argentum.grafico.GeradorDeModeloGrafico;
import br.com.argentum.model.Candlestick;
import br.com.argentum.model.CandlestickFactory;
import br.com.argentum.model.Negociacao;
import br.com.argentum.model.SerieTemporal;
import br.com.argentum.ws.ClientWebService;

@Named
@ViewScoped
public class NegociacaoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Negociacao> negociacoes;
	private LineChartModel modeloGrafico;

	
	public NegociacaoController() {
		this.negociacoes = new ClientWebService().getNegociacoes();
		
		List<Candlestick> candlestick = new CandlestickFactory().constroiCandlesticks(negociacoes);
		SerieTemporal serie = new SerieTemporal(candlestick);
		
		GeradorDeModeloGrafico geradorModelo = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorModelo.montaMediaMovelSimples();
		
		this.modeloGrafico = geradorModelo.getModeloGrafico();
		
		/*
		this.modeloGrafico = new LineChartModel();
		
		modeloGrafico.setTitle("Meu primeiro gráfico");
		modeloGrafico.setLegendPosition("w");
		
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Valores");
		series.set(1, 10.5);
		series.set(2, 13.0);
		series.set(3, 12.0);
		
		this.modeloGrafico.addSeries(series);
		*/
	}
	
	public List<Negociacao> getNegociacoes(){
		return this.negociacoes; 
	}
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
