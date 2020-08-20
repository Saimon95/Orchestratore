package dao;

import java.util.ArrayList;

import model.PartitaAdapt;

public class BetradarDao {

	ArrayList<PartitaAdapt> pList = new ArrayList<PartitaAdapt>();

	PartitaAdapt p1 = new PartitaAdapt(1, "20/08/2021 16:00:00");
	PartitaAdapt p2 = new PartitaAdapt(2, "22/08/2020 00:00:00");
	PartitaAdapt p3 = new PartitaAdapt(3, "21/08/2020 16:00:00");
	PartitaAdapt p4 = new PartitaAdapt(4, "18/07/2020 16:00:00");
	PartitaAdapt p5 = new PartitaAdapt(5, "20/08/2019 16:00:00");

	public void setPartita() {
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
	}

	public PartitaAdapt getPartita(PartitaAdapt p1) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getIdPartita() == p1.getIdPartita()) {
				return pList.get(i);
			}
		}
		return null;

	}
}
