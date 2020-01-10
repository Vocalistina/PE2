package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;

import static java.util.concurrent.TimeUnit.DAYS;

public class Meerdagenpas extends Skipas {

    private int aantalDagen;
    private LocalDate datum;

    public Meerdagenpas(Skigebied skigebied, LocalDate datum, int aantalDagen, boolean kind) {
        super(skigebied, kind);
        this.datum = datum;
        this.aantalDagen = aantalDagen;
        if (this.aantalDagen < 1) {
            this.aantalDagen = 2;
        }
    }

    @Override
    public boolean isGeldig(LocalDateTime datumGegeven) {
        LocalDateTime geldigVanaf = LocalDateTime.of(LocalDate.from(datum), LocalTime.MIN);
        LocalDateTime geldigTot = LocalDateTime.of(LocalDate.from(datum).plusDays(aantalDagen), LocalTime.MAX);
        int dagenTussenGegevenEnGeldigTot = datumGegeven.toLocalDate().until(geldigTot.toLocalDate()).getDays();
        if ((datumGegeven.toLocalDate().isEqual(geldigVanaf.toLocalDate()) && dagenTussenGegevenEnGeldigTot >= 1)||
                (datumGegeven.isAfter(geldigVanaf) && datumGegeven.isBefore(geldigTot)) && dagenTussenGegevenEnGeldigTot >= 1) {
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
