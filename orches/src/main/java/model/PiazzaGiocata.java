package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PiazzaGiocata {
	private int idTransazione;
	private int idAccount;
	private int ammount;
	private int idPartita;
	
	
	
	public int getIdTransazione() {
		return idTransazione;
	}
	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	
	@Override
	public String toString() {
		return "PiazzaGiocata [idTransazione=" + idTransazione + ", idAccount=" + idAccount + ", ammount="
				+ ammount + ", idPartita=" + idPartita + "]";
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public int getIdPartita() {
		return idPartita;
	}
	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}

}
