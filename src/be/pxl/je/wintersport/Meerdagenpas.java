package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meerdagenpas extends Skipas {

    private int aantalDagen;
    private LocalDate datum;

    public Meerdagenpas(Skigebied skigebied, LocalDate dateTime, int aantalDagen, boolean kind) {
        super(skigebied, kind);
    }

    @Override
    public boolean isGeldig(LocalDateTime datum) {
        LocalDateTime geldigVanaf = LocalDateTime.of(LocalDate.from(datum), LocalTime.MIN);
        LocalDateTime geldigTot = LocalDateTime.of(LocalDate.from(datum).plusDays(aantalDagen), LocalTime.MAX);
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
