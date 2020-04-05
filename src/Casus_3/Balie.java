//Hamburger restaurant door Evert Verduin
package Casus_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Balie {

    private BlockingQueue<Bestelling> bestellingen = null;            // De arraylisten
    private BlockingQueue<Maaltijd> maaltijden = null;

    public Balie() {
        this.bestellingen = new ArrayBlockingQueue<Bestelling>(Restaurant.AANTALBESTELLINGEN);
        this.maaltijden = new ArrayBlockingQueue<Maaltijd>(Restaurant.AANTALBESTELLINGEN);
    }

    // Nieuwe bestelling plaatsen die kok de bereidt
    public void plaatsBestelling(Bestelling b) {
        bestellingen.add(b);                                    // zet een bestelling op de arraylist
    }

    // Er zijn nog bestellingen om te bereiden
    public boolean erZijnNogBestellingen() {                    // De bestellingenlijst is nog niet leeg
        return !bestellingen.isEmpty();                            // geef terug: de inverse van er zijn geen bestellingen meer.
    }                                                            // Oftwel, de lijst is niet leeg.

    // Kok pakt bestelling om te bereiden
    public Bestelling pakBestelling() throws InterruptedException {                            // Pak de bestelling
        Bestelling res = null;                                    // verwijder een eventuele referentie ( dit is overbodige code, maar soms erg nuttig, waarom?? ).
        if (erZijnNogBestellingen()) {                            // Zijn er nog bestellingen?
            res = bestellingen.take();                        // Ja, haal er 1 van de lijst.
        }
        return res;                                                // en return deze.
    }

    // Kok plaatst maaltijd voor bezorging
    public void plaatsMaaltijd(Maaltijd m) throws InterruptedException {                    // zet een maaltijd op de queue
        maaltijden.put(m);
    }

    // Er zijn nog maaltijden die ober kan bezorgen
    public boolean erZijnNogMaaltijden() {                        // Zijn er nog maaltijden.
        return !maaltijden.isEmpty();
    }

    // Ober pakt een maaltijd om te bezorgen
    public Maaltijd pakMaaltijd() throws InterruptedException {                                // idem als pakbestelling.
        Maaltijd res = null;
        if (erZijnNogMaaltijden()) {
            res = maaltijden.take();
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
