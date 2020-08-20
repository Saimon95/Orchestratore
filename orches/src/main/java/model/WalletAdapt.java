package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WalletAdapt {
	//definisco gli attributi necessari per interfacciarsi con il servizio di Wallet

	private int idAccount;
	private int saldo;
	private int idTransazione;
	private int idServer;
	private int idWallet;
	private String error;
	
public WalletAdapt () {
		
	}

public WalletAdapt(int idAccoun, int sald) {
	idAccount=idAccoun;
	saldo=sald;
	
}

	
	public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

	public int getIdWallet() {
		return idWallet;
	}

	public void setIdWallet(int idWallet) {
		this.idWallet = idWallet;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	public int getIdServer() {
		return idServer;
	}

	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}

	@Override
	public String toString() {
		return "WalletAdapt [idAccount=" + idAccount + ", saldo=" + saldo + ", idTransazione=" + idTransazione
				+ ", idServer=" + idServer + ", idWallet=" + idWallet + ", error=" + error + "]";
	}
	
}
