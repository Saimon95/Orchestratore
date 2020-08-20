package com.Test.orches;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dao.WalletDao;
import model.MovWalletAdapt;
import model.WalletAdapt;

@Path("wallet")

public class Wallet {

	@POST
	@Path("saldo")
	@Produces(MediaType.APPLICATION_JSON)
	public WalletAdapt getSaldo(WalletAdapt walAdapt) {
		
		WalletDao wDao = new WalletDao();
		
		wDao.addWallet();
		
		
		return wDao.getWallet(walAdapt);
	}
	
	@POST
	@Path("movimento")
	@Produces(MediaType.APPLICATION_JSON)
	public MovWalletAdapt setMovement(MovWalletAdapt walAdapt) {
		
		WalletDao wDao = new WalletDao();
		wDao.addWallet();
		System.out.println("ricevuto a wallet movimento dao: "+walAdapt.toString());
		
		return wDao.setMovWallet(walAdapt);
	}
}
