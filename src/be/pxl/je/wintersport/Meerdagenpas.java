package be.pxl.je.wintersport;

import java.time.LocalDate;

public class Meerdagenpas extends Skipas {


    public Meerdagenpas(Skigebied skigebied, LocalDate dateTime, int aantalPersonen, boolean kind) {
        super(skigebied, kind);
    }
}
