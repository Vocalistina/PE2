package be.pxl.je.wintersport;


import java.time.LocalDateTime;
import java.time.LocalTime;


public class Dagpas extends Skipas {


    public Dagpas(Skigebied skigebied, LocalDateTime dateTime, boolean kind) {
        super(skigebied, kind);

    }

    private boolean isGeldig(LocalDateTime geldigVanaf){
        if ((geldigVanaf.isAfter(LocalDateTime.now())) && (geldigVanaf.isBefore(LocalDateTime.now()))) {
            return true;
        }
        return false;
    };

    private double getPrijs() {
        double prijs = getSkigebied().getLand().getBasisprijs();
        LocalTime middag = LocalTime.NOON;
        if (LocalDateTime.now().isAfter(middag)) {

        }
        if (isKind()) {
            prijs /= 1.20;
        }
        return prijs;

    }


}
