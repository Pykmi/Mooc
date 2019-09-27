package app;

public class Paivays {
    private int paiva;
    private int kuukausi;
    private int vuosi;

    private int maxPaiva = 30;
    private int maxKuukausi = 12;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        // ensin verrataan vuosia
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        // jos vuodet ovat samat, verrataan kuukausia
        if (this.vuosi == verrattava.vuosi && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        // vuodet ja kuukaudet samoja, verrataan päivää
        if (this.vuosi == verrattava.vuosi && this.kuukausi == verrattava.kuukausi &&
            this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }

    public void etene() {
        this.paiva++;

        if(this.josPaivaOnMax()) {
            this.paiva = 0;
            this.kuukausi++;

            if(this.josKuukausiOnMax()) {
                this.kuukausi = 0;
                this.vuosi++;
            }
        }
    }

    public Paivays paivienPaasta(int paivia) {
        Paivays klooni = new Paivays(this.paiva, this.kuukausi, this.vuosi);
    
        for(int i = 0; i < paivia; i++) {
            klooni.etene();
        }
    
        return klooni;
    }

    private boolean josPaivaOnMax() {
        if(this.paiva >= this.maxPaiva) {
            return true;
        }

        return false;
    }

    private boolean josKuukausiOnMax() {
        if(this.kuukausi >= this.maxKuukausi) {
            return true;
        }

        return false;
    }
}