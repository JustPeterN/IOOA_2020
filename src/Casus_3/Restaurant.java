//Hamburger restaurant door Evert Verduin
package Casus_3;

public class Restaurant {

    private Kok Kok = null;
    private Ober Ober = null;
    public static final int AANTALTAFELS = 10;                // Er zijn 10 tafels in dit restaurant.
    public static final int AANTALBESTELLINGEN = 20;        // Max aantal gedane bestellingen
    public static final int MINIMALE_BEREIDINGSTIJD = 750;  // Om de casus wat echter te laten lijken.
    public static final int MAXIMALE_BEREIDINGSTIJD = 1500;    // Om de casus wat echter te laten lijken.


    public void start() {

        Balie balie = new Balie();
        balie.genereerBestellingen();
        new Thread(new Kok("1", balie)).start();
        new Thread(new Kok("2", balie)).start();
        new Thread(new Ober("1", balie)).start();
        new Thread(new Ober("2", balie)).start();

    }

}
