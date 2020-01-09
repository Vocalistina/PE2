package be.pxl.je.wintersport;

import java.util.Objects;

public class Skigebied {
    private String naam;
    private Land land;

    public Skigebied(String naam, Land land) {
        this.naam = naam;
        this.land = land;
    }

    @Override
    public String toString() {
       return getNaam() + "[" + land.getLandcode() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skigebied skigebied = (Skigebied) o;
        return Objects.equals(land, skigebied.land) &&
                Objects.equals(naam, skigebied.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(land, naam);
    }

    public Land getLand() {
        return land;
    }

    public String getNaam() {
        return naam;
    }
}
