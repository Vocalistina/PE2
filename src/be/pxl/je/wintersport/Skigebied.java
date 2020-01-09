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
       return getNaam() + " [" + this.land.getLandcode() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skigebied skigebied = (Skigebied) o;
        return Objects.equals(this.land, skigebied.land) &&
                Objects.equals(this.naam, skigebied.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.land, this.naam);
    }

    public Land getLand() {
        return this.land;
    }

    public String getNaam() {
        return this.naam;
    }
}
