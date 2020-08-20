package com.Test.orches;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import dao.BetradarDao;
import model.PartitaAdapt;

@Path("betRadar")
public class Betradar {

	@POST
	@Path("partita")
	@Produces(MediaType.APPLICATION_JSON)
	public PartitaAdapt getPArtita(PartitaAdapt pAdapt) {
		BetradarDao pDao = new BetradarDao();
		pDao.setPartita();
		return pDao.getPartita(pAdapt);
	}

}
