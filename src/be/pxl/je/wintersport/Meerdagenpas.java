package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meerdagenpas extends Skipas {

    private int aantalDagen;
    private LocalDate datum;

    public Meerdagenpas(Skigebied skigebied, LocalDate dateTime, int aantalPersonen, boolean kind) {
        super(skigebied, kind);
    }

    @Override
    public boolean isGeldig(LocalDateTime datum) {
        LocalDateTime geldigVanaf = LocalDateTime.of(datum, LocalTime.MIDNIGHT);
        return false;
    }


    @Override
    public double getPrijs() {
        return 0;
    }

    @Override
    public String toString() {
        return "Meerdagenpas{}";
    }
}
