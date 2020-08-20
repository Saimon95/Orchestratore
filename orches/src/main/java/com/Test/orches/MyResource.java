package com.Test.orches;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;

import model.Partita;
import model.PiazzaGiocata;
import model.ResponseBase;
import model.WalletModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	@POST
	@Path("giocata")
	@Produces(MediaType.APPLICATION_JSON)
	// riceve i dati della giocata dal frontEnd in formato JSON e valorizza in
	// automatico gli attributi dell'oogetto g1 della classe PiazzaGiocata

	public ResponseBase giocata(PiazzaGiocata g1) {
		// posso aggiungere informazioni/restrizioni in base all'id account ricevuto
		// etc...
		// es if(g1.getIdAccount()==1)
		WalletModel wallet = new WalletModel();
		Partita partita = new Partita();
		ResponseBase r = new ResponseBase();
		CloseableHttpClient client = HttpClients.createDefault();
		int idTransazione = g1.getIdTransazione();
		try {
			// verifico che la partita esista e non sia ancora cominciata con idPartita .
			HttpPost httpPost1 = new HttpPost("http://localhost:8080/orches/webapi/betradarService/partita");
			Gson gson1 = new Gson();
			String json1 = gson1.toJson(g1).toString();
			
			StringEntity entity1 = new StringEntity(json1);
			httpPost1.setEntity(entity1);
			httpPost1.setHeader("Accept", "application/json");
			httpPost1.setHeader("Content-type", "application/json");
			CloseableHttpResponse response1 = client.execute(httpPost1);

			String str1 = IOUtils.toString(response1.getEntity().getContent(), "UTF-8");

			partita = gson1.fromJson(str1, Partita.class);
			

			if (partita.getIdTransazione() == idTransazione) {
				// verifico che il saldo sia sufficiente
			

				HttpPost httpPost2 = new HttpPost("http://localhost:8080/orches/webapi/walletService/saldo");

				Gson gson2 = new Gson();
				String json2 = gson2.toJson(g1).toString();

				StringEntity entity2 = new StringEntity(json2);
				httpPost2.setEntity(entity2);
				httpPost2.setHeader("Accept", "application/json");
				httpPost2.setHeader("Content-type", "application/json");
				CloseableHttpResponse response2 = client.execute(httpPost2);

				String str2= IOUtils.toString(response2.getEntity().getContent(), "UTF-8");
				//System.out.println(str2);

				wallet = gson2.fromJson(str2, WalletModel.class);
				client.close();

				if (wallet.getIdTransazione() == idTransazione) {
					r.setIdTransazione(idTransazione);
					r.setResponse("ok");

				} else {
					r.setResponse("ko, "+wallet.getError());
					r.setIdTransazione(0);
				}

			} else {
				System.out.println(partita.getError());
				r.setIdTransazione(0);
				r.setResponse("ko, " + partita.getError());

			}
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setIdTransazione(0);
			r.setResponse("ko, " + e.getMessage());
		}

		return r;
	}

}
