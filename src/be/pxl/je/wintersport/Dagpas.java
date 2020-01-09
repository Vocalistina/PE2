package be.pxl.je.wintersport;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Dagpas extends Skipas {


    public Dagpas(Skigebied skigebied, LocalDateTime dateTime, boolean kind) {
        super(skigebied, kind);

    }


    @Override
    public boolean isgeldig(LocalDateTime datum) {
        if ((datum.isAfter(LocalDateTime.now())) && (datum.isBefore(LocalDateTime.MAX))) {
            return true;
        }
        return false;
    }

    @Override
    public double getPrijs() {
        double prijs = getSkigebied().getLand().getBasisprijs();
        LocalDateTime middag = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
        if (LocalDateTime.now().isAfter(middag)) {
            prijs -= 15;
        }
        if (isKind()) {
            prijs /= 1.20;
        }
        return prijs;
    }



    }


