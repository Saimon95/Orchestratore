package adaptor;


import model.WalletModel;
import model.MovWallet;
import model.MovWalletAdapt;
import model.WalletAdapt;

//se cambio Wallet devo solo cambiare questa classe per
//modificare il modo in cui mi interfaccio


public class WalletAdaptor {
	
	public static WalletAdapt ToWalletAdapt(WalletModel wal) {
		WalletAdapt walAdapt= new WalletAdapt();
		walAdapt.setIdTransazione(wal.getIdTransazione());
		walAdapt.setIdAccount(wal.getIdAccount());
		walAdapt.setSaldo(wal.getSaldo());
		// esempio di paramentro aggiuntivo per adattarmi al Wallet.
		//walAdapt.setIdServer(idServer);
		//walAdapt.setIdWallet(idWallet);
		return walAdapt;
	}
	
	public static WalletModel fromWalletAdapt(WalletAdapt walAdapt) {
		WalletModel wal= new WalletModel();
		wal.setIdTransazione(walAdapt.getIdTransazione());
		wal.setIdAccount(walAdapt.getIdAccount());
		wal.setSaldo(walAdapt.getSaldo());
		wal.setError(walAdapt.getError());
		
		return wal;
	}
	
	public static MovWalletAdapt toMovAdapt(MovWallet mov){
		MovWalletAdapt movAdapt = new MovWalletAdapt();
		
		movAdapt.setIdAccount(mov.getIdAccount());
		movAdapt.setAmount(mov.getAmount());
		movAdapt.setTransactionId(mov.getTransactionId());
		movAdapt.setSaldo(mov.getSaldo());
		movAdapt.setData(mov.getData());
		return movAdapt;
	}
	
	public static MovWallet fromMovAdapt(MovWalletAdapt movAdapt){
		MovWallet mov = new MovWallet();
		
		mov.setIdAccount(movAdapt.getIdAccount());
		mov.setAmount(movAdapt.getAmount());
		mov.setTransactionId(movAdapt.getTransactionId());
		mov.setSaldo(movAdapt.getSaldo());
		mov.setData(movAdapt.getData());
		mov.setError(movAdapt.getError());
		return mov;
	}

}
