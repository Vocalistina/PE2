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
        if (this.aantalDagen < 1) {
            this.aantalDagen = 2;
        }
        LocalDateTime geldigVanaf = LocalDateTime.of(LocalDate.from(datum), LocalTime.MIN);
        LocalDateTime geldigTot = LocalDateTime.of(LocalDate.from(datum).plusDays(this.aantalDagen), LocalTime.MAX);

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
        String geldigTot = LocalDate.from(datum).plusDays(aantalDagen).format(DATE_FORMATTER) ;
        return String.format("%s\nGeldig van: %s tot en met: %s",super.toString(),
                geldigVanaf, geldigTot);
    }
}
