package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Partita {
	private int idPartita;
	private Date data;
	private int idTransazione;
	private String error;

	public Partita() {

	}

	public Partita(int idPartita, String data) {

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ITALY);
		try {
			this.data = format.parse(data);
			// System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010

			setIdPartita(this.idPartita);
			setData(this.data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	@Override
	public String toString() {
		return "Partita [idPartita=" + idPartita + ", data=" + data + ",idTransazione=" + idTransazione + ",error= "
				+ error + "]";
	}

}
