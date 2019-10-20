package app;

import java.util.ArrayList;

class Ruokalista {

    private ArrayList<String> ateriat;

    public Ruokalista() {
        this.ateriat = new ArrayList<>();
    }

    public void lisaaAteria(String ateria) {
        if(!this.ateriat.contains(ateria)) {
            ateriat.add(ateria);
        }
    }

    public void tulostaAteriat() {
        this.ateriat.forEach((ateria) -> System.out.println(ateria));
    }

    public void tyhjennaRuokalista() {
        this.ateriat.clear();
    }
}