package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meerdagenpas extends Skipas {

    private int aantalDagen;
    private LocalDate datum;

    public Meerdagenpas(Skigebied skigebied, LocalDate datum, int aantalDagen, boolean kind) {
        super(skigebied, kind);
        this.datum = datum;
        this.aantalDagen = aantalDagen;
    }

    @Override
    public boolean isGeldig(LocalDateTime datum) {
        if (this.aantalDagen < 1) {
            this.aantalDagen = 2;
        }
        LocalDateTime geldigVanaf = LocalDateTime.of(LocalDate.from(datum), LocalTime.from(datum).MIDNIGHT);
        if (geldigVanaf.isAfter(LocalDateTime.now())) {
            return true;
        }
        return false;
    }


    @Override
    public double getPrijs() {
        double prijs = getSkigebied().getLand().getBasisprijs();
        prijs *= this.aantalDagen;
        if (isKind()){
            prijs *= 0.75;
        }
        return prijs;
    }

    @Override
    public String toString() {
        String geldigVanaf = LocalDate.from(datum).format(DATE_FORMATTER);
        String geldigTot = LocalDate.from(datum).plusDays(aantalDagen).format(DATE_FORMATTER);
        return String.format("%s\nGeldig van: %s tot en met: %s",super.toString(),
                geldigVanaf, geldigTot);
    }
}
