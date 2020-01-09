package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meerdagenpas extends Skipas {


    public Meerdagenpas(Skigebied skigebied, LocalDate dateTime, int aantalPersonen, boolean kind) {
        super(skigebied, kind);
    }

    @Override
    public boolean isgeldig(LocalDateTime datum) {
        return false;
    }

    @Override
    public double getPrijs() {
        return 0;
    }
}
