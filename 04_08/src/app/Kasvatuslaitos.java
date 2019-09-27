package app;

public class Kasvatuslaitos {
    private int punnitukset = 0;

    public int punnitse(Henkilo henkilo) {
        this.punnitukset++;
        return henkilo.getPaino();
    }

    public void syota(Henkilo henkilo) {
        henkilo.setPaino(henkilo.getPaino()+1);
    }

    public int punnitukset() {
        return this.punnitukset;
    }
}