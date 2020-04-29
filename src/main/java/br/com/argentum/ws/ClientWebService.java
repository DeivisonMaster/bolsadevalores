package br.com.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import br.com.argentum.model.Negociacao;
import br.com.argentum.reader.LeitorXML;

public class ClientWebService {
	
	public static final String URL_WS = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes(){
		
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(URL_WS);
			connection = (HttpURLConnection) url.openConnection();
			
			InputStream stream = connection.getInputStream();
			List<Negociacao> fluxo = new LeitorXML().carrega(stream);
			
			return fluxo;
			
		} catch (IOException e) {
			throw new RuntimeException(e);
			
		} finally {
			connection.disconnect();
		}
	}
	
	public static void main(String[] args) {
		ClientWebService client = new ClientWebService();
		
		List<Negociacao> negociacoes = client.getNegociacoes();
		
		for (Negociacao negociacao : negociacoes) {
			System.out.println(negociacao.getQuantidade());
		}
		
	}
}
