package model;

import java.util.Date;

public class MovWalletAdapt {
	private int idAccount;
	private int amount;
	private int transactionId;
	private Date data;
	private int saldo;
	private String error;
	//attributi aggiuntivi
	//private int idServer;
	private int idMov;
	
	
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getIdMov() {
		return idMov;
	}
	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MovWalletAdapt [idAccount=" + idAccount + ", amount=" + amount + ", transactionId=" + transactionId
				+ ", data=" + data + "]";
	}
	
	

}
