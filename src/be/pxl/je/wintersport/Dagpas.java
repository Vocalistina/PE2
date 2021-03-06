package be.pxl.je.wintersport;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Dagpas extends Skipas {

    final private double  KORTING_NAMIDDAG = 15.0;
    private LocalDateTime geldigVanaf;

    public Dagpas(Skigebied skigebied, LocalDateTime dateTime, boolean kind) {
        super(skigebied, kind);
        this.geldigVanaf = dateTime;
    }


    @Override
    public boolean isGeldig(LocalDateTime datum) {
        if ( (datum.isEqual(this.geldigVanaf))  || (LocalTime.from(datum).isAfter(this.geldigVanaf.toLocalTime()) && datum.isBefore(geldigVanaf.MAX))){
            return true;
        }
        return false;
    }

    @Override
    public double getPrijs() {
        double prijs = getSkigebied().getLand().getBasisprijs();
        LocalDateTime middag = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
        if (LocalDateTime.now().isAfter(middag)) {
            prijs -= KORTING_NAMIDDAG;
        }
        if (isKind()) {
            prijs *= 0.8;
        }
        return prijs;
    }

    @Override
    public String toString() {
        return String.format("%S\nGeldig op: %s vanaf: %s",super.toString(),geldigVanaf.format(DATE_FORMATTER), geldigVanaf.format(TIME_FORMATTER));
    }

}


