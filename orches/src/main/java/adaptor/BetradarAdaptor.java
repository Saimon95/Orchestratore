package adaptor;

import model.Partita;
import model.PartitaAdapt;


public class BetradarAdaptor {
	public static PartitaAdapt toPartitaAdapt(Partita p1) {
		PartitaAdapt pAdapt = new PartitaAdapt();
		pAdapt.setIdPartita(p1.getIdPartita());
		pAdapt.setData(p1.getData());
		pAdapt.setIdTransazione(p1.getIdTransazione());
		//aggiungo gli attributi per interfacciarmi con betradar
		//pAdapt.setIdServer(idServer); etc..
		
		return pAdapt;
		
	}
	
	public static Partita fromPartitaAdapt(PartitaAdapt pAdapt) {
		Partita p1= new Partita();
		p1.setData(pAdapt.getData());
		p1.setIdPartita(pAdapt.getIdPartita());
		p1.setIdTransazione(pAdapt.getIdTransazione());
		
		return p1;
	}

}
