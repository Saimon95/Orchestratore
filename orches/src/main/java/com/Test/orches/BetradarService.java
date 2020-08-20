package com.Test.orches;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

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

import adaptor.BetradarAdaptor;
import model.Partita;
import model.PartitaAdapt;
import model.PiazzaGiocata;

@Path("betradarService")
public class BetradarService {

	@POST
	@Path("partita")
	@Produces(MediaType.APPLICATION_JSON)

	public Partita getPartita(PiazzaGiocata g1) {

		CloseableHttpClient client = HttpClients.createDefault();
		Partita p1 = new Partita();
		try {
		long timestamp = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(timestamp);
		System.out.println(dateFormat.format(date));
		

		p1.setIdPartita(g1.getIdPartita());
		p1.setIdTransazione(g1.getIdTransazione());

		HttpPost httpPost = new HttpPost("http://localhost:8080/orches/webapi/betRadar/partita");

		Gson gson = new Gson();
		String json = gson.toJson(BetradarAdaptor.toPartitaAdapt(p1)).toString();
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		CloseableHttpResponse response;
		
			response = client.execute(httpPost);
		

		String str = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		System.out.println(str);

		p1 = BetradarAdaptor.fromPartitaAdapt(gson.fromJson(str, PartitaAdapt.class));
	    

		if (date.before(p1.getData())) {
			System.out.println("partita possibile");
			p1.setIdTransazione(g1.getIdTransazione());
			System.out.println(p1.toString());
		} else {
			System.out.println("partita non possibile");
			p1.setIdTransazione(0);
			p1.setError("partita già iniziata");
			System.out.println(p1.toString());
		}

		client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p1.setError(e.getMessage());
			p1.setIdTransazione(0);
		}
		return p1;

	}
}
