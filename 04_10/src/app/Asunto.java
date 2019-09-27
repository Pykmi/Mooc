package app;

public class Asunto {
    private int huoneita;
    private int nelioita;
    private int neliohinta;

    public Asunto(int huoneita, int nelioita, int neliohinta) {
        this.huoneita = huoneita;
        this.nelioita = nelioita;
        this.neliohinta = neliohinta;
    }

    public int getNeliot() {
        return this.nelioita;
    }

    public int getHinta() {
        return this.neliohinta * this.nelioita;
    }

    public boolean suurempi(Asunto verrattava) {
        if(this.getNeliot() > verrattava.getNeliot()) {
            return true;
        }

        return false;
    }

    public int hintaero(Asunto verrattava) {
        return Math.abs(this.getHinta() - verrattava.getHinta());
    }

    public boolean kalliimpi(Asunto verrattava) {
        if(this.getHinta() > verrattava.getHinta()) {
            return true;
        }

        return false;
    }
}