package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseBase {
	
	private String response;
	private int idTransazione;

	public int getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	@Override
	public String toString() {
		return "ResponseBase [response=" + response + ", idTransazione=" + idTransazione + "]";
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
