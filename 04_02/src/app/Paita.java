package app;

class Paita {
    private String vari;
    private int koko;
    private String materiaali;

    public Paita(String vari, int koko, String materiaali) {
        this.vari = vari;
        this.koko = koko;
        this.materiaali = materiaali;
    }

    public int getKoko() {
        return this.koko;
    }

    public String toString() {
        return "";
    }
}