package app;

public class Ohjelma {

    private String nimi;
    private int pituus;

    public Ohjelma(String nimi, int pituus) {
        this.nimi = nimi;
        this.pituus = pituus;
    }

    public boolean onHuippu() {
        return this.nimi.contains("MasterChef");
    }

    public String getNimi() {
        return nimi;
    }

    public int getPituus() {
        return pituus;
    }

    @Override
    public String toString() {
        return this.nimi + ", " + this.pituus + " minuuttia";
    }
}