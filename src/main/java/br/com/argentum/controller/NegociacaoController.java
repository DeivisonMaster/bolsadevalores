package br.com.argentum.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.argentum.model.Negociacao;
import br.com.argentum.ws.ClientWebService;

@Named
@ViewScoped
public class NegociacaoController implements Serializable{
	private static final long serialVersionUID = 1L;

	
	public List<Negociacao> getNegociacoes(){
		return new ClientWebService().getNegociacoes();
	}
}
