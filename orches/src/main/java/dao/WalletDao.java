package dao;

import java.util.ArrayList;
import model.MovWalletAdapt;
import model.WalletAdapt;

//classe dao creata come test, dovrebbe essere compresa nel WalletService di terze parti che
//riceve in ingresso e restituisce un walletAdapt
public class WalletDao {
	// creo un arrayList con la funziona da Test database

	private ArrayList<WalletAdapt> wList = new ArrayList<WalletAdapt>();
	private ArrayList<MovWalletAdapt> movList = new ArrayList<MovWalletAdapt>();

	public ArrayList<WalletAdapt> getwList() {
		return wList;
	}

	public void setwList(ArrayList<WalletAdapt> wList) {
		this.wList = wList;
	}

	public ArrayList<MovWalletAdapt> getMovList() {
		return movList;
	}

	public void setMovList(ArrayList<MovWalletAdapt> movList) {
		this.movList = movList;
	}

	// nell'ordine idAccount, saldo

	public void addWallet() {

		// System.out.println("alimento l'arrayList dei wallet");
		WalletAdapt w1 = new WalletAdapt(1, 100);
		WalletAdapt w2 = new WalletAdapt(2, 50);
		WalletAdapt w3 = new WalletAdapt(3, 80);
		WalletAdapt w4 = new WalletAdapt(4, 0);

		wList.add(w1);
		wList.add(w2);
		wList.add(w3);
		wList.add(w4);
	}

	public WalletAdapt getWallet(WalletAdapt wallet) {
		try {

			for (int i = 0; i <= wList.size(); i++) {
				if (this.wList.get(i).getIdAccount() == wallet.getIdAccount())
					return wList.get(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			wallet.setIdAccount(0);
			wallet.setIdTransazione(0);
			wallet.setSaldo(0);
			wallet.setError("message: problemi con metodo getWallet ");
			return wallet;
		}
		return null;
	}

	public MovWalletAdapt setMovWallet(MovWalletAdapt movAdapt) {
		try {
			System.out.println("ricevuto a wallet setMovWallet " + movAdapt.getIdAccount());
			movAdapt.setIdMov(movList.size() + 1);
			movList.add(movAdapt);
			updateSaldoWallet(movAdapt.getIdAccount(), movAdapt.getSaldo());
			for (int i = 0; i < movList.size(); i++)
				System.out.println("Lista mov:"+movList.get(i).toString());
			return movAdapt;
		} catch (Exception e) {
			// TODO: handle exception
			movAdapt.setIdAccount(0);
			movAdapt.setIdMov(0);
			movAdapt.setSaldo(0);
			movAdapt.setTransactionId(0);
			movAdapt.setError("message: problemi con metodo setMovWallet");
			return movAdapt;
		}

	}

	public WalletAdapt updateSaldoWallet(int idAccount, int newSaldo) {
		for (int i = 0; i <= wList.size(); i++) {
			if (wList.get(i).getIdAccount() == idAccount) {
				wList.get(i).setSaldo(newSaldo);
				for (int j = 0; j < wList.size(); j++)
					System.out.println("lista wallet: "+wList.get(j).toString());
				return wList.get(i);
			}

		}
		
		return null;

	}

}
