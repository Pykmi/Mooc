package app;

public class Pelaaja {
    private String pelaaja;
    private int maalit = 0;

    public Pelaaja(String pelaaja, int maalit) {
        this.pelaaja = pelaaja;
        this.maalit = maalit;
    }

    public Pelaaja(String pelaaja) {
        this.pelaaja = pelaaja;
    }

    public int maalit() {
        return maalit;
    }

    @Override
    public String toString() {
        return this.pelaaja + ", " + "maaleja " + this.maalit;
    }
}
