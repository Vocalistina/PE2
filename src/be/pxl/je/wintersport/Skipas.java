package be.pxl.je.wintersport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Skipas {
    //EIGENSCHAPPEN
    Skigebied skigebied;
    private boolean kind;

    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    //CONSTRUCTOR
    public Skipas(Skigebied skigebied, boolean kind) {
        this.skigebied = skigebied;
        this.kind = kind;
    }
    //METHODS

    //GETTERS
    public boolean isKind() {
        /*hier komt de bepaling kind of niet */
        return kind;
    }

    public Skigebied getSkigebied() {
        return skigebied;
    }

    @Override
    public String toString() {
        String persoon;
        if (isKind()) {
            persoon = "KIND";
        } else {
            persoon = "VOLWASSENE";
        }
        return getSkigebied() + "\n" + persoon + " " + "prijsopzoeken\n" + "Geldig op: " + "datumopzoeken" + "vanaf" + "tijdopzoeken";
    }
}