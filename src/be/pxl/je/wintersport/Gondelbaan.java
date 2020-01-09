package be.pxl.je.wintersport;

import java.time.LocalDateTime;

public class Gondelbaan {
    private String naam;
    private Skigebied skigebied;

    //CONSTRUCTOR
    public Gondelbaan(String naam, Skigebied skigebied) {
        this.naam = naam;
        this.skigebied = skigebied;
    }

    //METHODES
    public boolean controleerToegang(Skipas skipas, LocalDateTime datumTijd) {
        if (skipas.isGeldig(datumTijd) && skipas.getSkigebied().equals(this.skigebied)){
            return true;

        } else {
            System.out.println("De skipas is niet geldig voor skigebied " + this.skigebied.toString());
        }
        return false;
    }
}
