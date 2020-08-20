package com.Test.orches;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import adaptor.WalletAdaptor;
import model.MovWallet;
import model.PiazzaGiocata;
import model.WalletModel;
import model.WalletAdapt;
//classe/RestService adibita a verificare che il saldo sia sufficiente per effettuare la giocata
//e nel caso lo sia salva il movimento e aggiorna il saldo.

@Path("walletService")
public class WalletService {

	@POST
	@Path("saldo")
	@Produces(MediaType.APPLICATION_JSON)
	public WalletModel giocata(PiazzaGiocata g1) throws ClientProtocolException, IOException {

		WalletModel walletModel = new WalletModel();
		MovWallet movWallet = new MovWallet();

		walletModel.setIdAccount(g1.getIdAccount());
		walletModel.setIdTransazione(g1.getIdTransazione());
		walletModel.setSaldo(0);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/orches/webapi/wallet/saldo");
		try {
			Gson gson = new Gson();
			String json = gson.toJson(WalletAdaptor.ToWalletAdapt(walletModel)).toString();
			//System.out.println("invio a wallet saldo " + json);
			StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			CloseableHttpResponse response;

			response = client.execute(httpPost);

			String str = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			// String str = response.getEntity().toString();
			//System.out.println("Risposta dal wallet saldo " + str);

			walletModel = WalletAdaptor.fromWalletAdapt(gson.fromJson(str, WalletAdapt.class));

			// System.out.println(walletModel.toString());

			if (walletModel.getSaldo() >= g1.getAmmount()) {

				int newSaldo = walletModel.getSaldo() - g1.getAmmount();

				movWallet.setAmount(g1.getAmmount());
				movWallet.setIdAccount(g1.getIdAccount());
				movWallet.setOperation("Scommessa");
				movWallet.setSaldo(newSaldo);
				movWallet.setTransactionId(g1.getIdTransazione());

				HttpPost httpPost2 = new HttpPost("http://localhost:8080/orches/webapi/wallet/movimento");
				Gson gson2 = new Gson();
				String json2 = gson2.toJson(WalletAdaptor.toMovAdapt(movWallet)).toString();
				//System.out.println("invio a wallet movimento " + json2);
				StringEntity entity2 = new StringEntity(json2);
				httpPost2.setEntity(entity2);
				httpPost2.setHeader("Accept", "application/json");
				httpPost2.setHeader("Content-type", "application/json");
				CloseableHttpResponse response2 = client.execute(httpPost2);

				String str2 = IOUtils.toString(response2.getEntity().getContent(), "UTF-8");
				// String str2 = response2.getEntity().toString();
				//System.out.println("risposta a wallet movimento: " + str2);
				movWallet = gson2.fromJson(str2, MovWallet.class);
				client.close();

				if (movWallet.getTransactionId() == g1.getIdTransazione()) {

					walletModel.setSaldo(newSaldo);
					walletModel.setIdTransazione(movWallet.getTransactionId());

				} else {
					walletModel.setIdTransazione(0);
					walletModel.setError(movWallet.getError());
				}

			} else {

				walletModel.setIdTransazione(0);
				walletModel.setError("saldo non sufficiente");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			walletModel.setIdTransazione(0);
			walletModel.setError(e.getMessage());
		}

		return walletModel;

	}
}
