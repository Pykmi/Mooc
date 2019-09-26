package app;

class Kirja {
    private int vuosi;
    private String nimi;
    private int sivuja;

    public Kirja(int vuosi, String nimi, int sivuja) {
        this.vuosi = vuosi;
        this.nimi = nimi;
        this.sivuja = sivuja;
    }

    public int getVuosi() {
        return this.vuosi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getSivuja() {
        return this.sivuja;
    }

    public String toString() {
        return this.nimi + ", " + this.sivuja + " sivua, " + this.vuosi;
    }
}