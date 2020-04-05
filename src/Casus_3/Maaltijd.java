//Hamburger restaurant door Evert Verduin
package Casus_3;

public class Maaltijd {

    private int tafelnummer;
    
    public Maaltijd(int tafelnummer) {
    	this.tafelnummer = tafelnummer;
    }

	public int getTafelnummer() {
		return tafelnummer;
	}
    
    public String toString() {
    	return "tafelnummer : " + tafelnummer; 
    }
	
	
}
