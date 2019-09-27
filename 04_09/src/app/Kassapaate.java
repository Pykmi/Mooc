package app;

public class Kassapaate {
    private double rahaa = 1000;  // kassassa olevan käteisen määrä
    private int edulliset; // myytyjen edullisten lounaiden määrä
    private int maukkaat;  // myytyjen maukkaiden lounaiden määrä

    private double edullinenHinta = 2.5;
    private double maukasHinta = 4.3;

    public double syoEdullisesti(double maksu) {
        double erotus = maksu - this.edullinenHinta;

        if(maksu < this.edullinenHinta) {
            return maksu;
        }

        this.edulliset++;

        this.rahaa += this.edullinenHinta;
        return erotus;
    }

    public double syoMaukkaasti(double maksu) {
        double erotus = maksu - this.maukasHinta;

        if(maksu < this.maukasHinta) {
            return maksu;
        }

        this.maukkaat++;

        this.rahaa += this.maukasHinta;
        return erotus;
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        if(kortti.saldo() < this.edullinenHinta) {
            return false;
        }

        this.edulliset++;
        kortti.otaRahaa(this.edullinenHinta);
        return true;
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        if(kortti.saldo() < this.maukasHinta) {
            return false;
        }

        this.maukkaat++;
        kortti.otaRahaa(this.maukasHinta);
        return true;
    }

    public void lataaRahaaKortille(Maksukortti kortti, double summa) {
        this.rahaa += summa;
        kortti.lataaRahaa(summa);
    }

    public String toString() {
        return "Kassassa rahaa " + rahaa + "\nEdullisia lounaita myyty " + edulliset + ", maukkaita lounaita myyty " + maukkaat + ".";
    }
}