package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PartitaAdapt {

	private int idPartita;
	private Date data;
	private int idTransazione;
	// altri parametri per interfacciarsi al betRadarService
	private int idServer;
	private String nomeServizio;

	public PartitaAdapt() {

	}

	public PartitaAdapt(int idPartita, String sData) {
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sData);
			// System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
			setIdPartita(idPartita);
			setData(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	public int getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdServer() {
		return idServer;
	}

	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	@Override
	public String toString() {
		return "PartitaAdapt [idPartita=" + idPartita + ", data=" + data + ", idServer=" + idServer + ", nomeServizio="
				+ nomeServizio + "]";
	}

}
