package model;

public class WalletModel {
	private int idAccount;
	private int saldo;
	private int idTransazione;
	private String error;
	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public WalletModel () {
		
	}
	
	@Override
	public String toString() {
		return "Wallet [idAccount=" + idAccount + ", saldo=" + saldo + ", idTransazione=" + idTransazione + "]";
	}

	public WalletModel(int idAccount, int saldo, int idWallet) {
		this.idAccount=idAccount;
		this.saldo=saldo;
		
	}
	
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
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

}
