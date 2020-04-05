//Hamburger restaurant door Evert Verduin
package Casus_3;

import java.util.concurrent.TimeUnit;

public class Ober {

	private String id;
	private Balie balie = null;
	private static final int BEZORGTIJD = 10;

	public Ober(String id, Balie balie) {					// Constructor.
		this.id = id;
		this.balie = balie;
	}

	public void bezorgMaaltijden() {
		while (balie.erZijnNogMaaltijden()) {				// Zijn er nog maaltijden op de queue/balie
			Maaltijd maaltijd = balie.pakMaaltijd();		// Zo ja, pak er 1
			bezorgMaaltijd(maaltijd);						// Bezorg deze
		}
	}

	private void bezorgMaaltijd(Maaltijd m) {
		try {
			TimeUnit.MILLISECONDS.sleep(BEZORGTIJD);
			System.out.println("Ober " + this.id + " bezorgt maaltijd " + m.getTafelnummer());
		}
		catch (InterruptedException e) {
		}
	}

}
