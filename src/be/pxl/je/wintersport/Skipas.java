package be.pxl.je.wintersport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Skipas {
    //EIGENSCHAPPEN
    Skigebied skigebied;
    private boolean kind;

    final public DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final public DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    //CONSTRUCTOR
    public Skipas(Skigebied skigebied, boolean kind) {
        this.skigebied = skigebied;
        this.kind = kind;
    }
    //METHODS
    public abstract boolean  isGeldig(LocalDateTime datum);
    public abstract double getPrijs();

    //GETTERS
    public boolean isKind() {
        return kind;
    }

    public Skigebied getSkigebied() {
        return skigebied;
    }

    @Override
    public String toString() {
        String volOfKind;
        if(isKind()) {
            volOfKind = "KIND";
        } else {
            volOfKind = "VOLWASSENE";
        }
        return String.format("%s\n%s €%f2\n", getSkigebied(),volOfKind,getPrijs());
    }
}
