package be.pxl.je.wintersport;

public enum Land {
    OOSTENRIJK(25.30,"A"), ITALIE(32.00, "I"), ZWITSERLAND(53.00,"CH"), FRANKRIJK(41.50,"FR");

    private double basisprijs;
    private String landcode;

    private Land(double basisprijs, String landcode) {

    };

    public double getBasisprijs() {
        return basisprijs;
    }

    public String getLandcode() {
        return this.landcode;
    }
}
