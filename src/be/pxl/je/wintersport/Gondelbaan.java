package be.pxl.je.wintersport;

import java.time.LocalDateTime;

public class Gondelbaan {
    String naam;
    Skigebied skigebied;

    //CONSTRUCTOR
    public Gondelbaan(String naam, Skigebied skigebied) {
        this.naam = naam;
        this.skigebied = skigebied;
    }

    //METHODES
    public boolean controleerToegang(Skipas skipas, LocalDateTime datumTijd) {
        return true;
    }
}
