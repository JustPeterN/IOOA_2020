//Hamburger restaurant door Evert Verduin
package Casus_3;

import java.util.ArrayList;

public class Balie {

	private ArrayList<Bestelling> bestellingen = null;			// De arraylisten
	private ArrayList<Maaltijd> maaltijden = null;

	public Balie() {
		this.bestellingen = new ArrayList<Bestelling>();
		this.maaltijden = new ArrayList<Maaltijd>();
	}

	// Nieuwe bestelling plaatsen die kok de bereidt
	public void plaatsBestelling(Bestelling b) {
		bestellingen.add(b);									// zet een bestelling op de arraylist
	}

	// Er zijn nog bestellingen om te bereiden
	public boolean erZijnNogBestellingen() {					// De bestellingenlijst is nog niet leeg
		return !bestellingen.isEmpty();							// geef terug: de inverse van er zijn geen bestellingen meer.
	}															// Oftwel, de lijst is niet leeg.
		
	// Kok pakt bestelling om te bereiden
	public Bestelling pakBestelling() {							// Pak de bestelling
		Bestelling res = null;									// verwijder een eventuele referentie ( dit is overbodige code, maar soms erg nuttig, waarom?? ).
		if (erZijnNogBestellingen()) {							// Zijn er nog bestellingen?
			res = bestellingen.remove(0);						// Ja, haal er 1 van de lijst.
		}
		return res;												// en return deze.
	}

	// Kok plaatst maaltijd voor bezorging
	public void plaatsMaaltijd(Maaltijd m) {					// zet een maaltijd op de queue
		maaltijden.add(m);
	}

	// Er zijn nog maaltijden die ober kan bezorgen
	public boolean erZijnNogMaaltijden() {						// Zijn er nog maaltijden.
		return !maaltijden.isEmpty();
	}

	// Ober pakt een maaltijd om te bezorgen
	public Maaltijd pakMaaltijd() {								// idem als pakbestelling.
		Maaltijd res = null;
		if (erZijnNogMaaltijden()) {
			res = maaltijden.remove(0);
		}
		return res;
	}
	
	public void genereerBestellingen() {
		for (int i = 0; i < Restaurant.AANTALBESTELLINGEN; i++) {
			int tafelnummer = Util.randInt(1, Restaurant.AANTALTAFELS);
			int bereidingstijd = Util.randInt(Restaurant.MINIMALE_BEREIDINGSTIJD, Restaurant.MAXIMALE_BEREIDINGSTIJD);
			Bestelling b = new Bestelling(bereidingstijd, tafelnummer);
			this.plaatsBestelling(b);
		}
	}

}
