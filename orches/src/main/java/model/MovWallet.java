package model;

import java.util.Date;

public class MovWallet {
	
	
	private int idAccount;
	private int amount;
	private int transactionId;
	private String operation;
	private Date data;
	private int saldo;
	private String error;

	
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MovWallet [idAccount=" + idAccount + ", amount=" + amount + ", transactionId=" + transactionId
				+ ", operation=" + operation + ", data=" + data + ", saldo=" + saldo + ", error=" + error + "]";
	}
	
	
	
}
